package ipc1_proyecto1_201222010;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author nelson
 */
public class CrearDoctor extends JFrame implements ActionListener, KeyListener {

    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoEspecialidad;
    private JTextField campoTelefono;
    private JTextField campoEdad;
    private JPasswordField campoPassword;
    private JComboBox<String> comboBoxGenero;
    private JButton buttonRegistrar;
    private JButton buttonCancelar;

    public CrearDoctor() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Título ventana
        JLabel titleLabel = new JLabel("Registro Doctor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(50, 20, 200, 30);
        this.add(titleLabel);

        JLabel nombresLabel = new JLabel("Nombres\u207A");
        nombresLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nombresLabel.setBounds(50, 70, 100, 30);
        this.add(nombresLabel);

        JLabel apellidosLabel = new JLabel("Apellidos\u207A");
        apellidosLabel.setFont(new Font("Arial", Font.BOLD, 15));
        apellidosLabel.setBounds(50, 110, 100, 30);
        this.add(apellidosLabel);

        JLabel contraseñaLabel = new JLabel("Contraseña\u207A");
        contraseñaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        contraseñaLabel.setBounds(50, 150, 100, 30);
        this.add(contraseñaLabel);

        JLabel generoLabel = new JLabel("Género\u207A");
        generoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        generoLabel.setBounds(50, 190, 100, 30);
        this.add(generoLabel);

        JLabel especialidadLabel = new JLabel("Especialidad\u207A");
        especialidadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        especialidadLabel.setBounds(400, 70, 100, 30);
        this.add(especialidadLabel);

        JLabel telefonoLabel = new JLabel("Teléfono");
        telefonoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        telefonoLabel.setBounds(400, 110, 100, 30);
        this.add(telefonoLabel);

        JLabel edadLabel = new JLabel("Edad\u207A");
        edadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        edadLabel.setBounds(400, 150, 100, 30);
        this.add(edadLabel);
        
        JLabel obligatorio = new JLabel("\u207A Campo obligatorio");
        obligatorio.setFont(new Font("Arial", Font.BOLD, 10));
        obligatorio.setBounds(400, 190, 100, 30);
        this.add(obligatorio);

        campoNombre = new JTextField();
        campoNombre.addKeyListener(this);
        campoNombre.setBounds(150, 70, 200, 30);
        this.add(campoNombre);

        campoApellido = new JTextField();
        campoApellido.addKeyListener(this);
        campoApellido.setBounds(150, 110, 200, 30);
        this.add(campoApellido);

        campoPassword = new JPasswordField();
        campoPassword.setBounds(150, 150, 200, 30);
        this.add(campoPassword);

        String[] vectorGenero = {"Masculino", "Femenino"};
        comboBoxGenero = new JComboBox<>(vectorGenero);
        comboBoxGenero.setBounds(150, 190, 120, 30);
        this.add(comboBoxGenero);

        campoEspecialidad = new JTextField();
        campoEspecialidad.addKeyListener(this);
        campoEspecialidad.setBounds(500, 70, 200, 30);
        this.add(campoEspecialidad);

        campoTelefono = new JTextField();
        campoTelefono.addKeyListener(this);
        campoTelefono.setBounds(500, 110, 200, 30);
        this.add(campoTelefono);

        campoEdad = new JTextField();
        campoEdad.addKeyListener(this);
        campoEdad.setBounds(500, 150, 200, 30);
        this.add(campoEdad);

        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(262, 250, 100, 40);
        buttonRegistrar.setForeground(Color.WHITE);
        buttonRegistrar.setBackground(new Color(136, 191, 243));
        buttonRegistrar.addActionListener(this);
        this.add(buttonRegistrar);

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(387, 250, 100, 40);
        buttonCancelar.setForeground(Color.WHITE);
        buttonCancelar.setBackground(new Color(148, 37, 37));
        buttonCancelar.addActionListener(this);
        this.add(buttonCancelar);

        this.setTitle("Nuevo Registro");
        this.setBounds(350, 400, 750, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonRegistrar) {
            String nombres = campoNombre.getText();
            String apellidos = campoApellido.getText();
            String especialidad = campoEspecialidad.getText();
            String telefono = campoTelefono.getText();
            String edad = campoEdad.getText();
            char[] passwordVector = campoPassword.getPassword();
            String password = new String(passwordVector);
            String genero = (String) comboBoxGenero.getSelectedItem();
            String codigoDoctor = Integer.toString(Proyect1.codigoDoctores);
            if (nombres.isEmpty()||apellidos.isEmpty()||especialidad.isEmpty()||edad.isEmpty()||password.isEmpty()||genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos obligatorios", "ERROR", 0);
            }else{
                Doctor newdoctor = new Doctor(codigoDoctor, nombres, apellidos, especialidad, telefono, edad, password, genero);
            Proyect1.addDoctor(newdoctor);
            JOptionPane.showMessageDialog(null, "Doctor registrado exitosamente\nCódigo de doctor: "+Proyect1.codigoDoctores,
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            Proyect1.codigoDoctores += 1;
            this.dispose();
            ModAdmin modAdmin = new ModAdmin();
            }
        } else if (ae.getSource() == buttonCancelar) {
            this.dispose();
            ModAdmin modAdmin = new ModAdmin();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // Obtener el carácter de la tecla presionada y llamar a discriminarCaracter
        char entrada = ke.getKeyChar();
        discriminarCaracter(ke, entrada);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    private void discriminarCaracter(KeyEvent ke, char entrada) {
        JTextField datoIngresado = (JTextField) ke.getSource();

        if (datoIngresado == campoTelefono || datoIngresado==campoEdad) {
        if (!(entrada>=48 && entrada<=57)) {
            ke.consume();
        }
    } else if (datoIngresado == campoNombre || datoIngresado == campoApellido || datoIngresado == campoEspecialidad) {
        if (entrada>=48 && entrada<=57) {
            ke.consume();
        }
    }
    }
}
