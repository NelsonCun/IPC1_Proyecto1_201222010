package ipc1_proyecto1_201222010;

/**
 *
 * @author nelson
 */
public class Doctor extends Persona {
    private String especialidad;
    private String telefono;

    public Doctor(String codigo, String nombres, String apellidos, String edad, String sexo, String contraseña) {
        super(codigo, nombres, apellidos, edad, sexo, contraseña);
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
    
    public String[] datosDoctores(){
        String[] newDoctor = new String[8];
        newDoctor[0] = this.getCodigo();
        newDoctor[1] = this.getNombres();
        newDoctor[2] = this.getApellidos();
        newDoctor[3] = this.getEdad();
        newDoctor[4] = this.getSexo();
        newDoctor[5] = this.getContraseña();
        newDoctor[6] = this.getEspecialidad();
        newDoctor[7] = this.getTelefono();
        return newDoctor;
    }
    
}
