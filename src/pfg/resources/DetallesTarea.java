package pfg.resources;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import pfg.ConectorDB;
import pfg.Menu;
import servidorprueba.Persona;
import servidorprueba.Tarea;

/**
 *
 * @author angel
 */
public class DetallesTarea extends javax.swing.JDialog {

    public Color colorTarea;
    private int idTarea;

    /**
     *
     * @param parent
     * @param modal
     */
    public DetallesTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     *
     * @param parent
     * @param modal
     * @param tarea
     */
    public DetallesTarea(java.awt.Frame parent, boolean modal, Tarea tarea) {
        super(parent, modal);
        initComponents();
        this.idTarea = tarea.getId();
        jTextFieldNombreTarea.setText(tarea.getNombre());
        jPanelColor.setBackground(Color.decode(tarea.getColor()));
        if ("0".equals(tarea.getPrioridad())) {
            jRadioButtonHora.setSelected(true);
            String horad = tarea.getHoraInicio().substring(0, 2);
            String mind = tarea.getHoraInicio().substring(2);
            jComboBoxHoraDesde.setSelectedItem(horad);
            jComboBoxMinDesde.setSelectedItem(mind);
            String horah = tarea.getHoraFin().substring(0, 2);
            String minh = tarea.getHoraFin().substring(2);
            jComboBoxHoraHasta.setSelectedItem(horah);
            jComboBoxMinHasta.setSelectedItem(minh);
        } else {
            jRadioButtonPrioridad.setSelected(true);
        }
        DefaultListModel demoList = new DefaultListModel();
        for (Persona p : tarea.getEmpleadosEnTarea()) {
            demoList.addElement(p.getNombre() + " " + p.getApellidos());
        }
        jList1.setModel(demoList);
        if (!Menu.usuario.isEsAdmin()) {
            jButtonAñadirPersonal.setVisible(false);
            jButtonEliminarPersonal.setVisible(false);
            jButtonActualizarTarea.setVisible(false);
            jButtonEliminarTarea.setVisible(false);

            jTextFieldNombreTarea.setEditable(false);
            jComboBoxHoraDesde.setEditable(false);
            jComboBoxHoraHasta.setEditable(false);
            jComboBoxMinDesde.setEditable(false);
            jComboBoxMinHasta.setEditable(false);

            jComboBoxLugar.setEditable(false);
            jComboBoxPrioridad.setEditable(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelNuevaTareaCreacion = new javax.swing.JPanel();
        jTextFieldNombreTarea = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabelColor = new javax.swing.JLabel();
        jPanelColor = new javax.swing.JPanel();
        jLabelDesde = new javax.swing.JLabel();
        jComboBoxHoraDesde = new javax.swing.JComboBox<>();
        jLabelDesde2 = new javax.swing.JLabel();
        jComboBoxMinDesde = new javax.swing.JComboBox<>();
        jComboBoxMinHasta = new javax.swing.JComboBox<>();
        jLabelHasta2 = new javax.swing.JLabel();
        jComboBoxHoraHasta = new javax.swing.JComboBox<>();
        jLabelHasta = new javax.swing.JLabel();
        jComboBoxPrioridad = new javax.swing.JComboBox<>();
        jLabelLugar = new javax.swing.JLabel();
        jComboBoxLugar = new javax.swing.JComboBox<>();
        jRadioButtonHora = new javax.swing.JRadioButton();
        jRadioButtonPrioridad = new javax.swing.JRadioButton();
        jLabelPersonal = new javax.swing.JLabel();
        jButtonAñadirPersonal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonEliminarPersonal = new javax.swing.JButton();
        jButtonActualizarTarea = new javax.swing.JButton();
        jButtonEliminarTarea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanelNuevaTareaCreacion.setName("jPanelNuevaTareaCreacion"); // NOI18N

        jTextFieldNombreTarea.setName("jTextFieldNombreTarea"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(DetallesTarea.class);
        jLabelNombre.setText(resourceMap.getString("jLabelNombre.text")); // NOI18N
        jLabelNombre.setName("jLabelNombre"); // NOI18N

        jLabelColor.setText(resourceMap.getString("jLabelColor.text")); // NOI18N
        jLabelColor.setName("jLabelColor"); // NOI18N

        jPanelColor.setBackground(resourceMap.getColor("jPanelColor.background")); // NOI18N
        jPanelColor.setName("jPanelColor"); // NOI18N
        jPanelColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabelDesde.setText(resourceMap.getString("jLabelDesde.text")); // NOI18N
        jLabelDesde.setName("jLabelDesde"); // NOI18N

        jComboBoxHoraDesde.setEditable(true);
        jComboBoxHoraDesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jComboBoxHoraDesde.setName("jComboBoxHoraDesde"); // NOI18N

        jLabelDesde2.setText(resourceMap.getString("jLabelDesde2.text")); // NOI18N
        jLabelDesde2.setName("jLabelDesde2"); // NOI18N

        jComboBoxMinDesde.setEditable(true);
        jComboBoxMinDesde.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        jComboBoxMinDesde.setName("jComboBoxMinDesde"); // NOI18N

        jComboBoxMinHasta.setEditable(true);
        jComboBoxMinHasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        jComboBoxMinHasta.setName("jComboBoxMinHasta"); // NOI18N

        jLabelHasta2.setText(resourceMap.getString("jLabelHasta2.text")); // NOI18N
        jLabelHasta2.setName("jLabelHasta2"); // NOI18N

        jComboBoxHoraHasta.setEditable(true);
        jComboBoxHoraHasta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jComboBoxHoraHasta.setName("jComboBoxHoraHasta"); // NOI18N

        jLabelHasta.setText(resourceMap.getString("jLabelHasta.text")); // NOI18N
        jLabelHasta.setName("jLabelHasta"); // NOI18N

        jComboBoxPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "baja", "media", "alta" }));
        jComboBoxPrioridad.setName("jComboBoxPrioridad"); // NOI18N

        jLabelLugar.setText(resourceMap.getString("jLabelLugar.text")); // NOI18N
        jLabelLugar.setName("jLabelLugar"); // NOI18N

        jComboBoxLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "H. San Carlos", "H. Puerta tierra" }));
        jComboBoxLugar.setName("jComboBoxLugar"); // NOI18N
        jComboBoxLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLugarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonHora);
        jRadioButtonHora.setText(resourceMap.getString("jRadioButtonHora.text")); // NOI18N
        jRadioButtonHora.setName("jRadioButtonHora"); // NOI18N
        jRadioButtonHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonHoraActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPrioridad);
        jRadioButtonPrioridad.setText(resourceMap.getString("jRadioButtonPrioridad.text")); // NOI18N
        jRadioButtonPrioridad.setName("jRadioButtonPrioridad"); // NOI18N
        jRadioButtonPrioridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPrioridadMouseClicked(evt);
            }
        });

        jLabelPersonal.setText(resourceMap.getString("jLabelPersonal.text")); // NOI18N
        jLabelPersonal.setName("jLabelPersonal"); // NOI18N

        jButtonAñadirPersonal.setText(resourceMap.getString("jButtonAñadirPersonal.text")); // NOI18N
        jButtonAñadirPersonal.setName("jButtonAñadirPersonal"); // NOI18N
        jButtonAñadirPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirPersonalActionPerformed(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setName("jList1"); // NOI18N
        jScrollPane2.setViewportView(jList1);

        jButtonEliminarPersonal.setText(resourceMap.getString("jButtonEliminarPersonal.text")); // NOI18N
        jButtonEliminarPersonal.setName("jButtonEliminarPersonal"); // NOI18N

        jButtonActualizarTarea.setText(resourceMap.getString("jButtonActualizarTarea.text")); // NOI18N
        jButtonActualizarTarea.setName("jButtonActualizarTarea"); // NOI18N

        jButtonEliminarTarea.setText(resourceMap.getString("jButtonEliminarTarea.text")); // NOI18N
        jButtonEliminarTarea.setName("jButtonEliminarTarea"); // NOI18N
        jButtonEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevaTareaCreacionLayout = new javax.swing.GroupLayout(jPanelNuevaTareaCreacion);
        jPanelNuevaTareaCreacion.setLayout(jPanelNuevaTareaCreacionLayout);
        jPanelNuevaTareaCreacionLayout.setHorizontalGroup(
            jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jLabelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jLabelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHasta2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMinHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jLabelLugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelPersonal)
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButtonActualizarTarea)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminarTarea))
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEliminarPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAñadirPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                            .addComponent(jLabelNombre)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldNombreTarea))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                            .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                    .addComponent(jLabelDesde)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxHoraDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelDesde2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxMinDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jRadioButtonHora)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonPrioridad)
                                .addComponent(jComboBoxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevaTareaCreacionLayout.setVerticalGroup(
            jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonHora)
                    .addComponent(jRadioButtonPrioridad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDesde)
                    .addComponent(jComboBoxHoraDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDesde2)
                    .addComponent(jComboBoxMinDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHasta2)
                    .addComponent(jComboBoxMinHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLugar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPersonal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jButtonAñadirPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarPersonal))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarTarea)
                    .addComponent(jButtonActualizarTarea))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevaTareaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevaTareaCreacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelColorMouseClicked
        if (!Menu.usuario.isEsAdmin()) {
            evt.consume();
        } else {
            Color color = JColorChooser.showDialog(null, "Elige un color", Color.WHITE);
            colorTarea = color;
            jPanelColor.setBackground(color);
        }
    }//GEN-LAST:event_jPanelColorMouseClicked

    private void jComboBoxLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLugarActionPerformed

    }//GEN-LAST:event_jComboBoxLugarActionPerformed

    private void jRadioButtonHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonHoraActionPerformed
        jComboBoxHoraDesde.setEnabled(true);
        jComboBoxHoraHasta.setEnabled(true);
        jComboBoxMinDesde.setEnabled(true);
        jComboBoxMinHasta.setEnabled(true);
        jComboBoxPrioridad.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonHoraActionPerformed

    private void jRadioButtonPrioridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonPrioridadMouseClicked
        jComboBoxHoraDesde.setEnabled(false);
        jComboBoxHoraHasta.setEnabled(false);
        jComboBoxMinDesde.setEnabled(false);
        jComboBoxMinHasta.setEnabled(false);
        jComboBoxPrioridad.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonPrioridadMouseClicked

    private void jButtonEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTareaActionPerformed

    private void jButtonAñadirPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirPersonalActionPerformed
        LinkedList argumentos = new LinkedList();
        argumentos.add(idTarea);
        argumentos.add(Menu.usuario.getGrupo());
        AñadirPersonaATarea ventanaAñadirPersonal = new AñadirPersonaATarea(null, true, ConectorDB.BuscarPersonalFueraDeTarea(argumentos));
        ventanaAñadirPersonal.setVisible(true);
    }//GEN-LAST:event_jButtonAñadirPersonalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesTarea dialog = new DetallesTarea(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonActualizarTarea;
    private javax.swing.JButton jButtonAñadirPersonal;
    private javax.swing.JButton jButtonEliminarPersonal;
    private javax.swing.JButton jButtonEliminarTarea;
    private javax.swing.JComboBox<String> jComboBoxHoraDesde;
    private javax.swing.JComboBox<String> jComboBoxHoraHasta;
    private javax.swing.JComboBox<String> jComboBoxLugar;
    private javax.swing.JComboBox<String> jComboBoxMinDesde;
    private javax.swing.JComboBox<String> jComboBoxMinHasta;
    private javax.swing.JComboBox<String> jComboBoxPrioridad;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelDesde;
    private javax.swing.JLabel jLabelDesde2;
    private javax.swing.JLabel jLabelHasta;
    private javax.swing.JLabel jLabelHasta2;
    private javax.swing.JLabel jLabelLugar;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPersonal;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelNuevaTareaCreacion;
    private javax.swing.JRadioButton jRadioButtonHora;
    private javax.swing.JRadioButton jRadioButtonPrioridad;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldNombreTarea;
    // End of variables declaration//GEN-END:variables
}
