package pfg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.JOptionPane;
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

    private static final int PUERTO = 6565;
    private static ObjectInputStream flujoEntrada;
    private static ObjectOutputStream flujoSalida;
    private static Socket socket;

    /**
     * Constructor sin parametros.
     */
    public ConectorDB() {
    }

    /**
     * Manda al servidor la orden de obtener la lista del personal
     * correspondiente a un grupo.
     *
     * @param num_grupo número del grupo a buscar el personal
     * @return una lista con el personal del grupo
     */
    public static LinkedList BuscarPersonal(int num_grupo) {
        LinkedList listaPersonal = new LinkedList();
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARMIEMBROSDELGRUPO, num_grupo);
                flujoSalida.writeObject(mensaje);
                listaPersonal = (LinkedList) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.getMessage();
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return listaPersonal;
    }

    /**
     * Manda al servidor la orden de obtener la lista del personal fuera de la
     * tarea de la que se manda la id.
     *
     * @param idTarea LinkedList con la ID de la tarea.
     * @return Lista del personal fuera de la tarea.
     */
    public static LinkedList BuscarPersonalFueraDeTarea(LinkedList<Integer> idTarea) {
        LinkedList listaPersonal = new LinkedList();
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.PERSONASFUERADETAREA, idTarea);
                flujoSalida.writeObject(mensaje);
                listaPersonal = (LinkedList) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.getMessage();
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return listaPersonal;
    }

    /**
     * Crea una nueva tarea en la base de datos del servidor.
     *
     * @param tarea La tarea a ser creada.
     * @return true si la tarea fue creada con éxito, false en caso contrario.
     */
    public static Boolean CrearTarea(Tarea tarea) {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.CREARTAREA, tarea);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.print(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     * Envía los datos necesarios para crear un nuevo empleado en la base de
     * datos.
     *
     * @param NuevoEmpleado Objeto persona con los datos del nuevo usuario.
     * @return el objeto Persona creado en la base de datos, o null si ocurrió
     * un error.
     */
    public static boolean CrearEmpleado(Persona NuevoEmpleado) {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.CREARUSUARIO, NuevoEmpleado);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                ex.getMessage();
                CerrarConexion();
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     *
     * Busca los lugares asociados a un grupo en particular.
     *
     * @param grupo el identificador del grupo cuyos lugares se desean buscar.
     * @return una lista enlazada con los lugares encontrados.
     */
    public static LinkedList<Lugar> BuscarLugaresDeUsuario(int grupo) {
        LinkedList<Lugar> listalugares = new LinkedList();
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARLUGARESDELUSUARIO, grupo);
                flujoSalida.writeObject(mensaje);
                listalugares = (LinkedList<Lugar>) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return listalugares;
    }

    /**
     * Manda al servidor la orden de obtener la lista de prioridades existentes
     * en la base de datos.
     *
     * @return LinkedList con las prioridades encontradas.
     */
    public static LinkedList<Prioridad> BuscarPrioridades() {
        LinkedList<Prioridad> listaPrioridades = new LinkedList();
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARPRIORIDAD);
                flujoSalida.writeObject(mensaje);
                listaPrioridades = (LinkedList<Prioridad>) flujoEntrada.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return listaPrioridades;
    }

    /**
     * Actualiza la asociación entre un lugar y un grupo en la base de datos del
     * servidor.
     *
     * @param idLugar El ID del lugar a asociar con el grupo.
     * @param idGrupo El ID del grupo al que se quiere asociar el lugar.
     * @return true si el proceso se completa con exito, false en caso
     * contrario.
     */
    public static boolean ActualizarGrupoLugares(int idLugar, int idGrupo) {

        LinkedList<Integer> argumentos = new LinkedList<>();
        argumentos.add(idGrupo);
        argumentos.add(idLugar);
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.CREARGRUPOLUGAR, argumentos);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     * Envía al servidor la orden de eliminar todos los lugares asociados a un
     * grupo.
     *
     * @param idGrupo el id del grupo del que se eliminarán los lugares.
     * @return true si se eliminaron los lugares correctamente, false en caso
     * contrario.
     */
    public static boolean EliminarLugaresParaUnGrupo(int idGrupo) {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARLUGARESPARAUNGRUPO, idGrupo);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     * Manda al servidor la orden de eliminar todas las tareas de un grupo en
     * particular.
     *
     * @param idGrupo id del grupo.
     * @return true si la operación de eliminar las tareas del grupo fue
     * exitosa, false en caso contrario.
     */
    public static boolean EliminarTareasDelGrupo(int idGrupo) {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARTODASLASTAREASDEGRUPO, idGrupo);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     * Envía las credenciales para iniciar sesión al servidor.
     *
     * @param credenciales Una lista enlazada que contiene las credenciales del
     * usuario.
     * @return Un objeto Persona que representa al usuario que inició sesión.
     */
    public static Persona Login(LinkedList credenciales) {
        Persona p = new Persona("1", "1", true);
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.LOGIN, credenciales);
                flujoSalida.writeObject(mensaje);
                p = (Persona) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.getMessage();
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return p;
    }

    /**
     * Envía una solicitud al servidor para obtener la lista de tareas
     * guardadas.
     *
     * @param num_grupo grupo al que corresponden las tareas.
     * @return Lista enlazada con las tareas guardadas.
     */
    public static LinkedList<Tarea> BuscarTareasGuardadas(int num_grupo) {
        LinkedList listaTareas = new LinkedList();
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.TAREASGUARDADAS, num_grupo);
                flujoSalida.writeObject(mensaje);
                listaTareas = (LinkedList) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.getMessage();
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return listaTareas;
    }

    /**
     * Crea un nuevo grupo en la base de datos.
     *
     * @param nombreGrupo El nombre del nuevo grupo.
     * @return true si el grupo se ha creado correctamente, false si no.
     */
    public static boolean CrearGrupo(String nombreGrupo) {
        if (Conectar()) {
            LinkedList<String> argumentos = new LinkedList<>();
            argumentos.add(nombreGrupo);
            try {
                Mensaje mensaje = new Mensaje(Comandos.CREARGRUPO, argumentos);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     * Busca si existen usuarios en un grupo que no sean administradores.
     *
     * @param grupoid ID del grupo a buscar.
     * @return true si existen usuarios en el grupo que no sean administradores,
     * false en caso contrario.
     */
    public static boolean BuscarUsuariosEnGrupoNoAdmin(int grupoid) {
        if (Conectar()) {
            LinkedList<Integer> argumentos = new LinkedList<>();
            argumentos.add(grupoid);
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARMIEMBROSDELGRUPONOADMIN, argumentos);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return true;
    }

    /**
     * Envía un mensaje al servidor para eliminar un grupo de la base de datos.
     *
     * @param grupoid ID del grupo a eliminar.
     * @return true si el grupo fue eliminado correctamente, false en caso
     * contrario.
     */
    public static boolean EliminarGrupo(int grupoid) {
        if (Conectar()) {
            LinkedList<Integer> argumentos = new LinkedList<>();
            argumentos.add(grupoid);
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARGRUPO, argumentos);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return true;
    }

    /**
     * Elimina todos los administradores de un grupo en particular.
     *
     * @param grupoid identificador del grupo.
     * @return true si se eliminaron todos los administradores, false en caso
     * contrario.
     */
    public static boolean EliminarAdminsDeGrupo(int grupoid) {
        if (Conectar()) {
            LinkedList<Integer> argumentos = new LinkedList<>();
            argumentos.add(grupoid);
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARADMINSDEGRUPO, argumentos);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        CerrarConexion();
        return true;
    }

    /**
     * Busca en la base de datos si existe algun resultado en la tabla
     * grupo_lugar, para el grupo id usado como parametro.
     *
     * @param grupoid id del grupo que se desea buscar.
     * @return true si encuantra algun resultado, false si no encuentra nada.
     */
    public static boolean BuscarLugaresParaUnGrupo(int grupoid) {
        if (Conectar()) {
            LinkedList<Integer> argumentos = new LinkedList<>();
            argumentos.add(grupoid);
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARLUGARESPARAUNGRUPO, argumentos);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        CerrarConexion();
        return true;
    }

    /**
     * Manda al servidor la orden de obtener la lista de grupos.
     *
     * @return Lista con los grupos.
     */
    public static LinkedList<Grupo> BuscarGrupos() {
        LinkedList listaGrupos = new LinkedList();
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARGRUPOS);
                flujoSalida.writeObject(mensaje);
                listaGrupos = (LinkedList) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.getMessage();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        CerrarConexion();
        return listaGrupos;
    }

    /**
     * Crea un nuevo lugar en la base de datos.
     *
     * @param lugar nuevo lugar a crear.
     * @return true si se crea un nuevo lugar, false en caso contrario.
     */
    public static boolean CrearNuevoLugar(Lugar lugar) {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.CREARLUGAR, lugar);
                flujoSalida.writeObject(mensaje);
                return flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return false;
    }

    /**
     * Busca los lugares guardados en la base de datos y los devuelve en una
     * lista.
     *
     * @return Una lista de objetos Lugar.
     */
    public static LinkedList<Lugar> BuscarLugares() {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARLUGARES);
                flujoSalida.writeObject(mensaje);
                return (LinkedList<Lugar>) flujoEntrada.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return null;
    }

    /**
     * Manda al servidor la orden de obtener la lista de tareas para un dia en
     * especifico.
     *
     * @param fecha día específico del que se quiere obtener las tareas. Debe
     * estar en formato "yyyy-MM-dd".
     * @param idgrupo id del grupo del usuario.
     * @return Lista de objetos Tarea correspondientes al día especificado.
     */
    public static LinkedList<Tarea> BuscarTareas(String fecha, int idgrupo) {
        LinkedList listaTareas = new LinkedList();
        LinkedList dia = new LinkedList();
        dia.add(fecha);
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.TAREASDELDIA, dia, idgrupo);
                flujoSalida.writeObject(mensaje);
                listaTareas = (LinkedList) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return listaTareas;
    }

    /**
     * Busca una tarea por su ID en la base de datos.
     *
     * @param tarea la tarea que se desea buscar.
     * @return la tarea encontrada o null si no se encontró.
     */
    public static Tarea BuscarTareaPorId(Tarea tarea) {
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.BUSCARTAREAPORID, tarea);
                flujoSalida.writeObject(mensaje);
                return (Tarea) flujoEntrada.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return null;
    }

    /**
     * Envía al servidor la orden de actualizar la información de una persona en
     * la base de datos.
     *
     * @param persona Objeto Persona que contiene la información a actualizar.
     * @return true si la información fue actualizada con éxito, false en caso
     * contrario.
     */
    public static boolean ActualizarPersonal(Persona persona) {
        LinkedList listapersona = new LinkedList();
        listapersona.add(persona);
        boolean actualizado = false;
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ACTUALIZARPERSONAL, listapersona);
                flujoSalida.writeObject(mensaje);
                actualizado = flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                CerrarConexion();
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return actualizado;
    }

    /**
     * Método para eliminar a una persona del sistema.
     *
     * @param persona la persona que se desea eliminar.
     * @return true si la persona fue eliminada correctamente, false si ocurrió
     * algún error.
     */
    public static boolean EliminarPersonal(Persona persona) {
        boolean eliminado = false;
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARPERSONAL, persona);
                flujoSalida.writeObject(mensaje);
                eliminado = flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return eliminado;
    }

    /**
     * Actualiza una tarea en el servidor.
     *
     * @param tarea la tarea a actualizar
     * @return true si la tarea se actualizó correctamente, false en caso
     * contrario
     */
    public static boolean ActualizarTarea(Tarea tarea) {
        boolean actualizada = false;
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ACTUALIZARTAREA, tarea);
                flujoSalida.writeObject(mensaje);
                actualizada = flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return actualizada;
    }

    /**
     * Añade una persona a una tarea especificada.
     *
     * @param persona La persona que se desea añadir a la tarea.
     * @param tarea La tarea a la que se desea añadir la persona.
     * @return true si la persona fue añadida exitosamente a la tarea, false en
     * caso contrario.
     */
    public static boolean AñadirPersonalATarea(Persona persona, Tarea tarea) {
        boolean añadido = false;
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.AÑADIRPERSONALATAREA, persona, tarea);
                flujoSalida.writeObject(mensaje);
                añadido = flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return añadido;
    }

    /**
     * Envía un mensaje al servidor para eliminar una persona de una tarea
     * específica.
     *
     * @param persona Persona a eliminar de la tarea.
     * @param tarea Tarea de la que se eliminará a la persona.
     * @return true si la persona fue eliminada de la tarea exitosamente, false
     * en caso contrario.
     */
    public static boolean EliminarPersonalDeTarea(Persona persona, Tarea tarea) {
        boolean eliminado = false;
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARPERSONALDETAREA, persona, tarea);
                flujoSalida.writeObject(mensaje);
                eliminado = flujoEntrada.readBoolean();
                return eliminado;
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return eliminado;
    }

    /**
     * Envia una solicitud al servidor para eliminar la tarea especificada y
     * devuelve un booleano que indica si la tarea fue eliminada correctamente.
     *
     * @param tarea la tarea a eliminar del servidor.
     * @return true si la tarea fue eliminada correctamente, false de lo
     * contrario.
     */
    public static boolean EliminarTarea(Tarea tarea) {
        boolean eliminado = false;
        if (Conectar()) {
            try {
                Mensaje mensaje = new Mensaje(Comandos.ELIMINARTAREA, tarea);
                flujoSalida.writeObject(mensaje);
                eliminado = flujoEntrada.readBoolean();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            CerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Ip de servidor no valida.\nPor favor introduzca una correcta en el submenu 'Servidor'.");
        }
        return eliminado;
    }

    /**
     * Abre la conexion con el servidor.
     *
     * @return si la conexion es correcta true, de lo contrario false.
     */
    private static boolean Conectar() {
        try {
            if (ControladorIP.validarIP(ControladorIP.TomarIp())) {
                socket = new Socket(ControladorIP.TomarIp(), PUERTO);
                flujoEntrada = new ObjectInputStream(socket.getInputStream());
                flujoSalida = new ObjectOutputStream(socket.getOutputStream());
            } else {
                return false;
            }
        } catch (IOException ex) {
            System.err.println("Error al conectar con el servidor: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
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
