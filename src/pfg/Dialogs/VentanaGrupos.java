package pfg.Dialogs;

import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pfg.ConectorDB;
import pfg.Maper;
import pfg.Menu;
import servidorprueba.Grupo;
import servidorprueba.Persona;

/**
 * La clase VentanaGrupos representa una ventana de diálogo para mostrar una
 * lista de grupos.
 */
public class VentanaGrupos extends javax.swing.JDialog {

    private DefaultListModel listaGrupos;
    private Maper maper;

    /**
     * Crea una nueva instancia de la clase VentanaGrupos.
     *
     * @param parent el JFrame padre de la ventana.
     * @param modal un indicador de si la ventana es modal o no.
     */
    public VentanaGrupos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

    }

    /**
     * Crea una nueva instancia de la clase VentanaGrupos.
     *
     * @param parent el JFrame padre de la ventana.
     * @param modal un indicador de si la ventana es modal o no.
     * @param maper el objeto Maper que se utiliza para obtener la lista de
     * grupos.
     */
    public VentanaGrupos(java.awt.Frame parent, boolean modal, Maper maper) {
        super(parent, modal);
        this.maper = maper;
        initComponents();
        this.setTitle("Grupos");
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
        jButtonCrearGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCrearGrupoMouseClicked(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jListGrupos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jListGrupos.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP)); // NOI18N
        jListGrupos.setName("jListGrupos"); // NOI18N
        jScrollPane1.setViewportView(jListGrupos);

        jButtonEliminarGrupos.setText(resourceMap.getString("jButtonEliminarGrupos.text")); // NOI18N
        jButtonEliminarGrupos.setName("jButtonEliminarGrupos"); // NOI18N
        jButtonEliminarGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarGruposMouseClicked(evt);
            }
        });

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

    private void jButtonCrearGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCrearGrupoMouseClicked
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
    }//GEN-LAST:event_jButtonCrearGrupoMouseClicked

    private void jButtonEliminarGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarGruposMouseClicked
        if (ConfirmarEliminarGrupo()) {
            LinkedList<Integer> gruposSeleccionados = GruposSeleccionados();
            for (Integer gruposSeleccionado : gruposSeleccionados) {
                if (SePuedeEliminarGrupo(gruposSeleccionado) && Menu.usuario.getGrupo() == gruposSeleccionado) {
                    EliminarAdministradoresEnTareas(ConectorDB.BuscarPersonal(gruposSeleccionado));
                    EliminarTareasDelGrupo(gruposSeleccionado);
                    EliminarAdmins(gruposSeleccionado);
                    EliminarGrupo(gruposSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No puede ser eliminado un grupo mientras\n haya lugares, empleados o tareas ligados a este.\n Solo puedes eliminar un grupo si perteneces a este.");
                }
            }
            RellenarGrupos(ConectorDB.BuscarGrupos());
        }
    }//GEN-LAST:event_jButtonEliminarGruposMouseClicked

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
     * Rellena la lista de grupos en la ventana con los nombres de los grupos en
     * la lista especificada.
     *
     * @param BuscarGrupos una lista de objetos Grupo cuyos nombres se
     * utilizarán para rellenar la lista de grupos en la ventana.
     */
    private void RellenarGrupos(LinkedList<Grupo> BuscarGrupos) {
        listaGrupos = new DefaultListModel();
        BuscarGrupos.forEach((grupo) -> {
            listaGrupos.addElement(grupo.getGrupoNombre());
        });
        jListGrupos.setModel(listaGrupos);
    }

    /**
     * Comprueba si el nombre del grupo introducido en el campo de texto ya
     * existe en la lista de grupos obtenida del objeto Maper.
     *
     * @return true si el nombre del grupo ya existe en la lista de grupos,
     * false de lo contrario.
     */
    private boolean ComprobarNombre() {
        for (Grupo grupo : maper.getListaGrupos()) {
            if (jTextFieldNombre.getText().equals(grupo.getGrupoNombre())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra un cuadro de diálogo de confirmación para pedir al usuario que
     * confirme si desea eliminar el grupo seleccionado.
     *
     * @return true si el usuario confirma que desea eliminar el grupo
     * seleccionado, false si el usuario cancela la operación.
     */
    private boolean ConfirmarEliminarGrupo() {
        int choice = JOptionPane.showConfirmDialog(rootPane, "¿Eliminar al grupo seleccionado?");
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sí el grupo seleccionado no tiene asignado ningún empleado no
     * administrador y tampoco tiene ningún lugar asignado, se eliminaran los
     * administradores que queden asignados a ese grupo y el grupo.
     *
     * @return true si la proceso se ha completado correctamente. false si no.
     */
    private boolean SePuedeEliminarGrupo(int IdGrupo) {
        //Comprobar que ningun usuario sin calidad de administrador esta en el grupo seleccionado.
        if (!ComprobarUsuariosEnGrupo(IdGrupo)) {
            System.out.println("false");
            //Comprobar que ningun lugar esta asignado a el grupo seleccionado.
            if (!ComprobarLugaresDelGrupo(IdGrupo)) {
                //si no ha habido fallo, eliminar los administradores existentes
                //en el grupo y posteriormente al grupo y desloguear.
                System.out.println("false2");
                return true;
            }
            //si no ha habido fallo, eliminar los administradores existentes
            //en el grupo y posteriormente al grupo y desloguear.
        } else {
            System.out.println("true");
            return false;
        }
        return false;
    }

    /**
     * Comprueba si hay usuarios que pertenecen al grupo especificado pero que
     * no tienen el rol de administrador en la base de datos.
     *
     * @param IdGrupo el ID del grupo para el cual se comprobará si hay usuarios
     * sin rol de administrador.
     * @return true si hay usuarios en el grupo que no tienen el rol de
     * administrador, false si todos los usuarios en el grupo son
     * administradores.
     */
    private boolean ComprobarUsuariosEnGrupo(int IdGrupo) {
        return ConectorDB.BuscarUsuariosEnGrupoNoAdmin(IdGrupo);
    }

    /**
     * Devuelve la lista de las Ids de los grupos seleccionados.
     *
     * @return LinkedList<Integer> con las ids.
     */
    private LinkedList<Integer> GruposSeleccionados() {
        List<String> GruposSeleccionados = new LinkedList<>();
        LinkedList<Integer> IdGruposSeleccionados = new LinkedList<>();
        GruposSeleccionados = jListGrupos.getSelectedValuesList();
        for (String grupoNombre : GruposSeleccionados) {
            IdGruposSeleccionados.add((int) maper.getMapaGrupos().get(grupoNombre));
        }
        return IdGruposSeleccionados;
    }

    /**
     * Comprueba si el grupo especificado tiene lugares asociados en la base de
     * datos.
     *
     * @param IdGrupo el ID del grupo para el cual se comprobará si hay lugares
     * asociados.
     * @return true si el grupo tiene lugares asociados en la base de datos,
     * false de lo contrario.
     */
    private boolean ComprobarLugaresDelGrupo(int IdGrupo) {
        return ConectorDB.BuscarLugaresParaUnGrupo(IdGrupo);
    }

    /**
     * Elimina el grupo especificado de la base de datos.
     *
     * @param idGrupo el ID del grupo que se eliminará de la base de datos.
     * @return true si se eliminó el grupo correctamente de la base de datos,
     * false de lo contrario.
     */
    private boolean EliminarGrupo(int idGrupo) {
        return ConectorDB.EliminarGrupo(idGrupo);
    }

    /**
     * Elimina a todos los administradores restantes del grupo especificado en
     * la base de datos.
     *
     * @param idGrupo el ID del grupo para el cual se eliminarán los
     * administradores restantes.
     * @return true si se eliminaron los administradores correctamente de la
     * base de datos, false de lo contrario.
     */
    private boolean EliminarAdmins(Integer idGrupo) {
        return ConectorDB.EliminarAdminsDeGrupo(idGrupo);
    }

    /**
     * Eliminar las tareas pertenecientes a un grupo.
     *
     * @param gruposSeleccionado id del grupo
     */
    private boolean EliminarTareasDelGrupo(Integer gruposSeleccionado) {
        return ConectorDB.EliminarTareasDelGrupo(gruposSeleccionado);
    }

    private boolean EliminarAdministradoresEnTareas(LinkedList<Persona> BuscarPersonal) {
        BuscarPersonal.forEach(persona -> {
            ConectorDB.EliminarPersonal(persona);
        });
        return true;
    }
}
