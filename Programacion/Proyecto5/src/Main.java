import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                Pattern pat = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 ]+ $");
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    System.out.println("========= MENU =========\n" +
            "1) Inscribir Equipos \n" +
            "2) Inscribir Jugadores");
    int respuesta = sc.nextInt();
    try {
        if (respuesta == 1) {
            equipos();
        }
        if (respuesta == 2) {
            jugadores();
        }
    }
    catch (Exception e){
        System.err.println("No has escogido una opcion valida");
    }
    }
}