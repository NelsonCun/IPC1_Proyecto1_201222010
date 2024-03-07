package ipc1_proyecto1_201222010;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.text.MessageFormat;
import java.util.Map;
import javax.swing.*;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author nelson
 */
public class ModDoctor extends JFrame implements ActionListener, ChangeListener {

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10;
    JButton btn1, btn2, btn3;
    JTextField textField1;
    JFrame frame;
    JTabbedPane panel;
    JPanel jp1, jp2;

    public ModDoctor() {

        panel = new JTabbedPane(JTabbedPane.TOP);

        jp1 = new JPanel(null);
        panel.addTab("Citas", jp1);
        jp2 = new JPanel(null);
        panel.addTab("Asignar horario", jp2);
        
        //Lable NombrePaciente
        lbl1 = new JLabel("Nombre de paciente");
        lbl1.setFont(new Font("Arial", Font.BOLD, 14));
        lbl1.setForeground(Color.BLACK);
        lbl1.setBounds(100, 25, 150, 40);
        lbl1.setVisible(true);
        jp1.add(lbl1);
        
        //Lable HoraCita
        lbl2 = new JLabel("Hora cita");
        lbl2.setFont(new Font("Arial", Font.BOLD, 14));
        lbl2.setForeground(Color.BLACK);
        lbl2.setBounds(300, 25, 150, 40);
        lbl2.setVisible(true);
        jp1.add(lbl2);
        
        //Lable FechaCita
        lbl3 = new JLabel("Fecha cita");
        lbl3.setFont(new Font("Arial", Font.BOLD, 14));
        lbl3.setForeground(Color.BLACK);
        lbl3.setBounds(425, 25, 150, 40);
        lbl3.setVisible(true);
        jp1.add(lbl3);
        
        //Lable FechaCita
        lbl4 = new JLabel("Acciones");
        lbl4.setFont(new Font("Arial", Font.BOLD, 14));
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(750, 25, 150, 40);
        lbl4.setVisible(true);
        jp1.add(lbl4);
        
        // Título Horario
        lbl5 = new JLabel("Horario");
        lbl5.setFont(new Font("Arial", Font.BOLD, 30));
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(50, 50, 300, 40);
        lbl5.setVisible(true);
        jp2.add(lbl5);
        
        //Lable Title Fecha Cita jp2
        lbl6 = new JLabel("Fecha de cita");
        lbl6.setFont(new Font("Arial", Font.BOLD, 16));
        lbl6.setForeground(Color.BLACK);
        lbl6.setBounds(60, 110, 200, 40);
        lbl6.setVisible(true);
        jp2.add(lbl6);
        
        //Lable Title Horario Cita jp2
        lbl7 = new JLabel("Horario de cita");
        lbl7.setFont(new Font("Arial", Font.BOLD, 16));
        lbl7.setForeground(Color.BLACK);
        lbl7.setBounds(60, 160, 200, 40);
        lbl7.setVisible(true);
        jp2.add(lbl7);
        
        //Lable Horario Cita jp2
        lbl8 = new JLabel("Mi horario disponible para citas");
        lbl8.setFont(new Font("Arial", Font.BOLD, 18));
        lbl8.setForeground(Color.BLACK);
        lbl8.setBounds(375, 230, 700, 40);
        lbl8.setVisible(true);
        jp2.add(lbl8);
        
        //Campo horario de cita
        textField1 = new JTextField();
        //textField1.addKeyListener();
        textField1.setBounds(175, 160, 150, 40);
        jp2.add(textField1);
        
        //Campo entrada fecha
        JDateChooser entradaFecha = new JDateChooser();
        entradaFecha.setBounds(175, 110, 150, 40);
        entradaFecha.setDateFormatString("dd/MM/yyyy");
        jp2.add(entradaFecha);
        
        //Button Asignar
        btn1 = new JButton("Asignar nuevo horario");
        btn1.setBounds(400, 140, 160, 40);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(191, 168, 214));
        btn1.addActionListener(this);
        jp2.add(btn1);
        
        //Actualizar perfil
        btn2 = new JButton("Actualizar perfil");
        btn2.setBounds(1150, 50, 200, 40);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(157, 189, 128));
        btn2.setFont(new Font("Arial", Font.BOLD, 22));
        btn2.setVisible(true);
        btn2.setEnabled(true);
        btn2.addActionListener(this);
        this.add(btn2);
        
        //Boton salir
        btn3 = new JButton("Cerrar sesión");
        btn3.setBounds(1150, 700, 200, 50);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(new Color(216, 36, 36));
        btn3.setFont(new Font("Arial", Font.BOLD, 22));
        btn3.setVisible(true);
        btn3.setEnabled(true);
        btn3.addActionListener(this);
        this.add(btn3);

        //Fondo Citas
        lbl9 = new JLabel();
        lbl9.setBounds(0, 0, 1500, 800);
        ImageIcon icitas = new ImageIcon(getClass().getResource("./Images/iCitas.png"));
        Image imgEscaladaCitas = icitas.getImage().getScaledInstance(lbl9.getWidth(), lbl9.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoCitas = new ImageIcon(imgEscaladaCitas);
        lbl9.setIcon(iconoEscaladoCitas);
        lbl9.setVisible(true);
        jp1.add(lbl9);

        //Fondo Asignar horario
        lbl10 = new JLabel();
        lbl10.setBounds(0, 0, 1500, 800);
        ImageIcon iAsignarHor = new ImageIcon(getClass().getResource("./Images/iAsignarh.png"));
        Image imgEscaladaAsignarh = iAsignarHor.getImage().getScaledInstance(lbl10.getWidth(), lbl10.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoAsignarh = new ImageIcon(imgEscaladaAsignarh);
        lbl10.setIcon(iconoEscaladoAsignarh);
        lbl10.setVisible(true);
        jp2.add(lbl10);

        //Login Window
        this.setTitle("Doctor " + Proyect1.doctores.get(Proyect1.indiceUsuario).getNombres());
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
