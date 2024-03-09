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
public class CrearProducto extends JFrame implements ActionListener, KeyListener {

    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JTextField campoDescripcion;
    private JTextField campoCantidad;

    private JButton buttonRegistrar;
    private JButton buttonCancelar;

    public CrearProducto() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Título ventana
        JLabel titleLabel = new JLabel("Registro Producto");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(50, 20, 250, 30);
        this.add(titleLabel);

        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nombreLabel.setBounds(50, 70, 100, 30);
        this.add(nombreLabel);

        JLabel precioLabel = new JLabel("Precio          Q");
        precioLabel.setFont(new Font("Arial", Font.BOLD, 15));
        precioLabel.setBounds(50, 110, 100, 30);
        this.add(precioLabel);

        JLabel cantidadLabel = new JLabel("Cantidad");
        cantidadLabel.setFont(new Font("Arial", Font.BOLD, 15));
        cantidadLabel.setBounds(400, 70, 100, 30);
        this.add(cantidadLabel);

        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setFont(new Font("Arial", Font.BOLD, 15));
        descripcionLabel.setBounds(400, 110, 100, 30);
        this.add(descripcionLabel);

        campoNombre = new JTextField();
        campoNombre.addKeyListener(this);
        campoNombre.setBounds(150, 70, 200, 30);
        this.add(campoNombre);

        campoPrecio = new JTextField();
        campoPrecio.addKeyListener(this);
        campoPrecio.setBounds(150, 110, 200, 30);
        this.add(campoPrecio);

        campoCantidad = new JTextField();
        campoCantidad.addKeyListener(this);
        campoCantidad.setBounds(500, 70, 200, 30);
        this.add(campoCantidad);

        campoDescripcion = new JTextField();
        campoDescripcion.addKeyListener(this);
        campoDescripcion.setBounds(500, 110, 200, 30);
        this.add(campoDescripcion);

        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(262, 170, 100, 40);
        buttonRegistrar.setForeground(Color.WHITE);
        buttonRegistrar.setBackground(new Color(136, 191, 243));
        buttonRegistrar.addActionListener(this);
        this.add(buttonRegistrar);

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(387, 170, 100, 40);
        buttonCancelar.setForeground(Color.WHITE);
        buttonCancelar.setBackground(new Color(148, 37, 37));
        buttonCancelar.addActionListener(this);
        this.add(buttonCancelar);

        this.setTitle("Nuevo Registro");
        this.setBounds(350, 400, 750, 270);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonRegistrar) {
            String nombre = campoNombre.getText();
            String precio = campoPrecio.getText();
            String cantidad = campoCantidad.getText();
            String descripcion = campoDescripcion.getText();
            String codigoProducto = Integer.toString(Proyect1.codigoProductos);
            if (nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "ERROR", 0);
            } else {
                Producto newproducto = new Producto(codigoProducto, nombre, precio, descripcion, cantidad);
                Proyect1.addProducto(newproducto);
                JOptionPane.showMessageDialog(null, "Producto registrado exitosamente\nCódigo de producto: " + Proyect1.codigoProductos,
                        "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                Proyect1.codigoProductos += 1;
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

        if (datoIngresado == campoPrecio) {
            if (!((entrada >= 48 && entrada <= 57) || entrada == 46)) {
                ke.consume();
            }
        } else if (datoIngresado == campoCantidad) {
            if (!(entrada >= 48 && entrada <= 57)) {
                ke.consume();
            }
        } else if (datoIngresado == campoPrecio) {
            if (entrada >= 48 && entrada <= 57) {
                ke.consume();
            }
        }
    }
}
