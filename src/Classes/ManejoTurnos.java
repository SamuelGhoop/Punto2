package Classes;

public class ManejoTurnos {
    private static final int capacidad = 50;

    private final int[] ids = new int[capacidad];
    private final char[] tipos = new char[capacidad];
    private final int[] tiempos = new int[capacidad];
    private int n = 0;

    public ManejoTurnos() {
    }

    private int buscarPorId(int id) {
        for (int i = 0; i < n; i++) {
            if (ids[i] == id) return i;
        }
        return -1;
    }

    private boolean tipoValido(char t) {
        t = Character.toUpperCase(t);
        return t == 'P' || t == 'G';
    }

    private boolean tiempoValido(int tiempo) {
        return tiempo >= 1 && tiempo <= 60;
    }

    public boolean registrarTurno(int id, char tipo, int tiempo){
        if (n>= capacidad) return false;
        if (id<=0) return false;
        if (buscarPorId(id) != -1) return false;

        tipo=Character.toUpperCase(tipo); //Pa que quede P o G
        if (!tipoValido(tipo)) return false;
        if (!tiempoValido(tiempo)) return false;

        ids[n] = id;
        tipos[n] = tipo;
        tiempos[n] = tiempo;
        n++;
        return true;
    }
    private void eliminar(int idx) {
        for (int i = idx; i < n - 1; i++) {
            ids[i] = ids[i + 1];
            tipos[i] = tipos[i + 1];
            tiempos[i] = tiempos[i + 1];
        }
        n--;
    }// el fin se acerca

    public void atenderSiguiente(){
        if (n==0){
            System.out.println("No hay turno para atender"); return;
        }

        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (Character.toUpperCase(tipos[i]) == 'P') {
                idx = i;
                break;
            }
        }

        if (idx == -1) {idx = 0;}
        int idAtendido = ids[idx];
        char tipoAtendido = tipos[idx];
        int tiempoAtendido = tiempos[idx];

        eliminar(idx);
        System.out.println("Se atendió al turno: ID=" + idAtendido + ", tipo= " + tipoAtendido + ", tiempo= " + tiempoAtendido);
    }
    public boolean cancelarPorId(int id) {
        int idx = buscarPorId(id);
        if (idx == -1) return false;

        eliminar(idx);
        return true;
    }

    private void desplazarDerecha(int k) {
        for (int i = n; i > k; i--) {
            ids[i] = ids[i - 1];
            tipos[i] = tipos[i - 1];
            tiempos[i] = tiempos[i - 1];
        }
    }

    public boolean insertarUrgente(int id, char tipo, int tiempo, int k) {
        if (n >= capacidad) return false;
        if (k < 0 || k > n) return false;
        if (id <= 0) return false;
        if (buscarPorId(id) != -1) return false;

        tipo = Character.toUpperCase(tipo);
        if (!tipoValido(tipo)) return false;
        if (!tiempoValido(tiempo)) return false;

        desplazarDerecha(k);

        ids[k] = id;
        tipos[k] = tipo;
        tiempos[k] = tiempo;
        n++;
        return true;
    }
//AYUDA
public void mostrarEstadisticas() {
    if (n == 0) {
        System.out.println("No hay turnos para calcular estadísticas.");
        return;
    }

    int sumaTiempos = 0;                                              //todos en 0 para sumarles despues
    int pref = 0;
    int gen = 0;

    int maxTiempo = -1;                                                //Todavia no sabemos cual es el max de ninguno de estos
    int maxId = -1;
    char maxTipo = '?';
    int multiplos5 = 0;                                                // Cuenta tiempos múltiplos de 5 empieza en 0 por lo mismo

    for (int i = 0; i < n; i++) {
        int t = tiempos[i];                                           //tiempo de la posicion i
        char tipo = Character.toUpperCase(tipos[i]);                   // Tipo de posicion i llevada a mayuscula G-P

        sumaTiempos += t;                                              // Suma para promedio

        if (tipo == 'P') pref++;                                       // Suma preferenciales
        else if (tipo == 'G') gen++;                                   // Suma generales

        if (t > maxTiempo) {                                           // Si este tiempo es el mayor
            maxTiempo = t;                                             // Actualiza mayor tiempo
            maxId = ids[i];                                            // Guarda id asociado
            maxTipo = tipo;                                            // Guarda tipo asociado
        }

        if (t % 5 == 0) multiplos5++;                                  // Cuenta si es múltiplo de 5
    }

    double promedio = (double) sumaTiempos / n;                        // Promedio de tiempo
    double porcPref = (double) pref * 100 / n;                         // % preferenciales
    double porcGen = (double) gen * 100 / n;                           // % generales

    System.out.println("a) Promedio del tiempo estimado: " + promedio);
    System.out.println("b) % Preferenciales: " + porcPref + " , % Generales: " + porcGen);
    System.out.println("c) Mayor tiempo estimado: ID=" + maxId + ", Tipo=" + maxTipo + ", Tiempo=" + maxTiempo);
    System.out.println("d) Cantidad de turnos con tiempo múltiplo de 5: " + multiplos5);
}

    public void mostrarCola() {
        if (n == 0) {
            System.out.println("No hay nada en la cola.");
            return;
        }

        System.out.println("\nPos\tID\tTipo\tTiempo");  //\t tabulacion
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + ids[i] + "\t" + tipos[i] + "\t" + tiempos[i]);
        }
    }


}
