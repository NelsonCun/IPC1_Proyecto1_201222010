package ipc1_proyecto1_201222010;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.text.MaskFormatter;
import javax.swing.border.Border;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author nelson
 */
public class ModPaciente extends JFrame implements ActionListener, ChangeListener {

    JTabbedPane panel;
    JPanel jp1, jp2, jp3;
    JButton btn1, btn2, btn3, btn4, btn5;
    JTextArea parrafo;
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11;
    JComboBox<String> cbx1, cbx2, cbx3;

    public ModPaciente() {
        panel = new JTabbedPane(JTabbedPane.TOP);

        jp1 = new JPanel(null);
        panel.addTab("Solicitar cita", jp1);
        jp2 = new JPanel(null);
        panel.addTab("Ver estado de cita", jp2);
        jp3 = new JPanel();
        jp3.setLayout(null);
        panel.addTab("Farmacia", jp3);
        panel.addChangeListener(this);

        //Lable Motivo de la cita
        lbl1 = new JLabel("Motivo de la cita:");
        lbl1.setBounds(25, 50, 750, 50);
        lbl1.setBackground(Color.DARK_GRAY);
        lbl1.setForeground(Color.WHITE);
        lbl1.setOpaque(true);
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        lbl1.setVisible(true);
        jp1.add(lbl1);

        //Lable Especialidad
        lbl2 = new JLabel("Especialidad:");
        lbl2.setFont(new Font("Arial", Font.BOLD, 20));
        lbl2.setForeground(Color.BLACK);
        lbl2.setBounds(75, 250, 150, 40);
        lbl2.setVisible(true);
        jp1.add(lbl2);

        //Lable Doctor
        lbl3 = new JLabel("Doctor:");
        lbl3.setFont(new Font("Arial", Font.BOLD, 20));
        lbl3.setForeground(Color.BLACK);
        lbl3.setBounds(75, 310, 150, 40);
        lbl3.setVisible(true);
        jp1.add(lbl3);

        //Lable Horario de Citas disponibles
        lbl4 = new JLabel("Horario de citas disponibles:");
        lbl4.setFont(new Font("Arial", Font.BOLD, 20));
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(50, 400, 300, 40);
        lbl4.setVisible(true);
        jp1.add(lbl4);

        //Lable Fecha
        lbl5 = new JLabel("Fecha:");
        lbl5.setFont(new Font("Arial", Font.BOLD, 20));
        lbl5.setForeground(Color.BLACK);
        lbl5.setBounds(75, 450, 150, 40);
        lbl5.setVisible(true);
        jp1.add(lbl5);

        //Lable Hora
        lbl6 = new JLabel("Hora:");
        lbl6.setFont(new Font("Arial", Font.BOLD, 20));
        lbl6.setForeground(Color.BLACK);
        lbl6.setBounds(350, 450, 150, 40);
        lbl6.setVisible(true);
        jp1.add(lbl6);

        //Entrada Motivo de la cita
        parrafo = new JTextArea();
        parrafo.setForeground(Color.BLACK);
        parrafo.setBackground(new Color(173, 173, 173));
        parrafo.setFont(new Font("Arial", Font.BOLD, 15));
        parrafo.setBounds(25, 110, 750, 75);
        Border bordeLinea = BorderFactory.createLineBorder(Color.BLACK, 1);
        parrafo.setBorder(bordeLinea);
        jp1.add(parrafo);

        //Listado especialidades
        if (Proyect1.doctoresEspSelect!=null) {
            cbx1 = new JComboBox<>(Proyect1.vectorEspecialidades);
            cbx1.setSelectedItem(Proyect1.especialidadSeleccionada);
        } else if (Proyect1.doctoresEspSelect==null) {
          if (Proyect1.vectorEspecialidades!=null) {
            cbx1 = new JComboBox<>(Proyect1.vectorEspecialidades);
        } else if (Proyect1.vectorEspecialidades==null) {
            String[] vectorSeleccionar = {"Seleccionar"};
            cbx1 = new JComboBox<>(vectorSeleccionar);
        }  
        }
        
        cbx1.setBounds(230, 250, 250, 40);
        jp1.add(cbx1);

        //Listado doctores
        if (Proyect1.doctoresEspSelect!=null) {
            cbx2 = new JComboBox<>(Proyect1.doctoresEspSelect);
        } else if (Proyect1.doctoresEspSelect==null) {
            String[] vectorSeleccionar = {"Seleccionar"};
            cbx2 = new JComboBox<>(vectorSeleccionar);
        }
        cbx2.setBounds(230, 310, 250, 40);
        jp1.add(cbx2);

        //Listado horarios
        String[] vectorHorarios = {"Seleccionar", "otros horarios"};
        cbx3 = new JComboBox<>(vectorHorarios);
        cbx3.setBounds(425, 450, 150, 40);
        jp1.add(cbx3);

        // Button Mostrar doctores
        btn1 = new JButton("Mostrar doctores");
        btn1.setBounds(500, 250, 150, 40);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(191, 168, 214));
        btn1.addActionListener(this);
        jp1.add(btn1);

