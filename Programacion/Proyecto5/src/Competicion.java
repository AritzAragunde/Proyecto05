import java.util.ArrayList;
import java.util.List;

public class Competicion {
    private String nombre;
    private String estado = "abierto";
    private List<Jornada> lista_jornadas = new ArrayList<>();

    public Competicion(String nombre,List<Jornada> lista_jornadas) {
        this.nombre = nombre;
        this.lista_jornadas = lista_jornadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Jornada> getLista_jornadas() {
        return lista_jornadas;
    }

    public void setLista_jornadas(List<Jornada> lista_jornadas) {
        this.lista_jornadas = lista_jornadas;
    }

    @Override
    public String toString() {
        return "Competicion{" +
                "nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", lista_jornadas=" + lista_jornadas +
                '}';
    }
}
