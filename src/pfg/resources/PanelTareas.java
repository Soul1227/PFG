package pfg.resources;

import java.util.LinkedList;
import servidorprueba.Tarea;

/**
 *
 * @author angel
 */
public class PanelTareas extends javax.swing.JPanel {

    /**
     * Creates new form PanelTareas
     */
    public PanelTareas() {
        initComponents();
    }

    public PanelTareas(LinkedList<Tarea> listaTareas) {
        this.setAutoscrolls(true);
        for(Tarea t :listaTareas){
            EtiquetaTarea etiquetaTarea = new EtiquetaTarea(t.getNombre(),t.getFechaInicio()+" - "+t.getFechaFin() , t.getColor());
        this.add(etiquetaTarea);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelTareas.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
