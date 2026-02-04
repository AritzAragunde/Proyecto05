import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Equipo> equipos = new ArrayList<>();
    private static List<Jugador> jugadores = new ArrayList<>();
    private static int equipo;
    static int contadorIdJugador = 1;


    public static void menu(int respuesta) {
        switch (respuesta) {
            case 1:
                inscribirJugador();
                break;
            case 2:
                inscribirEquipo();
                break;
                case 3:
                verEquipos();
                break;
                case 4:
                    verJugadores();
                    break;
        }
    }

    public static void inscribirJugador() {
        Scanner sc = new Scanner(System.in);
        try{
            if (equipos.isEmpty()) {
                throw new RuntimeException("Minimo debes de crear un equipo antes!!");
            }
            System.out.println("Indica a que equipo vas a inscribir al jugador");
            for (int i = 0; i < equipos.size(); i++){
                System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
            }
            int equipo = sc.nextInt() - 1;
            if (equipo < 0 || equipo >= equipos.size()) {
                throw new RuntimeException("Equipo no válido.");
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Nombre:");
            String nombre = sc.next();

            System.out.println("Apellido:");
            String apellido = sc.next();

            System.out.println("Nacionalidad");
            String nacionalidad = sc.next();

            System.out.println("fecha de nacimiento:");
            String fecha_nacimiento = sc.next();

            System.out.println("nickname:");
            String nickname = sc.next();

            System.out.println("rol del jugador:");
            String rol = sc.next();

            System.out.println("Sueldo:");
            double sueldo = sc.nextInt();
            Jugador.salarioMinimo();

            Jugador j1 = new Jugador(contadorIdJugador,nombre,apellido,nacionalidad,fecha_nacimiento,nickname,rol,sueldo);
            jugadores.add(j1);
            equipos.get(equipo).getLista_jugadores().add(j1);
            Equipo.contarJugadores();
            System.out.println("se ha añadido al " + j1 + "al equipo");
            System.out.println("QUIERES VOlVER AL MENU? s/n");
            String respuesta = sc.next();
            sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Volviendo al menu ......");
                sc.nextLine();
                main(null);
            } else if (respuesta.equalsIgnoreCase("n")) {
                inscribirJugador();
            }
            contadorIdJugador++;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public  static void inscribirEquipo() {

        try{
            System.out.println("Indique el nombre del equipo que quiere ingresar");
            String nombre = sc.next();
            System.out.println("Ingrese la fecha de fundacion del equipo (dd/MM/yyyy)");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha_fundacion = LocalDate.parse(sc.next(), formatter);
            Equipo e1 = new Equipo(nombre,fecha_fundacion);
            equipos.add(new Equipo(nombre, fecha_fundacion));
            System.out.println("Equipo " + nombre + " inscrito!");
            sc.nextLine();
            System.out.println("QUIERES VOlVER AL MENU? s/n");
            String respuesta = sc.next();
            sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Volviendo al menu ......");
                sc.nextLine();
                main(null);
            } else if (respuesta.equalsIgnoreCase("n")) {
                inscribirEquipo();
            }
            if (equipos.isEmpty()) {
                throw new RuntimeException("");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void verEquipos(){
         System.out.println(equipos);
        System.out.println("QUIERES VOlVER AL MENU? s/n");
        String respuesta = sc.next();
        sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Volviendo al menu ......");
            sc.nextLine();
            main(null);
        } else if (respuesta.equalsIgnoreCase("n")) {
            inscribirEquipo();
        }
    }

    public static void verJugadores(){
        System.out.println(jugadores);
        System.out.println("QUIERES VOlVER AL MENU? s/n");
        String respuesta = sc.next();
        sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Volviendo al menu ......");
            sc.nextLine();
            main(null);
        } else if (respuesta.equalsIgnoreCase("n")) {
            inscribirEquipo();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("======== MENU ========\n" +
                "1.- Inscribir Jugadores\n" +
                "2.- Inscribir Equipos\n" +
                "3.- Ver equipos\n" +
                "4.- Ver jugadores");
        int respuesta = sc.nextInt();
        menu(respuesta);
    }
}
