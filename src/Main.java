import Classes.ManejoTurnos;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);
    ManejoTurnos niggaTurno = new ManejoTurnos(); //dejalo asi si si

    public static void   mostrarOpciones(){
        System.out.println("--- MENU TURNOS ---");
        System.out.println("1. Registrar turno");
        System.out.println("2. Atender siguiente");
        System.out.println("3. Cancelar turno por id");
        System.out.println("4. Insertar turno urgente");
        System.out.println("5. Estadísticas");
        System.out.println("6. Mostrar cola");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    public static void registrarTurno(){
        System.out.println("Perra mete el id");
        int id = sc.nextInt(); //me voy tio
    }
    public static void atenderSiguiente(){}
    public static void cancelarTurno(int idTurno){}
    public static void insertarTurno(int posicion){}
    public static void estadisticas(){}
    public static void mostrarCola(){}

    public static void main(String[] args) {


        int opcion;

        do
        {
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    // monta esto al github y añadime pa yo terminarlo
                    registrarTurno();
                    break;
                case 2:
                    registrarTurno();
                    break;
                case 3:
                    registrarTurno();
                    break;
                case 4:
                    registrarTurno();
                    break;
                case 5:
                    registrarTurno();
                    break;
                case 6:
                    registrarTurno();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Aún no implementado.");
            }
        } while (opcion != 0);

    }
}