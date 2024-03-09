package ipc1_proyecto1_201222010;

import java.util.ArrayList;

/**
 *
 * @author nelson
 */
public class Paciente extends Persona {
    
    private ArrayList<Cita> citas;
    
    public Paciente(String codigo, String nombres, String apellidos, String edad, String contraseña,String sexo) {
        super(codigo, nombres, apellidos, edad, sexo, contraseña);
        this.citas = new ArrayList<>();
    }

    /**
     * @return the citas
     */
    public ArrayList<Cita> getCitas() {
        return citas;
    }

    /**
     * @param citas the citas to set
     */
    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    
}
