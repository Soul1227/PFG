package pfg;

import java.util.HashMap;
import java.util.LinkedList;
import servidorprueba.Lugar;
import servidorprueba.Prioridad;

/**
 *
 * @author angel
 */
public class Maper {

    int grupoUsuario;
    private HashMap<String, Integer> mapaPrioridades;
    private HashMap<String, Integer> mapaLugares;
    private LinkedList<Prioridad> listaPrioridades;
    private LinkedList<Lugar> listaLugares;

    public Maper(int grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
        listaLugares = ConectorDB.BuscarLugaresDeUsuario(grupoUsuario);
        listaPrioridades = ConectorDB.BuscarPrioridades();
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
        if (listaPrioridades == null) {
            this.listaPrioridades = new LinkedList<>();
        }
        this.listaPrioridades = listaPrioridades;
    }

    public LinkedList<Lugar> getListaLugares() {
        return listaLugares;
    }

    public void setListaLugares(LinkedList<Lugar> listaLugares) {
        if (listaLugares == null) {
            this.listaLugares = new LinkedList<>();
        }
        this.listaLugares = listaLugares;
    }

    /**
     *
     * @param listaLugares
     * @return
     */
    public HashMap CrearMapaLugares(LinkedList<Lugar> listaLugares) {
        HashMap<String, Integer> mapaLugaresActualizado = new HashMap();
        listaLugares.forEach((l) -> {
            mapaLugaresActualizado.put(l.getNombre(), l.getId());
        });
        return mapaLugaresActualizado;
    }

    /**
     *
     * @param listaPrioridades
     * @return
     */
    public HashMap CrearMapaPrioridades(LinkedList<Prioridad> listaPrioridades) {
        HashMap<String, Integer> mapaPrioridadesActualizado = new HashMap();
        listaPrioridades.forEach((p) -> {
            mapaPrioridadesActualizado.put(p.getNombre(), p.getId());
        });
        return mapaPrioridadesActualizado;
    }
    /**
     * 
     * @param listaPrioridades 
     */
    public void ActualizarMapaPrioridades(LinkedList<Prioridad> listaPrioridades){
        setMapaPrioridades(CrearMapaPrioridades(listaPrioridades));
    }
    /**
     * 
     * @param listaLugares 
     */
    public void ActualizarMapaLugares(LinkedList<Lugar> listaLugares){
        setMapaLugares(CrearMapaLugares(listaLugares));
    }
}
