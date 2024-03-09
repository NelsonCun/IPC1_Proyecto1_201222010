package ipc1_proyecto1_201222010;

/**
 *
 * @author nelson
 */
class Cita {
    private String estado;
    private String especialidad;
    private String doctor;
    private String fecha;
    private String horario;
    private String motivoCita;

    public Cita(String estado, String especialidad, String doctor, String fecha, String horario, String motivoCita) {
        this.estado = estado;
        this.especialidad = especialidad;
        this.doctor = doctor;
        this.fecha = fecha;
        this.horario = horario;
        this.motivoCita = motivoCita;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @return the doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the motivoCita
     */
    public String getMotivoCita() {
        return motivoCita;
    }

    /**
     * @param motivoCita the motivoCita to set
     */
    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }
    
    
}
