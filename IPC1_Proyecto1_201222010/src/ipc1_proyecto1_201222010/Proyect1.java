package ipc1_proyecto1_201222010;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author nelson
 */
public class Proyect1 {

    static ArrayList<Doctor> doctores = new ArrayList<>();
    //static ArrayList<String[]> pacientes = new ArrayList<>();
    //static ArrayList<String[]> productos = new ArrayList<>();
    static int codigoDoctores = 20241000;
    static int codigoPacientes= 20242000;
    static int codigoProductos= 20243000;

    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login login = new Login();
        
    }
    
    
    //Añadir doctores al ArrayList
    public static void addDoctor(Doctor datosDoctores) {
        doctores.add(datosDoctores);
    }
    
    //Para mostrar tabla doctores
    public static Object[][] convertirDatosDoctores() {
        int filas = doctores.size();
        Object[][] arregloDoctores = new Object[filas][8];
        for (int i = 0; i < filas; i++) {
            arregloDoctores[i][0] = doctores.get(i).getCodigo();
            arregloDoctores[i][1] = doctores.get(i).getNombres();
            arregloDoctores[i][2] = doctores.get(i).getApellidos();
            arregloDoctores[i][3] = doctores.get(i).getEspecialidad();
            arregloDoctores[i][4] = doctores.get(i).getTelefono();
            arregloDoctores[i][5] = doctores.get(i).getEdad();
            arregloDoctores[i][6] = doctores.get(i).getSexo();
        }
        return arregloDoctores;
    }
    
    public static int codigoActual = 0;
    
    public static boolean validarCodigoDoctor(String codigo){
        for (int i = 0; i < doctores.size(); i++) {
            String codigoTem = doctores.get(i).getCodigo();
            if (codigoTem.equals(codigo)) {
                codigoActual = i;
                return true;
            }
        }
        return false;
    }
    

}
