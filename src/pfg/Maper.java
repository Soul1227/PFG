package pfg;

import java.util.HashMap;
import java.util.LinkedList;
import servidorprueba.Grupo;
import servidorprueba.Lugar;
import servidorprueba.Prioridad;

/**
 *
 * La clase Maper es una herramienta para gestionar una serie de listas y mapas,
 * de grupos, prioridades y lugares.
 *
 * @author angel
 */
public final class Maper {

    int grupoUsuario;
    private HashMap<String, Integer> mapaPrioridades;
    private HashMap<String, Integer> mapaLugares;
    private HashMap<String, Integer> mapaGrupos;
    private LinkedList<Grupo> listaGrupos;
    private LinkedList<Prioridad> listaPrioridades;
    private LinkedList<Lugar> listaLugares;

    /**
     * Constructor de la clase con el grupo del usuario.
     *
     * @param grupoUsuario id del grupo al que pertenece el usuario.
     */
    public Maper(int grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public HashMap getMapaPrioridades() {
        return mapaPrioridades;
    }

    public void setMapaPrioridades(HashMap mapaPrioridades) {
        this.mapaPrioridades = mapaPrioridades;
    }

    public HashMap getMapaLugares() {
        return mapaLugares;
    }

    public void setMapaLugares(HashMap mapaLugares) {
        this.mapaLugares = mapaLugares;
    }

    public LinkedList<Prioridad> getListaPrioridades() {
        return listaPrioridades;
    }

    public void setListaPrioridades(LinkedList<Prioridad> listaPrioridades) {
        if (this.listaPrioridades == null) {
            this.listaPrioridades = new LinkedList<>();
        }
        this.listaPrioridades = listaPrioridades;
    }

    public HashMap<String, Integer> getMapaGrupos() {
        return mapaGrupos;
    }

    public void setMapaGrupos(HashMap<String, Integer> mapaGrupos) {
        this.mapaGrupos = mapaGrupos;
    }

    public LinkedList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(LinkedList<Grupo> listaGrupos) {
        if (this.listaGrupos == null) {
            this.listaGrupos = new LinkedList<>();
        }
        this.listaGrupos = listaGrupos;
    }

    public LinkedList<Lugar> getListaLugares() {
        return listaLugares;
    }

    public void setListaLugares(LinkedList<Lugar> listaLugares) {
        if (this.listaLugares == null) {
            this.listaLugares = new LinkedList<>();
        }
        this.listaLugares = listaLugares;
    }

    /**
     * Este método crea un mapa de lugares actualizado a partir de una lista de
     * lugares dada. Asigna a cada lugar su respectivo ID y lo agrega al mapa.
     *
     * @param listaLugares una lista de lugares que se utilizará para crear el
     * mapa
     * @return un objeto de tipo HashMap que contiene los nombres de los lugares
     * como clave y sus IDs como valor
     */
    public HashMap CrearMapaLugares(LinkedList<Lugar> listaLugares) {
        HashMap<String, Integer> mapaLugaresActualizado = new HashMap();
        listaLugares.forEach((lugar) -> {
            mapaLugaresActualizado.put(lugar.getNombre(), lugar.getId());
        });
        return mapaLugaresActualizado;
    }

    /**
     * Este método crea un mapa de Prioridades actualizado a partir de una lista
     * de prioridades dada. Asigna a cada prioridad su respectivo ID y lo agrega
     * al mapa.
     *
     * @param listaPrioridades una lista de prioridades que se utilizará para
     * crear el mapa
     * @return un objeto de tipo HashMap que contiene los nombres de las
     * prioridades como clave y sus IDs como valor
     */
    public HashMap CrearMapaPrioridades(LinkedList<Prioridad> listaPrioridades) {
        HashMap<String, Integer> mapaPrioridadesActualizado = new HashMap();
        listaPrioridades.forEach((prioridad) -> {
            mapaPrioridadesActualizado.put(prioridad.getNombre(), prioridad.getId());
        });
        return mapaPrioridadesActualizado;
    }

    /**
     * Este método crea un mapa de Grupos actualizado a partir de una lista de
     * grupos dada. Asigna a cada grupo su respectivo ID y lo agrega al mapa.
     *
     * @param listaGrupos una lista de grupos que se utilizará para crear el
     * mapa
     * @return un objeto de tipo HashMap que contiene los nombres de los grupos
     * como clave y sus IDs como valor
     */
    public HashMap CrearMapaGrupos(LinkedList<Grupo> listaGrupos) {
        HashMap<String, Integer> mapaGruposActualizado = new HashMap<>();
        listaGrupos.forEach((grupo) -> {
            mapaGruposActualizado.put(grupo.getGrupoNombre(), grupo.getGrupoId());
        });
        return mapaGruposActualizado;
    }

    /**
     * Actualiza el mapa de prioridades con la lista de prioridades especificada
     *
     * @param listaPrioridades La lista de prioridades actualizada
     */
    public void ActualizarMapaPrioridades(LinkedList<Prioridad> listaPrioridades) {
        setListaPrioridades(listaPrioridades);
        setMapaPrioridades(CrearMapaPrioridades(listaPrioridades));
    }

    /**
     * Actualiza el mapa de lugares con la lista de lugares especificada
     *
     * @param listaLugares La lista de lugares actualizada
     */
    public void ActualizarMapaLugares(LinkedList<Lugar> listaLugares) {
        setListaLugares(listaLugares);
        setMapaLugares(CrearMapaLugares(listaLugares));
    }

    /**
     * Actualiza el mapa de grupos con la lista de grupos especificada
     *
     * @param listaGrupos La lista de grupos actualizada
     */
    public void ActualizarMapaGrupos(LinkedList<Grupo> listaGrupos) {
        setListaGrupos(listaGrupos);
        setMapaGrupos(CrearMapaGrupos(listaGrupos));
    }
}
