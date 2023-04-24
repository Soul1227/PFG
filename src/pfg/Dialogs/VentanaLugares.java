package pfg.Dialogs;

import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import pfg.ConectorDB;
import pfg.Maper;
import pfg.Menu;
import servidorprueba.Lugar;

/**
 *
 * @author angel
 */
public class VentanaLugares extends javax.swing.JDialog {
    
    private LinkedList<JCheckBox> listaCheckBoxLugares;
    private Maper maper;

    /**
     * Creates new form VentanaLugares
     *
     * @param parent
     * @param modal
     */
    public VentanaLugares(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     *
     * @param parent
     * @param modal
     * @param maper
     */
    public VentanaLugares(java.awt.Frame parent, boolean modal, Maper maper) {
        super(parent, modal);
        this.maper = maper;
        listaCheckBoxLugares = new LinkedList<>();
        initComponents();
        RellenarListaLugares(this.maper.getListaLugares());
        MarcarLugaresDelGrupo(ConectorDB.BuscarLugaresDeUsuario(Menu.usuario.getGrupo()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jButtonCrearLugar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanelLugares = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(VentanaLugares.class);
        jLabelNombre.setText(resourceMap.getString("jLabelNombre.text")); // NOI18N
        jLabelNombre.setName("jLabelNombre"); // NOI18N

        jLabelDireccion.setText(resourceMap.getString("jLabelDireccion.text")); // NOI18N
        jLabelDireccion.setName("jLabelDireccion"); // NOI18N

        jTextFieldNombre.setText(resourceMap.getString("jTextFieldNombre.text")); // NOI18N
        jTextFieldNombre.setName("jTextFieldNombre"); // NOI18N

        jTextFieldDireccion.setText(resourceMap.getString("jTextFieldDireccion.text")); // NOI18N
        jTextFieldDireccion.setName("jTextFieldDireccion"); // NOI18N

        jButtonCrearLugar.setText(resourceMap.getString("jButtonCrearLugar.text")); // NOI18N
        jButtonCrearLugar.setName("jButtonCrearLugar"); // NOI18N
        jButtonCrearLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearLugarActionPerformed(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jPanelLugares.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanelLugares.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP)); // NOI18N
        jPanelLugares.setName("jPanelLugares"); // NOI18N

        javax.swing.GroupLayout jPanelLugaresLayout = new javax.swing.GroupLayout(jPanelLugares);
        jPanelLugares.setLayout(jPanelLugaresLayout);
        jPanelLugaresLayout.setHorizontalGroup(
            jPanelLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelLugaresLayout.setVerticalGroup(
            jPanelLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelLugares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDireccion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jButtonCrearLugar)))
                                .addContainerGap(113, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButtonCrearLugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelLugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearLugarActionPerformed
        if (!ComprobarNombre()) {
            String nombre = jTextFieldNombre.getText();
            String direccion = jTextFieldDireccion.getText();
            CrearNuevoLugar(nombre, direccion);
            maper.ActualizarMapaLugares(ConectorDB.BuscarLugares());
            RellenarListaLugares(maper.getListaLugares());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ya existe un grupo con ese nombre.");
        }
    }//GEN-LAST:event_jButtonCrearLugarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            VentanaLugares dialog = new VentanaLugares(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCrearLugar;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanelLugares;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param ResultadoLugares
     */
    private void RellenarListaLugares(LinkedList<Lugar> ResultadoLugares) {
        jPanelLugares.setLayout(new BoxLayout(jPanelLugares, BoxLayout.Y_AXIS));
        for (Lugar lugar : ResultadoLugares) {
            JCheckBox box = new JCheckBox();
            box.setText(lugar.getNombre());
            listaCheckBoxLugares.add(box);
            jPanelLugares.add(box);
        }
        jPanelLugares.updateUI();
    }

    /**
     *
     * @return
     */
    private boolean ComprobarNombre() {
        for (Lugar lugar : maper.getListaLugares()) {
            if (jTextFieldNombre.getText().equals(lugar.getNombre())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param nombre
     * @param direccion
     */
    private void CrearNuevoLugar(String nombre, String direccion) {
        Lugar nuevoLugar = new Lugar(0, nombre, direccion);
        ConectorDB.CrearNuevoLugar(nuevoLugar);
    }

    /**
     * Marca los lugares pasados por parametros.
     */
    private void MarcarLugaresDelGrupo(LinkedList<Lugar> lugares) {
        for (Lugar lugar : lugares) {
            for (JCheckBox box : listaCheckBoxLugares) {
                if (lugar.getNombre().equals(box.getText())) {
                    box.setSelected(true);
                }
            }
        }
    }
    
}