        // Button Mostrar Horarios
        btn2 = new JButton("Mostrar horarios");
        btn2.setBounds(500, 310, 150, 40);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(136, 191, 243));
        btn2.addActionListener(this);
        jp1.add(btn2);

        // Button Generar Cita
        btn3 = new JButton("Generar Cita");
        btn3.setBounds(500, 550, 100, 40);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(new Color(87, 168, 224));
        btn3.addActionListener(this);
        jp1.add(btn3);

        //Boton salir
        btn4 = new JButton("Cerrar sesión");
        btn4.setBounds(1150, 700, 200, 50);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(new Color(216, 36, 36));
        btn4.setFont(new Font("Arial", Font.BOLD, 22));
        btn4.setVisible(true);
        btn4.setEnabled(true);
        btn4.addActionListener(this);
        this.add(btn4);

        //Actualizar perfil
        btn5 = new JButton("Actualizar perfil");
        btn5.setBounds(1150, 50, 200, 40);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(new Color(157, 189, 128));
        btn5.setFont(new Font("Arial", Font.BOLD, 22));
        btn5.setVisible(true);
        btn5.setEnabled(true);
        btn5.addActionListener(this);
        this.add(btn5);

        //Fondo Solicitar cita
        lbl9 = new JLabel();
        lbl9.setBounds(0, 0, 1500, 800);
        ImageIcon idoctores = new ImageIcon(getClass().getResource("./Images/iPacientes.png"));
        Image imgEscaladaDoc = idoctores.getImage().getScaledInstance(lbl9.getWidth(), lbl9.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoDoc = new ImageIcon(imgEscaladaDoc);
        lbl9.setIcon(iconoEscaladoDoc);
        lbl9.setVisible(true);
        jp1.add(lbl9);

        //Fondo ver estado de cita
        lbl10 = new JLabel();
        lbl10.setBounds(0, 0, 1500, 800);
        ImageIcon ipacientes = new ImageIcon(getClass().getResource("./Images/iEstado.png"));
        Image imgEscaladaPacientes = ipacientes.getImage().getScaledInstance(lbl10.getWidth(), lbl10.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoPacientes = new ImageIcon(imgEscaladaPacientes);
        lbl10.setIcon(iconoEscaladoPacientes);
        lbl10.setVisible(true);
        jp2.add(lbl10);

        //Fondo Farmacia
        lbl11 = new JLabel();
        lbl11.setBounds(0, 0, 1500, 800);
        ImageIcon iproductos = new ImageIcon(getClass().getResource("./Images/iProductos.png"));
        Image imgEscaladaProd = iproductos.getImage().getScaledInstance(lbl11.getWidth(), lbl11.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoProd = new ImageIcon(imgEscaladaProd);
        lbl11.setIcon(iconoEscaladoProd);
        lbl11.setVisible(true);
        jp3.add(lbl11);

        //Login Window
        this.setTitle("Paciente: " + Proyect1.pacientes.get(Proyect1.indiceUsuario).getNombres());
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            Proyect1.especialidadSeleccionada = (String) cbx1.getSelectedItem();
            Proyect1.doctoresPorEspecialidad();
            ModPaciente modpaciente = new ModPaciente();
            this.dispose();
            
        } else if (ae.getSource() == btn2) {

        } else if (ae.getSource() == btn3) {
            String nombres = campoNombre.getText();
            String apellidos = campoApellido.getText();
            String especialidad = campoEspecialidad.getText();
            String telefono = campoTelefono.getText();
            String edad = campoEdad.getText();
            char[] passwordVector = campoPassword.getPassword();
            String password = new String(passwordVector);
            String genero = (String) comboBoxGenero.getSelectedItem();
            String codigoDoctor = Integer.toString(Proyect1.codigoDoctores);
            if (nombres.isEmpty() || apellidos.isEmpty() || especialidad.isEmpty() || edad.isEmpty() || password.isEmpty() || genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos obligatorios", "ERROR", 0);
            } else {
                Doctor newdoctor = new Doctor(codigoDoctor, nombres, apellidos, especialidad, telefono, edad, password, genero);
                Proyect1.addDoctor(newdoctor);
                JOptionPane.showMessageDialog(null, "Doctor registrado exitosamente\nCódigo de doctor: " + Proyect1.codigoDoctores,
                        "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                Proyect1.codigoDoctores += 1;
                ModAdmin modAdmin = new ModAdmin();
                this.dispose();
            }
        } else if (ae.getSource() == btn4) {
            Login login = new Login();
            Proyect1.tipoUsuario = 0;
            this.dispose();
        } else if (ae.getSource() == btn5) {
            ActualizarPaciente actualizarPaciente = new ActualizarPaciente();
            this.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}

}
