package pfg.resources;

import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author angel
 */
public class PanelDiaSemana extends javax.swing.JPanel {

    public PanelDiaSemana() {
        initComponents();
    }
    public PanelDiaSemana(Date fecha) {
        initComponents();
        String diaSemana; //Lunes-15
        Border borde = BorderFactory.createEtchedBorder();
        Border bordeTitulado = BorderFactory.createTitledBorder(borde, //diaSemana);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAñadirTarea = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jPanelTareasEnDia = new javax.swing.JPanel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelDiaSemana.class);
        jButtonAñadirTarea.setText(resourceMap.getString("jButtonAñadirTarea.text")); // NOI18N
        jButtonAñadirTarea.setName("jButtonAñadirTarea"); // NOI18N
        jButtonAñadirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirTareaActionPerformed(evt);
            }
        });

        jScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jScrollPane.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP)); // NOI18N
        jScrollPane.setName("jScrollPane"); // NOI18N

        jPanelTareasEnDia.setName("jPanelTareasEnDia"); // NOI18N

        javax.swing.GroupLayout jPanelTareasEnDiaLayout = new javax.swing.GroupLayout(jPanelTareasEnDia);
        jPanelTareasEnDia.setLayout(jPanelTareasEnDiaLayout);
        jPanelTareasEnDiaLayout.setHorizontalGroup(
            jPanelTareasEnDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        jPanelTareasEnDiaLayout.setVerticalGroup(
            jPanelTareasEnDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        jScrollPane.setViewportView(jPanelTareasEnDia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAñadirTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAñadirTarea)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAñadirTareaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirTarea;
    private javax.swing.JPanel jPanelTareasEnDia;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
