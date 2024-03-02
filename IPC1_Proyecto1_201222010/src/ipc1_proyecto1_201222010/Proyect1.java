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

    static ArrayList<String[]> doctores = new ArrayList<>();
    //static String[][] listado_doctores = {{"nombres","apellidos","especialidad","contraseña","género","teléfono","edad"}};
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
        //for (String[] newDoctor : Doctor) {
          //  doctores.add(newDoctor);
        //}
        Login login = new Login();
        
    }
    
    //Para mostrar tabla doctores
    public static Object[][] convertirDatosDoctores() {
        int filas = doctores.size();
        Object[][] arregloDoctores = new Object[filas][8];
        for (int i = 0; i < filas; i++) {
            arregloDoctores[i][0] = doctores.get(i)[0];
            arregloDoctores[i][1] = doctores.get(i)[1];
            arregloDoctores[i][2] = doctores.get(i)[2];
            arregloDoctores[i][3] = doctores.get(i)[3];
            arregloDoctores[i][4] = doctores.get(i)[4];
            arregloDoctores[i][5] = doctores.get(i)[5];
            arregloDoctores[i][6] = doctores.get(i)[6];
            arregloDoctores[i][7] = doctores.get(i)[7];
        }
        return arregloDoctores;
    }
    
    public static void addDoctor(String[] datosDoctores) {
        doctores.add(datosDoctores);
    }

}
