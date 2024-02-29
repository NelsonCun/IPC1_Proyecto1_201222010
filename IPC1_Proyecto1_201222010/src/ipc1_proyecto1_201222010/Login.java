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
        JLabel titleLabel = new JLabel("Bienvenido");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(200, 2, 150, 30);
        this.add(titleLabel);

        //Icono de inicio
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("./Images/Login.png"));
        Image imageDimension = ImageIcon.getImage().getScaledInstance(110, 100, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon = new ImageIcon(imageDimension);
        JLabel imageLabel = new JLabel(adjustedImageIcon);
        imageLabel.setBounds(190, 30, 110, 100);
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
        passwordLabel.setBounds(43, 180, 88, 25);
        this.add(passwordLabel);

        //Campo para la contraseña
        passwordField = new JPasswordField("Contraseña");
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds(130, 180, 260, 25);
        passwordField.addFocusListener(this);
        this.add(passwordField);

        //Botón de inicio
        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(275, 260, 150, 25);
        loginButton.setForeground(new Color(165, 105, 7));
        loginButton.setBackground(new Color(243, 190, 102));
        loginButton.addActionListener(this);
        this.add(loginButton);

        //Botón de registro
        registerButton = new JButton("Registrarse");
        registerButton.setBounds(75, 260, 150, 25);
        registerButton.setForeground(new Color(108, 123, 207));
        registerButton.setBackground(new Color(126, 200, 242));
        registerButton.addActionListener(this);
        this.add(registerButton);

        //Ver contraseña
        cb1 = new JCheckBox("Ver contraseña");
        cb1.setFont(new Font("Arial", Font.BOLD, 12));
        cb1.setBounds(130, 220, 150, 25);
        cb1.setVisible(true);
        cb1.addActionListener(this);
        this.add(cb1);
        
        //Ventana iniciar sesión
        this.setTitle("Iniciar Sesión");
        this.setLocationRelativeTo(null);
        this.setSize(500,350);
        setLocationRelativeTo(null);
        
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
