package pfg.Dialogs;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import pfg.ConectorDB;
import pfg.Menu;
import servidorprueba.Lugar;
import servidorprueba.Persona;
import servidorprueba.Prioridad;
import servidorprueba.Tarea;

/**
 *
 * @author angel
 */
public class VentanaDetallesTarea extends javax.swing.JDialog {

    private Tarea tarea;
    private String nombreTarea;
    public Color colorTarea;
    private String StringColor;
    private String horaInicio;
    private String horaFin;
    private String horaDesde;
    private String minDesde;
    private String horaHasta;
    private String minHasta;
    private int prioridad;
    private int lugar;
    private LinkedList<Persona> listaPersonal;
    private String editadoPor;

    private DefaultListModel<String> demoList;

    /**
     * @param parent
     * @param modal
     */
    public VentanaDetallesTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     *
     * Crea una nueva instancia del diálogo DetallesTarea.
     *
     * @param parentFrame El frame padre del diálogo.
     * @param isModal Si el diálogo debe ser modal.
     * @param tarea La tarea que se mostrará en el diálogo.
     */
    public VentanaDetallesTarea(java.awt.Frame parentFrame, boolean isModal, Tarea tarea) {
        super(parentFrame, isModal);
        initComponents();
        this.tarea = tarea;
        ConfigurarComponentesUI();
        RellenarDetallesTarea(tarea);
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
        jListEmpleadosEnTarea = new javax.swing.JList<>();
        jButtonEliminarPersonal = new javax.swing.JButton();
        jButtonActualizarTarea = new javax.swing.JButton();
        jButtonEliminarTarea = new javax.swing.JButton();
        jLabelEditadoPor = new javax.swing.JLabel();
        jLabelEditador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanelNuevaTareaCreacion.setName("jPanelNuevaTareaCreacion"); // NOI18N

        jTextFieldNombreTarea.setName("jTextFieldNombreTarea"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaDetallesTarea.class);
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

        jComboBoxPrioridad.setName("jComboBoxPrioridad"); // NOI18N

        jLabelLugar.setText(resourceMap.getString("jLabelLugar.text")); // NOI18N
        jLabelLugar.setName("jLabelLugar"); // NOI18N

        jComboBoxLugar.setName("jComboBoxLugar"); // NOI18N

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

        jListEmpleadosEnTarea.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListEmpleadosEnTarea.setName("jListEmpleadosEnTarea"); // NOI18N
        jScrollPane2.setViewportView(jListEmpleadosEnTarea);

        jButtonEliminarPersonal.setText(resourceMap.getString("jButtonEliminarPersonal.text")); // NOI18N
        jButtonEliminarPersonal.setName("jButtonEliminarPersonal"); // NOI18N
        jButtonEliminarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPersonalActionPerformed(evt);
            }
        });

        jButtonActualizarTarea.setText(resourceMap.getString("jButtonActualizarTarea.text")); // NOI18N
        jButtonActualizarTarea.setName("jButtonActualizarTarea"); // NOI18N
        jButtonActualizarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarTareaActionPerformed(evt);
            }
        });

        jButtonEliminarTarea.setText(resourceMap.getString("jButtonEliminarTarea.text")); // NOI18N
        jButtonEliminarTarea.setName("jButtonEliminarTarea"); // NOI18N
        jButtonEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTareaActionPerformed(evt);
            }
        });

        jLabelEditadoPor.setText(resourceMap.getString("jLabelEditadoPor.text")); // NOI18N
        jLabelEditadoPor.setName("jLabelEditadoPor"); // NOI18N

        jLabelEditador.setText(resourceMap.getString("jLabelEditador.text")); // NOI18N
        jLabelEditador.setName("jLabelEditador"); // NOI18N

        javax.swing.GroupLayout jPanelNuevaTareaCreacionLayout = new javax.swing.GroupLayout(jPanelNuevaTareaCreacion);
        jPanelNuevaTareaCreacion.setLayout(jPanelNuevaTareaCreacionLayout);
        jPanelNuevaTareaCreacionLayout.setHorizontalGroup(
            jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                .addComponent(jLabelNombre)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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
                                    .addComponent(jRadioButtonPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                        .addComponent(jComboBoxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(1, 1, 1))
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
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
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonEliminarPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAñadirPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButtonActualizarTarea)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEliminarTarea))
                            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                .addComponent(jLabelEditadoPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEditador)))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPersonal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jButtonAñadirPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminarPersonal))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEditadoPor)
                    .addComponent(jLabelEditador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizarTarea)
                    .addComponent(jButtonEliminarTarea))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevaTareaCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevaTareaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    }//GEN-LAST:event_jButtonEliminarTareaActionPerformed

    private void jButtonAñadirPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirPersonalActionPerformed
        CearVentanaAñadirPersonalATarea();
    }//GEN-LAST:event_jButtonAñadirPersonalActionPerformed

    private void jButtonActualizarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarTareaActionPerformed
        ActualizarTarea();
    }//GEN-LAST:event_jButtonActualizarTareaActionPerformed

    private void jButtonEliminarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPersonalActionPerformed
        EliminarPersonarlDeTarea(ConfirmarEliminarPersonal());
        RellenarDetallesTarea(tarea);
    }//GEN-LAST:event_jButtonEliminarPersonalActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaDetallesTarea dialog = new VentanaDetallesTarea(new javax.swing.JFrame(), true);
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

    /**
     * Llena los componentes de la interfaz de usuario con los detalles de la
     * tarea dada.
     *
     * @param tarea La tarea que se mostrará en el diálogo.
     */
    private void RellenarDetallesTarea(Tarea tarea) {
        jTextFieldNombreTarea.setText(tarea.getNombre());
        jPanelColor.setBackground(Color.decode(tarea.getColor()));
        RellenarComboBoxPrioridad(ConectorDB.BuscarPrioridades());
        RellenarComboBoxLugares(ConectorDB.BuscarLugaresDeUsuario(Menu.usuario.getGrupo()));
        if (tarea.getPrioridad() == 0) {
            jRadioButtonHora.setSelected(true);
            RellenarHora(tarea.getHoraInicio(), tarea.getHoraFin());
        } else {
            jRadioButtonPrioridad.setSelected(true);
        }
        demoList = new DefaultListModel<>();
        tarea.getEmpleadosEnTarea().forEach((p) -> {
            demoList.addElement(p.getNombre() + " " + p.getApellidos());
        });
        jListEmpleadosEnTarea.setModel(demoList);
        jLabelEditador.setText(tarea.getEditadoPor());
    }

    /**
     * Configura los componentes de la interfaz de usuario, incluyendo la
     * desactivación de la edición si el usuario no es un administrador.
     */
    private void ConfigurarComponentesUI() {
        boolean esAdmin = Menu.usuario.isEsAdmin();
        jButtonAñadirPersonal.setVisible(esAdmin);
        jButtonEliminarPersonal.setVisible(esAdmin);
        jButtonActualizarTarea.setVisible(esAdmin);
        jButtonEliminarTarea.setVisible(esAdmin);
        jTextFieldNombreTarea.setEditable(esAdmin);
        jComboBoxHoraDesde.setEditable(esAdmin);
        jComboBoxHoraHasta.setEditable(esAdmin);
        jComboBoxMinDesde.setEditable(esAdmin);
        jComboBoxMinHasta.setEditable(esAdmin);
        jComboBoxLugar.setEditable(esAdmin);
        jComboBoxPrioridad.setEditable(esAdmin);
    }

    /**
     *
     */
    private void CearVentanaAñadirPersonalATarea() {
        LinkedList argumentos = new LinkedList();
        argumentos.add(tarea.getId());
        argumentos.add(Menu.usuario.getGrupo());
        VentanaAñadirPersonaATarea ventanaAñadirPersonal = new VentanaAñadirPersonaATarea(null, true, ConectorDB.BuscarPersonalFueraDeTarea(argumentos), tarea);
        ventanaAñadirPersonal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                RellenarDetallesTarea(tarea);
            }
        });
        ventanaAñadirPersonal.setVisible(true);
    }

    /**
     * Muestra una ventana para que el usuario decida si quiere eliminar al
     * personal seleccionado de la tarea o no.
     *
     * @return true o false.
     */
    public boolean ConfirmarEliminarPersonal() {
        int choice = JOptionPane.showConfirmDialog(rootPane, "¿Eliminar al personal seleccionado de la tarea?");
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    private void EliminarPersonarlDeTarea(Boolean eliminar) {
        if (eliminar) {
            List<String> selectedValues = jListEmpleadosEnTarea.getSelectedValuesList();
            selectedValues.forEach((String value) -> {
                tarea.getEmpleadosEnTarea().forEach((Persona persona) -> {
                    String nombreEmpleado = persona.getNombre() + " " + persona.getApellidos();
                    if (nombreEmpleado.equals(value)) {
                        tarea.getEmpleadosEnTarea().remove(persona);
                        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
                            @Override
                            protected Boolean doInBackground() throws Exception {
                                return ConectorDB.EliminarPersonalDeTarea(persona, tarea);
                            }

                            @Override
                            protected void done() {
                                try {
                                    if (get()) {
                                    }
                                } catch (ExecutionException | InterruptedException ex) {
                                    System.err.println(ex.getMessage());
                                }
                            }
                        };
                        worker.execute();
                    }
                });
            });
        }
    }

    /**
     * Rellena el ComboBox Prioridades y asigna como selecteditem aquel que
     * corresponda con la prioridad de la tarea.
     *
     * @param BuscarPrioridades lista de prioridades obtenida de la base de
     * datos
     */
    private void RellenarComboBoxPrioridad(LinkedList<Prioridad> BuscarPrioridades) {
        //Rellenar el combo box
        Menu.maper.ActualizarMapaPrioridades(BuscarPrioridades);
        BuscarPrioridades.forEach((prioridad) -> {
            jComboBoxPrioridad.addItem(prioridad.getNombre());
        });
        //Asignar el item prioridad de la tarea en el combo box
        if (tarea.getPrioridad() != 0) {
            BuscarPrioridades.forEach((prioridad) -> {
                if (prioridad.getId() == tarea.getPrioridad()) {
                    jComboBoxPrioridad.setSelectedItem(prioridad.getNombre());
                }
            });
        }
    }

    /**
     * Rellena los ComboBox de hora desde y hasta.
     *
     * @param horaInicio de la tarea.
     * @param horaFin de la tarea.
     */
    private void RellenarHora(String horaInicio, String horaFin) {
        horaDesde = horaInicio.substring(0, 2);
        minDesde = horaInicio.substring(3);
        jComboBoxHoraDesde.setSelectedItem(horaDesde);
        jComboBoxMinDesde.setSelectedItem(minDesde);
        horaHasta = horaFin.substring(0, 2);
        minHasta = horaFin.substring(3);
        jComboBoxHoraHasta.setSelectedItem(horaHasta);
        jComboBoxMinHasta.setSelectedItem(minHasta);
    }

    /**
     *
     * @param BuscarLugaresDeUsuario
     */
    private void RellenarComboBoxLugares(LinkedList<Lugar> BuscarLugaresDeUsuario) {
        //Rellena el combobox
        Menu.maper.ActualizarMapaLugares(BuscarLugaresDeUsuario);
        BuscarLugaresDeUsuario.forEach((lugar) -> {
            jComboBoxLugar.addItem(lugar.getNombre());
        });
        // Asigna el lugar de la tarea en el combobox.
        BuscarLugaresDeUsuario.forEach((lugar) -> {
            if (lugar.getId() == tarea.getLugar()) {
                jComboBoxLugar.setSelectedItem(lugar.getNombre());
            }
        });
    }

    /**
     * Tomas los valores de la ventana "VentanaDetallesTarea" para actualizar la
     * tarea en la base de datos.
     */
    private void ActualizarTarea() {
        setNombreTarea(jTextFieldNombreTarea.getText());
        setStringColor(colorTarea);
        if (jRadioButtonPrioridad.isSelected()) {
            setHoraInicio(null);
            setHoraFin(null);
            setPrioridad(getValorPrioridad());
        } else {
            prioridad = 0;
            CrearHoras();
        }
        setLugar(getValorLugar());
        setEditadoPor(Menu.usuario.getNombre() + " " + Menu.usuario.getApellidos());
        Tarea tareaActualizada = new Tarea(tarea.getId(), nombreTarea, StringColor, tarea.getFecha(), lugar, prioridad,tarea.isGuardada(), tarea.getGrupo(), tarea.getEmpleadosEnTarea(), horaInicio, horaFin, editadoPor);
        ConectorDB.ActualizarTarea(tareaActualizada);    
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
    private javax.swing.JLabel jLabelEditadoPor;
    private javax.swing.JLabel jLabelEditador;
    private javax.swing.JLabel jLabelHasta;
    private javax.swing.JLabel jLabelHasta2;
    private javax.swing.JLabel jLabelLugar;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPersonal;
    private javax.swing.JList<String> jListEmpleadosEnTarea;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelNuevaTareaCreacion;
    private javax.swing.JRadioButton jRadioButtonHora;
    private javax.swing.JRadioButton jRadioButtonPrioridad;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldNombreTarea;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @return
     */
    private int getValorLugar() {
        return (int) Menu.maper.getMapaLugares().get(jComboBoxLugar.getSelectedItem().toString());
    }

    /**
     *
     * @return
     */
    private int getValorPrioridad() {
        return (int) Menu.maper.getMapaPrioridades().get(jComboBoxPrioridad.getSelectedItem().toString());
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getStringColor() {
        return StringColor;
    }

    public void setStringColor(Color colorTarea) {
        if(colorTarea==null){
            this.StringColor = tarea.getColor();
        }else{
            this.StringColor = String.format("#%06x", colorTarea.getRGB() & 0xFFFFFF);
        }  
    }

    public String getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(String horaDesde) {
        this.horaDesde = horaDesde;
    }

    public String getMinDesde() {
        return minDesde;
    }

    public void setMinDesde(String minDesde) {
        this.minDesde = minDesde;
    }

    public String getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(String horaHasta) {
        this.horaHasta = horaHasta;
    }

    public String getMinHasta() {
        return minHasta;
    }

    public void setMinHasta(String minHasta) {
        this.minHasta = minHasta;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getLugar() {
        return lugar;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }

    public LinkedList<Persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(LinkedList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public String getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(String editadoPor) {
        this.editadoPor = editadoPor;
    }

    private void CrearHoras() {
        setHoraDesde(jComboBoxHoraDesde.getSelectedItem().toString());
        setMinDesde(jComboBoxMinDesde.getSelectedItem().toString());
        setHoraHasta(jComboBoxHoraHasta.getSelectedItem().toString());
        setMinHasta(jComboBoxMinHasta.getSelectedItem().toString());

        setHoraInicio(getHoraDesde() + ":" + getMinDesde());
        setHoraFin(getHoraHasta() + ":" + getMinHasta());
    }

}
