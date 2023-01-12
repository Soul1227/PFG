package pfg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import servidorprueba.Comandos;
import servidorprueba.Mensaje;
import servidorprueba.Persona;

/**
 * Clase encargada de hacer la conexion con la base de datos y llevar a cabo las
 * peticiones.
 *
 * @author angel
 */
public class ConectorDB {

    private static final String SERVERIP = "192.168.0.12";
    private static final int PUERTO = 6565;
    private static ObjectInputStream flujoEntrada;
    private static ObjectOutputStream flujoSalida;
    private static Socket s;

    public ConectorDB() {
    }

    public static LinkedList BuscarPersonal() {
        LinkedList listaPersonal = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.PERSONAL);
            flujoSalida.writeObject(mensaje);
            s.setSoTimeout(3000);
            listaPersonal = (LinkedList) flujoEntrada.readObject();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaPersonal;
    }

    public static Persona Login(LinkedList credenciales){
        Persona p = new Persona("1", "1", true);
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.LOGIN, credenciales);
            flujoSalida.writeObject(mensaje);
            s.setSoTimeout(3000);
            p = (Persona) flujoEntrada.readObject();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return p;
    }

    private static void Conectar() {
        try {
            s = new Socket(SERVERIP, PUERTO);
            flujoEntrada = new ObjectInputStream(s.getInputStream());
            flujoSalida = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

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
