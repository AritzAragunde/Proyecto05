import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Equipo> equipos = new ArrayList<>();
    private static List<Jugador> jugadores = new ArrayList<>();
    private static List<Enfrentamiento> enfrentamientos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static List<Jornada> jornadas = new ArrayList<>();
    private static int equipo;
    static int contadorIdJugador = 1;
    private static Competicion c1;


    public static void inscribirJugador() {
        if (equipos.isEmpty()) {
            System.out.println("Error: Debes crear al menos un equipo antes de inscribir jugadores.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        for (Equipo equipo : equipos) {
            System.out.println("------ INSCRIBIENDO JUGADORES PARA EL EQUIPO: " + equipo.getNombre() + " ------");

            int jugadoresFaltantes = 6 - equipo.getLista_jugadores().size();
            if (jugadoresFaltantes == 0) {
                System.out.println("El equipo ya tiene 6 jugadores. No se puede añadir más.");
                continue;
            }

            int numJugadores = 0;

            while (true) {
                System.out.println("¿Cuántos jugadores quieres inscribir en este equipo? (mínimo 2, máximo " + jugadoresFaltantes + ")");
                try {
                    numJugadores = sc.nextInt();
                    sc.nextLine();

                    if (numJugadores < 2 || numJugadores > jugadoresFaltantes) {
                        System.out.println("Error: Debes ingresar un número entre 2 y " + jugadoresFaltantes + ".");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Debes ingresar un número válido.");
                    sc.nextLine();
                }
            }

            for (int i = 0; i < numJugadores; i++) {
                System.out.println("Jugador " + (i + 1) + ":");
                try {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Nacionalidad: ");
                    String nacionalidad = sc.nextLine();

                    System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
                    String fecha_nacimiento = sc.nextLine();

                    System.out.print("Nickname: ");
                    String nickname = sc.nextLine();

                    System.out.print("Rol del jugador: ");
                    String rol = sc.nextLine();

                    System.out.print("Sueldo: ");
                    double sueldo = sc.nextDouble();
                    sc.nextLine();

                    Jugador.salarioMinimo();

                    Jugador j1 = new Jugador(contadorIdJugador, nombre, apellido, nacionalidad, fecha_nacimiento, nickname, rol, sueldo);
                    jugadores.add(j1);
                    equipo.getLista_jugadores().add(j1);

                    System.out.println("Se ha añadido al jugador " + nombre + " al equipo " + equipo.getNombre());
                    contadorIdJugador++;

                } catch (Exception e) {
                    System.out.println("Error al ingresar el jugador: " + e.getMessage());
                    sc.nextLine();
                    i--;
                }
            }

            System.out.println("Todos los jugadores asignados al equipo " + equipo.getNombre() + " correctamente!");
        }

        System.out.println("Todos los equipos tienen sus jugadores inscritos.");
    }




    public static void inscribirEquipo() {
        int numEquipos = 0;
        while (true) {
            System.out.println("¿Cuántos equipos quieres inscribir? (debe ser un número par)");
            try {
                numEquipos = sc.nextInt();

                if (numEquipos <= 0) {
                    System.out.println("Error: Debe ser un número mayor que cero.");
                } else if (numEquipos % 2 != 0) {
                    System.out.println("Error: El número de equipos debe ser PAR.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.next();
            }
        }

        sc.nextLine();
        for (int i = 0; i < numEquipos; i++) {
            try {
                System.out.println("Indique el nombre del equipo que quiere ingresar:");
                String nombre = sc.nextLine();

                System.out.println("Ingrese la fecha de fundación del equipo (dd/MM/yyyy):");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha_fundacion = LocalDate.parse(sc.nextLine(), formatter);

                Equipo e1 = new Equipo(nombre, fecha_fundacion);
                equipos.add(e1);

                System.out.println("Equipo " + nombre + " inscrito!");
            } catch (Exception e) {
                System.out.println("Error al registrar el equipo: " + e.getMessage());
                i--;
            }
        }

        System.out.println("Todos los equipos inscritos correctamente!");
    }


    public static void verEquipos() {
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

    public static void verJugadores() {
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
       inscribirEquipo();
       inscribirJugador();
        menu();
    }

    public static void menu() {
       if (usuarios.isEmpty()) {
           System.out.print("No hay usuarios");
           crearUsuarios();
       }
       else {
           System.out.print("Que tipo de usuario eres?(usuario/admin)");
           String respuesta = sc.next().toLowerCase();
           switch (respuesta) {
               case "usuario":{
                   if (users.isEmpty()) {
                       System.out.print("No hay users creados");
                       crearUsuarios();
                   }
                   else {
                       System.out.print("Que hacemos?");
                       menuUser();
                   }
               }
               case "admin":{
                   if (admins.isEmpty()) {
                       System.out.print("No hay admins creados");
                       crearUsuarios();
                   }
                   else {
                       System.out.print("Que hacemos?");
                       menuAdmin();
                   }
               }
               }
           }
       }

    public static void  menuUser() {
       System.out.println("1.-Ver informe\n" +
               "2.-Ver resultados");
       int opcion = sc.nextInt();
       switch (opcion) {
           case 1: {
               for (int i = 0; i<equipos.size(); i++) {
                   Equipo e = equipos.get(i);
                   System.out.println("Equipo" + (i+1) + e.getNombre() + "fundado en" + e.getFecha_fundacion() + "con jugadores" + e.getJugadores());
               }
           }
           case 2:{
               mostrarResultados();
           }
       }
    }

    public static void menuAdmin() {
       System.out.println("1.-Generar calnderio\n" +
               "2.-Cerrar estado de la competicion\n" +
               "3.- Introducir resultado\n" +
               "4.-Ver informes\n" +
               "5.-CRUD\n" +
               "6.-Salir");
       int opcion = sc.nextInt();
       switch (opcion) {
           case 1:
               crearEnfrentamientos();
               crearJornadas();
               crearCompeticion();
               System.out.println("Calendario creado");
               menuAdmin();
           break;
           case 2:
               Competicion c = c1;
               c.setEstado("cerrado");
               menuAdmin();
           break;
           case 3:
               introducirResultados();
               menuAdmin();
               break;
           case 4:
               if (equipos.isEmpty()) {
                   throw new RuntimeException("No existen equipos");
               }
               else {
               verEquipos();
               verJugadores();}
                 break;

           case 5:
               System.out.println("que quieres crear?(jugador/equipo)");
               String respuesta = sc.next().toLowerCase();
               if (respuesta.equalsIgnoreCase("jugador")) {
                   if (equipos.isEmpty()) {
                       System.out.println("primero se deben de crear los equipos");
                       inscribirEquipo();
                   }
                   else {
                       inscribirJugador();
                   }
               }
               if (respuesta.equalsIgnoreCase("equipo")) {
                   inscribirJugador();
               }
               break;
               case 6:
                   menu();
                   break;
       }
    }


    public static void crearEnfrentamientos() {
        LocalDate fecha = LocalDate.now();
        LocalDate fechaSemana = fecha.plusWeeks(1);
        LocalTime hora = LocalTime.of(21,00);
        for (int i = 0; i < equipos.size()/2; i++) {
            System.out.print("cual es el id del enfrentamiento");
            String id_enfrentamiento = sc.next();
            Equipo equipo1 = equipos.get(i * 2);
            Equipo equipo2 = equipos.get(i * 2 + 1);

            Enfrentamiento e1 = new Enfrentamiento(fechaSemana, hora, id_enfrentamiento, equipo1, equipo2);
            enfrentamientos.add(e1);
            }
        }

        public static void crearJornadas(){
        for (int i = 0; i < (equipos.size() -1 ) * 2; i++) {
            System.out.print("cual es el id de la jornada");
            String id_jornada = sc.next();
            Enfrentamiento e1 = enfrentamientos.get(i% enfrentamientos.size());
            Jornada j = new Jornada(id_jornada,(i+1),e1.getFecha(),e1);
            jornadas.add(j);
        }
        }

        public static void crearUsuarios(){
        System.out.print("que quieres crear Admin/user");
        String opcion = sc.nextLine().toLowerCase();
        switch(opcion){
            case "admin": {
                System.out.print("cuantos quieres crear?");
                int opcion2 = sc.nextInt();
                for (int i = 0; i<opcion2; i++) {
                    System.out.print("que nombre?");
                    String nombre = sc.next();
                    System.out.print("contraseña:");
                    String password = sc.next();
                    Admin admin = new Admin(nombre,password);
                    admins.add(admin);
                    usuarios.add(admin);
                }
                menu();
            }
            case "user": {
                System.out.print("cuantos quieres crear?");
                int opcion2 = sc.nextInt();
                for (int i = 0; i<opcion2; i++) {
                    System.out.print("que nombre?");
                    String nombre = sc.next();
                    System.out.print("contraseña:");
                    String password = sc.next();
                    User user = new User(nombre,password);
                    users.add(user);
                    usuarios.add(user);
                }
                menu();
            }

        }
        }

        public static void crearCompeticion(){
        System.out.print("que nombre tiene la competicion:");
        String nombre = sc.nextLine();
        System.out.println("cual es el estado de la competicion");
        String competiocion = sc.nextLine();
        c1 = new Competicion(nombre,competiocion,jornadas);
        }
    public static void introducirResultados() {
        for (int i = 0; i < enfrentamientos.size(); i++) {
            Enfrentamiento e = enfrentamientos.get(i);

            System.out.println("Enfrentamiento " + (i + 1) +
                    " - Equipo Local: " + e.getEquipo_local().getNombre() +
                    " vs Equipo Visitante: " + e.getEquipo_visitante().getNombre());

            System.out.print("Cuantos goles ha marcado el local: ");
            int golesLocal = sc.nextInt();

            System.out.print("Cuantos goles ha marcado el visitante: ");
            int golesVisitante = sc.nextInt();

            e.setGoles_local(golesLocal);
            e.setGoles_visitante(golesVisitante);
        }

        System.out.println("Resultados introducidos correctamente");
    }

    public static void mostrarResultados() {
        if (enfrentamientos.isEmpty()) {
            System.out.println("Error: No hay enfrentamientos creados.");
            return;
        }

        boolean hayResultados = false;

        System.out.println("----- RESULTADOS -----");
        for (int i = 0; i < enfrentamientos.size(); i++) {
            Enfrentamiento e = enfrentamientos.get(i);

            String local = e.getEquipo_local().getNombre();
            String visitante = e.getEquipo_visitante().getNombre();
            int golesLocal = e.getGoles_local();
            int golesVisitante = e.getGoles_visitante();

            if (golesLocal == -1 || golesVisitante == -1) {
                System.out.println((i + 1) + ". " + local + " vs " + visitante + " (Aún no jugado)");
            } else {
                System.out.println((i + 1) + ". " + local + " " + golesLocal + " - " + golesVisitante + " " + visitante);
                hayResultados = true;
            }
        }
        if (!hayResultados) {
            System.out.println("Error: No hay resultados registrados aún.");
        }

        System.out.println("----------------------");
    }


}
