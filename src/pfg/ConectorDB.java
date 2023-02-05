package pfg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import servidorprueba.Comandos;
import servidorprueba.Mensaje;
import servidorprueba.Persona;
import servidorprueba.Tarea;

/**
 * Clase encargada de hacer la conexion con la base de datos y llevar a cabo las
 * peticiones.
 *
 * @author angel
 */
public class ConectorDB {

    private static final String SERVERIP = "192.168.0.12";
    private static final int PUERTO = 6565;
    private final int TIMER = 6000;
    private static ObjectInputStream flujoEntrada;
    private static ObjectOutputStream flujoSalida;
    private static Socket s;

    public ConectorDB() {
    }
/**
 * Manda al servidor la orden de obtener la lista del personal.
 * @return lista con el personal
 */
    public static LinkedList BuscarPersonal() {
        LinkedList listaPersonal = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.PERSONAL);
            flujoSalida.writeObject(mensaje);
            s.setSoTimeout(10000);
            listaPersonal = (LinkedList) flujoEntrada.readObject();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaPersonal;
    }
    
    public static LinkedList BuscarLugaresDeUsuario(LinkedList grupo){
        LinkedList listalugares = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.LUGARES, grupo);
            flujoSalida.writeObject(mensaje);
            s.setSoTimeout(10000);
            listalugares = (LinkedList) flujoEntrada.readObject();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listalugares;
    }

    /**
     * Manda las credenciales para el login al servidor.
     * @param credenciales
     * @return 
     */
    public static Persona Login(LinkedList credenciales) {
        Persona p = new Persona("1", "1", true);
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.LOGIN, credenciales);
            flujoSalida.writeObject(mensaje);
            s.setSoTimeout(10000);
            p = (Persona) flujoEntrada.readObject();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return p;
    }
/**
 * Manda al servidor la orden de obtener la lista de tareas.
 * @return Lista con las tareas.
 */
    public static LinkedList<Tarea> BuscarTareas() {
        LinkedList listaTareas = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.TAREAS);
            flujoSalida.writeObject(mensaje);
            s.setSoTimeout(10000);
            listaTareas = (LinkedList) flujoEntrada.readObject();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaTareas;
    }
/**
 * Abre la conexion con el servidor.
 */
    private static void Conectar() {
        try {
            s = new Socket(SERVERIP, PUERTO);
            flujoEntrada = new ObjectInputStream(s.getInputStream());
            flujoSalida = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
/**
 * Cierra la conexion con el servidor.
 */
    private static void CerrarConexion() {
        if (flujoEntrada != null) {
            try {
                flujoEntrada.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        if (flujoSalida != null) {
            try {
                flujoSalida.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }
}
