package pfg.Dialogs;

import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import pfg.ConectorDB;
import pfg.Menu;
import servidorprueba.Persona;

/**
 * Clase que representa una ventana para ver los detalles de un objeto Persona.
 *
 * Se utiliza para mostrar la información de una persona y permitir su edición
 * en caso de que el usuario sea administrador o la persona sea el propio
 * usuario.
 */
public class VentanaDetallesPersonal extends javax.swing.JDialog {

    private Persona persona;

    /**
     * Constructor que crea una nueva instancia de la ventana para mostrar los
     * detalles de una persona.
     *
     * @param parent Objeto Frame que representa la ventana padre.
     * @param modal Booleano que indica si la ventana debe ser modal o no.
     */
    public VentanaDetallesPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Constructor que crea una nueva instancia de la ventana para mostrar y
     * editar los detalles de una persona.
     *
     * @param parent Objeto Frame que representa la ventana padre.
     * @param modal Booleano que indica si la ventana debe ser modal o no.
     * @param persona Objeto Persona que se va a mostrar y/o editar.
     * @param esAdmin Booleano que indica si el usuario es administrador o no.
     */
    public VentanaDetallesPersonal(java.awt.Frame parent, boolean modal, Persona persona, boolean esAdmin) {
        super(parent, modal);
        initComponents();
        this.persona = persona;
        jTextFieldNombre.setText(persona.getNombre());
        jTextFieldApellidos.setText(persona.getApellidos());
        jLabelEditador.setText(persona.getEditadoPor());
        jTextFieldEmail.setText(persona.getEmail());
        jTextFieldNombreUsuario.setText(persona.getNombreUsuario());
        jTextFieldPass.setText(persona.getPass());
        jTextFieldTelefonos.setText(persona.getTelefono());
        jTextFieldNombre.setEditable(false);
        jTextFieldApellidos.setEditable(false);
        jTextFieldNombreUsuario.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldTelefonos.setEditable(false);
        jTextFieldPass.setEditable(false);
        if (esAdmin || persona == Menu.usuario) {
            jTextFieldNombre.setEditable(true);
            jTextFieldApellidos.setEditable(true);
            jTextFieldNombreUsuario.setEditable(true);
            jTextFieldEmail.setEditable(true);
            jTextFieldTelefonos.setEditable(true);
            jTextFieldPass.setEditable(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelefonos = new javax.swing.JTextField();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jTextFieldPass = new javax.swing.JTextField();
        jButtonActualizarPersonal = new javax.swing.JButton();
        jLabelEditador = new javax.swing.JLabel();
        jButtonEliminarPersonal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaDetallesPersonal.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jTextFieldNombre.setText(resourceMap.getString("jTextFieldNombre.text")); // NOI18N
        jTextFieldNombre.setName("jTextFieldNombre"); // NOI18N

        jTextFieldApellidos.setText(resourceMap.getString("jTextFieldApellidos.text")); // NOI18N
        jTextFieldApellidos.setName("jTextFieldApellidos"); // NOI18N

        jTextFieldEmail.setText(resourceMap.getString("jTextFieldEmail.text")); // NOI18N
        jTextFieldEmail.setName("jTextFieldEmail"); // NOI18N

        jTextFieldTelefonos.setText(resourceMap.getString("jTextFieldTelefonos.text")); // NOI18N
        jTextFieldTelefonos.setName("jTextFieldTelefonos"); // NOI18N

        jTextFieldNombreUsuario.setText(resourceMap.getString("jTextFieldNombreUsuario.text")); // NOI18N
        jTextFieldNombreUsuario.setName("jTextFieldNombreUsuario"); // NOI18N

        jTextFieldPass.setText(resourceMap.getString("jTextFieldPass.text")); // NOI18N
        jTextFieldPass.setName("jTextFieldPass"); // NOI18N

        jButtonActualizarPersonal.setText(resourceMap.getString("jButtonActualizarPersonal.text")); // NOI18N
        jButtonActualizarPersonal.setName("jButtonActualizarPersonal"); // NOI18N
        jButtonActualizarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarPersonalActionPerformed(evt);
            }
        });

        jLabelEditador.setText(resourceMap.getString("jLabelEditador.text")); // NOI18N
        jLabelEditador.setName("jLabelEditador"); // NOI18N

        jButtonEliminarPersonal.setText(resourceMap.getString("jButtonEliminarPersonal.text")); // NOI18N
        jButtonEliminarPersonal.setName("jButtonEliminarPersonal"); // NOI18N
        jButtonEliminarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(jTextFieldPass))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEditador))
                            .addComponent(jButtonEliminarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonActualizarPersonal)
                        .addGap(47, 47, 47)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelEditador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizarPersonal)
                    .addComponent(jButtonEliminarPersonal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarPersonalActionPerformed
        RellenarPersona();
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return ConectorDB.ActualizarPersonal(persona);
            }

            @Override
            protected void done() {
                try {
                    if (get()) {
                        dispose();
                    } else {
                        JOptionPane.showConfirmDialog(rootPane, "No se pudo conectar con la base de datos\nintentelo mas tarde");
                    }
                } catch (ExecutionException | InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        };
        worker.execute();
    }//GEN-LAST:event_jButtonActualizarPersonalActionPerformed

    private void jButtonEliminarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPersonalActionPerformed
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return ConectorDB.EliminarPersonal(persona);
            }

            @Override
            protected void done() {
                try {
                    if (get()) {
                        dispose();
                    } else {
                        JOptionPane.showConfirmDialog(rootPane, "No se pudo conectar con la base de datos\nintentelo mas tarde");
                    }
                } catch (ExecutionException ex) {
                    System.err.println(ex.getMessage());
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        };
        worker.execute();
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
            java.util.logging.Logger.getLogger(VentanaDetallesPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaDetallesPersonal dialog = new VentanaDetallesPersonal(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonActualizarPersonal;
    private javax.swing.JButton jButtonEliminarPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelEditador;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldPass;
    private javax.swing.JTextField jTextFieldTelefonos;
    // End of variables declaration//GEN-END:variables

    /**
     * Rellena el objeto Persona con los datos actuales en los campos.
     */
    private void RellenarPersona() {
        persona.setNombre(jTextFieldNombre.getText());
        persona.setApellidos(jTextFieldApellidos.getText());
        persona.setNombreUsuario(jTextFieldNombreUsuario.getText());
        persona.setEmail(jTextFieldEmail.getText());
        persona.setEditadoPor(Menu.usuario.getNombre() + " " + Menu.usuario.getApellidos());
        persona.setPass(jTextFieldPass.getText());
        persona.setTelefono(jTextFieldTelefonos.getText());
    }
}
