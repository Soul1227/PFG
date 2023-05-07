package pfg.Dialogs;

import java.util.LinkedList;
import javax.swing.SwingWorker;
import pfg.ConectorDB;
import pfg.Menu;
import servidorprueba.Grupo;
import servidorprueba.Persona;

/**
 * La clase VentanaCrearPersonal representa una ventana de diálogo para crear
 * personal.
 *
 * Esta ventana permite al usuario crear un nuevo perfil de personal.
 */
public class VentanaCrearPersonal extends javax.swing.JDialog {

    private int grupo;
    private LinkedList<Grupo> listagrupos;

    /**
     * Constructor para crear la ventana de diálogo CrearPersonal.
     *
     * @param parent La ventana padre a la que está asociada esta ventana.
     * @param modal Booleano que indica si la ventana es modal o no.
     */
    public VentanaCrearPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Constructor para crear la ventana de diálogo CrearPersonal.
     *
     * @param parent - El marco principal de la ventana de diálogo.
     * @param modal - Especifica si la ventana de diálogo debe ser modal o no.
     * @param listagrupos - Lista de grupos disponibles.
     * @throws IllegalArgumentException si alguno de los parámetros de entrada
     * es inválido.
     */
    public VentanaCrearPersonal(java.awt.Frame parent, boolean modal, LinkedList<Grupo> listagrupos) throws IllegalArgumentException {
        super(parent, modal);
        if (listagrupos == null || listagrupos.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        this.listagrupos = listagrupos;
        initComponents();
        initializeUIComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTelefonos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPass = new javax.swing.JTextField();
        jButtonCrear = new javax.swing.JButton();
        jCheckBoxEsAdministrador = new javax.swing.JCheckBox();
        jComboBoxGrupos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaCrearPersonal.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jTextFieldNombre.setName("jTextFieldNombre"); // NOI18N

        jTextFieldApellidos.setName("jTextFieldApellidos"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jTextFieldEmail.setName("jTextFieldEmail"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jTextFieldTelefonos.setName("jTextFieldTelefonos"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jTextFieldNombreUsuario.setName("jTextFieldNombreUsuario"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jTextFieldPass.setName("jTextFieldPass"); // NOI18N

        jButtonCrear.setText(resourceMap.getString("jButtonCrear.text")); // NOI18N
        jButtonCrear.setName("jButtonCrear"); // NOI18N
        jButtonCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCrearMouseClicked(evt);
            }
        });

        jCheckBoxEsAdministrador.setText(resourceMap.getString("jCheckBoxEsAdministrador.text")); // NOI18N
        jCheckBoxEsAdministrador.setName("jCheckBoxEsAdministrador"); // NOI18N
        jCheckBoxEsAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEsAdministradorActionPerformed(evt);
            }
        });

        jComboBoxGrupos.setName("jComboBoxGrupos"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTelefonos))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldApellidos)
                                    .addComponent(jTextFieldEmail)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNombreUsuario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(jTextFieldPass)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxEsAdministrador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCrear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTelefonos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxEsAdministrador)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCrear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxEsAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEsAdministradorActionPerformed
        if (jCheckBoxEsAdministrador.isSelected()) {
            jComboBoxGrupos.setEnabled(true);
        } else {
            jComboBoxGrupos.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxEsAdministradorActionPerformed

    private void jButtonCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCrearMouseClicked
         SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return ConectorDB.CrearEmpleado(TomaDatosDeLosCampos());
            }

            @Override
            protected void done() {
                jButtonCrear.setEnabled(true);
                dispose();
            }
        };
        jButtonCrear.setEnabled(false);
        worker.execute();
    }//GEN-LAST:event_jButtonCrearMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaCrearPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            VentanaCrearPersonal dialog = new VentanaCrearPersonal(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    /**
     * Recorre los campos, crea y devuelve un objeto persona.
     * @return Persona con los datos de los campos.
     */
    private Persona TomaDatosDeLosCampos() {
        String nombre = jTextFieldNombre.getText().trim();
        String apellidos = jTextFieldApellidos.getText().trim();
        String nombreUsuario = jTextFieldNombreUsuario.getText().trim();
        String pass = jTextFieldPass.getText().trim();
        String email = jTextFieldEmail.getText().trim();
        String telefonos = jTextFieldTelefonos.getText().trim();
        if (nombre.isEmpty() || apellidos.isEmpty() || nombreUsuario.isEmpty() || pass.isEmpty() || email.isEmpty()) {
            throw new IllegalArgumentException("Por favor ingrese todos los campos obligatorios.");
        }

        if (jCheckBoxEsAdministrador.isSelected()) {
            for (Grupo g : listagrupos) {
                if (jComboBoxGrupos.getSelectedItem().toString().equals(g.getGrupoNombre())) {
                    setGrupo(g.getGrupoId());
                }
            }
        } else {
            grupo = Menu.usuario.getGrupo();
        }
        Persona nuevoUsuario = new Persona(nombre, apellidos, nombreUsuario, pass, email, telefonos,
                jCheckBoxEsAdministrador.isSelected(), grupo, Menu.usuario.getNombre());
        return nuevoUsuario;
    }

    /**
     * Inicializa los componentes de la interfaz de usuario de la ventana de
     * diálogo.
     */
    private void initializeUIComponents() {
        this.setTitle("Crear Personal");
        jCheckBoxEsAdministrador.setSelected(false);
        for (Grupo grupo : listagrupos) {
            jComboBoxGrupos.addItem(grupo.getGrupoNombre());
        }
        jComboBoxGrupos.setEnabled(false);
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public LinkedList<Grupo> getListagrupos() {
        return listagrupos;
    }

    public void setListagrupos(LinkedList<Grupo> listagrupos) {
        this.listagrupos = listagrupos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JCheckBox jCheckBoxEsAdministrador;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldPass;
    private javax.swing.JTextField jTextFieldTelefonos;
    // End of variables declaration//GEN-END:variables

}
