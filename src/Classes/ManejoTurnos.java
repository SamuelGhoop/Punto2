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

        ids[n] = id;
        tipos[n] = tipo;
        tiempos[n] = tiempo;
        n++;
        return true;
    }

    public void eliminarPorIndex(int index){
        for (int i=index;i<n-1;i++){

        }
    }
}
