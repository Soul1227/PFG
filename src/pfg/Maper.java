package pfg;

import java.util.HashMap;
import java.util.LinkedList;
import servidorprueba.Grupo;
import servidorprueba.Lugar;
import servidorprueba.Prioridad;

/**
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
        if(this.listaGrupos==null){
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
     *
     * @param listaLugares
     * @return
     */
    public HashMap CrearMapaLugares(LinkedList<Lugar> listaLugares) {
        HashMap<String, Integer> mapaLugaresActualizado = new HashMap();
        listaLugares.forEach((lugar) -> {
            mapaLugaresActualizado.put(lugar.getNombre(), lugar.getId());
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
        listaPrioridades.forEach((prioridad) -> {
            mapaPrioridadesActualizado.put(prioridad.getNombre(), prioridad.getId());
        });
        return mapaPrioridadesActualizado;
    }
    
    public HashMap CrearMapaGrupos(LinkedList<Grupo> listaGrupos){
        HashMap<String, Integer> mapaGruposActualizado = new HashMap<>();
        listaGrupos.forEach((grupo)->{
            mapaGruposActualizado.put(grupo.getGrupoNombre(), grupo.getGrupoId());
        });
        return mapaGruposActualizado;
    }
    /**
     * 
     * @param listaPrioridades 
     */
    public void ActualizarMapaPrioridades(LinkedList<Prioridad> listaPrioridades){
        setListaPrioridades(listaPrioridades);
        setMapaPrioridades(CrearMapaPrioridades(listaPrioridades));
    }
    /**
     * 
     * @param listaLugares 
     */
    public void ActualizarMapaLugares(LinkedList<Lugar> listaLugares){
        setListaLugares(listaLugares);
        setMapaLugares(CrearMapaLugares(listaLugares));
    }
    
    public void ActualizarMapaGrupos (LinkedList<Grupo> listaGrupos){
        setListaGrupos(listaGrupos);
        setMapaGrupos(CrearMapaGrupos(listaGrupos));
    } 
}
