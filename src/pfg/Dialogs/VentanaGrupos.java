package pfg.Dialogs;

import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pfg.ConectorDB;
import pfg.Maper;
import servidorprueba.Grupo;

/**
 *
 * @author angel
 */
public class VentanaGrupos extends javax.swing.JDialog {

    private DefaultListModel listaGrupos;
    private Maper maper;

    public VentanaGrupos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

    }

    /**
     * Creates new form VentanaGrupos
     *
     * @param parent
     * @param modal
     * @param maper
     */
    public VentanaGrupos(java.awt.Frame parent, boolean modal, Maper maper) {
        super(parent, modal);
        this.maper = maper;
        initComponents();
        RellenarGrupos(maper.getListaGrupos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonCrearGrupo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListGrupos = new javax.swing.JList<>();
        jButtonEliminarGrupos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaGrupos.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabelName.setText(resourceMap.getString("jLabelName.text")); // NOI18N
        jLabelName.setName("jLabelName"); // NOI18N

        jTextFieldNombre.setText(resourceMap.getString("jTextFieldNombre.text")); // NOI18N
        jTextFieldNombre.setName("jTextFieldNombre"); // NOI18N

        jButtonCrearGrupo.setText(resourceMap.getString("jButtonCrearGrupo.text")); // NOI18N
        jButtonCrearGrupo.setName("jButtonCrearGrupo"); // NOI18N
        jButtonCrearGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearGrupoActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jListGrupos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jListGrupos.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP)); // NOI18N
        jListGrupos.setName("jListGrupos"); // NOI18N
        jScrollPane1.setViewportView(jListGrupos);

        jButtonEliminarGrupos.setText(resourceMap.getString("jButtonEliminarGrupos.text")); // NOI18N
        jButtonEliminarGrupos.setName("jButtonEliminarGrupos"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCrearGrupo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jButtonEliminarGrupos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCrearGrupo))
                    .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarGrupos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearGrupoActionPerformed
        if (jTextFieldNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor introduzca un nombre.");
            return;
        }
        if (ComprobarNombre()) {
            JOptionPane.showMessageDialog(rootPane, "Ya existe un grupo con ese nombre.");
            return;
        }
        if (ConectorDB.CrearGrupo(jTextFieldNombre.getText())) {
            maper.ActualizarMapaGrupos(ConectorDB.BuscarGrupos());
            RellenarGrupos(maper.getListaGrupos());
        } else {
            JOptionPane.showMessageDialog(rootPane, "No pudo conectase con la base de datos\n porfavor intentelo más tarde.");
        }
    }//GEN-LAST:event_jButtonCrearGrupoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            VentanaGrupos dialog = new VentanaGrupos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCrearGrupo;
    private javax.swing.JButton jButtonEliminarGrupos;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JList<String> jListGrupos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param BuscarGrupos
     */
    private void RellenarGrupos(LinkedList<Grupo> BuscarGrupos) {
        listaGrupos = new DefaultListModel();
        BuscarGrupos.forEach((grupo) -> {
            listaGrupos.addElement(grupo.getGrupoNombre());
        });
        jListGrupos.setModel(listaGrupos);
    }

    /**
     *
     * @return
     */
    private boolean ComprobarNombre() {
        for (Grupo grupo : maper.getListaGrupos()) {
            if (jTextFieldNombre.getText().equals(grupo.getGrupoNombre())) {
                return true;
            }
        }
        return false;
    }
}
