package ipc1_proyecto1_201222010;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nelson
 */
public class CrearDoctor extends JFrame implements ActionListener {
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
    
    private void iniciarComponentes(){
        //Título ventana
        JLabel titleLabel = new JLabel("Registro Doctor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(50, 20, 200, 30);
        this.add(titleLabel);
        
        JLabel nombres = new JLabel("Nombres");
        nombres.setFont(new Font("Arial", Font.BOLD, 15));
        nombres.setBounds(50, 70, 100, 30);
        this.add(nombres);
        
        JLabel apellidos = new JLabel("Apellidos");
        apellidos.setFont(new Font("Arial", Font.BOLD, 15));
        apellidos.setBounds(50, 110, 100, 30);
        this.add(apellidos);
        
        JLabel contraseña = new JLabel("Contraseña");
        contraseña.setFont(new Font("Arial", Font.BOLD, 15));
        contraseña.setBounds(50, 150, 100, 30);
        this.add(contraseña);
        
        JLabel genero = new JLabel("Género");
        genero.setFont(new Font("Arial", Font.BOLD, 15));
        genero.setBounds(50, 190, 100, 30);
        this.add(genero);
        
        JLabel especialidad = new JLabel("Especialidad");
        especialidad.setFont(new Font("Arial", Font.BOLD, 15));
        especialidad.setBounds(400, 70, 100, 30);
        this.add(especialidad);
        
        JLabel telefono = new JLabel("Teléfono");
        telefono.setFont(new Font("Arial", Font.BOLD, 15));
        telefono.setBounds(400, 110, 100, 30);
        this.add(telefono);
        
        JLabel edad = new JLabel("Edad");
        edad.setFont(new Font("Arial", Font.BOLD, 15));
        edad.setBounds(400, 150, 100, 30);
        this.add(edad);
        
        campoNombre = new JTextField();
        campoNombre.setBounds(150, 70, 200, 30);
        this.add(campoNombre);
        
        campoApellido = new JTextField();
        campoApellido.setBounds(150, 110, 200, 30);
        this.add(campoApellido);
        
        campoPassword = new JPasswordField();
        campoPassword.setBounds(150, 150, 200, 30);
        this.add(campoPassword);
        
        String[] vectorGenero = {"Masculino","Femenino"};
        comboBoxGenero = new JComboBox<>(vectorGenero);
        comboBoxGenero.setBounds(150,190,120,30);
        this.add(comboBoxGenero);
        
        campoEspecialidad = new JTextField();
        campoEspecialidad.setBounds(500, 70, 200, 30);
        this.add(campoEspecialidad);
        
        campoTelefono = new JTextField();
        campoTelefono.setBounds(500, 110, 200, 30);
        this.add(campoTelefono);
        
        campoEdad = new JTextField();
        campoEdad.setBounds(500, 150, 200, 30);
        this.add(campoEdad);
        
        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(262,250,100,40);
        buttonRegistrar.setForeground(Color.WHITE);
        buttonRegistrar.setBackground(new Color(136,191,243));
        buttonRegistrar.addActionListener(this);
        this.add(buttonRegistrar);
        
        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(387,250,100,40);
        buttonCancelar.setForeground(Color.WHITE);
        buttonCancelar.setBackground(new Color(148,37,37));
        buttonCancelar.addActionListener(this);
        this.add(buttonCancelar);
        
        
        this.setTitle("Nuevo Registro");
        this.setBounds(350, 400, 750, 350);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonRegistrar) {
            
        } else if (ae.getSource()== buttonCancelar) {
            this.dispose();
        }
        }
    
}
