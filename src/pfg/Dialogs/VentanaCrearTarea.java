package pfg.Dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.event.MouseInputAdapter;
import pfg.ConectorDB;
import pfg.Maper;
import pfg.Menu;
import pfg.paneles.EtiquetaTarea;
import servidorprueba.Lugar;
import servidorprueba.Prioridad;
import servidorprueba.Tarea;

/**
 * Ventana para crear una nueva Tarea. La ventana contiene diferentes campos que
 * el usuario debe completar para crear una nueva Tarea. Además, muestra tareas
 * previamente guardadas para que el usuario pueda seleccionarlas y utilizarlas
 * como base para crear una nueva Tarea.
 *
 * @author angel
 */
public class VentanaCrearTarea extends javax.swing.JDialog {

    public Tarea tarea;
    public String nombreTarea;
    public Color colorTarea;
    public String horaInicio;
    public String horaFinal;
    public Date fecha;
    public String editadoPor;
    public SimpleDateFormat dateFormat;
    private Maper maper;

    /**
     * Crea una nueva instancia de la ventana.
     *
     * @param parent El Frame padre de la ventana.
     * @param modal Un valor booleano que indica si la ventana es modal.
     */
    public VentanaCrearTarea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Crea una nueva instancia de la ventana.
     *
     * @param parent El Frame padre de la ventana.
     * @param modal Un valor booleano que indica si la ventana es modal.
     * @param fecha La fecha en la que se creará la nuevaTarea.
     * @param listaLugares Una lista de lugares disponibles para asociar a la
     * nuevaTarea.
     */
    public VentanaCrearTarea(java.awt.Frame parent, boolean modal, Date fecha, LinkedList<Lugar> listaLugares) {
        super(parent, modal);
        initComponents();
        this.maper = Menu.maper;
        this.dateFormat = new SimpleDateFormat();

        //Creacion de panel e introduccion de las tareas guardadas.
        JPanel jPanelTareasGuardadas = new JPanel();
        LinkedList<Tarea> listaTareas = ConectorDB.BuscarTareasGuardadas(Menu.usuario.getGrupo());
        for (Tarea t : listaTareas) {
            EtiquetaTarea etiquetaTarea = new EtiquetaTarea(t);
            etiquetaTarea.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Obtener el índice de la pestaña "Tareas Guardadas"
                    int index = jTabbedPane.indexOfTab("Nueva Tarea");
                    tarea = etiquetaTarea.getTarea();
                    // Seleccionar la pestaña "Tareas Guardadas"
                    jTabbedPane.setSelectedIndex(index);
                    RellenarDatosTarea(tarea);
                }
            });
            jPanelTareasGuardadas.add(etiquetaTarea);
        }
        jPanelTareasGuardadas.setLayout(new BoxLayout(jPanelTareasGuardadas, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(jPanelTareasGuardadas);
        scroll.setPreferredSize(new Dimension(300, 300));
        //Se añade el nuevo panel al tabpanel.
        jTabbedPane.add(scroll, "Tareas Guardadas");

        RellenarPrioridades(ConectorDB.BuscarPrioridades());
        RellenarLugares(listaLugares);

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
        jTabbedPane = new javax.swing.JTabbedPane();
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
        jTabbedPane.setFont(resourceMap.getFont("jTabbedPane.font")); // NOI18N
        jTabbedPane.setName("jTabbedPane"); // NOI18N

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

        jTabbedPane.addTab(resourceMap.getString("jPanelNuevaTareaCreacion.TabConstraints.tabTitle"), jPanelNuevaTareaCreacion); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    /**
     * Método que se ejecuta al hacer clic en el panel de color para elegir un
     * color para la nuevaTarea. Abre un JColorChooser para que el usuario
     * seleccione un color y lo asigna a la variable de clase colorTarea.
     * También cambia el fondo del panel para que muestre el color seleccionado.
     *
     * @param evt El evento del mouse que se produce al hacer clic en el panel
     * de color.
     */
    private void jPanelColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelColorMouseClicked
        Color color = JColorChooser.showDialog(null, "Elige un color", Color.WHITE);
        colorTarea = color;
        jPanelColor.setBackground(color);
    }//GEN-LAST:event_jPanelColorMouseClicked
    /**
     * Método que se ejecuta al hacer clic en el botón "Cancelar". Cierra la
     * ventana actual.
     *
     * @param evt El evento del mouse que se produce al hacer clic en el botón
     * "Cancelar".
     */
    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_jButtonCancelarMouseClicked
    /**
     * Método que se ejecuta al seleccionar la opción de hora en el radio
     * button. Habilita los campos para seleccionar la hora de inicio y
     * finalización de la nuevaTarea, y deshabilita el campo para seleccionar la
     * prioridad.
     *
     * @param evt El evento que se produce al seleccionar la opción de hora en
     * el radio button.
     */
    private void jRadioButtonHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonHoraActionPerformed
        jComboBoxHoraDesde.setEnabled(true);
        jComboBoxHoraHasta.setEnabled(true);
        jComboBoxMinDesde.setEnabled(true);
        jComboBoxMinHasta.setEnabled(true);
        jComboBoxPrioridad.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonHoraActionPerformed
    /**
     * Método que se ejecuta al hacer clic en la opción de prioridad en el radio
     * button. Deshabilita los campos para seleccionar la hora de inicio y
     * finalización de la nuevaTarea, y habilita el campo para seleccionar la
     * prioridad.
     *
     * @param evt El evento del mouse que se produce al hacer clic en la opción
     * de prioridad en el radio button.
     */
    private void jRadioButtonPrioridadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonPrioridadMouseClicked
        jComboBoxHoraDesde.setEnabled(false);
        jComboBoxHoraHasta.setEnabled(false);
        jComboBoxMinDesde.setEnabled(false);
        jComboBoxMinHasta.setEnabled(false);
        jComboBoxPrioridad.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonPrioridadMouseClicked
    /**
     * Método que se ejecuta cuando se presiona el botón "Aceptar" del
     * formulario de creación de tarea. Verifica que se haya seleccionado entre
     * "Hora" y "Prioridad". Si no es así, muestra un mensaje de error y termina
     * la ejecución. Obtiene los valores del formulario y los convierte en una
     * instancia de la clase Tarea. Luego, la envía a la base de datos para que
     * sea creada. Si la tarea es creada exitosamente, cierra el formulario. Si
     * no, muestra un mensaje de error. Este método se ejecuta en un hilo
     * SwingWorker para no bloquear la interfaz gráfica de usuario.
     *
     * @param evt objeto que representa el evento de presionar el botón
     * "Aceptar".
     */
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if (!jRadioButtonHora.isSelected() && !jRadioButtonPrioridad.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "seleccione entre hora y prioridad");
            return;
        }
        Tarea nuevaTarea = generarTareaDelFormulario();
        if (nuevaTarea == null) {
            return;
        }
        jButtonAceptar.setEnabled(false);
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return ConectorDB.CrearTarea(nuevaTarea);
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
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldNombreTarea;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para estableceren en el jDatePicker la fecha del dia que hemos
     * seleccionado para la nuevaTarea.
     *
     * @param fecha Date dia-mes-año
     */
    private void TomarFechaDelDia(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        jDatePicker1.getModel().setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        jDatePicker1.getModel().setSelected(true);
    }

    /**
     * Comprueba si la hora de inicio es anterior a la hora de finalización.
     *
     * @param horaInicio La hora de inicio en formato HH:mm
     * @param horaFin La hora de finalización en formato HH:mm
     * @return True si la hora de inicio es anterior a la hora de finalización,
     * false en caso contrario.
     */
    private boolean comprobarHoras(String horaInicio, String horaFin) {
        Time horaInicioTime = Time.valueOf(horaInicio + ":00");
        Time horaFinTime = Time.valueOf(horaFin + ":00");
        return horaInicioTime.before(horaFinTime);
    }

    /**
     * Rellena el ComboBox de prioridades con los nombres de las prioridades
     * contenidas en la lista de prioridades proporcionada, y actualiza el mapa
     * de prioridades en el maper.
     *
     * @param listaPrioridades la lista de prioridades a utilizar
     */
    private void RellenarPrioridades(LinkedList<Prioridad> listaPrioridades) {
        // Actualiza el mapa de prioridades en el maper
        maper.ActualizarMapaPrioridades(listaPrioridades);

        // Añade cada prioridad de la lista al ComboBox de prioridades
        listaPrioridades.forEach((p) -> {
            jComboBoxPrioridad.addItem(p.getNombre());
        });
    }

    /**
     * Rellena el JComboBox de lugares con los elementos de la lista de lugares
     * proporcionada y actualiza el mapa de lugares en el maper.
     *
     * @param listaLugares La lista de lugares a mostrar en el JComboBox.
     */
    private void RellenarLugares(LinkedList<Lugar> listaLugares) {
        maper.ActualizarMapaLugares(listaLugares);
        listaLugares.forEach((lugar) -> {
            jComboBoxLugar.addItem(lugar.getNombre());
        });
    }

    /**
     * Genera una nueva instancia de Tarea desde los campos del formulario.
     *
     * @return la nueva instancia de tarea.
     */
    private Tarea generarTareaDelFormulario() {
        String nombre = jTextFieldNombreTarea.getText();
        Color backgroundcolor = jPanelColor.getBackground();
        String color = String.format("#%06x", backgroundcolor.getRGB() & 0xFFFFFF);

        String horaDesde = null;
        String horaHasta = null;
        if (jRadioButtonHora.isSelected()) {
            horaDesde = jComboBoxHoraDesde.getSelectedItem().toString() + ":" + jComboBoxMinDesde.getSelectedItem().toString();
            horaHasta = jComboBoxHoraHasta.getSelectedItem().toString() + ":" + jComboBoxMinHasta.getSelectedItem().toString();

            if (!comprobarHoras(horaDesde, horaHasta)) {
                JOptionPane.showMessageDialog(rootPane, "las horas no son válidas");
                return null;
            }
        }

        int lugarId = (int) Menu.maper.getMapaLugares().get(jComboBoxLugar.getSelectedItem().toString());

        int PrioridadId = 0;
        if (jRadioButtonPrioridad.isSelected()) {
            PrioridadId = (int) Menu.maper.getMapaPrioridades().get(jComboBoxPrioridad.getSelectedItem().toString());
        }

        Date date = null;
        boolean guardada = true;
        if (jDatePicker1.isVisible()) {
            guardada = false;
            java.util.Calendar calendar = (java.util.Calendar) jDatePicker1.getModel().getValue();
            if (calendar != null) {
                date = new java.sql.Date(calendar.getTime().getTime());
            }
        }

        return new Tarea(nombre, color, (java.sql.Date) date, lugarId, PrioridadId, guardada, Menu.usuario.getGrupo(), null, horaDesde, horaHasta, Menu.usuario.getNombre() + " " + Menu.usuario.getApellidos());
    }

    /**
     * Este método se encarga de rellenar los datos de una tarea en los campos
     * correspondientes del formulario.
     *
     * @param tarea la tarea cuyos datos se van a rellenar en el formulario.
     */
    private void RellenarDatosTarea(Tarea tarea) {
        jTextFieldNombreTarea.setText(tarea.getNombre());
        colorTarea = Color.decode(tarea.getColor());
        jPanelColor.setBackground(colorTarea);
        if (tarea.getPrioridad() == 0) {
            jRadioButtonHora.setSelected(true);
            jComboBoxHoraDesde.setSelectedItem(tarea.getHoraInicio().substring(0, 2));
            jComboBoxMinDesde.setSelectedItem(tarea.getHoraInicio().substring(3));
            jComboBoxHoraHasta.setSelectedItem(tarea.getHoraFin().substring(0, 2));
            jComboBoxMinHasta.setSelectedItem(tarea.getHoraFin().substring(3));
        } else {
            jRadioButtonPrioridad.setSelected(true);
            maper.getListaPrioridades().forEach((prioridad) -> {
                if (prioridad.getId() == tarea.getPrioridad()) {
                    jComboBoxPrioridad.setSelectedItem(prioridad.getNombre());
                }
            });
        }
        maper.getListaLugares().forEach((lugar) -> {
            if (lugar.getId() == tarea.getLugar()) {
                jComboBoxLugar.setSelectedItem(lugar.getNombre());
            }
        });
    }
}
