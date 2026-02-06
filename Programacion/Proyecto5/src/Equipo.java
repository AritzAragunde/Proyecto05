import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private LocalDate fecha_fundacion;
    private int jugadores;
    private List<Jugador> lista_jugadores = new ArrayList<>();

    public Equipo(List<Jugador> lista_jugadores, String nombre) {
        this.lista_jugadores = lista_jugadores;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(LocalDate fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public List<Jugador> getLista_jugadores() {
        return lista_jugadores;
    }

    public void setLista_jugadores(List<Jugador> lista_jugadores) {
        this.lista_jugadores = lista_jugadores;
    }



    public Equipo(String nombre, LocalDate fecha_fundacion) {
        this.nombre = nombre;
        this.lista_jugadores = lista_jugadores;
        this.jugadores = jugadores;
        this.fecha_fundacion = this.fecha_fundacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", fecha_fundacion='" + fecha_fundacion + '\'' +
                ", jugadores=" + jugadores +
                ", lista_jugadores=" + lista_jugadores +
                '}';
    }

    public void jugadoresMaxMin() {
        if (lista_jugadores.size() > 6){
            System.out.println("no se permite inscribir a tantos jugadores, maximo 6");
        }
        else {
            System.out.println("equipo creado con: " + lista_jugadores.size() + "jugadores");
        }
    }

}
