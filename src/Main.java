import Classes.ManejoTurnos;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static ManejoTurnos niggaTurnos; //🥷
    private static int idTurno;

    public static void mostrarOpciones() {
        System.out.println("\n--- MENU TURNOS (choose wisely) ---");
        System.out.println("1. ➕ Registrar turno (entra en la fila)");
        System.out.println("2. ▶️ Atender siguiente (que pase el siguiente pobre)");
        System.out.println("3. ❌ Cancelar turno (yeet el turno)");
        System.out.println("4. 🚨 Insertar turno urgente (URGENTE!!! URGENTE!!!)");
        System.out.println("5. 📊 Estadísticas (que se vea cuanto caos hay)");
        System.out.println("6. 📋 Mostrar cola (a ver quien esta ahi sufiendo)");
        System.out.println("0. 🚪 Salir (escapar de aqui)");
        System.out.print(">> ");
    }

    private static void registrarTurno() {
        try {
            System.out.print("Tipo (P preferencial / G general): ");
            String t = sc.nextLine();
            if (t.isEmpty()) { System.out.println("❌ Tipo? cual tipo? pon algo"); return; }  //miramos a ver si el usuario puso algo, sino no podemos sacar el char
            char tipo = t.charAt(0); // sacamos el primer char del string
            System.out.print("Tiempo estimado (1-60 minutos): ");
            int tiempo = Integer.parseInt(sc.nextLine());

            boolean ok = niggaTurnos.registrarTurno(idTurno++, tipo, tiempo);
            if (ok) {
                System.out.println("✅ Turno #" + (idTurno-1) + " registrado! que vueltas da la vida eh");
            } else {
                System.out.println("❌ Nah, no se pudo. capaz ya existe ese turno o la cola esta llena");
            }
        } catch (NumberFormatException ex) {
            System.out.println("❌ Ey, pon números! no ficción científica");
        }
    }

    private static void atenderSiguiente() {
        niggaTurnos.atenderSiguiente();
    }

    private static void cancelarTurno() {
        try {
            System.out.print("ID a cancelar (yeet it chao hpta): ");
            mostrarCola();
            int id = Integer.parseInt(sc.nextLine());
            boolean ok = niggaTurnos.cancelarPorId(id);
            if (ok) {
                System.out.println("✅ Turno #" + id + " eliminado  chao hpta");
            } else {
                System.out.println("❌ Ese ID no existe boludo, mira bien la cola");
            }
        } catch (NumberFormatException ex) {
            System.out.println("❌ ID? eso no se ve como un número che");
        }
    }

    private static void insertarTurnoUrgente() {
        try {
            System.out.print("Posición donde colarce(corlarse)? (0 = adelante de todos): ");
            mostrarCola();
            int pos = Integer.parseInt(sc.nextLine());

            System.out.print("Tipo (P si es vip / G si es common): ");
            String t = sc.nextLine();
            if (t.isEmpty()) { System.out.println("❌ dale pon algo"); return; }
            char tipo = t.charAt(0);
            System.out.print("Tiempo (1-60): ");
            int tiempo = Integer.parseInt(sc.nextLine());

            boolean ok = niggaTurnos.insertarUrgente(idTurno++, tipo, tiempo, pos);
            if (ok) {
                System.out.println("✅ SIIIU! Te colaste en la fila en la posición " + pos);
            } else {
                System.out.println("❌ oof, no se pudo. capaz la posición esta fuera de rango o algo");
            }

        } catch (NumberFormatException ex) {
            System.out.println("❌ numeros numeros numeros che");
        }
    }

    private static void estadisticas() {
        niggaTurnos.mostrarEstadisticas();
    }

    private static void mostrarCola() {
        niggaTurnos.mostrarCola();
    }

    public static void main(String[] args) {

        niggaTurnos = new ManejoTurnos();
        System.out.println("Hola tio Sistema listo para el caos con 50 turnos");

        int opcion = -1;
        do {
            mostrarOpciones();

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    registrarTurno();
                    break;
                case 2:
                    atenderSiguiente();
                    break;
                case 3:
                    cancelarTurno();
                    break;
                case 4:
                    insertarTurnoUrgente();
                    break;
                case 5:
                    estadisticas();
                    break;
                case 6:
                    mostrarCola();
                    break;
                case 0:
                    System.out.println("👋 Adios che, que te vaya bien");
                    System.exit(1);
                    break;
                default:
                    System.out.println("⚠️ esa opción no existe boludo");
            }

        } while (opcion != 0);

        sc.close();
    }
}