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

public class ActualizarDoctor extends JFrame implements ActionListener, KeyListener{
    
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoEspecialidad;
    private JTextField campoTelefono;
    private JTextField campoEdad;
    private JPasswordField campoPassword;
    private JButton buttonActualizar;
    private JButton buttonCancelar;

    public ActualizarDoctor() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Título ventana
        JLabel titleLabel = new JLabel("Actualizar Doctor\u207A");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(50, 20, 250, 30);
        this.add(titleLabel);

        JLabel codigoLabel = new JLabel("Código");
        codigoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        codigoLabel.setBounds(50, 70, 100, 30);
        this.add(codigoLabel);
        
        JLabel code = new JLabel(Proyect1.doctores.get(Proyect1.codigoActual).getCodigo());
        code.setBounds(150, 70, 100, 30);
        code.setVerticalAlignment(SwingConstants.CENTER);
        code.setHorizontalAlignment(SwingConstants.CENTER);
        code.setFont(new Font("Arial", Font.BOLD, 15));
        code.setVisible(true);
        this.add(code);
        
        JLabel nombresLabel = new JLabel("Nombres\u207A");
        nombresLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nombresLabel.setBounds(50, 110, 100, 30);
        this.add(nombresLabel);

        JLabel apellidosLabel = new JLabel("Apellidos\u207A");
        apellidosLabel.setFont(new Font("Arial", Font.BOLD, 15));
        apellidosLabel.setBounds(50, 150, 100, 30);
        this.add(apellidosLabel);

        JLabel contraseñaLabel = new JLabel("Contraseña\u207A");
        contraseñaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        contraseñaLabel.setBounds(50, 190, 100, 30);
        this.add(contraseñaLabel);

        JLabel generoLabel = new JLabel("Género");
        generoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        generoLabel.setBounds(50, 230, 100, 30);
        this.add(generoLabel);
        
        JLabel gender = new JLabel(Proyect1.doctores.get(Proyect1.codigoActual).getSexo());
        gender.setBounds(150, 230, 100, 30);
        gender.setVerticalAlignment(SwingConstants.CENTER);
        gender.setHorizontalAlignment(SwingConstants.CENTER);
        gender.setFont(new Font("Arial", Font.BOLD, 15));
        gender.setVisible(true);
        this.add(gender);

        JLabel especialidadLabel = new JLabel("Especialidad\u207A");
        especialidadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        especialidadLabel.setBounds(400, 110, 100, 30);
        this.add(especialidadLabel);

        JLabel telefonoLabel = new JLabel("Teléfono");
        telefonoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        telefonoLabel.setBounds(400, 150, 100, 30);
        this.add(telefonoLabel);

        JLabel edadLabel = new JLabel("Edad\u207A");
        edadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        edadLabel.setBounds(400, 190, 100, 30);
        this.add(edadLabel);
        
        JLabel obligatorio = new JLabel("\u207A Campo obligatorio");
        obligatorio.setFont(new Font("Arial", Font.BOLD, 10));
        obligatorio.setBounds(400, 230, 100, 30);
        this.add(obligatorio);

        campoNombre = new JTextField(Proyect1.doctores.get(Proyect1.codigoActual).getNombres());
        campoNombre.addKeyListener(this);
        campoNombre.setBounds(150, 110, 200, 30);
        this.add(campoNombre);

        campoApellido = new JTextField(Proyect1.doctores.get(Proyect1.codigoActual).getApellidos());
        campoApellido.addKeyListener(this);
        campoApellido.setBounds(150, 150, 200, 30);
        this.add(campoApellido);

        campoPassword = new JPasswordField(Proyect1.doctores.get(Proyect1.codigoActual).getContraseña());
        campoPassword.setBounds(150, 190, 200, 30);
        this.add(campoPassword);

        campoEspecialidad = new JTextField(Proyect1.doctores.get(Proyect1.codigoActual).getEspecialidad());
        campoEspecialidad.addKeyListener(this);
        campoEspecialidad.setBounds(500, 110, 200, 30);
        this.add(campoEspecialidad);

        campoTelefono = new JTextField(Proyect1.doctores.get(Proyect1.codigoActual).getTelefono());
        campoTelefono.addKeyListener(this);
        campoTelefono.setBounds(500, 150, 200, 30);
        this.add(campoTelefono);

        campoEdad = new JTextField(Proyect1.doctores.get(Proyect1.codigoActual).getEdad());
        campoEdad.addKeyListener(this);
        campoEdad.setBounds(500, 190, 200, 30);
        this.add(campoEdad);

        buttonActualizar = new JButton("Actualizar");
        buttonActualizar.setBounds(262, 290, 100, 40);
        buttonActualizar.setForeground(Color.WHITE);
        buttonActualizar.setBackground(new Color(136, 191, 243));
        buttonActualizar.addActionListener(this);
        this.add(buttonActualizar);

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(387, 290, 100, 40);
        buttonCancelar.setForeground(Color.WHITE);
        buttonCancelar.setBackground(new Color(148, 37, 37));
        buttonCancelar.addActionListener(this);
        this.add(buttonCancelar);

        this.setTitle("Actualización");
        this.setBounds(350, 400, 750, 390);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonActualizar) {
            String nombres = campoNombre.getText();
            String apellidos = campoApellido.getText();
            String especialidad = campoEspecialidad.getText();
            String telefono = campoTelefono.getText();
            String edad = campoEdad.getText();
            char[] passwordVector = campoPassword.getPassword();
            String password = new String(passwordVector);
            String genero = Proyect1.doctores.get(Proyect1.codigoActual).getSexo();
            String codigoDoctor = Proyect1.doctores.get(Proyect1.codigoActual).getCodigo();
            if (nombres.isEmpty()||apellidos.isEmpty()||especialidad.isEmpty()||edad.isEmpty()||password.isEmpty()||genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos obligatorios", "ERROR", 0);
            }else{

            Doctor newdoctor = new Doctor(codigoDoctor, nombres, apellidos, especialidad, telefono, edad, password, genero);
            Proyect1.doctores.set(Proyect1.codigoActual,newdoctor);
            JOptionPane.showMessageDialog(null, "Doctor actualizado exitosamente",
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            
            ModAdmin modAdmin = new ModAdmin();
            this.dispose();
            }
        } else if (ae.getSource() == buttonCancelar) {
            this.dispose();
            if (Proyect1.tipoUsuario==1) {
                ModAdmin modAdmin = new ModAdmin();
            } else if (Proyect1.tipoUsuario==2) {
                ModDoctor modDoctor = new ModDoctor();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
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
