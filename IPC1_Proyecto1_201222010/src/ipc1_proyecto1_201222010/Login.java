package ipc1_proyecto1_201222010;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author nelson
 */
public class Login extends JFrame implements ActionListener, FocusListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JCheckBox cb1;

    public Login() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel titleLabel = new JLabel("HOSPITAL \"BIENESTAR INTEGRAL\"");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(75, 2, 350, 30);
        this.add(titleLabel);

        //Icono de inicio
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("./Images/Logo.png"));
        Image imageDimension = ImageIcon.getImage().getScaledInstance(110, 100, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension);
        JLabel imageLabel = new JLabel(adjustedImageIcon);
        imageLabel.setBounds(180, 15, 140, 140);
        this.add(imageLabel);

        //Etiqueta: Nombre de usuario
        JLabel usernameLabel = new JLabel("Código");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        usernameLabel.setBounds(70, 140, 80, 25);
        this.add(usernameLabel);

        //Campo para nombre de usuario
        usernameField = new JTextField("Código");
        usernameField.setBounds(130, 140, 260, 25);
        usernameField.addFocusListener(this);
        this.add(usernameField);

        //Etiqueta contraseña
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
        passwordLabel.setBounds(43, 175, 88, 25);
        this.add(passwordLabel);

        //Campo para la contraseña
        passwordField = new JPasswordField("Contraseña");
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds(130, 175, 260, 25);
        passwordField.addFocusListener(this);
        this.add(passwordField);

        //Botón de iniciar sesión
        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(175, 235, 150, 35);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(243, 190, 102));
        loginButton.addActionListener(this);
        this.add(loginButton);

        //Etiqueta: ¿No tienes una cuenta?
        JLabel cuentaLabel = new JLabel("¿No tienes una cuenta?");
        cuentaLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 11));
        cuentaLabel.setBounds(187, 290, 150, 12);
        this.add(cuentaLabel);

        //Botón de registro
        registerButton = new JButton("Crear cuenta nueva");
        registerButton.setBounds(170, 310, 160, 40);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(126, 200, 242));
        registerButton.addActionListener(this);
        this.add(registerButton);

        //Ver contraseña
        cb1 = new JCheckBox("Ver contraseña");
        cb1.setFont(new Font("Arial", Font.BOLD, 10));
        cb1.setBounds(130, 205, 150, 25);
        cb1.setVisible(true);
        cb1.addActionListener(this);
        this.add(cb1);

        //Ventana iniciar sesión
        this.setTitle("Inicio de sesión");
        this.setLocationRelativeTo(null);
        this.setSize(500, 400);
        setLocationRelativeTo(null);

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cb1) {
            if (cb1.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('\u25CF');
            }
        } else if (ae.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            String pwd = new String(password);

            System.out.println("Usuario " + username);
            System.out.println("Password " + pwd);

            boolean valido = false;

            if (!valido) {
                for (int i = 0; i < Proyect1.administradores.size(); i++) {
                    if (username.equals(Proyect1.administradores.get(i).getCodigo())) {
                        if (pwd.equals(Proyect1.administradores.get(i).getContraseña())) {
                            ModAdmin modAdmin = new ModAdmin();
                            Proyect1.tipoUsuario = 1;
                            Proyect1.indiceUsuario = i;
                            this.dispose();
                            valido = true;
                        }
                    }
                }
                if (!valido) {
                    for (int i = 0; i < Proyect1.doctores.size(); i++) {
                        if (username.equals(Proyect1.doctores.get(i).getCodigo())) {
                            if (pwd.equals(Proyect1.doctores.get(i).getContraseña())) {
                                ModDoctor modDoctor = new ModDoctor();
                                System.out.println("Se abre módulo doctores");
                                Proyect1.tipoUsuario = 2;
                                Proyect1.indiceUsuario = i;
                                this.dispose();
                                valido = true;
                            }
                        }
                    }
                    if (!valido) {
                        for (int i = 0; i < Proyect1.pacientes.size(); i++) {
                            if (username.equals(Proyect1.pacientes.get(i).getCodigo())) {
                                if (pwd.equals(Proyect1.pacientes.get(i).getContraseña())) {
                                    ModPaciente modPaciente = new ModPaciente();
                                    System.out.println("Se abre módulo pacientes");
                                    Proyect1.tipoUsuario = 3;
                                    Proyect1.indiceUsuario = i;
                                    this.dispose();
                                    valido = true;
                                }
                            }
                        }
                        if (!valido) {
                            JOptionPane.showMessageDialog(this, "El usuario o la contraseña son incorrectos", "ERROR", 0);
                        }
                    }
                }
            }

        } else if (ae.getSource() == registerButton) {
            CrearPaciente crearPaciente = new CrearPaciente();
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == usernameField) {
            usernameField.setText("");
        } else if (fe.getSource() == passwordField) {
            if (cb1.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('\u25CF');
            }
            passwordField.setText("");
        }

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
