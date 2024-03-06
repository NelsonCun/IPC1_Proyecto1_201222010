package ipc1_proyecto1_201222010;

/**
 *
 * @author nelson
 */
class Administrador {
    private String codigo;
    private String Nombre;
    private String Contraseña;

    public Administrador(String codigo, String Nombre, String Contraseña) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Contraseña
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * @param Contraseña the Contraseña to set
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
}

