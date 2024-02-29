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
public class IPC1_Proyecto1_201222010 {

    static ArrayList<String[]> doctores = new ArrayList<>();
    static String[][] listado_doctores = {{"nombres","apellidos","especialidad","contraseña","género","teléfono","edad"}};
    static int codigo = 20240000;

    public static void main(String[] args) {
        try {
//            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String[] newDoctor : listado_doctores) {
            doctores.add(newDoctor);
        }
        Login login = new Login();
    }
    

}
