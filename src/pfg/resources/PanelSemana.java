package pfg.resources;

import java.util.Date;

/**
 *
 * @author angel
 */
public class PanelSemana extends javax.swing.JPanel {

    /**
     * Creates new form PanelSemana
     */
    public PanelSemana() {
        initComponents();
    }

    public PanelSemana(Date[] semana) {
        initComponents();
        for (Date d : semana) {
            PanelDiaSemana diaSemana = new PanelDiaSemana(d);
            diaSemana.setSize(WIDTH,this.getHeight());
            diaSemana.setMaximumSize(this.getSize());
            diaSemana.setAutoscrolls(true);
            this.add(diaSemana);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelSemana.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setName("Form"); // NOI18N
        setLayout(new java.awt.GridLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
