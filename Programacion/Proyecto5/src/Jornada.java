import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Jornada {
    private String id_jornada;
    private int numero;
    private LocalDate fecha;
    private List<Enfrentamiento> enfrentamientos = new ArrayList<>();

    public String getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(String id_jornada) {
        this.id_jornada = id_jornada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(List<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }

    public Jornada(String id_jornada, int numero, LocalDate fecha) {
        this.id_jornada = id_jornada;
        this.numero = numero;
        this.fecha = fecha;
        this.enfrentamientos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Jornada{" +
                "id_jornada='" + id_jornada + '\'' +
                ", numero=" + numero +
                ", fecha=" + fecha +
                ", enfrentamientos=" + enfrentamientos +
                '}';
    }

}
