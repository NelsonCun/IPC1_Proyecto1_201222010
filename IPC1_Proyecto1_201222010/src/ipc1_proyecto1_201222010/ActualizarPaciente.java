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
public class ActualizarPaciente extends JFrame implements ActionListener, KeyListener {
    
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoEdad;
    private JPasswordField campoPassword;
    private JButton buttonRegistrar;
    private JButton buttonCancelar;

    public ActualizarPaciente() {
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        //Título ventana
        JLabel titleLabel = new JLabel("Actualizar Paciente");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(50, 20, 250, 30);
        this.add(titleLabel);
        
        JLabel codigoLabel = new JLabel("Código");
        codigoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        codigoLabel.setBounds(400, 30, 100, 30);
        this.add(codigoLabel);

        JLabel code = new JLabel(Proyect1.pacientes.get(Proyect1.codigoActual).getCodigo());
        code.setBounds(500, 30, 100, 30);
        code.setVerticalAlignment(SwingConstants.CENTER);
        code.setHorizontalAlignment(SwingConstants.CENTER);
        code.setFont(new Font("Arial", Font.BOLD, 15));
        code.setVisible(true);
        this.add(code);
        
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
        
        JLabel gender = new JLabel(Proyect1.pacientes.get(Proyect1.codigoActual).getSexo());
        gender.setBounds(150, 150, 100, 30);
        gender.setVerticalAlignment(SwingConstants.CENTER);
        gender.setHorizontalAlignment(SwingConstants.CENTER);
        gender.setFont(new Font("Arial", Font.BOLD, 15));
        gender.setVisible(true);
        this.add(gender);

        JLabel edadLabel = new JLabel("Edad");
        edadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        edadLabel.setBounds(400, 110, 100, 30);
        this.add(edadLabel);

        campoNombre = new JTextField(Proyect1.pacientes.get(Proyect1.codigoActual).getNombres());
        campoNombre.addKeyListener(this);
        campoNombre.setBounds(150, 70, 200, 30);
        this.add(campoNombre);

        campoApellido = new JTextField(Proyect1.pacientes.get(Proyect1.codigoActual).getApellidos());
        campoApellido.addKeyListener(this);
        campoApellido.setBounds(500, 70, 200, 30);
        this.add(campoApellido);

        campoPassword = new JPasswordField(Proyect1.pacientes.get(Proyect1.codigoActual).getContraseña());
        campoPassword.setBounds(150, 110, 200, 30);
        this.add(campoPassword);

        campoEdad = new JTextField(Proyect1.pacientes.get(Proyect1.codigoActual).getEdad());
        campoEdad.addKeyListener(this);
        campoEdad.setBounds(500, 110, 200, 30);
        this.add(campoEdad);

        buttonRegistrar = new JButton("Actualizar");
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

        this.setTitle("Actualización");
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
            String genero = Proyect1.pacientes.get(Proyect1.codigoActual).getSexo();
            String codigoPaciente = Integer.toString(Proyect1.codigoPacientes);
            if (nombres.isEmpty()||apellidos.isEmpty()||edad.isEmpty()||password.isEmpty()||genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "ERROR", 0);
            }else{
                Paciente newpaciente = new Paciente(codigoPaciente, nombres, apellidos, edad, password, genero);
            Proyect1.pacientes.set(Proyect1.codigoActual,newpaciente);
            JOptionPane.showMessageDialog(null, "Paciente actualizado exitosamente",
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                
                    ModAdmin modAdmin = new ModAdmin();
                    this.dispose();
                
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

        if (datoIngresado==campoEdad) {
        if (!(entrada>=48 && entrada<=57)) {
            ke.consume();
        }
    } else if (datoIngresado == campoNombre || datoIngresado == campoApellido) {
        if (entrada>=48 && entrada<=57) {
            ke.consume();
        }
    }
    }
    
}
