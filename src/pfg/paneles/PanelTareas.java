package pfg.paneles;

import java.util.LinkedList;
import pfg.Menu;
import servidorprueba.Tarea;

/**
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
     * 
     * @param listaTareas
     * @param menu 
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
