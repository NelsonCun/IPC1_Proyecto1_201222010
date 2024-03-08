package ipc1_proyecto1_201222010;

import java.util.ArrayList;

/**
 *
 * @author nelson
 */
public class Fecha {
    private String dia;
    private ArrayList<String> horario;

    public Fecha(String dia) {
        this.dia = dia;
        this.horario = new ArrayList<>();
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the horario
     */
    public ArrayList<String> getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(ArrayList<String> horario) {
        this.horario = horario;
    }
    
    

}
