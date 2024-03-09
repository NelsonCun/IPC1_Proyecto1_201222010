package ipc1_proyecto1_201222010;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.MessageFormat;
import java.util.Map;
import javax.swing.*;;

/**
 *
 * @author nelson
 */

public class OpcionEnCita {
    private String nombrePaciente;
    private String horaCita;
    private String fechaCita;
    private String 
    JPanel jp1;
    JLabel lbl1,lbl2,lbl3;
    JButton btn1,btn2,btn3;

    public OpcionEnCita(String nombrePaciente, String horaCita, String fechaCita, JPanel jp1, JLabel lbl1, JLabel lbl2, JLabel lbl3, JButton btn1, JButton btn2, JButton btn3) {
        this.nombrePaciente = nombrePaciente;
        this.horaCita = horaCita;
        this.fechaCita = fechaCita;
        
    }
    
    
}
