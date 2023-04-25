package pfg.paneles;

import java.util.LinkedList;
import pfg.Menu;
import servidorprueba.Tarea;

/**
 * Panel que muestra una lista de tareas y permite agregar nuevas tareas. La
 * lista de tareas se pasa como argumento en el constructor y se muestran las
 * tareas mediante instancias de la clase EtiquetaTarea.
 *
 * El menú se pasa como argumento para que las tareas puedan ser editadas o
 * eliminadas desde este panel.
 *
 * El panel tiene un botón "Añadir tarea" que permite agregar nuevas tareas.
 *
 *
 * @author angel
 */
public class PanelTareas extends javax.swing.JPanel {

    private Menu menu;

    public LinkedList<Tarea> listaTareas;

    public PanelTareas() {
        initComponents();
    }

    /**
     * Crea un nuevo PanelTareas con una lista de tareas.
     *
     * @param listaTareas La lista de tareas a mostrar.
     * @param menu El menú principal de la aplicación.
     */
    public PanelTareas(LinkedList<Tarea> listaTareas, Menu menu) {
        this.listaTareas = listaTareas;
        this.menu = menu;
        for (Tarea t : listaTareas) {
            EtiquetaTarea etiquetaTarea = new EtiquetaTarea(t, menu);
            this.add(etiquetaTarea);
        }
    }

    public LinkedList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(LinkedList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelTareas.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
