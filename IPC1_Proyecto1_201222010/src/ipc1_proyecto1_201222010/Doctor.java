package ipc1_proyecto1_201222010;

/**
 *
 * @author nelson
 */
public class Doctor extends Persona {
    private String especialidad;
    private String telefono;

    public Doctor(String codigo, String nombres, String apellidos, String especialidad, String telefono, String edad, String contraseña, String sexo) {
        super(codigo, nombres, apellidos, edad, sexo, contraseña);
        this.especialidad=especialidad;
        this.telefono=telefono;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
