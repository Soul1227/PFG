package pfg.resources;

import java.awt.Color;

/**
 *
 * @author angel
 */
public class PanelTarea extends javax.swing.JPanel {

    /**
     * Creates new form PanelTarea
     */
    public PanelTarea() {
        initComponents();
    }
    public PanelTarea(String nombre, String hora, Color color) {
        initComponents();
        jLabelNombreTarea.setText(nombre);
        jLabelHora.setText(hora);
        setBackground(color);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreTarea = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jPanelPersonalEnTarea = new javax.swing.JPanel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelTarea.class);
        jLabelNombreTarea.setText(resourceMap.getString("jLabelNombreTarea.text")); // NOI18N
        jLabelNombreTarea.setName("jLabelNombreTarea"); // NOI18N

        jLabelHora.setText(resourceMap.getString("jLabelHora.text")); // NOI18N
        jLabelHora.setName("jLabelHora"); // NOI18N

        jPanelPersonalEnTarea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanelPersonalEnTarea.border.title"), javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP)); // NOI18N
        jPanelPersonalEnTarea.setName("jPanelPersonalEnTarea"); // NOI18N

        javax.swing.GroupLayout jPanelPersonalEnTareaLayout = new javax.swing.GroupLayout(jPanelPersonalEnTarea);
        jPanelPersonalEnTarea.setLayout(jPanelPersonalEnTareaLayout);
        jPanelPersonalEnTareaLayout.setHorizontalGroup(
            jPanelPersonalEnTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelPersonalEnTareaLayout.setVerticalGroup(
            jPanelPersonalEnTareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPersonalEnTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreTarea)
                            .addComponent(jLabelHora))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNombreTarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPersonalEnTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNombreTarea;
    private javax.swing.JPanel jPanelPersonalEnTarea;
    // End of variables declaration//GEN-END:variables
}
