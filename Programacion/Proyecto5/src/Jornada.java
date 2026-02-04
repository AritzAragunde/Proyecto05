import java.util.List;

public class Jornada {
    private String id_jornada;
    private int numero;
    private String fecha;
    private List<Enfrentamiento> lista_enfrentamientos;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Enfrentamiento> getLista_enfrentamientos() {
        return lista_enfrentamientos;
    }

    public void setLista_enfrentamientos(List<Enfrentamiento> lista_enfrentamientos) {
        this.lista_enfrentamientos = lista_enfrentamientos;
    }

    public Jornada(String id_jornada, int numero, String fecha, List<Enfrentamiento> lista_enfrentamientos) {
        this.id_jornada = id_jornada;
        this.numero = numero;
        this.fecha = fecha;
        this.lista_enfrentamientos = lista_enfrentamientos;
    }

    @Override
    public String toString() {
        return "Jornada{" +
                "id_jornada='" + id_jornada + '\'' +
                ", numero=" + numero +
                ", fecha='" + fecha + '\'' +
                ", lista_enfrentamientos=" + lista_enfrentamientos +
                '}';
    }
}
