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
    static int codigoDoctores = 202420000;
    static int codigoPacientes = 202430000;
    static int codigoProductos = 202440000;
    static int tipoUsuario = 0; //Predeterminado = 0, Admin = 1, Doctor = 2 , Paciente = 3
    static int indiceUsuario = 0; //Se determina al loguear

    static int seSeleccionoEspecialidad = 0;
    static int seSeleccionoDoctor = 0;
    static int seSeleccionoFecha = 0;
    static String doctorSeleccionado = "0";
    static String fechaSeleccionada = "0";
    static String motivoCita = "0";
    static String horarioSeleccionado = "0";
    static int indiceDoctorSeleccionado = -1;
    static int indiceFechaSeleccionada = -1;
    static int indiceHorarioSeleccionado = -1;

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

    //Vector utilizado para que el paciente vea las especialidades disponibles
    public static String[] vectorEspecialidades;

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

        //Llena el vector Especialidades
        int n = especialidades.size();
        vectorEspecialidades = new String[1 + n];
        vectorEspecialidades[0] = "Seleccionar";
        for (int i = 0; i < especialidades.size(); i++) {
            vectorEspecialidades[i + 1] = especialidades.get(i);
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

    //Vector con médicos que tienen la especialidad seleccionada
    public static String[] doctoresEspSelect;
    //public static String especialidadSeleccionada;
    public static String especialidadSeleccionada;

    public static void doctoresPorEspecialidad() {
        ArrayList<String> arrayDoctoresEspSelect = new ArrayList<>();
        for (int i = 0; i < doctores.size(); i++) {
            if (doctores.get(i).getEspecialidad().equals(especialidadSeleccionada)) {
                arrayDoctoresEspSelect.add(doctores.get(i).getApellidos() + ", " + doctores.get(i).getNombres());
            }
        }

        doctoresEspSelect = new String[arrayDoctoresEspSelect.size() + 1];
        doctoresEspSelect[0] = "Seleccionar";
        for (int i = 0; i < arrayDoctoresEspSelect.size(); i++) {
            doctoresEspSelect[i + 1] = arrayDoctoresEspSelect.get(i);
        }

        for (int i = 0; i < doctoresEspSelect.length; i++) {
            System.out.println(doctoresEspSelect[i]);
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

    //Añadir nueva fecha disponible por un doctor
    public static void addFecha(Fecha fecha) {
        boolean existenciaFecha = false;
        for (int i = 0; i < doctores.get(indiceUsuario).getFechasDisponibles().size(); i++) {
            if (doctores.get(indiceUsuario).getFechasDisponibles().get(i).getDia().equals(fecha.getDia())) {
                existenciaFecha = true;
            }
            if (existenciaFecha) {
                break;
            }
        }

        if (!existenciaFecha) {
            doctores.get(indiceUsuario).getFechasDisponibles().add(fecha);
        }

    }

    //Añadir un nuevo horario disponible por un doctor
    public static boolean addHorario(String horaHabil, Fecha fecha) {
        boolean existenciaHorario = false;
        int indiceFecha = 0;
        for (int i = 0; i < doctores.get(indiceUsuario).getFechasDisponibles().size(); i++) {
            if (doctores.get(indiceUsuario).getFechasDisponibles().get(i).getDia().equals(fecha.getDia())) {
                indiceFecha = i;
            }
        }

        System.out.println("indice de fecha es : " + indiceFecha);

        for (int i = 0; i < doctores.get(indiceUsuario).getFechasDisponibles().get(indiceFecha).getHorario().size(); i++) {
            if (doctores.get(indiceUsuario).getFechasDisponibles().get(indiceFecha).getHorario().get(i).equals(horaHabil)) {
                existenciaHorario = true;
                return false;
            }
        }

        if (!existenciaHorario) {
            doctores.get(indiceUsuario).getFechasDisponibles().get(indiceFecha).getHorario().add(horaHabil);
        }
        return true;
    }

    public static Object[][] convertirFechasDisponibles() {
        int filas = 0;
        for (int i = 0; i < doctores.get(indiceUsuario).getFechasDisponibles().size(); i++) {
            for (String horario : doctores.get(indiceUsuario).getFechasDisponibles().get(i).getHorario()) {
                filas = filas + 1;
            }
        }

        Object[][] arregloFechasDisponibles = new String[filas][3];
        int indiceArreglo = 0;

        for (int i = 0; i < doctores.get(indiceUsuario).getFechasDisponibles().size(); i++) {
            for (int j = 0; j < doctores.get(indiceUsuario).getFechasDisponibles().get(i).getHorario().size(); j++) {
                int numeracion = indiceArreglo + 1;
                String stringNumeración = "" + numeracion;

                arregloFechasDisponibles[indiceArreglo][0] = stringNumeración;
                arregloFechasDisponibles[indiceArreglo][1] = doctores.get(indiceUsuario).getFechasDisponibles().get(i).getDia();
                arregloFechasDisponibles[indiceArreglo][2] = doctores.get(indiceUsuario).getFechasDisponibles().get(i).getHorario().get(j);
                indiceArreglo++;

            }
        }

        return arregloFechasDisponibles;
    }

    public static void buscarDoctorSeleccionado(String nombre, String apellido) {
        for (int i = 0; i < doctores.size(); i++) {

            if (doctores.get(i).getNombres().equals(nombre) && doctores.get(i).getApellidos().equals(apellido)) {
                indiceDoctorSeleccionado = i;
            }
        }
    }

    public static String[] listadoFechas;

    public static void fechasDoctor() {
        listadoFechas = new String[doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().size() + 1];
        int numeroFechas = doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().size();
        listadoFechas[0] = "Seleccionar";
        for (int i = 0; i < numeroFechas; i++) {
            listadoFechas[i + 1] = doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(i).getDia();
        }
    }

    public static void buscarFechaSeleccionada(String fecha) {
        for (int i = 0; i < doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().size(); i++) {

            if (doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(i).getDia().equals(fecha)) {
                indiceFechaSeleccionada = i;
            }
        }
    }

    public static String[] listadoHorarios;

    public static void horariosDoctor() {
        listadoHorarios = new String[doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(indiceFechaSeleccionada).getHorario().size() + 1];
        int numeroHorarios = doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(indiceFechaSeleccionada).getHorario().size();
        listadoHorarios[0] = "Seleccionar";
        for (int i = 0; i < numeroHorarios; i++) {
            listadoHorarios[i + 1] = doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(indiceFechaSeleccionada).getHorario().get(i);
        }
    }

    //Ubica el índice del horario seleccionado por el paciente en los horarios de un doctor
    public static void buscarHorarioSeleccionado(String horario) {
        for (int i = 0; i < doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(indiceFechaSeleccionada).getHorario().size(); i++) {

            if (doctores.get(indiceDoctorSeleccionado).getFechasDisponibles().get(indiceFechaSeleccionada).getHorario().get(i).equals(horario)) {
                indiceHorarioSeleccionado = i;
            }
        }
    }

    //Genera una tabla para mostrar al paciente su historial de citas
    public static Object[][] historialCitas() {
        int filas = pacientes.get(indiceUsuario).getCitas().size();

        Object[][] arregloHistorialCitas = new String[filas][4];
        int indiceArreglo = 0;

        for (int i = 0; i < pacientes.get(indiceUsuario).getCitas().size(); i++) {
            int numeracion = indiceArreglo + 1;
            String stringNumeración = "" + numeracion;

            arregloHistorialCitas[indiceArreglo][0] = stringNumeración;
            arregloHistorialCitas[indiceArreglo][1] = pacientes.get(indiceUsuario).getCitas().get(i).getEstado();
            arregloHistorialCitas[indiceArreglo][2] = pacientes.get(indiceUsuario).getCitas().get(i).getFecha();
            arregloHistorialCitas[indiceArreglo][3] = pacientes.get(indiceUsuario).getCitas().get(i).getHorario();
            indiceArreglo++;

        }
        return arregloHistorialCitas;
    }

    //Añadir nueva cita al historial de citas de un paciente
    public static void addCita(Cita cita) {
        pacientes.get(indiceUsuario).getCitas().add(cita);
    }

}
