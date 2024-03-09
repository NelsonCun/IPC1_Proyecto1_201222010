package ipc1_proyecto1_201222010;

import com.toedter.calendar.JDateChooser;//Lo usé para mostrar un calendario al ingresar la fecha.
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lbl12, lbl13;
    JButton btn1, btn2, btn3;
    JComboBox hora, minuto;
    JFrame frame;
    JTabbedPane panel;
    JPanel jp1, jp2;
    JTable tablaCitas;
    JScrollPane sp1, sp2;
    JDateChooser entradaFecha;

    public ModDoctor() {
        
        Proyect1.contarEspecialidad(Proyect1.doctores);

        panel = new JTabbedPane(JTabbedPane.TOP);

        jp1 = new JPanel(null);
        panel.addTab("Citas", jp1);
        jp2 = new JPanel(null);
        panel.addTab("Asignar horario", jp2);

        /////////////////////////////////////// pestaña citas /////////////////////////
        
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

        //Lable Acciones
        lbl4 = new JLabel("Acciones");
        lbl4.setFont(new Font("Arial", Font.BOLD, 14));
        lbl4.setForeground(Color.BLACK);
        lbl4.setBounds(750, 25, 150, 40);
        lbl4.setVisible(true);
        jp1.add(lbl4);
        
        ///////////////////////////// Pestaña Asignar horarios///////////////////////////

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
        lbl7.setBounds(60, 180, 115, 40);
        lbl7.setVisible(true);
        jp2.add(lbl7);

        //Lable puntos entre hora y minutos
        lbl11 = new JLabel(":");
        lbl11.setFont(new Font("Arial", Font.BOLD, 16));
        lbl11.setForeground(Color.BLACK);
        lbl11.setBounds(253, 180, 10, 40);
        lbl11.setVisible(true);
        jp2.add(lbl11);

        //Hora (24h)
        lbl12 = new JLabel("Hora (24h)");
        lbl12.setFont(new Font("Arial", Font.BOLD, 10));
        lbl12.setForeground(Color.BLACK);
        lbl12.setBounds(185, 210, 50, 40);
        lbl12.setVisible(true);
        jp2.add(lbl12);

        //Hora (24h)
        lbl13 = new JLabel("Minuto");
        lbl13.setFont(new Font("Arial", Font.BOLD, 10));
        lbl13.setForeground(Color.BLACK);
        lbl13.setBounds(278, 210, 50, 40);
        lbl13.setVisible(true);
        jp2.add(lbl13);

        //Lable Horario Cita jp2
        lbl8 = new JLabel("Mi horario disponible para citas");
        lbl8.setFont(new Font("Arial", Font.BOLD, 18));
        lbl8.setForeground(Color.BLACK);
        lbl8.setBounds(375, 250, 700, 40);
        lbl8.setVisible(true);
        jp2.add(lbl8);

        //Campo hora de cita
        String[] horas = new String[24];
        for (int i = 0; i < horas.length; i++) {
            horas[i] = "" + i;
        }
        hora = new JComboBox(horas);
        hora.setBounds(175, 180, 75, 40);
        jp2.add(hora);

        //Campo minuto de cita
        String[] minutos = new String[60];
        for (int i = 0; i < minutos.length; i++) {
            minutos[i] = "" + i;
        }
        minuto = new JComboBox(minutos);
        minuto.setBounds(260, 180, 75, 40);
        jp2.add(minuto);

        //Campo entrada fecha
        entradaFecha = new JDateChooser();
        entradaFecha.setBounds(175, 110, 150, 40);
        entradaFecha.setDateFormatString("dd/MM/yyyy");
        jp2.add(entradaFecha);

        //Tabla Citas
        String[] titulos_c = {"Número", "Fecha", "Hora"};
        Object[][] pruebaNelson = Proyect1.convertirFechasDisponibles();
        for (int i = 0; i < pruebaNelson.length; i++) {
            for (int j = 0; j < pruebaNelson[i].length; j++) {
                System.out.print("  " + pruebaNelson[i][j]);
            }
            System.out.println("");
        }
        tablaCitas = new JTable(Proyect1.convertirFechasDisponibles(), titulos_c);
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_c.length; i++) {
            tablaCitas.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
        tablaCitas.setEnabled(false);
        this.tablaCitas.setOpaque(true);
        resizeColumnWidth(tablaCitas);
        sp1 = new JScrollPane(tablaCitas);
        sp1.setBounds(150, 300, 650, 370);
        this.sp1.setOpaque(true);
        sp1.setVisible(true);
        jp2.add(sp1);

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
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            Date fechaSeleccionada = entradaFecha.getDate();
            String horario = (String) hora.getSelectedItem() + ":" + (String) minuto.getSelectedItem();
            if (fechaSeleccionada == null || horario == null) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "ERROR", 0);
            } else {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                String entradaFechaString = formatoFecha.format(fechaSeleccionada);
                Fecha newfecha = new Fecha(entradaFechaString);
                Proyect1.addFecha(newfecha);
                boolean correcto = Proyect1.addHorario(horario, newfecha);
                if (correcto) {
                    JOptionPane.showMessageDialog(null, "Horario registrado exitosamente: ",
                            "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    ModDoctor modDoctor = new ModDoctor();
                } else {
                    JOptionPane.showMessageDialog(this, "Este horario ya ha sido ingresado", "ERROR", 0);
                }
            }

        } else if (ae.getSource() == btn2) {
            ActualizarDoctor actualizarDoctor = new ActualizarDoctor();
            this.dispose();
        } else if (ae.getSource() == btn3) {
            Proyect1.tipoUsuario = 0;
            this.dispose();
            Login login = new Login();
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
