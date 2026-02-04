public class Calendario {
    private String fecha;
    private String hora;
    private int numero_jornada;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumero_jornada() {
        return numero_jornada;
    }

    public void setNumero_jornada(int numero_jornada) {
        this.numero_jornada = numero_jornada;
    }

    public Calendario(String fecha, String hora, int numero_jornada) {
        this.fecha = fecha;
        this.hora = hora;
        this.numero_jornada = numero_jornada;
    }

    @Override
    public String toString() {
        return "Calendario{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", numero_jornada=" + numero_jornada +
                '}';
    }
}
