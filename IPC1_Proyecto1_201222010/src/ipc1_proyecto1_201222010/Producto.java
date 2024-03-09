package ipc1_proyecto1_201222010;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.MessageFormat;
import java.util.Map;
import javax.swing.*;;

/**
 *
 * @author nelson
 */
class Producto {
    private String codigo;
    private String nombre;
    private String precio;
    private String descripcion;
    private String cantidad;
    JPanel jp1;
    JLabel lbl1,lbl2,lbl3;
    JButton btn1;

    public Producto(String codigo, String nombre, String precio, String descripcion, String cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        initComponents();
    }
    
    public void initComponents(){
        jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBackground(new Color(255,226,168));
        jp1.setPreferredSize(new Dimension(210,150));
        
        lbl1 = new JLabel(this.getNombre());
        lbl1.setFont(new Font("arial",Font.BOLD,20));
        lbl1.setBounds(5,10,200,40);
        lbl1.setForeground(Color.BLACK);
        lbl1.setVerticalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        jp1.add(lbl1);
        
        lbl2 = new JLabel(this.getDescripcion());
        lbl2.setFont(new Font("arial",Font.BOLD,15));
        lbl2.setBounds(15,50,200,40);
        lbl2.setForeground(Color.BLACK);
        lbl2.setVerticalAlignment(SwingConstants.CENTER);
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        jp1.add(lbl2);
        
        lbl3 = new JLabel("Q " + this.precio);
        lbl3.setFont(new Font("arial",Font.BOLD,15));
        lbl3.setBounds(130, 100,175,40);
        lbl3.setForeground(Color.BLACK);
        lbl3.setVerticalAlignment(SwingConstants.CENTER);
        jp1.add(lbl3);
        
        jp1.setVisible(true);
    }
    
    public JPanel getPanel(){
        return jp1;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
