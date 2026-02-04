import java.util.List;

public class Enfrentamiento {
    private String id_enfrentamiento;
    private String equipo_local;
    private String equipo_visitante;
    private int goles_local;
    private int goles_visitante;
    private List <Equipo> equipos;

    public String getId_enfrentamiento() {
        return id_enfrentamiento;
    }

    public void setId_enfrentamiento(String id_enfrentamiento) {
        this.id_enfrentamiento = id_enfrentamiento;
    }

    public String getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setEquipo_visitante(String equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }

    public String getEquipo_local() {
        return equipo_local;
    }

    public void setEquipo_local(String equipo_local) {
        this.equipo_local = equipo_local;
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

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Enfrentamiento(String id_enfrentamiento, String equipo_local, String equipo_visitante, int goles_local, int goles_visitante, List<Equipo> equipos) {
        this.id_enfrentamiento = id_enfrentamiento;
        this.equipo_local = equipo_local;
        this.equipo_visitante = equipo_visitante;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Enfrentamiento{" +
                "id_enfrentamiento='" + id_enfrentamiento + '\'' +
                ", equipo_local='" + equipo_local + '\'' +
                ", equipo_visitante='" + equipo_visitante + '\'' +
                ", goles_local=" + goles_local +
                ", goles_visitante=" + goles_visitante +
                ", equipos=" + equipos +
                '}';
    }
}
