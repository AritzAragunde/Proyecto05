import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Enfrentamiento {
    private LocalDate fecha;
    private LocalTime hora;
    private String id_enfrentamiento;
    private Equipo equipo_local;
    private Equipo equipo_visitante;
    private int goles_local;
    private int goles_visitante;
    private static List<Equipo> equipos = new ArrayList<>();


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getId_enfrentamiento() {
        return id_enfrentamiento;
    }

    public void setId_enfrentamiento(String id_enfrentamiento) {
        this.id_enfrentamiento = id_enfrentamiento;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Equipo getEquipo_local() {
        return equipo_local;
    }

    public void setEquipo_local(Equipo equipo_local) {
        this.equipo_local = equipo_local;
    }

    public Equipo getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setEquipo_visitante(Equipo equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    public static List<Equipo> getEquipos() {
        return equipos;
    }

    public static void setEquipos(List<Equipo> equipos) {
        Enfrentamiento.equipos = equipos;
    }

    public Enfrentamiento(LocalDate fecha, LocalTime hora, String id_enfrentamiento, Equipo equipo_local, Equipo equipo_visitante) {
        this.fecha = fecha;
        this.hora = hora;
        this.id_enfrentamiento = id_enfrentamiento;
        this.equipo_local = equipo_local;
        this.equipo_visitante = equipo_visitante;
    }

    @Override
    public String toString() {
        return "Enfrentamiento{" +
                "fecha=" + fecha +
                ", hora=" + hora +
                ", id_enfrentamiento='" + id_enfrentamiento + '\'' +
                ", equipo_local=" + equipo_local +
                ", equipo_visitante=" + equipo_visitante +
                ", goles_local=" + goles_local +
                ", goles_visitante=" + goles_visitante +
                '}';
    }


}

