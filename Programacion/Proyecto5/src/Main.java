import java.time.format.DateTimeParseException;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  

    public static void jugadores() {
        Scanner sc = new Scanner(System.in);

        String nombre = "";
        boolean valido = false;
        do {
            try {
                System.out.print("Nombre del Jugador: ");
                nombre = sc.nextLine();
                if (nombre.trim().isEmpty()) throw new Exception();
                valido = true;
                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]{3,}$");
                Matcher mat = pat.matcher(nombre);
                if (mat.matches()) {
                    valido = true;
                }
                else  {
                    valido = false;
                    System.out.println("Nombre invalido");
                }
            } catch (Exception e) {
                System.out.println("El nombre introducido para el jugador no es válido. Intenta de nuevo.");
            }
        } while (!valido);

        String apellido = "";
        valido = false;
        do {
            try {
                System.out.print("Apellido del Jugador: ");
                apellido = sc.nextLine();
                if (apellido.trim().isEmpty()) throw new Exception();
                valido = true;
                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]{3,}$");
                Matcher mat = pat.matcher(apellido);
                if (mat.matches()) {
                    valido = true;
                }
                else  {
                    valido = false;
                    System.out.println("Apellido invalido");
                }
            } catch (Exception e) {
                System.out.println("El apellido del jugador no es válido. Intenta de nuevo.");
            }
        } while (!valido);

        String nacionalidad = "";
        valido = false;
        do {
            try {
                System.out.print("Nacionalidad del Jugador: ");
                nacionalidad = sc.nextLine();
                if (nacionalidad.trim().isEmpty()) throw new Exception();
                valido = true;
                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]{3,}$");
                Matcher mat = pat.matcher(nacionalidad);
                if (mat.matches()) {
                    valido = true;
                }
                else  {
                    valido = false;
                    System.out.println("Nacionalidad invalido");
                }
            } catch (Exception e) {
                System.out.println("La nacionalidad del jugador no es válida. Intenta de nuevo.");
            }
        } while (!valido);

        LocalDate fechaNacimiento = null;
        valido = false;
        do {
            try {
                System.out.print("Fecha de nacimiento del Jugador (dd/MM/yyyy): ");
                String fecha_nacimiento = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaNacimiento = LocalDate.parse(fecha_nacimiento, formatter);
                valido = true;
            } catch (Exception e) {
                System.out.println("La fecha de nacimiento no es válida. Intenta de nuevo (formato dd/MM/yyyy).");
            }
        } while (!valido);

        String nickname = "";
        valido = false;
        do {
            try {
                System.out.print("Nickname del Jugador: ");
                nickname = sc.nextLine();
                if (nickname.trim().isEmpty()) throw new Exception();
                valido = true;
                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]{3,}$");
                Matcher mat = pat.matcher(nickname);
                if (mat.matches()) {
                    valido = true;
                }
                else  {
                    valido = false;
                    System.out.println("nickname invalido");
                }
            } catch (Exception e) {
                System.out.println("El nickname no es válido. Intenta de nuevo.");
            }
        } while (!valido);

        String rol = "";
        valido = false;
        do {
            try {
                System.out.print("Rol del Jugador: ");
                rol = sc.nextLine();
                if (rol.trim().isEmpty()) throw new Exception();
                valido = true;
                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]{3,}$");
                Matcher mat = pat.matcher(rol);
                if (mat.matches()) {
                    valido = true;
                }
                else  {
                    valido = false;
                    System.out.println("Rol invalido");
                }
            } catch (Exception e) {
                System.out.println("El rol no es válido. Intenta de nuevo.");
            }
        } while (!valido);

        int sueldo = 0;
        valido = false;
        do {
            try {
                System.out.print("Sueldo del Jugador: ");
                sueldo = Integer.parseInt(sc.nextLine());
                valido = true;
                if (sueldo>0) {
                    valido = true;
                }
                else  {
                    valido = false;
                    System.out.println("No se puede introducir un sueldo negativo");
                }
            } catch (Exception e) {
                System.out.println("El sueldo no es válido. Introduce un número entero.");
            }
        } while (!valido);
    }
    
    public static void equipos() {

    Scanner sc = new Scanner(System.in);
    boolean valido;
    do {
        valido = true;
        try {
            System.out.println("Ingrese el nombre del equipo ");
            String nombreEquipo = sc.nextLine();
            Pattern pattern = Pattern.compile("[A-Za-z]+$");
            Matcher mat = pattern.matcher(nombreEquipo);
            if(mat.matches()){
                valido = true;
            } else {
                valido = false;
                System.out.println("Cadena incorrecta");
            }
            if (nombreEquipo.isEmpty()) {
                throw new Exception("El nombre no puede estar vacío.");
            }
        } catch (Exception e) {
            System.out.println("Error en el equipo");
            valido = false;
        }
    }while(!valido);
    do {
        try {
            System.out.println("Ingrese la fecha de fundacion del equipo ");
            String fechaInput = sc.nextLine();
            LocalDate fechaFundacion = validarFecha(fechaInput);
        } catch (Exception e) {
            System.out.println("Error en el fecha de fundacion del equipo");
            valido = false;
        }
    }while(!valido);
    do {
        try {
            System.out.println("Ingrese los jugadores del equipo ");
            String jugador = sc.nextLine();
            Pattern pattern = Pattern.compile("^(?:[1-9]|1[0-9]|2[0-4])$");
            Matcher mat = pattern.matcher(jugador);
            if(mat.matches()){
                valido = true;
            } else {
                valido = false;
                System.out.println("Cadena incorrecta");
            }
            if (jugador.isEmpty()) {
                throw new Exception("El nombre no puede estar vacío.");
            }
        } catch (Exception e) {
            System.out.println("Error en los jugadores del equipo");
            valido = false;
        }
    }while(!valido);
}
public static LocalDate validarFecha(String fechaInput) throws Exception {
    try {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaInput, formato);


        if (fecha.isAfter(LocalDate.now())) {
            throw new Exception("La fecha no puede ser futura.");
        }
        return fecha;
    } catch (DateTimeParseException e) {
        throw new Exception("Formato de fecha incorrecto. Use dd/MM/yyyy");
    }
}
   public static void main() {

    Scanner sc = new Scanner(System.in);
    int respuesta = 0;

    do {
        try {
            System.out.println("\n========= MENU =========\n" +
                    "1) Inscribir Equipos \n" +
                    "2) Inscribir Jugadores\n" +
                    "3) Salir");

            respuesta = sc.nextInt();
            sc.nextLine();

            switch (respuesta) {
                case 1:
                    equipos();
                    break;
                case 2:
                    jugadores();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } catch (Exception e) {
            System.err.println("Error: Debe introducir un número válido.");
            sc.nextLine();
        }

    } while (respuesta != 3);

    sc.close();

 }
}


