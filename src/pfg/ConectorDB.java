package pfg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import servidorprueba.Comandos;
import servidorprueba.Grupo;
import servidorprueba.Lugar;
import servidorprueba.Mensaje;
import servidorprueba.Persona;
import servidorprueba.Prioridad;
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
    private static ObjectInputStream flujoEntrada;
    private static ObjectOutputStream flujoSalida;
    private static Socket s;

    /**
     * Constructor sin parametros.
     */
    public ConectorDB() {
    }

    /**
     * Manda al servidor la orden de obtener la lista del personal.
     *
     * @param num_grupo
     * @return lista con el personal
     */
    public static LinkedList BuscarPersonal(int num_grupo) {
        LinkedList listaPersonal = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.BUSCARMIEMBROSDELGRUPO, num_grupo);
            flujoSalida.writeObject(mensaje);
            listaPersonal = (LinkedList) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaPersonal;
    }

    /**
     * Manda al servidor la orden de obtener la lista del personal fuera de la
     * tarea de la que se manda la id.
     *
     * @param idTarea linkedlist con la id de la tarea.
     * @return
     */
    public static LinkedList BuscarPersonalFueraDeTarea(LinkedList idTarea) {
        LinkedList listaPersonal = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.USUARIOSFUERADETAREA, idTarea);
            flujoSalida.writeObject(mensaje);
            listaPersonal = (LinkedList) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaPersonal;
    }

    public static Boolean CrearTarea(Tarea tarea) {
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.CREARTAREA, tarea);
            flujoSalida.writeObject(mensaje);
            return flujoEntrada.readBoolean();
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
        }
        CerrarConexion();
        return false;
    }

    /**
     * Manda las los datos para la creacion de un nuevo usuario en la base de
     * datos
     *
     * @param datosNuevoEmpleado LinkedList con un objeto Persona.
     * @return
     */
    public static Persona CrearEmpleado(LinkedList<Persona> datosNuevoEmpleado) {
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.CREARUSUARIO, datosNuevoEmpleado);
            flujoSalida.writeObject(mensaje);
            return (Persona) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
            CerrarConexion();
        }
        return null;
    }

    public static LinkedList<Lugar> BuscarLugaresDeUsuario(int grupo) {
        LinkedList<Lugar> listalugares = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.BUSCARLUGARES, grupo);
            flujoSalida.writeObject(mensaje);
            listalugares = (LinkedList<Lugar>) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        CerrarConexion();
        return listalugares;
    }

    public static LinkedList<Prioridad> BuscarPrioridades() {
        LinkedList<Prioridad> listaPrioridades = new LinkedList<>();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.BUSCARPRIORIDAD);
            flujoSalida.writeObject(mensaje);
            listaPrioridades = (LinkedList<Prioridad>) flujoEntrada.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println(ex.getMessage());
        }
        return listaPrioridades;
    }

    /**
     * Manda las credenciales para el login al servidor.
     *
     * @param credenciales
     * @return
     */
    public static Persona Login(LinkedList credenciales) {
        Persona p = new Persona("1", "1", true);
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.LOGIN, credenciales);
            flujoSalida.writeObject(mensaje);
            p = (Persona) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return p;
    }

    /**
     * Manda al servidor la orden de obtener la lista de tareas guardadas.
     *
     * @return Lista con las tareas.
     */
    public static LinkedList<Tarea> BuscarTareasGuardadas() {
        LinkedList listaTareas = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.TAREASGUARDADAS);
            flujoSalida.writeObject(mensaje);
            listaTareas = (LinkedList) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaTareas;
    }

    /**
     * Manda al servidor la orden de obtener la lista de grupos.
     *
     * @return Lista con las tareas.
     */
    public static LinkedList<Grupo> BuscarGrupos() {
        LinkedList listaLugares = new LinkedList();
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.BUSCARGRUPOS);
            flujoSalida.writeObject(mensaje);
            listaLugares = (LinkedList) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        CerrarConexion();
        return listaLugares;
    }

    /**
     * manda al servidor la orden de obtener la lista de tareas para un dia en
     * especifico.
     *
     * @param fecha dia especifico del que se quiere obtener las tareas.
     * @return
     */
    public static LinkedList<Tarea> BuscarTareas(String fecha) {
        LinkedList listaTareas = new LinkedList();
        LinkedList dia = new LinkedList();
        dia.add(fecha);
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.TAREASDELDIA, dia);
            flujoSalida.writeObject(mensaje);
            listaTareas = (LinkedList) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        CerrarConexion();
        return listaTareas;
    }

    public static Tarea BuscarTareaPorId(Tarea tarea) {
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.BUSCARTAREAPORID, tarea);
            flujoSalida.writeObject(mensaje);
            return (Tarea) flujoEntrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        CerrarConexion();
        return null;
    }

    public static boolean ActualizarPersonal(Persona persona) {
        LinkedList listapersona = new LinkedList();
        listapersona.add(persona);
        boolean actualizado = false;
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.ACTUALIZARPERSONAL, listapersona);
            flujoSalida.writeObject(mensaje);
            actualizado = flujoEntrada.readBoolean();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            CerrarConexion();
        }
        CerrarConexion();
        return actualizado;
    }

    /**
     *
     * @param persona
     * @return
     */
    public static boolean EliminarPersonal(Persona persona) {
        LinkedList listapersona = new LinkedList();
        listapersona.add(persona);
        boolean eliminado = false;
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.ELIMINARPERSONAL, listapersona);
            flujoSalida.writeObject(mensaje);
            eliminado = flujoEntrada.readBoolean();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return eliminado;
    }

    /**
     *
     * @param tarea
     * @return
     */
    public static boolean ActualizarTarea(Tarea tarea) {
        Conectar();
        boolean actualizada = false;
        try {
            Mensaje mensaje = new Mensaje(Comandos.ACTUALIZARTAREA, tarea);
            flujoSalida.writeObject(mensaje);
            actualizada = flujoEntrada.readBoolean();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return actualizada;
    }

    /**
     *
     * @param persona
     * @param tarea
     * @return
     */
    public static boolean AñadirPersonalATarea(Persona persona, Tarea tarea) {
        boolean añadido = false;
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.AÑADIRPERSONALATAREA, persona, tarea);
            flujoSalida.writeObject(mensaje);
            añadido = flujoEntrada.readBoolean();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return añadido;
    }

    /**
     *
     * @param persona
     * @param tarea
     * @return
     */
    public static boolean EliminarPersonalDeTarea(Persona persona, Tarea tarea) {
        boolean eliminado = false;
        Conectar();
        try {
            Mensaje mensaje = new Mensaje(Comandos.ELIMINARPERSONALDETAREA, persona, tarea);
            flujoSalida.writeObject(mensaje);
            eliminado = flujoEntrada.readBoolean();
            return eliminado;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return eliminado;
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
