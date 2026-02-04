import java.util.ArrayList;
import java.util.List;

public class Competicion {
    private String nombre;
    private String estado_competicion;
    private List<Jornada> lista_jornadas;
    private static ArrayList<Equipo> equiposTorneo = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado_competicion() {
        return estado_competicion;
    }

    public void setEstado_competicion(String estado_competicion) {
        this.estado_competicion = estado_competicion;
    }

    public List<Jornada> getLista_jornadas() {
        return lista_jornadas;
    }

    public void setLista_jornadas(List<Jornada> lista_jornadas) {
        this.lista_jornadas = lista_jornadas;
    }

    public Competicion(String nombre, String estado_competicion, List<Jornada> lista_jornadas) {
        this.nombre = nombre;
        this.estado_competicion = estado_competicion;
        this.lista_jornadas = lista_jornadas;
    }

    @Override
    public String toString() {
        return "Competicion{" +
                "nombre='" + nombre + '\'' +
                ", estado_competicion='" + estado_competicion + '\'' +
                ", lista_jornadas=" + lista_jornadas +
                ", equipos=" + equiposTorneo +
                '}';
    }

    public static void equipospares(){
        if (equiposTorneo.size() % 2 == 0) {
            System.out.println("Se pueden hacer emparejamientos, equipos pares");
        } else {
            System.out.println("Número de equipos impar, falta o sobra uno");
        }

    }

}
