package pfg.resources;

import java.awt.Color;
import javax.swing.JLabel;
import servidorprueba.Persona;
import servidorprueba.Tarea;

/**
 *
 * @author angel
 */
public class EtiquetaTarea extends javax.swing.JPanel {

    private Tarea tarea;

    /**
     * Creates new form PanelTarea
     */
    public EtiquetaTarea() {
        initComponents();
    }

    /**
     *
     * @param tarea
     */
    public EtiquetaTarea(Tarea tarea) {
        initComponents();
        this.tarea = tarea;
        jLabelNombreTarea.setText(tarea.getNombre());
        if (!tarea.getHoraInicio().equals("null")) {
            jLabelHora.setText(tarea.getHoraInicio() + ":" + tarea.getHoraFin());
        } else {
            jLabelHora.setText("prioridad: Alta");
        }
        jPanelColor.setBackground(Color.decode(tarea.getColor()));
//        if (tarea.getEmpleadosEnTarea().size() > 0) {
//            for (Persona p : tarea.getEmpleadosEnTarea()) {
//                JLabel etiquetaNombre = new JLabel(p.getNombre() + " " + p.getApellidos());
//                jPanelPersonalEnTarea.add(etiquetaNombre);
//            }
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreTarea = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jPanelColor = new javax.swing.JPanel();

        setName("Form"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(EtiquetaTarea.class);
        jLabelNombreTarea.setText(resourceMap.getString("jLabelNombreTarea.text")); // NOI18N
        jLabelNombreTarea.setName("jLabelNombreTarea"); // NOI18N

        jLabelHora.setText(resourceMap.getString("jLabelHora.text")); // NOI18N
        jLabelHora.setName("jLabelHora"); // NOI18N

        jPanelColor.setName("jPanelColor"); // NOI18N
        jPanelColor.setPreferredSize(new java.awt.Dimension(15, 100));

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombreTarea)
                    .addComponent(jLabelHora))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombreTarea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHora)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        DetallesTarea detalles = new DetallesTarea(null, true, tarea);
        detalles.setVisible(true);
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNombreTarea;
    private javax.swing.JPanel jPanelColor;
    // End of variables declaration//GEN-END:variables
}
