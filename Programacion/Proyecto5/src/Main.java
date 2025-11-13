import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



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


