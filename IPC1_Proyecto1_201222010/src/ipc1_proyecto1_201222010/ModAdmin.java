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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author nelson
 */
public class ModAdmin extends JFrame implements ActionListener, ChangeListener {

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;
    JTabbedPane panel;
    JPanel jp1, jp2, jp3;
    JTable tablaDoctores, tablaPacientes, tablaProductos;
    JScrollPane sp1, sp2, sp3;
    boolean vb1 = true;

    public ModAdmin() {

        Proyect1.contarEspecialidad(Proyect1.doctores);//Eliminar al terminar

        panel = new JTabbedPane(JTabbedPane.TOP);

        jp1 = new JPanel(null);
        panel.addTab("Doctores", jp1);
        jp2 = new JPanel(null);
        panel.addTab("Pacientes", jp2);
        jp3 = new JPanel();
        jp3.setLayout(null);
        panel.addTab("Productos", jp3);
        panel.addChangeListener(this);

        //Botón Crear doctor
        btn1 = new JButton("Crear doctor");
        btn1.setBounds(850, 75, 257, 50);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(new Color(129, 229, 229));
        btn1.setFont(new Font("Arial", Font.BOLD, 22));
        btn1.setVisible(true);
        btn1.setEnabled(true);
        btn1.addActionListener(this);
        jp1.add(btn1);

        //Botón Actualizar doctor
        btn2 = new JButton("Actualizar doctor");
        btn2.setBounds(1150, 75, 257, 50);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(new Color(129, 229, 229));
        btn2.setFont(new Font("Arial", Font.BOLD, 22));
        btn2.setVisible(true);
        btn2.setEnabled(true);
        btn2.addActionListener(this);
        jp1.add(btn2);

        //Botón Eliminar doctor
        btn3 = new JButton("Eliminar doctor");
        btn3.setBounds(1004, 150, 257, 50);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(new Color(129, 229, 229));
        btn3.setFont(new Font("Arial", Font.BOLD, 22));
        btn3.setVisible(true);
        btn3.setEnabled(true);
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

        //Lable listado doctores
        lbl1 = new JLabel("Listado de doctores");
        lbl1.setBounds(25, 25, 750, 50);
        this.lbl1.setBackground(Color.LIGHT_GRAY);
        this.lbl1.setOpaque(true);
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font(lbl1.getFont().getFontName(), Font.BOLD, 24));
        lbl1.setVisible(true);
        jp1.add(lbl1);

