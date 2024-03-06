package ipc1_proyecto1_201222010;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author nelson
 */
public class Proyect1 {

    static ArrayList<Doctor> doctores = new ArrayList<>();
    static ArrayList<Paciente> pacientes = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Administrador> administradores = new ArrayList<>();
    static int codigoDoctores = 202410000;
    static int codigoPacientes = 202420000;
    static int codigoProductos = 202430000;
    static int codigoUsuario = 0;
    static int indiceUsuario = 0;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        Login login = new Login();

        Administrador newAdmin = new Administrador("20", "admin", "20");
        addAdmin(newAdmin);
    }

    //Añadir doctores al ArrayList
    public static void addDoctor(Doctor datosDoctores) {
        doctores.add(datosDoctores);
    }

    //Añadir pacientes al Arraylist
    public static void addPaciente(Paciente datosPacientes) {
        pacientes.add(datosPacientes);
    }

    //Añadir productos al Arraylist
    public static void addProducto(Producto datosProductos) {
        productos.add(datosProductos);
    }

    //Añadir administradores al Arraylist
    public static void addAdmin(Administrador newAdmin) {
        administradores.add(newAdmin);
    }

    //Para mostrar tabla doctores
    public static Object[][] convertirDatosDoctores() {
        int filas = doctores.size();
        Object[][] arregloDoctores = new Object[filas][7];
        for (int i = 0; i < filas; i++) {
            arregloDoctores[i][0] = doctores.get(i).getCodigo();
            arregloDoctores[i][1] = doctores.get(i).getNombres();
            arregloDoctores[i][2] = doctores.get(i).getApellidos();
            arregloDoctores[i][3] = doctores.get(i).getEspecialidad();
            arregloDoctores[i][4] = doctores.get(i).getTelefono();
            arregloDoctores[i][5] = doctores.get(i).getEdad();
            arregloDoctores[i][6] = doctores.get(i).getSexo();
        }
        return arregloDoctores;
    }

    //Para mostrar tabla pacientes
    public static Object[][] convertirDatosPacientes() {
        int filas = pacientes.size();
        Object[][] arregloPacientes = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arregloPacientes[i][0] = pacientes.get(i).getCodigo();
            arregloPacientes[i][1] = pacientes.get(i).getNombres();
            arregloPacientes[i][2] = pacientes.get(i).getApellidos();
            arregloPacientes[i][3] = pacientes.get(i).getEdad();
            arregloPacientes[i][4] = pacientes.get(i).getSexo();
        }
        return arregloPacientes;
    }

    //Para mostrar tabla productos
    public static Object[][] convertirDatosProductos() {
        int filas = productos.size();
        Object[][] arregloProductos = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arregloProductos[i][0] = productos.get(i).getCodigo();
            arregloProductos[i][1] = productos.get(i).getNombre();
            arregloProductos[i][2] = productos.get(i).getPrecio();
            arregloProductos[i][3] = productos.get(i).getDescripcion();
            arregloProductos[i][4] = productos.get(i).getCantidad();
        }
        return arregloProductos;
    }

    //Validación para actualizar o eliminar
    public static int codigoActual = 0;

    public static boolean validarCodigoDoctor(String codigo) {
        for (int i = 0; i < doctores.size(); i++) {
            String codigoTem = doctores.get(i).getCodigo();
            if (codigoTem.equals(codigo)) {
                codigoActual = i;
                return true;
            }
        }
        return false;
    }

    public static boolean validarCodigoPaciente(String codigo) {
        for (int i = 0; i < pacientes.size(); i++) {
            String codigoTem = pacientes.get(i).getCodigo();
            if (codigoTem.equals(codigo)) {
                codigoActual = i;
                return true;
            }
        }
        return false;
    }

    public static boolean validarCodigoProducto(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            String codigoTem = productos.get(i).getCodigo();
            if (codigoTem.equals(codigo)) {
                codigoActual = i;
                return true;
            }
        }
        return false;
    }

    //Matriz retornada para la grafica nombres
    public static String[][] topEspecialidades = new String[5][2];

    public static void contarEspecialidad(ArrayList<Doctor> doctores) {
        // ArrayList para almacenar las nombres y sus frecuencias
        ArrayList<String> especialidades = new ArrayList<>();
        ArrayList<Integer> frecuencia = new ArrayList<>();

        for (Doctor doctor : doctores) {
            String especialidad = doctor.getEspecialidad();
            int indiceEncontrado = especialidades.indexOf(especialidad);

            if (indiceEncontrado != -1) {
                // Ya tenemos esta nombre, incrementamos la cantidad
                frecuencia.set(indiceEncontrado, frecuencia.get(indiceEncontrado) + 1);
            } else {
                // Añadimos una nueva nombre y establecemos su cantidad en 1
                especialidades.add(especialidad);
                frecuencia.add(1);
            }
        }

        for (int i = 0; i < Math.min(5, especialidades.size()); i++) {
            int indiceMaximaFrecuencia = 0;
            int maxFreq = frecuencia.get(0);

            for (int j = 1; j < especialidades.size(); j++) {
                if (frecuencia.get(j) > maxFreq) {
                    maxFreq = frecuencia.get(j);
                    indiceMaximaFrecuencia = j;
                }
            }

            topEspecialidades[i][0] = especialidades.get(indiceMaximaFrecuencia);
            String maximaFrecuencia = "" + maxFreq;
            topEspecialidades[i][1] = maximaFrecuencia;
            frecuencia.set(indiceMaximaFrecuencia, -1);

        }

    }

    //Matriz retornada para la grafica productos
    public static String[][] topProductos = new String[3][2];

    public static void contarProductos(ArrayList<Producto> productos) {
        // ArrayList para almacenar las nombres y sus frecuencias
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> cantidad = new ArrayList<>();

        for (Producto producto : productos) {

            nombres.add(producto.getNombre());
            cantidad.add(Integer.valueOf(producto.getCantidad()));
        }

        for (int i = 0; i < Math.min(3, nombres.size()); i++) {
            int indiceMaximaFrecuencia = 0;
            int maxFreq = cantidad.get(0);

            for (int j = 1; j < nombres.size(); j++) {
                if (cantidad.get(j) > maxFreq) {
                    maxFreq = cantidad.get(j);
                    indiceMaximaFrecuencia = j;
                }
            }

            topProductos[i][0] = nombres.get(indiceMaximaFrecuencia);
            String maximaFrecuencia = "" + maxFreq;
            topProductos[i][1] = maximaFrecuencia;
            cantidad.set(indiceMaximaFrecuencia, -1);

        }

    }

}
