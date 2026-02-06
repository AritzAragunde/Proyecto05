import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int id_jugador;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String fecha_nacimiento;
    private String nickname;
    private String rol;
    private static double sueldo;
    private static List<Equipo> equipos = new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Jugador(int id_jugador, String nombre, String apellido, String nacionalidad, String fecha_nacimiento, String nickname, String rol, double sueldo) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nickname = nickname;
        this.rol = rol;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id_jugador='" + id_jugador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", nickname='" + nickname + '\'' +
                ", rol='" + rol + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
    public static void salarioMinimo(){
        if(sueldo < 1221){
            System.out.println("El sueldo minimo de un jugador no puede ser inferior al SMI");
        }
    }

}