        //Tabla Doctores
        String[] titulos_d = {"Codigo", "Nombres", "Apellidos", "Epecialidad", "Telefono", "Edad", "Genero"};
        tablaDoctores = new JTable(Proyect1.convertirDatosDoctores(), titulos_d);
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_d.length; i++) {
            tablaDoctores.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
        tablaDoctores.setEnabled(false);
        this.tablaDoctores.setOpaque(true);
        resizeColumnWidth(tablaDoctores);
        sp1 = new JScrollPane(tablaDoctores);
        sp1.setBounds(25, 80, 750, 470);
        this.sp1.setOpaque(true);
        sp1.setVisible(true);
        jp1.add(sp1);

        //Gráfica Doctores
        Proyect1.contarEspecialidad(Proyect1.doctores);
        int freqEspecialidad1 = 0;
        int freqEspecialidad2 = 0;
        int freqEspecialidad3 = 0;
        int freqEspecialidad4 = 0;
        int freqEspecialidad5 = 0;
        String especialidad1 = "Especialidad 1";
        String especialidad2 = "Especialidad 2";
        String especialidad3 = "Especialidad 3";
        String especialidad4 = "Especialidad 4";
        String especialidad5 = "Especialidad 5";
        try {
            freqEspecialidad1 = Integer.parseInt(Proyect1.topEspecialidades[0][1]);
        } catch (NumberFormatException e) {
            
        }
        try {
            freqEspecialidad2 = Integer.parseInt(Proyect1.topEspecialidades[1][1]);
        } catch (NumberFormatException e) {
            
        }try {
            freqEspecialidad3 = Integer.parseInt(Proyect1.topEspecialidades[2][1]);
        } catch (NumberFormatException e) {
            
        }try {
            freqEspecialidad4 = Integer.parseInt(Proyect1.topEspecialidades[3][1]);
        } catch (NumberFormatException e) {
            
        }try {
            freqEspecialidad5 = Integer.parseInt(Proyect1.topEspecialidades[4][1]);
        } catch (NumberFormatException e) {
            
        }
        if (Proyect1.topEspecialidades[0][0]==null) {
            
        } else {
            especialidad1 = Proyect1.topEspecialidades[0][0];
        }
        if (Proyect1.topEspecialidades[1][0]==null) {
            
        } else {
            especialidad2 = Proyect1.topEspecialidades[1][0];
        }
        if (Proyect1.topEspecialidades[2][0]==null) {
            
        } else {
            especialidad3 = Proyect1.topEspecialidades[2][0];
        }
        if (Proyect1.topEspecialidades[3][0]==null) {
            
        } else {
            especialidad4 = Proyect1.topEspecialidades[3][0];
        }
        if (Proyect1.topEspecialidades[4][0]==null) {
            
        } else {
            especialidad5 = Proyect1.topEspecialidades[4][0];
        }
        
        
        DefaultCategoryDataset datosTopEspecialidades = new DefaultCategoryDataset();
        datosTopEspecialidades.setValue(freqEspecialidad1, especialidad1, especialidad1);
        datosTopEspecialidades.setValue(freqEspecialidad2, especialidad2, especialidad2);
        datosTopEspecialidades.setValue(freqEspecialidad3, especialidad3, especialidad3);
        datosTopEspecialidades.setValue(freqEspecialidad4, especialidad4, especialidad4);
        datosTopEspecialidades.setValue(freqEspecialidad5, especialidad5, especialidad5);

        // Instancear gráfica de barras 3D
        JFreeChart graficoTopEspecialidades = ChartFactory.createBarChart3D(
                "Top 5 Especialidades", // Nombre del grafico
                "Especialidades", // Nombre de las barras o columnas
                "Cantidad de médicos", // Nombre de la numeracion
                datosTopEspecialidades, // Datos del grafico
                PlotOrientation.VERTICAL, // Orientacion
                true, // Leyenda de barras individuales por color
                true, // Herramientas
                false // Url del grafico
        );

        // Creación de un ChartPanel el cual almacenará nuestro gráfico
        ChartPanel cPanel = new ChartPanel(graficoTopEspecialidades);
        // Habilitamos es scroll
        cPanel.setMouseWheelEnabled(true);
        // Asignamos la posición y las dimensiones de nuestro ChartPanel
        cPanel.setBounds(800, 300, 550, 300);
        // Agregamos a nuestra pestaña el ChartPanel con nuestro gráfico
        jp1.add(cPanel);

        //Botón Crear Paciente
        btn5 = new JButton("Crear paciente");
        btn5.setBounds(850, 75, 257, 50);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(new Color(129, 229, 229));
        btn5.setFont(new Font("Arial", Font.BOLD, 22));
        btn5.setVisible(true);
        btn5.setEnabled(true);
        btn5.addActionListener(this);
        jp2.add(btn5);

        //Botón Actualizar paciente
        btn6 = new JButton("Actualizar paciente");
        btn6.setBounds(1150, 75, 257, 50);
        btn6.setForeground(Color.WHITE);
        btn6.setBackground(new Color(129, 229, 229));
        btn6.setFont(new Font("Arial", Font.BOLD, 22));
        btn6.setVisible(true);
        btn6.setEnabled(true);
        btn6.addActionListener(this);
        jp2.add(btn6);

        //Botón Eliminar paciente
        btn7 = new JButton("Eliminar paciente");
        btn7.setBounds(1004, 150, 257, 50);
        btn7.setForeground(Color.WHITE);
        btn7.setBackground(new Color(129, 229, 229));
        btn7.setFont(new Font("Arial", Font.BOLD, 22));
        btn7.setVisible(true);
        btn7.setEnabled(true);
        btn7.addActionListener(this);
        jp2.add(btn7);

        //Lable listado pacientes
        lbl5 = new JLabel("Listado de pacientes");
        lbl5.setBounds(25, 25, 750, 50);
        this.lbl5.setBackground(Color.LIGHT_GRAY);
        this.lbl5.setOpaque(true);
        lbl5.setVerticalAlignment(SwingConstants.CENTER);
        lbl5.setHorizontalAlignment(SwingConstants.CENTER);
        lbl5.setFont(new Font(lbl5.getFont().getFontName(), Font.BOLD, 24));
        lbl5.setVisible(true);
        jp2.add(lbl5);

        //Tabla Pacientes
        String[] titulos_pacientes={"Código","Nombres","Apellidos","Edad","Género"};
        tablaPacientes = new JTable(Proyect1.convertirDatosPacientes(),titulos_pacientes);
        DefaultTableCellRenderer AlinearPac = new DefaultTableCellRenderer();
        AlinearPac.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_pacientes.length; i++) {
            tablaPacientes.getColumnModel().getColumn(i).setCellRenderer(AlinearPac);
        }
        tablaPacientes.setEnabled(false);
        resizeColumnWidth(tablaPacientes);
        sp2 = new JScrollPane(tablaPacientes);
        sp2.setBounds(25, 80, 750, 470);
        sp2.setVisible(true);
        jp2.add(sp2);
        
        //Botón Crear Producto
        btn8 = new JButton("Crear producto");
        btn8.setBounds(850, 75, 257, 50);
        btn8.setForeground(Color.WHITE);
        btn8.setBackground(new Color(129, 229, 229));
        btn8.setFont(new Font("Arial", Font.BOLD, 22));
        btn8.setVisible(true);
        btn8.setEnabled(true);
        btn8.addActionListener(this);
        jp3.add(btn8);

        //Botón Actualizar producto
        btn9 = new JButton("Actualizar producto");
        btn9.setBounds(1150, 75, 257, 50);
        btn9.setForeground(Color.WHITE);
        btn9.setBackground(new Color(129, 229, 229));
        btn9.setFont(new Font("Arial", Font.BOLD, 22));
        btn9.setVisible(true);
        btn9.setEnabled(true);
        btn9.addActionListener(this);
        jp3.add(btn9);

        //Botón Eliminar producto
        btn10 = new JButton("Eliminar producto");
        btn10.setBounds(1004, 150, 257, 50);
        btn10.setForeground(Color.WHITE);
        btn10.setBackground(new Color(129, 229, 229));
        btn10.setFont(new Font("Arial", Font.BOLD, 22));
        btn10.setVisible(true);
        btn10.setEnabled(true);
        btn10.addActionListener(this);
        jp3.add(btn10);

        //Lable listado productos
        lbl6 = new JLabel("Listado de productos");
        lbl6.setBounds(25, 25, 750, 50);
        this.lbl6.setBackground(Color.LIGHT_GRAY);
        this.lbl6.setOpaque(true);
        lbl6.setVerticalAlignment(SwingConstants.CENTER);
        lbl6.setHorizontalAlignment(SwingConstants.CENTER);
        lbl6.setFont(new Font(lbl6.getFont().getFontName(), Font.BOLD, 24));
        lbl6.setVisible(true);
        jp3.add(lbl6);

        //Tabla Productos
        String[] titulos_prod={"Código","Nombre","Precio (Q)","Descripción","Cantidad"};
        tablaProductos = new JTable(Proyect1.convertirDatosProductos(),titulos_prod);
        DefaultTableCellRenderer AlinearProd = new DefaultTableCellRenderer();
        AlinearProd.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < titulos_prod.length; i++) {
            tablaProductos.getColumnModel().getColumn(i).setCellRenderer(AlinearProd);
        }
        tablaDoctores.setEnabled(false);
        resizeColumnWidth(tablaProductos);
        sp3 = new JScrollPane(tablaProductos);
        sp3.setBounds(25, 80, 750, 470);
        sp3.setVisible(true);
        jp3.add(sp3);
        
        //Gráfica Productos
        Proyect1.contarProductos(Proyect1.productos);
        int freqProducto1 = 0;
        int freqProducto2 = 0;
        int freqProducto3 = 0;
        String producto1 = "Prod 1";
        String producto2 = "Prod 2";
        String producto3 = "Prod 3";
        try {
            freqProducto1 = Integer.parseInt(Proyect1.topProductos[0][1]);
        } catch (NumberFormatException e) {
            
        }
        try {
            freqProducto2 = Integer.parseInt(Proyect1.topProductos[1][1]);
        } catch (NumberFormatException e) {
            
        }try {
            freqProducto3 = Integer.parseInt(Proyect1.topProductos[2][1]);
        } catch (NumberFormatException e) {
            
        }
        if (Proyect1.topProductos[0][0]==null) {
            
        } else {
            producto1 = Proyect1.topProductos[0][0];
        }
        if (Proyect1.topProductos[1][0]==null) {
            
        } else {
            producto2 = Proyect1.topProductos[1][0];
        }
        if (Proyect1.topProductos[2][0]==null) {
            
        } else {
            producto3 = Proyect1.topProductos[2][0];
        }
        
        DefaultCategoryDataset datosTopProductos = new DefaultCategoryDataset();
        datosTopProductos.setValue(freqProducto1, producto1, producto1);
        datosTopProductos.setValue(freqProducto2, producto2, producto2);
        datosTopProductos.setValue(freqProducto3, producto3, producto3);

        // Instancear gráfica de barras 3D
        JFreeChart graficoTopProductos = ChartFactory.createBarChart3D(
                "Top 3 - Productos", // Nombre del grafico
                "Productos", // Nombre de las barras o columnas
                "Cantidad", // Nombre de la numeracion
                datosTopProductos, // Datos del grafico
                PlotOrientation.VERTICAL, // Orientacion
                true, // Leyenda de barras individuales por color
                true, // Herramientas
                false // Url del grafico
        );

        // Creación de un ChartPanel el cual almacenará nuestro gráfico
        ChartPanel prodPanel = new ChartPanel(graficoTopProductos);
        // Habilitamos es scroll
        prodPanel.setMouseWheelEnabled(true);
        // Asignamos la posición y las dimensiones de nuestro ChartPanel
        prodPanel.setBounds(800, 300, 550, 300);
        // Agregamos a nuestra pestaña el ChartPanel con nuestro gráfico
        jp3.add(prodPanel);
        
        //Fondo Doctores
        lbl2 = new JLabel();
        lbl2.setBounds(0, 0, 1500, 800);
        ImageIcon idoctores = new ImageIcon(getClass().getResource("./Images/iMedicos.png"));
        Image imgEscaladaDoc = idoctores.getImage().getScaledInstance(lbl2.getWidth(), lbl2.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoDoc = new ImageIcon(imgEscaladaDoc);
        lbl2.setIcon(iconoEscaladoDoc);
        lbl2.setVisible(true);
        jp1.add(lbl2);

        //Fondo Pacientes
        lbl3 = new JLabel();
        lbl3.setBounds(0, 0, 1500, 800);
        ImageIcon ipacientes = new ImageIcon(getClass().getResource("./Images/iPacientes.png"));
        Image imgEscaladaPacientes = ipacientes.getImage().getScaledInstance(lbl2.getWidth(), lbl2.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoPacientes = new ImageIcon(imgEscaladaPacientes);
        lbl3.setIcon(iconoEscaladoPacientes);
        lbl3.setVisible(true);
        jp2.add(lbl3);

        //Fondo Productos
        lbl4 = new JLabel();
        lbl4.setBounds(0, 0, 1500, 800);
        ImageIcon iproductos = new ImageIcon(getClass().getResource("./Images/iProductos.png"));
        Image imgEscaladaProd = iproductos.getImage().getScaledInstance(lbl2.getWidth(), lbl2.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscaladoProd = new ImageIcon(imgEscaladaProd);
        lbl4.setIcon(iconoEscaladoProd);
        lbl4.setVisible(true);
        jp3.add(lbl4);

        //Login Window
        this.setTitle("Administrador");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(panel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            CrearDoctor crearDoctor = new CrearDoctor();
            this.dispose();
        } else if (ae.getSource() == btn2) {
            ValidarDoctorActualizar validarDoctor = new ValidarDoctorActualizar();
            this.dispose();
        } else if (ae.getSource() == btn3) {
            EliminarDoctor eliminarDoctor = new EliminarDoctor();
            this.dispose();
        } else if (ae.getSource() == btn5) {
            CrearPaciente crearPaciente = new CrearPaciente();
            this.dispose();
        } else if (ae.getSource() == btn6) {
            ValidarPacienteActualizar validarPaciente = new ValidarPacienteActualizar();
            this.dispose();
        } else if (ae.getSource() == btn7) {
            EliminarPaciente eliminarPaciente = new EliminarPaciente();
            this.dispose();
        } else if (ae.getSource() == btn8) {
            CrearProducto crearProducto = new CrearProducto();
            this.dispose();
        } else if (ae.getSource() == btn9) {
            ValidarProductoActualizar validarProducto = new ValidarProductoActualizar();
            this.dispose();
        } else if (ae.getSource() == btn10) {
            EliminarProducto eliminarProd = new EliminarProducto();
            this.dispose();
        } else if (ae.getSource() == btn4) {
            Login login = new Login();
            Proyect1.tipoUsuario = 0;
            this.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {

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
