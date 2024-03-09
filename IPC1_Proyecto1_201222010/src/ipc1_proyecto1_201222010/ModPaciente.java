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
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author nelson
 */
public class ModPaciente extends JFrame implements ActionListener, ChangeListener {

    JTabbedPane panel;
    JPanel jp1, jp2, jp3;
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JTextArea parrafo;
    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11;
    JComboBox<String> cbx1, cbx2, cbx3, cbx4;
    JTable tablaCitas;
    JScrollPane sp1, sp2;

    public ModPaciente() {

        Proyect1.contarEspecialidad(Proyect1.doctores);
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
        lbl6.setBounds(75, 500, 150, 40);
        lbl6.setVisible(true);
        jp1.add(lbl6);

        //Entrada Motivo de la cita
        if (Proyect1.motivoCita == "0") {
            parrafo = new JTextArea("Escriba aquí el motivo de su cita");
        } else {
            parrafo = new JTextArea(Proyect1.motivoCita);
        }
        parrafo.setForeground(Color.BLACK);
        parrafo.setBackground(new Color(173, 173, 173));
        parrafo.setFont(new Font("Arial", Font.BOLD, 15));
        parrafo.setBounds(25, 110, 750, 75);
        Border bordeLinea = BorderFactory.createLineBorder(Color.BLACK, 1);
        parrafo.setBorder(bordeLinea);
        jp1.add(parrafo);

        //Listado especialidades
        if (Proyect1.doctoresEspSelect != null) {
            cbx1 = new JComboBox<>(Proyect1.vectorEspecialidades);
            cbx1.setSelectedItem(Proyect1.especialidadSeleccionada);
        } else if (Proyect1.doctoresEspSelect == null) {
            if (Proyect1.vectorEspecialidades != null) {
                cbx1 = new JComboBox<>(Proyect1.vectorEspecialidades);
            } else if (Proyect1.vectorEspecialidades == null) {
                String[] vectorSeleccionar = {"Seleccionar"};
                cbx1 = new JComboBox<>(vectorSeleccionar);
            }
        }
        cbx1.setBounds(230, 250, 250, 40);
        jp1.add(cbx1);

        //Listado doctores
        if (Proyect1.doctoresEspSelect != null) {
            cbx2 = new JComboBox<>(Proyect1.doctoresEspSelect);
            cbx2.setSelectedItem(Proyect1.doctorSeleccionado);
        } else if (Proyect1.doctoresEspSelect == null) {
            String[] vectorSeleccionar = {"Seleccionar"};
            cbx2 = new JComboBox<>(vectorSeleccionar);
        }
        cbx2.setBounds(230, 310, 250, 40);
        jp1.add(cbx2);

        //Listado fechas
        String[] vectorFechasDoctor = {"Seleccionar"};
        if (Proyect1.seSeleccionoDoctor == 0) {
            cbx3 = new JComboBox<>(vectorFechasDoctor);
        } else {
            cbx3 = new JComboBox<>(Proyect1.listadoFechas);
            cbx3.setSelectedItem(Proyect1.fechaSeleccionada);
        }
        cbx3.setBounds(150, 450, 150, 40);
        jp1.add(cbx3);

        //Listado horarios
        String[] vectorHorarios = {"Seleccionar"};
        if (Proyect1.fechaSeleccionada == "0") {
            cbx4 = new JComboBox<>(vectorHorarios);
        } else {
            cbx4 = new JComboBox<>(Proyect1.listadoHorarios);
        }
        cbx4.setBounds(150, 500, 150, 40);
        jp1.add(cbx4);

        // Button Mostrar doctores
        btn1 = new JButton("Mostrar doctores");
        btn1.setBounds(500, 250, 150, 40);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(191, 168, 214));
        btn1.addActionListener(this);
        jp1.add(btn1);

