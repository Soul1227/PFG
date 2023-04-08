package pfg.paneles;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import pfg.Dialogs.DetallesPersonal;
import javax.swing.JDialog;
import pfg.Menu;
import servidorprueba.Persona;

/**
 *
 * @author angel
 */
public class EtiquetaPersonal extends javax.swing.JPanel {

    private Persona persona;
    private boolean chequeable;
    private Menu menu;

    /**
     * Creates new form PanelPersonal
     */
    public EtiquetaPersonal() {
        initComponents();
    }

    /**
     *
     * @param persona
     */
    public EtiquetaPersonal(Persona persona) {
        initComponents();
        this.persona = persona;
        jLabelNombreUsuario.setText(persona.getNombre() + " " + persona.getApellidos());
        jLabelTelefono.setText(persona.getTelefono());
        jLabelEmail.setText(persona.getEmail());
    }

    public EtiquetaPersonal(Persona persona, boolean chequeable) {
        initComponents();
        this.persona = persona;
        this.chequeable = chequeable;
        jLabelNombreUsuario.setText(persona.getNombre() + " " + persona.getApellidos());
        jLabelTelefono.setText(persona.getTelefono());
        jLabelEmail.setText(persona.getEmail());
        if (!chequeable) {
            jCheckBox1.setVisible(false);
        }
    }

    public EtiquetaPersonal(Persona persona, boolean chequeable, Menu menu) {
        initComponents();
        this.persona = persona;
        this.menu = menu;
        this.chequeable = chequeable;
        jLabelNombreUsuario.setText(persona.getNombre() + " " + persona.getApellidos());
        jLabelTelefono.setText(persona.getTelefono());
        jLabelEmail.setText(persona.getEmail());
        if (!chequeable) {
            jCheckBox1.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setName("Form"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(EtiquetaPersonal.class);
        jLabelTelefono.setText(resourceMap.getString("jLabelTelefono.text")); // NOI18N
        jLabelTelefono.setName("jLabelTelefono"); // NOI18N

        jLabelEmail.setText(resourceMap.getString("jLabelEmail.text")); // NOI18N
        jLabelEmail.setName("jLabelEmail"); // NOI18N

        jLabelNombreUsuario.setText(resourceMap.getString("jLabelNombreUsuario.text")); // NOI18N
        jLabelNombreUsuario.setName("jLabelNombreUsuario"); // NOI18N

        jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreUsuario)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (chequeable) {
            jCheckBox1.setSelected(!jCheckBox1.isSelected());
        } else {
            JDialog detallesPersona = new DetallesPersonal(null, true, persona, Menu.usuario.isEsAdmin());
            detallesPersona.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    menu.CambiarPanel(Menu.Paneles.Personal);
                }
            });
            detallesPersona.setVisible(true);
        }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}