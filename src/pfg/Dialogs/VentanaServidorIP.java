package pfg.Dialogs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import pfg.ControladorIP;

/**
 *
 * @author angel
 */
public class VentanaServidorIP extends javax.swing.JDialog {

    /**
     * Creates new form VentanaServidorIP
     *
     * @param parent
     * @param modal
     */
    public VentanaServidorIP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        MostrarIPServidor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIPServidor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonGuardarIP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaServidorIP.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jTextFieldIPServidor.setText(resourceMap.getString("jTextFieldIPServidor.text")); // NOI18N
        jTextFieldIPServidor.setName("jTextFieldIPServidor"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButtonGuardarIP.setText(resourceMap.getString("jButtonGuardarIP.text")); // NOI18N
        jButtonGuardarIP.setName("jButtonGuardarIP"); // NOI18N
        jButtonGuardarIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextFieldIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonGuardarIP)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardarIP)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarIPActionPerformed
        GuardarIP();
    }//GEN-LAST:event_jButtonGuardarIPActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaServidorIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaServidorIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaServidorIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaServidorIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            VentanaServidorIP dialog = new VentanaServidorIP(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonGuardarIP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldIPServidor;
    // End of variables declaration//GEN-END:variables

    /**
     * Toma el valor del archivo "ServerIP.txt" y lo pone en el
     * jTextFieldIPServidor.
     */
    private void MostrarIPServidor() {
        if (ControladorIP.getArchivoIP().exists()) {
            try {
                FileReader fr = new FileReader(ControladorIP.getArchivoIP());
                BufferedReader br = new BufferedReader(fr);
                jTextFieldIPServidor.setText(br.readLine());
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void GuardarIP() {
        ControladorIP.GuardarNuevaIP(jTextFieldIPServidor.getText());
    }
}
