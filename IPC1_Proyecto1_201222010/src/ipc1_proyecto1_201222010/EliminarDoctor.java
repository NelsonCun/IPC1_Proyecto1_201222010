package ipc1_proyecto1_201222010;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nelson
 */

public class EliminarDoctor extends JFrame implements ActionListener {
    JLabel mensaje1, mensaje2;
    JTextField codigo;
    JButton cancelar, aceptar;

    public EliminarDoctor() {
        inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        
        mensaje1 = new JLabel("Ingrese el código del");
        mensaje1.setFont(new Font("Arial", Font.BOLD, 15));
        mensaje1.setBounds(75, 10, 200, 20);
        this.add(mensaje1);
        
        mensaje2 = new JLabel("doctor a eliminar");
        mensaje2.setFont(new Font("Arial", Font.BOLD, 15));
        mensaje2.setBounds(81, 30, 200, 20);
        this.add(mensaje2);
        
        codigo = new JTextField();
        codigo.setBounds(50, 60, 200, 30);
        this.add(codigo);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(166, 110, 100, 40);
        cancelar.setForeground(Color.WHITE);
        cancelar.setBackground(new Color(148, 37, 37));
        cancelar.addActionListener(this);
        this.add(cancelar);
        
        aceptar = new JButton("aceptar");
        aceptar.setBounds(33, 110, 100, 40);
        aceptar.setForeground(Color.WHITE);
        aceptar.setBackground(new Color(136, 191, 243));
        aceptar.addActionListener(this);
        this.add(aceptar);
        
        this.setTitle("Código de doctor");
        this.setBounds(350, 400, 300, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==aceptar) {
            boolean continuar = Proyect1.validarCodigoDoctor(codigo.getText());
            if (continuar) {
                Proyect1.doctores.remove(Proyect1.codigoActual);
                JOptionPane.showMessageDialog(null, "Se ha eliminado el doctor con éxito",
                "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                ModAdmin modAdmin = new ModAdmin();
                this.dispose();
            } else if (!continuar) {
                JOptionPane.showMessageDialog(null, "Código no encontrado",
                "ERROR", JOptionPane.ERROR_MESSAGE);
            }
                
        } else if (ae.getSource()==cancelar) {
            this.dispose();
            ModAdmin modAdmin = new ModAdmin();
        }
        }
}
