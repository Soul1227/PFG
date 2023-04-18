package pfg.Dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import pfg.ConectorDB;
import pfg.Menu;
import pfg.paneles.EtiquetaTarea;
import servidorprueba.Lugar;
import servidorprueba.Prioridad;
import servidorprueba.Tarea;

/**
 * @author angel
 */
public class VentanaCrearTarea extends javax.swing.JDialog {

    public String nombreTarea;
    public Color colorTarea;
    public String horaInicio;
    public String horaFinal;
    public Date fecha;
    public String editadoPor;
    public SimpleDateFormat model;

    /**
     * Creates new form CrearTarea
     *
     * @param parent
     * @param modal
     */
    public VentanaCrearTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     *
     * @param parent
     * @param modal
     * @param fecha
     * @param listaLugares
     */
    public VentanaCrearTarea(java.awt.Frame parent, boolean modal, Date fecha, LinkedList<Lugar> listaLugares) {
        super(parent, modal);
        initComponents();

        //Creacion de panel e introduccion de las tareas guardadas.
        JPanel jPanelTareasGuardadasCreacion = new JPanel();
        LinkedList<Tarea> listaTareas = ConectorDB.BuscarTareasGuardadas();
        for (Tarea t : listaTareas) {
            EtiquetaTarea etiquetaTarea = new EtiquetaTarea(t);
            jPanelTareasGuardadasCreacion.add(etiquetaTarea);
        }
        jPanelTareasGuardadasCreacion.setLayout(new BoxLayout(jPanelTareasGuardadasCreacion, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(jPanelTareasGuardadasCreacion);
        scroll.setPreferredSize(new Dimension(300, 300));
        //Se añade el nuevo panel al tabpanel.
        jTabbedPane1.add(scroll, "Tareas Guardadas");

        
        RellenarPrioridades(ConectorDB.BuscarPrioridades());
        Menu.maper.setMapaLugares(Menu.maper.CrearMapaLugares(listaLugares));
        //Se rellena el combo box con los lugares que pertenecen al grupo.
        for (Lugar l : listaLugares) {
            String nombreLugar = l.getNombre();
            jComboBoxLugar.addItem(nombreLugar);
        }
        if (fecha == null) {
            jDatePicker1.setVisible(false);
            jLabelFecha.setVisible(false);
        } else {
            TomarFechaDelDia(fecha);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jLabelFecha = new javax.swing.JLabel();
        jDatePicker1 = new org.jdatepicker.JDatePicker();
        jComboBoxPrioridad = new javax.swing.JComboBox<>();
        jLabelLugar = new javax.swing.JLabel();
        jComboBoxLugar = new javax.swing.JComboBox<>();
        jRadioButtonHora = new javax.swing.JRadioButton();
        jRadioButtonPrioridad = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaCrearTarea.class);
        jTabbedPane1.setFont(resourceMap.getFont("jTabbedPane1.font")); // NOI18N
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanelNuevaTareaCreacion.setName("jPanelNuevaTareaCreacion"); // NOI18N

        jTextFieldNombreTarea.setText(resourceMap.getString("jTextFieldNombreTarea.text")); // NOI18N
        jTextFieldNombreTarea.setName("jTextFieldNombreTarea"); // NOI18N

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

        jLabelFecha.setText(resourceMap.getString("jLabelFecha.text")); // NOI18N
        jLabelFecha.setName("jLabelFecha"); // NOI18N

        jDatePicker1.setName("jDatePicker1"); // NOI18N

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

        javax.swing.GroupLayout jPanelNuevaTareaCreacionLayout = new javax.swing.GroupLayout(jPanelNuevaTareaCreacion);
        jPanelNuevaTareaCreacion.setLayout(jPanelNuevaTareaCreacionLayout);
        jPanelNuevaTareaCreacionLayout.setHorizontalGroup(
            jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addComponent(jLabelNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jRadioButtonHora))
                            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                .addComponent(jLabelDesde)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHoraDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDesde2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMinDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelFecha)
                            .addComponent(jDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                                .addComponent(jLabelLugar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButtonPrioridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxPrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
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
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButtonPrioridad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelNuevaTareaCreacionLayout.createSequentialGroup()
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDesde)
                            .addComponent(jComboBoxHoraDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDesde2)
                            .addComponent(jComboBoxMinDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxHoraHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHasta2)
                            .addComponent(jComboBoxMinHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelNuevaTareaCreacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLugar)
                            .addComponent(jComboBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanelNuevaTareaCreacion.TabConstraints.tabTitle"), jPanelNuevaTareaCreacion); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.setName("jPanel3"); // NOI18N

        jButtonAceptar.setText(resourceMap.getString("jButtonAceptar.text")); // NOI18N
        jButtonAceptar.setName("jButtonAceptar"); // NOI18N
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAceptar);

        jButtonCancelar.setText(resourceMap.getString("jButtonCancelar.text")); // NOI18N
        jButtonCancelar.setName("jButtonCancelar"); // NOI18N
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });
        jPanel3.add(jButtonCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelColorMouseClicked
        Color color = JColorChooser.showDialog(null, "Elige un color", Color.WHITE);
        colorTarea = color;
        jPanelColor.setBackground(color);
    }//GEN-LAST:event_jPanelColorMouseClicked

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked

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

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if (!jRadioButtonHora.isSelected() && !jRadioButtonPrioridad.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "seleccione entre hora y prioridad");
        } else {
            //tomar los valores del formulario.
            String nombre = jTextFieldNombreTarea.getText();
            Color backgroundcolor = jPanelColor.getBackground();
            String color = String.format("#%06x", backgroundcolor.getRGB() & 0xFFFFFF);
            String horaDesde = jComboBoxHoraDesde.getSelectedItem().toString() + ":" + jComboBoxMinDesde.getSelectedItem().toString();
            String horaHasta = jComboBoxHoraHasta.getSelectedItem().toString() + ":" + jComboBoxMinHasta.getSelectedItem().toString();
            String lugarSeleccionado = jComboBoxLugar.getSelectedItem().toString();
            int lugarId = (int) Menu.maper.getMapaLugares().get(lugarSeleccionado);
            String prioridadSeleccionada = jComboBoxPrioridad.getSelectedItem().toString();
            int PrioridadId = (int) Menu.maper.getMapaPrioridades().get(prioridadSeleccionada);
            Date date;
            boolean guardada;
            if (jDatePicker1.isEnabled()) {
                guardada = false;
                java.util.Calendar calendar = (java.util.Calendar) jDatePicker1.getModel().getValue();
                if (calendar != null) {
                    date = new java.sql.Date(calendar.getTime().getTime());
                } else {
                    date = null;
                }
            } else {
                date = null;
                guardada = true;
            }
            if (jRadioButtonHora.isSelected() && ComprobarHoras(horaDesde, horaHasta)) {
                jButtonAceptar.setEnabled(false);
                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
                    @Override
                    protected Boolean doInBackground() throws Exception {
                        Tarea tarea = new Tarea(nombre, color, (java.sql.Date) date, lugarId, 0, guardada, Menu.usuario.getGrupo(), null, horaDesde, horaHasta, Menu.usuario.getNombre() + " " + Menu.usuario.getApellidos());
                        return ConectorDB.CrearTarea(tarea);
                    }

                    @Override
                    protected void done() {
                        try {
                            if (get()) {
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "no se pudo conectar con la base de datos\nintentelo más tarde.");
                            }
                        } catch (ExecutionException | InterruptedException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                };
                worker.execute();
            } else if (jRadioButtonPrioridad.isSelected()) {
                jButtonAceptar.setEnabled(false);
                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
                    @Override
                    protected Boolean doInBackground() throws Exception {
                        Tarea tarea = new Tarea(nombre, color, (java.sql.Date) date, lugarId, PrioridadId, guardada, Menu.usuario.getGrupo(), null, null, null, Menu.usuario.getNombre() + " " + Menu.usuario.getApellidos());
                        return ConectorDB.CrearTarea(tarea);
                    }

                    @Override
                    protected void done() {
                        try {
                            if (get()) {
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "no se pudo conectar con la base de datos\nintentelo más tarde.");
                            }
                        } catch (ExecutionException | InterruptedException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                };
                worker.execute();
            }
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            VentanaCrearTarea dialog = new VentanaCrearTarea(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxHoraDesde;
    private javax.swing.JComboBox<String> jComboBoxHoraHasta;
    private javax.swing.JComboBox<String> jComboBoxLugar;
    private javax.swing.JComboBox<String> jComboBoxMinDesde;
    private javax.swing.JComboBox<String> jComboBoxMinHasta;
    private javax.swing.JComboBox<String> jComboBoxPrioridad;
    private org.jdatepicker.JDatePicker jDatePicker1;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelDesde;
    private javax.swing.JLabel jLabelDesde2;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelHasta;
    private javax.swing.JLabel jLabelHasta2;
    private javax.swing.JLabel jLabelLugar;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelNuevaTareaCreacion;
    private javax.swing.JRadioButton jRadioButtonHora;
    private javax.swing.JRadioButton jRadioButtonPrioridad;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldNombreTarea;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para estableceren en el jDatePicker la fecha del dia que hemos
     * seleccionado para la tarea.
     *
     * @param fecha Date dia-mes-año
     */
    private void TomarFechaDelDia(Date fecha) {
        DateFormat dfDia = new SimpleDateFormat("dd");
        DateFormat dfMes = new SimpleDateFormat("MM");
        DateFormat dfAno = new SimpleDateFormat("yyyy");
        int dia = Integer.valueOf(dfDia.format(fecha));
        int mes = Integer.valueOf(dfMes.format(fecha)) - 1;
        int ano = Integer.valueOf(dfAno.format(fecha));
        jDatePicker1.getModel().setDay(dia);
        jDatePicker1.getModel().setMonth(mes);
        jDatePicker1.getModel().setYear(ano);
        jDatePicker1.getModel().setSelected(true);
    }

    /**
     *
     * @param desde
     * @param hasta
     * @return
     */
    private boolean ComprobarHoras(String desde, String hasta) {
        Time time1 = Time.valueOf(desde + ":00");
        Time time2 = Time.valueOf(hasta + ":00");
        return time1.before(time2);
    }

    /**
     * 
     * @param listaPrioridades 
     */
    private void RellenarPrioridades(LinkedList<Prioridad> listaPrioridades) {
        Menu.maper.setListaPrioridades(listaPrioridades);
        Menu.maper.ActualizarMapaPrioridades(listaPrioridades);
        listaPrioridades.forEach((p)->{
            jComboBoxPrioridad.addItem(p.getNombre());
        });
    }

}
