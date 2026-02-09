import java.time.LocalDate;
import java.time.LocalTime;
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
    private static List<Competicion> competiciones = new ArrayList<>();

    // ------------------- INSCRIPCIONES -------------------
    public static void inscribirJugador() {
        if (equipos.isEmpty()) {
            System.out.println("Error: Debes crear al menos un equipo antes de inscribir jugadores.");
            return;
        }

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
                    numJugadores = Integer.parseInt(sc.nextLine());
                    if (numJugadores < 2 || numJugadores > jugadoresFaltantes) {
                        System.out.println("Error: Debes ingresar un número entre 2 y " + jugadoresFaltantes + ".");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Debes ingresar un número válido.");
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

                    // Validación de fecha de nacimiento
                    LocalDate fecha_nacimiento;
                    while (true) {
                        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
                        try {
                            fecha_nacimiento = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            break;
                        } catch (Exception e) {
                            System.out.println("Error: Formato de fecha incorrecto.");
                        }
                    }
                    String fechaNacimientoStr = fecha_nacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    System.out.print("Nickname: ");
                    String nickname = sc.nextLine();

                    System.out.print("Rol del jugador: ");
                    String rol = sc.nextLine();

                    // Validación del sueldo
                    double sueldo;
                    while (true) {
                        System.out.print("Sueldo: ");
                        try {
                            sueldo = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Error: Debes ingresar un número válido.");
                        }
                    }

                    // Se asume que esta función comprueba el salario mínimo
                    Jugador.salarioMinimo();

                    // Crear jugador usando String para la fecha
                    Jugador j1 = new Jugador(contadorIdJugador, nombre, apellido, nacionalidad, fechaNacimientoStr, nickname, rol, sueldo);

                    jugadores.add(j1);
                    equipo.getLista_jugadores().add(j1);

                    System.out.println("Se ha añadido al jugador " + nombre + " al equipo " + equipo.getNombre());
                    contadorIdJugador++;

                } catch (Exception e) {
                    System.out.println("Error al ingresar el jugador: " + e.getMessage());
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
                numEquipos = Integer.parseInt(sc.nextLine());

                if (numEquipos <= 0) {
                    System.out.println("Error: Debe ser un número mayor que cero.");
                } else if (numEquipos % 2 != 0) {
                    System.out.println("Error: El número de equipos debe ser PAR.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un número entero.");
            }
        }

        for (int i = 0; i < numEquipos; i++) {
            try {
                System.out.println("Indique el nombre del equipo:");
                String nombre = sc.nextLine();

                LocalDate fecha_fundacion;
                while (true) {
                    System.out.println("Ingrese la fecha de fundación (dd/MM/yyyy):");
                    try {
                        fecha_fundacion = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: Formato de fecha incorrecto.");
                    }
                }

                Equipo e1 = new Equipo(nombre, fecha_fundacion);
                equipos.add(e1);

                System.out.println("Equipo " + nombre + " inscrito correctamente!");
            } catch (Exception e) {
                System.out.println("Error al registrar el equipo. Formato de fecha incorrecto.");
                i--;
            }
        }

        System.out.println("Todos los equipos inscritos correctamente!");
    }

    // ------------------- VER EQUIPOS/JUGADORES -------------------
    public static void verEquipos() {
        System.out.println(equipos);
        System.out.println("QUIERES VOLVER AL MENU? s/n");
        String respuesta = sc.next();
        sc.nextLine();
        System.out.println("Volviendo al menu ......");
        menuAdmin();
    }

    public static void verJugadores() {
        System.out.println(jugadores);
        System.out.println("QUIERES VOLVER AL MENU? s/n");
        String respuesta = sc.next();
        sc.nextLine();
        System.out.println("Volviendo al menu ......");
        menuAdmin();
    }

    // ------------------- MAIN -------------------
    public static void main(String[] args) {
        inscribirEquipo();
        inscribirJugador();
        menuAdmin();
    }

    // ------------------- MENU ADMIN -------------------
    public static void menuAdmin() {
        System.out.println("1.-Generar calendario\n" +
                "2.-Cerrar estado de la competicion\n" +
                "3.- Introducir resultado\n" +
                "4.-Ver informes\n" +
                "5.-CRUD\n" +
                "6.-Salir");
        int opcion = Integer.parseInt(sc.nextLine());
        switch (opcion) {
            case 1:
                crearEnfrentamientos();
                crearJornadas();
                crearCompeticion();
                System.out.println("Calendario creado");
                menuAdmin();
                break;
            case 2:
                if (c1 != null) c1.setEstado("cerrado");
                menuAdmin();
                break;
            case 3:
                introducirResultados();
                menuAdmin();
                break;
            case 4:
                if (equipos.isEmpty()) {
                    System.out.println("No existen equipos");
                } else {
                    System.out.println("Que quieres ver?(equipos/jugadores/competicion/enfrentamientos/resultados)");
                    String respuesta = sc.nextLine().toLowerCase();
                    switch (respuesta) {
                        case "equipos": verEquipos(); break;
                        case "jugadores": verJugadores(); break;
                        case "competicion": verCompeticion(); break;
                        case "enfrentamientos": verEnfrentamientos(); break;
                        case "resultados": verJornada(); break;
                        default: System.out.println("Opción no válida");
                    }
                }
                menuAdmin();
                break;
            case 5:
                crud();
                menuAdmin();
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
        }
    }

    // ------------------- FUNCIONES AUXILIARES -------------------
    public static void crearCompeticion() {
        System.out.print("Que nombre tiene la competicion:");
        String nombre = sc.nextLine();
        c1 = new Competicion(nombre, jornadas);
    }

    public static void crearEnfrentamientos() {
        LocalDate fecha = LocalDate.now().plusWeeks(1);
        LocalTime hora = LocalTime.of(21, 0);

        enfrentamientos.clear();

        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {

                System.out.print("ID enfrentamiento (IDA) " + equipos.get(i).getNombre() + " vs " + equipos.get(j).getNombre() + ": ");
                String idIda = sc.nextLine();

                enfrentamientos.add(new Enfrentamiento(fecha, hora, idIda, equipos.get(i), equipos.get(j)));

                System.out.print("ID enfrentamiento (VUELTA) " + equipos.get(j).getNombre() + " vs " + equipos.get(i).getNombre() + ": ");
                String idVuelta = sc.nextLine();

                enfrentamientos.add(new Enfrentamiento(fecha.plusWeeks(1), hora, idVuelta, equipos.get(j), equipos.get(i)));
            }
        }

        System.out.println("Se han creado " + enfrentamientos.size() + " enfrentamientos.");
    }

    public static void crearJornadas() {
        jornadas.clear();

        int indice = 0;
        int jornadaNum = 1;

        while (indice < enfrentamientos.size()) {
            String id_jornada = "J" + jornadaNum;
            LocalDate fechaJornada = enfrentamientos.get(indice).getFecha();
            Jornada j = new Jornada(id_jornada, jornadaNum, fechaJornada);

            j.getEnfrentamientos().add(enfrentamientos.get(indice));
            indice++;

            jornadas.add(j);
            jornadaNum++;
        }
    }

    public static void introducirResultados() {
        if (enfrentamientos.isEmpty()) {
            System.out.println("No hay enfrentamientos creados.");
            return;
        }

        for (int i = 0; i < enfrentamientos.size(); i++) {
            Enfrentamiento e = enfrentamientos.get(i);
            System.out.println("Enfrentamiento " + (i + 1) + " - Equipo Local: " + e.getEquipo_local().getNombre() +
                    " vs Equipo Visitante: " + e.getEquipo_visitante().getNombre());
            int golesLocal;
            while (true) {
                try {
                    System.out.print("Cuantos goles ha marcado el local: ");
                    golesLocal = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) { System.out.println("Número inválido"); }
            }
            int golesVisitante;
            while (true) {
                try {
                    System.out.print("Cuantos goles ha marcado el visitante: ");
                    golesVisitante = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception ex) { System.out.println("Número inválido"); }
            }

            e.setGoles_local(golesLocal);
            e.setGoles_visitante(golesVisitante);
        }

        System.out.println("Resultados introducidos correctamente");
    }

    // ------------------- FUNCIONES VER -------------------
    public static void verCompeticion() { if (c1 != null) { System.out.println(c1.getNombre() + " - " + c1.getEstado()); } else { System.out.println("No hay competicion"); } }
    public static void verJornada() { System.out.println(jornadas); }
    public static void verEnfrentamientos() { System.out.println(enfrentamientos); }

    // ------------------- CRUD -------------------
    public static void crud() {
        System.out.println("¿Qué quieres hacer? (ver / crear / modificar / borrar)");
        String respuesta = sc.nextLine().toLowerCase();

        switch (respuesta) {

            case "ver":
                System.out.println("¿Qué quieres ver? (equipos / jugadores / competicion / enfrentamientos / resultados)");
                String respuestaVer = sc.nextLine().toLowerCase();

                switch (respuestaVer) {
                    case "equipos":
                        verEquipos();
                        break;
                    case "jugadores":
                        verJugadores();
                        break;
                    case "competicion":
                        verCompeticion();
                        break;
                    case "enfrentamientos":
                        verEnfrentamientos();
                        break;
                    case "resultados":
                        verJornada();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                break;

            case "crear":
                System.out.println("¿Qué quieres crear? (equipo / jugador / competicion / enfrentamientos / jornadas)");
                String respuestaCrear = sc.nextLine().toLowerCase();

                switch (respuestaCrear) {
                    case "equipo":
                        inscribirEquipo();
                        break;
                    case "jugador":
                        inscribirJugador();
                        break;
                    case "competicion":
                        crearCompeticion();
                        break;
                    case "enfrentamientos":
                        crearEnfrentamientos();
                        break;
                    case "jornadas":
                        crearJornadas();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                break;

            case "modificar":
                System.out.println("¿Qué quieres modificar? (equipos / jugadores / resultados)");
                String respuestaModificar = sc.nextLine().toLowerCase();

                switch (respuestaModificar) {
                    case "equipos":
                        modificarEquipos();
                        break;
                    case "jugadores":
                        modificarJugadores();
                        break;
                    case "resultados":
                        modificarResultados();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                break;

            case "borrar":
                System.out.println("¿Qué quieres borrar? (equipos / jugadores / competicion / enfrentamientos)");
                String respuestaBorrar = sc.nextLine().toLowerCase();

                switch (respuestaBorrar) {
                    case "equipos":
                        borrarEquipos();
                        break;
                    case "jugadores":
                        borrarJugadores();
                        break;
                    case "competicion":
                        borrarCompeticion();
                        break;
                    case "enfrentamientos":
                        borrarEnfrentamientos();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                break;

            default:
                System.out.println("Acción no válida");
        }
    }
    public static void modificarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos para modificar.");
            return;
        }
        System.out.println("=== MODIFICAR EQUIPO ===");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        System.out.print("Selecciona el número del equipo que quieres modificar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > equipos.size()) {
            System.out.println("Opción inválida.");
            return;
        }
        Equipo equipo = equipos.get(opcion - 1);
        System.out.println("Has seleccionado: " + equipo.getNombre());
        System.out.print("Nuevo nombre (enter para mantener '" + equipo.getNombre() + "'): ");
        String nuevoNombre = sc.nextLine();
        if (!nuevoNombre.isEmpty()) {
            equipo.setNombre(nuevoNombre);
        }
        System.out.print("Nueva fecha de fundación (dd/MM/yyyy) (enter para mantener '" + equipo.getFecha_fundacion() + "'): ");
        String fechaStr = sc.nextLine();
        if (!fechaStr.isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate nuevaFecha = LocalDate.parse(fechaStr, formatter);
                equipo.setFecha_fundacion(nuevaFecha);
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto, se mantiene la original.");
            }
        }
        System.out.print("Nuevo número de jugadores (enter para mantener '" + equipo.getJugadores() + "'): ");
        String numJugadoresStr = sc.nextLine();
        if (!numJugadoresStr.isEmpty()) {
            try {
                int nuevosJugadores = Integer.parseInt(numJugadoresStr);
                equipo.setJugadores(nuevosJugadores);
            } catch (NumberFormatException e) {
                System.out.println("Número inválido, se mantiene el original.");
            }
        }
        System.out.println("Equipo modificado correctamente:");
        System.out.println(equipo);
    }

    public static void modificarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para modificar.");
            return;
        }
        System.out.println("=== MODIFICAR JUGADOR ===");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " " + j.getApellido() + " (" + j.getNickname() + ")");
        }
        System.out.print("Selecciona el número del jugador que quieres modificar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > jugadores.size()) {
            System.out.println("Opción inválida.");
            return;
        }
        Jugador jugador = jugadores.get(opcion - 1);
        System.out.println("Has seleccionado: " + jugador.getNombre() + " " + jugador.getApellido());
        System.out.print("Nuevo nombre (enter para mantener '" + jugador.getNombre() + "'): ");
        String nuevoNombre = sc.nextLine();
        if (!nuevoNombre.isEmpty()) jugador.setNombre(nuevoNombre);
        System.out.print("Nuevo apellido (enter para mantener '" + jugador.getApellido() + "'): ");
        String nuevoApellido = sc.nextLine();
        if (!nuevoApellido.isEmpty()) jugador.setApellido(nuevoApellido);
        System.out.print("Nueva nacionalidad (enter para mantener '" + jugador.getNacionalidad() + "'): ");
        String nuevaNacionalidad = sc.nextLine();
        if (!nuevaNacionalidad.isEmpty()) jugador.setNacionalidad(nuevaNacionalidad);
        System.out.print("Nueva fecha de nacimiento (dd/MM/yyyy) (enter para mantener '" + jugador.getFecha_nacimiento() + "'): ");
        String nuevaFecha = sc.nextLine();
        if (!nuevaFecha.isEmpty()) jugador.setFecha_nacimiento(nuevaFecha);
        System.out.print("Nuevo nickname (enter para mantener '" + jugador.getNickname() + "'): ");
        String nuevoNickname = sc.nextLine();
        if (!nuevoNickname.isEmpty()) jugador.setNickname(nuevoNickname);
        System.out.print("Nuevo rol (enter para mantener '" + jugador.getRol() + "'): ");
        String nuevoRol = sc.nextLine();
        if (!nuevoRol.isEmpty()) jugador.setRol(nuevoRol);
        System.out.println("Jugador modificado correctamente:");
        System.out.println(jugador);
    }

    public static void modificarResultados() {
        if (enfrentamientos.isEmpty()) {
            System.out.println("No hay enfrentamientos para modificar.");
            return;
        }
        System.out.println("=== MODIFICAR RESULTADOS DE ENFRENTAMIENTOS ===");
        for (int i = 0; i < enfrentamientos.size(); i++) {
            Enfrentamiento e = enfrentamientos.get(i);
            System.out.println((i + 1) + ". " + e.getEquipo_local().getNombre() + " vs " + e.getEquipo_visitante().getNombre() +
                    " | Resultado: " + e.getGoles_local() + " - " + e.getGoles_visitante() +
                    " | Fecha: " + e.getFecha() + " Hora: " + e.getHora());
        }
        System.out.print("Selecciona el número del enfrentamiento que quieres modificar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > enfrentamientos.size()) {
            System.out.println("Opción inválida.");
            return;
        }
        Enfrentamiento partido = enfrentamientos.get(opcion - 1);

        System.out.print("Goles de " + partido.getEquipo_local().getNombre() + " (enter para mantener " + partido.getGoles_local() + "): ");
        String golesLocalStr = sc.nextLine();
        if (!golesLocalStr.isEmpty()) partido.setGoles_local(Integer.parseInt(golesLocalStr));

        System.out.print("Goles de " + partido.getEquipo_visitante().getNombre() + " (enter para mantener " + partido.getGoles_visitante() + "): ");
        String golesVisitanteStr = sc.nextLine();
        if (!golesVisitanteStr.isEmpty()) partido.setGoles_visitante(Integer.parseInt(golesVisitanteStr));

        System.out.println("Resultado modificado correctamente:");
        System.out.println(partido.getEquipo_local().getNombre() + " " + partido.getGoles_local() +
                " - " + partido.getGoles_visitante() + " " + partido.getEquipo_visitante().getNombre());
    }

    public static void borrarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos para borrar.");
            return;
        }
        System.out.println("=== BORRAR EQUIPO ===");
        for (int i = 0; i < equipos.size(); i++) System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        System.out.print("Selecciona el número del equipo que quieres borrar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > equipos.size()) return;
        Equipo equipoBorrar = equipos.get(opcion - 1);
        System.out.print("¿Estás seguro de que quieres borrar el equipo '" + equipoBorrar.getNombre() + "'? (si/no): ");
        String confirmar = sc.nextLine().toLowerCase();
        if (confirmar.equals("si") || confirmar.equals("s")) {
            equipos.remove(equipoBorrar);
            System.out.println("Equipo borrado correctamente.");
        } else {
            System.out.println("Borrado cancelado.");
        }
    }

    public static void borrarJugadores() {
        if (jugadores.isEmpty()) return;
        System.out.println("=== BORRAR JUGADOR ===");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.getNombre() + " " + j.getApellido() + " (" + j.getNickname() + ")");
        }
        System.out.print("Selecciona el número del jugador que quieres borrar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > jugadores.size()) return;
        Jugador jugadorBorrar = jugadores.get(opcion - 1);
        System.out.print("¿Estás seguro de que quieres borrar al jugador '" + jugadorBorrar.getNombre() + " " + jugadorBorrar.getApellido() + "'? (si/no): ");
        String confirmar = sc.nextLine().toLowerCase();
        if (confirmar.equals("si") || confirmar.equals("s")) {
            jugadores.remove(jugadorBorrar);
            System.out.println("Jugador borrado correctamente.");
        } else {
            System.out.println("Borrado cancelado.");
        }
    }

    public static void borrarCompeticion() {
        if (competiciones.isEmpty()) return;
        System.out.println("=== BORRAR COMPETICIÓN ===");
        for (int i = 0; i < competiciones.size(); i++) System.out.println((i + 1) + ". " + competiciones.get(i).getNombre());
        System.out.print("Selecciona el número de la competición que quieres borrar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > competiciones.size()) return;
        Competicion competicionBorrar = competiciones.get(opcion - 1);
        System.out.print("¿Estás seguro de que quieres borrar la competición '" + competicionBorrar.getNombre() + "' y todas sus jornadas y enfrentamientos? (si/no): ");
        String confirmar = sc.nextLine().toLowerCase();
        if (confirmar.equals("si") || confirmar.equals("s")) {
            if (competicionBorrar.getLista_jornadas() != null) {
                for (Jornada j : competicionBorrar.getLista_jornadas()) {
                    if (j.getEnfrentamientos() != null) j.getEnfrentamientos().clear();
                }
                competicionBorrar.getLista_jornadas().clear();
            }
            competiciones.remove(competicionBorrar);
            System.out.println("Competición y todos sus datos asociados borrados correctamente.");
        } else {
            System.out.println("Borrado cancelado.");
        }
    }

    public static void borrarEnfrentamientos() {
        if (enfrentamientos.isEmpty()) return;
        System.out.println("=== BORRAR ENFRENTAMIENTO ===");
        for (int i = 0; i < enfrentamientos.size(); i++) {
            Enfrentamiento e = enfrentamientos.get(i);
            System.out.println((i + 1) + ". " + e.getEquipo_local().getNombre() + " vs " + e.getEquipo_visitante().getNombre() +
                    " | Fecha: " + e.getFecha() + " Hora: " + e.getHora() +
                    " | Resultado: " + e.getGoles_local() + "-" + e.getGoles_visitante());
        }
        System.out.print("Selecciona el número del enfrentamiento que quieres borrar: ");
        int opcion = Integer.parseInt(sc.nextLine());
        if (opcion < 1 || opcion > enfrentamientos.size()) return;
        Enfrentamiento enfrentamientoBorrar = enfrentamientos.get(opcion - 1);
        System.out.print("¿Estás seguro de que quieres borrar este enfrentamiento? (si/no): ");
        String confirmar = sc.nextLine().toLowerCase();
        if (confirmar.equals("si") || confirmar.equals("s")) {
            enfrentamientos.remove(enfrentamientoBorrar);
            System.out.println("Enfrentamiento borrado correctamente.");
        } else {
            System.out.println("Borrado cancelado.");
        }
    }

}