        // Button Mostrar Fechas
        btn2 = new JButton("Mostrar fechas");
        btn2.setBounds(500, 310, 150, 40);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(136, 191, 243));
        btn2.addActionListener(this);
        if (Proyect1.seSeleccionoEspecialidad == 0) {
            btn2.setEnabled(false);
        } else if (Proyect1.seSeleccionoEspecialidad == 1) {
            btn2.setSelected(true);
        }
        jp1.add(btn2);

        // Button Mostrar Horarios
        btn6 = new JButton("Mostrar horarios");
        btn6.setBounds(350, 450, 150, 40);
        btn6.setForeground(Color.WHITE);
        btn6.setBackground(new Color(187, 165, 141));
        btn6.addActionListener(this);
        if (Proyect1.seSeleccionoDoctor == 0) {
            btn6.setEnabled(false);
        } else if (Proyect1.seSeleccionoDoctor == 1) {
            btn6.setSelected(true);
        }
        jp1.add(btn6);

        // Button Generar Cita
        btn3 = new JButton("Generar Cita");
        btn3.setBounds(500, 550, 100, 40);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(new Color(87, 168, 224));
        btn3.addActionListener(this);
        if (Proyect1.seSeleccionoFecha == 0) {
            btn3.setEnabled(false);
        } else if (Proyect1.seSeleccionoFecha == 1) {
            btn3.setSelected(true);
        }
        jp1.add(btn3);

        //Tabla Historial de Citas
        String[] titulos_c = {"Número", "Estado", "Fecha", "Hora"};
        Object[][] pruebaNelson = Proyect1.historialCitas();
        for (int i = 0; i < pruebaNelson.length; i++) {
            for (int j = 0; j < pruebaNelson[i].length; j++) {
                System.out.print("  " + pruebaNelson[i][j]);
            }
            System.out.println("");
        }
        tablaCitas = new JTable(Proyect1.historialCitas(), titulos_c);
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_c.length; i++) {
            tablaCitas.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
        tablaCitas.setEnabled(false);
        this.tablaCitas.setOpaque(true);
        resizeColumnWidth(tablaCitas);
        sp1 = new JScrollPane(tablaCitas);
        sp1.setBounds(150, 150, 650, 370);
        this.sp1.setOpaque(true);
        sp1.setVisible(true);
        jp2.add(sp1);

        //Paneles de productos de manera dinámica
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(null);
        int x = 758, y = 32;
        int alturaPanel = (((Proyect1.productos.size() / 4) + 1) * 182);

        for (int i = 0; i < Proyect1.productos.size(); i++) {
            Producto prodTemp = new Producto(Proyect1.productos.get(i).getCodigo(),
                    Proyect1.productos.get(i).getNombre(),
                    Proyect1.productos.get(i).getPrecio(),
                    Proyect1.productos.get(i).getDescripcion(),
                    Proyect1.productos.get(i).getCantidad());
            if (x==758){
                x=32;
            } else if (x==32) {
                x = 274 ; 
            } else if (x==274) {
                x=516;
            } else if (x==516) {
                x=758;
            }  

            JPanel jpTemp = prodTemp.getPanel();
            jpTemp.setBounds(x, y, 210, 150);
            jpTemp.setVisible(true);
            panelProductos.add(jpTemp);
            if (x==758) {
                y += 182 ;
            }
        }
        
        panelProductos.setPreferredSize(new Dimension(1000, alturaPanel));
        sp2 = new JScrollPane(panelProductos);
        sp2.setBounds(25, 100, 1000, 500);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jp3.add(sp2);

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

        // Título ver estado de cita
        lbl7 = new JLabel("Historial de citas:");
        lbl7.setFont(new Font("Arial", Font.BOLD, 30));
        lbl7.setForeground(Color.BLACK);
        lbl7.setBounds(50, 50, 300, 40);
        lbl7.setVisible(true);
        jp2.add(lbl7);

        // Titulo farmacia
        lbl7 = new JLabel("Mira nuestro productos y visita nuestra farmacia para comprarlos");
        lbl7.setFont(new Font("Arial", Font.BOLD, 25));
        lbl7.setForeground(Color.BLACK);
        lbl7.setBounds(50, 50, 1000, 40);
        lbl7.setVisible(true);
        jp3.add(lbl7);

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
            String motivoCita = parrafo.getText();
            Proyect1.especialidadSeleccionada = (String) cbx1.getSelectedItem();
            if (motivoCita.isEmpty() || motivoCita.equals("Escriba aquí el motivo de su cita") || (String) cbx1.getSelectedItem() == "Seleccionar") {
                JOptionPane.showMessageDialog(this, "Debe escribir el motivo de su cita\ny seleccionar una especialidad", "ERROR", 0);
            } else {
                Proyect1.doctoresPorEspecialidad();
                Proyect1.seSeleccionoEspecialidad = 1;
                Proyect1.seSeleccionoDoctor = 0;
                Proyect1.seSeleccionoFecha = 0;
                Proyect1.doctorSeleccionado = "Seleccionar";
                Proyect1.indiceDoctorSeleccionado = -1;
                Proyect1.motivoCita = motivoCita;
                ModPaciente modpaciente = new ModPaciente();
                this.dispose();
            }
        } else if (ae.getSource() == btn2) {
            String motivoCita = parrafo.getText();
            Proyect1.doctorSeleccionado = (String) cbx2.getSelectedItem();
            if (motivoCita.isEmpty() || (String) cbx2.getSelectedItem() == "Seleccionar") {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un doctor", "ERROR", 0);
            } else {
                Proyect1.seSeleccionoDoctor = 1;
                Proyect1.seSeleccionoFecha = 0;
                String[] nombres = Proyect1.doctorSeleccionado.split(", ");
                String apellido = nombres[0];
                String nombre = nombres[1];
                Proyect1.buscarDoctorSeleccionado(nombre, apellido);
                Proyect1.fechasDoctor();
                ModPaciente modpaciente = new ModPaciente();
                this.dispose();
            }

        } else if (ae.getSource() == btn6) {
            String motivoCita = parrafo.getText();
            Proyect1.fechaSeleccionada = (String) cbx3.getSelectedItem();
            if (motivoCita.isEmpty() || (String) cbx3.getSelectedItem() == "Seleccionar") {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha", "ERROR", 0);
            } else {
                Proyect1.seSeleccionoFecha = 1;
                Proyect1.buscarFechaSeleccionada(Proyect1.fechaSeleccionada);
                Proyect1.horariosDoctor();
                ModPaciente modpaciente = new ModPaciente();
                this.dispose();
            }
        } else if (ae.getSource() == btn3) {
            String motivoCita = parrafo.getText();
            Proyect1.horarioSeleccionado = (String) cbx4.getSelectedItem();
            if (motivoCita.isEmpty() || (String) cbx4.getSelectedItem() == "Seleccionar") {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un horario", "ERROR", 0);
            } else {
                String estado = "Pendiente";
                Cita newcita = new Cita(estado, Proyect1.especialidadSeleccionada, Proyect1.doctorSeleccionado, Proyect1.fechaSeleccionada, Proyect1.horarioSeleccionado, motivoCita);
                Proyect1.addCita(newcita);
                JOptionPane.showMessageDialog(null, "Cita asignada exitosamente",
                        "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                Proyect1.buscarHorarioSeleccionado(Proyect1.horarioSeleccionado);
                Proyect1.doctores.get(Proyect1.indiceDoctorSeleccionado).getFechasDisponibles().get(Proyect1.indiceFechaSeleccionada).getHorario().remove(Proyect1.indiceHorarioSeleccionado);
                Proyect1.motivoCita = "0";
                Proyect1.especialidadSeleccionada = "0";
                Proyect1.doctorSeleccionado = "Seleccionar";
                Proyect1.fechaSeleccionada = "0";
                Proyect1.seSeleccionoEspecialidad = 0;
                Proyect1.seSeleccionoDoctor = 0;
                Proyect1.seSeleccionoFecha = 0;
                Proyect1.indiceDoctorSeleccionado = -1;
                Proyect1.indiceFechaSeleccionada = -1;

                ModPaciente modPaciente = new ModPaciente();
                this.dispose();
            }
        } else if (ae.getSource() == btn4) {
            Proyect1.motivoCita = "0";
            Proyect1.especialidadSeleccionada = "0";
            Proyect1.doctorSeleccionado = "Seleccionar";
            Proyect1.fechaSeleccionada = "0";
            Proyect1.seSeleccionoEspecialidad = 0;
            Proyect1.seSeleccionoDoctor = 0;
            Proyect1.seSeleccionoFecha = 0;
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
