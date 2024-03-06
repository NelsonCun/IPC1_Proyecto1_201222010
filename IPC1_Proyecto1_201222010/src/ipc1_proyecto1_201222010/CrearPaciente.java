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
public class CrearPaciente extends JFrame implements ActionListener, KeyListener {

    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoEdad;
    private JPasswordField campoPassword;
    private JComboBox<String> comboBoxGenero;
    private JButton buttonRegistrar;
    private JButton buttonCancelar;

    public CrearPaciente() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Título ventana
        JLabel titleLabel = new JLabel("Registro de Paciente");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(50, 20, 250, 30);
        this.add(titleLabel);

        JLabel nombresLabel = new JLabel("Nombres");
        nombresLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nombresLabel.setBounds(50, 70, 100, 30);
        this.add(nombresLabel);

        JLabel apellidosLabel = new JLabel("Apellidos");
        apellidosLabel.setFont(new Font("Arial", Font.BOLD, 15));
        apellidosLabel.setBounds(400, 70, 100, 30);
        this.add(apellidosLabel);

        JLabel contraseñaLabel = new JLabel("Contraseña");
        contraseñaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        contraseñaLabel.setBounds(50, 110, 100, 30);
        this.add(contraseñaLabel);

        JLabel generoLabel = new JLabel("Género");
        generoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        generoLabel.setBounds(50, 150, 100, 30);
        this.add(generoLabel);

        JLabel edadLabel = new JLabel("Edad");
        edadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        edadLabel.setBounds(400, 110, 100, 30);
        this.add(edadLabel);

        campoNombre = new JTextField();
        campoNombre.addKeyListener(this);
        campoNombre.setBounds(150, 70, 200, 30);
        this.add(campoNombre);

        campoApellido = new JTextField();
        campoApellido.addKeyListener(this);
        campoApellido.setBounds(500, 70, 200, 30);
        this.add(campoApellido);

        campoPassword = new JPasswordField();
        campoPassword.setBounds(150, 110, 200, 30);
        this.add(campoPassword);

        String[] vectorGenero = {"Masculino", "Femenino"};
        comboBoxGenero = new JComboBox<>(vectorGenero);
        comboBoxGenero.setBounds(150, 150, 200, 30);
        this.add(comboBoxGenero);

        campoEdad = new JTextField();
        campoEdad.addKeyListener(this);
        campoEdad.setBounds(500, 110, 200, 30);
        this.add(campoEdad);

        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(262, 210, 100, 40);
        buttonRegistrar.setForeground(Color.WHITE);
        buttonRegistrar.setBackground(new Color(136, 191, 243));
        buttonRegistrar.addActionListener(this);
        this.add(buttonRegistrar);

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(387, 210, 100, 40);
        buttonCancelar.setForeground(Color.WHITE);
        buttonCancelar.setBackground(new Color(148, 37, 37));
        buttonCancelar.addActionListener(this);
        this.add(buttonCancelar);

        this.setTitle("Nuevo Registro");
        this.setBounds(350, 400, 750, 310);
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
            String edad = campoEdad.getText();
            char[] passwordVector = campoPassword.getPassword();
            String password = new String(passwordVector);
            String genero = (String) comboBoxGenero.getSelectedItem();
            String codigoPaciente = Integer.toString(Proyect1.codigoPacientes);
            if (nombres.isEmpty() || apellidos.isEmpty() || edad.isEmpty() || password.isEmpty() || genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "ERROR", 0);
            } else {
                Paciente newpaciente = new Paciente(codigoPaciente, nombres, apellidos, edad, password, genero);
                Proyect1.addPaciente(newpaciente);
                JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente\nCódigo de paciente: " + Proyect1.codigoPacientes,
                        "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                if (Proyect1.tipoUsuario == 0) {
                    this.dispose();
                } else if (Proyect1.tipoUsuario == 1) {
                    ModAdmin modAdmin = new ModAdmin();
                    this.dispose();
                } else if (Proyect1.tipoUsuario == 3) {
                    ModPaciente modPaciente = new ModPaciente();
                    this.dispose();
                }
                Proyect1.codigoPacientes += 1;
            }
        } else if (ae.getSource() == buttonCancelar) {
            if (Proyect1.tipoUsuario == 0) {
                this.dispose();
            } else if (Proyect1.tipoUsuario == 1) {
                ModAdmin modAdmin = new ModAdmin();
                this.dispose();
            }

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

        if (datoIngresado == campoEdad) {
            if (!(entrada >= 48 && entrada <= 57)) {
                ke.consume();
            }
        } else if (datoIngresado == campoNombre || datoIngresado == campoApellido) {
            if (entrada >= 48 && entrada <= 57) {
                ke.consume();
            }
        }
    }
}
