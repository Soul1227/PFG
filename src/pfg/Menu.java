package pfg;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import pfg.Menu.Paneles;
import pfg.Dialogs.VentanaCrearPersonal;
import pfg.Dialogs.VentanaCrearTarea;
import pfg.Dialogs.VentanaDetallesPersonal;
import pfg.paneles.PanelPersonal;
import pfg.paneles.PanelSemana;
import pfg.paneles.PanelTareas;
import servidorprueba.Persona;

/**
 * @author angel
 */
public class Menu extends javax.swing.JFrame {

    public enum Paneles {
        Tareas, Personal, Semana
    };
    public Paneles panelActivo;
    private final Date diaActual;
    private Calendar calendar;
    private final Date[] dias;
    public static Persona usuario;
    public static Maper maper;
    private JPanel panel;

    /**
     * Crea un nuevo Menu.
     *
     * @param usuario Usuario que ha logeado.
     */
    public Menu(Persona usuario) {
        super();
        Menu.usuario = usuario;
        maper = new Maper(usuario.getGrupo());
        panelActivo = Paneles.Semana;
        dias = new Date[7];
        calendar = Calendar.getInstance();
        diaActual = calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        initComponents();
        PrepararInterface(usuario.isEsAdmin());
        TomarFechaDelDia(diaActual);
        ActualizarSemana(true);
        CambiarPanel(Paneles.Semana);
    }

    private Menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanelArriba = new javax.swing.JPanel();
        jPanelLogo = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jButtonAñadirPT = new javax.swing.JButton();
        jPanelMedio = new javax.swing.JPanel();
        jPanelIconos = new javax.swing.JPanel();
        jLabelHome = new javax.swing.JLabel();
        jLabelTareas = new javax.swing.JLabel();
        jLabelPersonal = new javax.swing.JLabel();
        jPanelSemana = new javax.swing.JPanel();
        jLabelFlechaDerecha = new javax.swing.JLabel();
        jLabelSemana = new javax.swing.JLabel();
        jLabelFlechaIzquierda = new javax.swing.JLabel();
        jDatePickerMenu = new org.jdatepicker.JDatePicker();
        jPanelUsuario = new javax.swing.JPanel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jPaneAbajo = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        mainPanel.setName("mainPanel"); // NOI18N

        jPanelArriba.setName("jPanelArriba"); // NOI18N
        jPanelArriba.setLayout(new java.awt.GridLayout(1, 0));

        jPanelLogo.setName("jPanelLogo"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(Menu.class);
        jLabelLogo.setFont(resourceMap.getFont("jLabelLogo.font")); // NOI18N
        jLabelLogo.setIcon(resourceMap.getIcon("jLabelLogo.icon")); // NOI18N
        jLabelLogo.setText(resourceMap.getString("jLabelLogo.text")); // NOI18N
        jLabelLogo.setName("jLabelLogo"); // NOI18N
        jLabelLogo.setPreferredSize(new java.awt.Dimension(120, 50));

        jButtonAñadirPT.setText(resourceMap.getString("jButtonAñadirPT.text")); // NOI18N
        jButtonAñadirPT.setName("jButtonAñadirPT"); // NOI18N
        jButtonAñadirPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirPTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLogoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonAñadirPT, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButtonAñadirPT))
        );

        jPanelArriba.add(jPanelLogo);

        jPanelMedio.setName("jPanelMedio"); // NOI18N

        jPanelIconos.setName("jPanelIconos"); // NOI18N

        jLabelHome.setText(resourceMap.getString("jLabelHome.text")); // NOI18N
        jLabelHome.setName("jLabelHome"); // NOI18N
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
        });
        jPanelIconos.add(jLabelHome);

        jLabelTareas.setText(resourceMap.getString("jLabelTareas.text")); // NOI18N
        jLabelTareas.setName("jLabelTareas"); // NOI18N
        jLabelTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTareasMouseClicked(evt);
            }
        });
        jPanelIconos.add(jLabelTareas);

        jLabelPersonal.setText(resourceMap.getString("jLabelPersonal.text")); // NOI18N
        jLabelPersonal.setName("jLabelPersonal"); // NOI18N
        jLabelPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPersonalMouseClicked(evt);
            }
        });
        jPanelIconos.add(jLabelPersonal);

        jPanelSemana.setName("jPanelSemana"); // NOI18N

        jLabelFlechaDerecha.setText(resourceMap.getString("jLabelFlechaDerecha.text")); // NOI18N
        jLabelFlechaDerecha.setName("jLabelFlechaDerecha"); // NOI18N
        jLabelFlechaDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFlechaDerechaMouseClicked(evt);
            }
        });
        jPanelSemana.add(jLabelFlechaDerecha);

        jLabelSemana.setText(resourceMap.getString("jLabelSemana.text")); // NOI18N
        jLabelSemana.setName("jLabelSemana"); // NOI18N
        jPanelSemana.add(jLabelSemana);

        jLabelFlechaIzquierda.setText(resourceMap.getString("jLabelFlechaIzquierda.text")); // NOI18N
        jLabelFlechaIzquierda.setName("jLabelFlechaIzquierda"); // NOI18N
        jLabelFlechaIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFlechaIzquierdaMouseClicked(evt);
            }
        });
        jPanelSemana.add(jLabelFlechaIzquierda);

        jDatePickerMenu.setName("jDatePickerMenu"); // NOI18N
        jDatePickerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDatePickerMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMedioLayout = new javax.swing.GroupLayout(jPanelMedio);
        jPanelMedio.setLayout(jPanelMedioLayout);
        jPanelMedioLayout.setHorizontalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIconos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMedioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSemana, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMedioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jDatePickerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMedioLayout.setVerticalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMedioLayout.createSequentialGroup()
                .addComponent(jPanelIconos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDatePickerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelArriba.add(jPanelMedio);

        jPanelUsuario.setName("jPanelUsuario"); // NOI18N
        jPanelUsuario.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanelUsuario.setRequestFocusEnabled(false);

        jLabelNombreUsuario.setText(resourceMap.getString("jLabelNombreUsuario.text")); // NOI18N
        jLabelNombreUsuario.setName("jLabelNombreUsuario"); // NOI18N
        jLabelNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNombreUsuarioMouseClicked(evt);
            }
        });

        jButtonActualizar.setText(resourceMap.getString("jButtonActualizar.text")); // NOI18N
        jButtonActualizar.setName("jButtonActualizar"); // NOI18N

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                .addGap(0, 410, Short.MAX_VALUE)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(jButtonActualizar)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabelNombreUsuario)
                        .addContainerGap())))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addComponent(jLabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelArriba.add(jPanelUsuario);

        jPaneAbajo.setMaximumSize(getSize());
        jPaneAbajo.setName("jPaneAbajo"); // NOI18N
        jPaneAbajo.setPreferredSize(new java.awt.Dimension(500, 500));
        jPaneAbajo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelArriba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPaneAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, 1517, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jPanelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getActionMap(Menu.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        fileMenu.add(jMenuItem1);

        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        fileMenu.add(jMenuItem2);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1517, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPersonalMouseClicked
        CambiarPanel(Paneles.Personal);
        jButtonAñadirPT.setVisible(true);
    }//GEN-LAST:event_jLabelPersonalMouseClicked

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
        ActualizarSemana(true);
        CambiarPanel(Paneles.Semana);
        jButtonAñadirPT.setVisible(false);
    }//GEN-LAST:event_jLabelHomeMouseClicked

    private void jLabelTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTareasMouseClicked
        CambiarPanel(Paneles.Tareas);
        jButtonAñadirPT.setVisible(true);
    }//GEN-LAST:event_jLabelTareasMouseClicked

    private void jLabelFlechaIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFlechaIzquierdaMouseClicked
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        ActualizarSemana(false);
        CambiarPanel(Paneles.Semana);
        jButtonAñadirPT.setVisible(false);
    }//GEN-LAST:event_jLabelFlechaIzquierdaMouseClicked

    private void jLabelFlechaDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFlechaDerechaMouseClicked
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        ActualizarSemana(false);
        CambiarPanel(Paneles.Semana);
        jButtonAñadirPT.setVisible(false);
    }//GEN-LAST:event_jLabelFlechaDerechaMouseClicked

    private void jLabelNombreUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNombreUsuarioMouseClicked
        JDialog detallesPersona = new VentanaDetallesPersonal(null, true, Menu.usuario, Menu.usuario.isEsAdmin());
        detallesPersona.setVisible(true);
    }//GEN-LAST:event_jLabelNombreUsuarioMouseClicked

    private void jButtonAñadirPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirPTActionPerformed
        if (panelActivo == Paneles.Tareas) {
            VentanaCrearTarea ventanaCrearTarea = new VentanaCrearTarea(this, true, null, ConectorDB.BuscarLugaresDeUsuario(usuario.getGrupo()));
            ventanaCrearTarea.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    CambiarPanel(panelActivo);
                }
            });
            ventanaCrearTarea.setVisible(true);
        } else if (panelActivo == Paneles.Personal) {
            VentanaCrearPersonal ventanaCrearPersonal = new VentanaCrearPersonal(this, true, ConectorDB.BuscarGrupos());
            ventanaCrearPersonal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    CambiarPanel(panelActivo);
                }
            });
            ventanaCrearPersonal.setVisible(true);
        }
    }//GEN-LAST:event_jButtonAñadirPTActionPerformed

    private void jDatePickerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDatePickerMenuActionPerformed
        Calendar selectedValue = (Calendar) jDatePickerMenu.getModel().getValue();
        ActualizarSemana(selectedValue);
        CambiarPanel(Paneles.Semana);
    }//GEN-LAST:event_jDatePickerMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    /**
     *
     * @param bool
     */
    private void ActualizarSemana(boolean bool) {
        StringBuilder textoSemana = new StringBuilder();
        DateFormat df = new SimpleDateFormat("dd/MMMMM");
        textoSemana.append("Semana ");
        textoSemana.append(df.format(calendar.getTime())).append(" - ");
        dias[0] = calendar.getTime();
        for (int i = 1; i <= 6; i++) {
            calendar.add(Calendar.DATE, 1);
            dias[i] = calendar.getTime();
        }
        textoSemana.append(df.format(calendar.getTime()));
        jLabelSemana.setText(textoSemana.toString());
        if (bool) {
            calendar.setTime(diaActual);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    /**
     *
     * @param calendar
     */
    private void ActualizarSemana(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        StringBuilder textoSemana = new StringBuilder();
        DateFormat df = new SimpleDateFormat("dd/MMMMM");
        textoSemana.append("Semana ");
        textoSemana.append(df.format(calendar.getTime())).append(" - ");
        dias[0] = calendar.getTime();
        for (int i = 1; i <= 6; i++) {
            calendar.add(Calendar.DATE, 1);
            dias[i] = calendar.getTime();
        }
        textoSemana.append(df.format(calendar.getTime()));
        jLabelSemana.setText(textoSemana.toString());
    }

    /**
     * Metodo que prepara la interfaz de usuario en base a si el usuario es
     * administrador o no.
     *
     * @param isAdmin Booleano que designa si el usuario es admin o no.
     */
    private void PrepararInterface(boolean isAdmin) {
        ImageIcon imageFDerecha = new ImageIcon(new ImageIcon(".\\iconos\\chevronright.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageFIzquierda = new ImageIcon(new ImageIcon(".\\iconos\\chevronleft.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageHome = new ImageIcon(new ImageIcon(".\\iconos\\home.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        jLabelFlechaDerecha.setIcon(imageFIzquierda);
        jLabelFlechaIzquierda.setIcon(imageFDerecha);
        jLabelFlechaDerecha.setText("");
        jLabelFlechaIzquierda.setText("");
        jButtonAñadirPT.setVisible(false);
        jLabelHome.setText("");
        jLabelHome.setIcon(imageHome);
        jLabelNombreUsuario.setText(usuario.getNombre() + " " + usuario.getApellidos());
        if (isAdmin) {
            ImageIcon imagePersonal = new ImageIcon(new ImageIcon(".\\iconos\\staff.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            ImageIcon imageTareas = new ImageIcon(new ImageIcon(".\\iconos\\tasks.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            jLabelPersonal.setText("");
            jLabelTareas.setText("");
            jLabelPersonal.setIcon(imagePersonal);
            jLabelTareas.setIcon(imageTareas);
        } else {
            jPanelIconos.remove(jLabelPersonal);
            jPanelIconos.remove(jLabelTareas);
        }
    }

    /**
     * Cambia el panel activo en el frame principal según el tipo de panel
     * especificado.
     *
     * @param panelTipo El tipo de panel a activar.
     */
    public void CambiarPanel(Paneles panelTipo) {
        jPaneAbajo.removeAll();
        switch (panelTipo) {
            case Semana:
                panel = CrearPanelSemana();
                break;
            case Tareas:
                panel = CrearPanelTareas();
                break;
            case Personal:
                panel = CrearPanelPersonal();
                break;
        }
        panel.setSize(jPaneAbajo.getWidth(), jPaneAbajo.getHeight());
        jPaneAbajo.add(panel);
        jPaneAbajo.updateUI();
    }

    /**
     * Crea y devuelve un nuevo PanelPersonal.
     *
     * @return Un nuevo PanelPersonal.
     */
    private PanelPersonal CrearPanelPersonal() {
        panelActivo = Paneles.Personal;
        return new PanelPersonal(ConectorDB.BuscarPersonal(usuario.getGrupo()), this);
    }

    /**
     * Crea y devuelve un nuevo PanelTareas.
     *
     * @return Un nuevo PanelTareas.
     */
    private PanelTareas CrearPanelTareas() {
        panelActivo = Paneles.Tareas;
        return new PanelTareas(ConectorDB.BuscarTareasGuardadas());
    }

    /**
     * Crea y devuelve un nuevo PanelSemana.
     *
     * @return Un nuevo PanelSemana.
     */
    private PanelSemana CrearPanelSemana() {
        panelActivo = Paneles.Semana;
        return new PanelSemana(dias, ConectorDB.BuscarLugaresDeUsuario(usuario.getGrupo()), usuario.isEsAdmin(),this);
    }

    /**
     * Toma una fecha y la utiliza para seleccionar esa fecha en el componente
     * jDatePickerMenu.
     *
     * @param fecha la fecha que se va a seleccionar en el jDatePickerMenu. Debe
     * ser un objeto java.util.Date.
     */
    private void TomarFechaDelDia(Date fecha) {
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int dia = localDate.getDayOfMonth();
        int mes = localDate.getMonthValue() - 1;
        int ano = localDate.getYear();
        jDatePickerMenu.getModel().setDate(ano, mes, dia);
        jDatePickerMenu.getModel().setSelected(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAñadirPT;
    private org.jdatepicker.JDatePicker jDatePickerMenu;
    private javax.swing.JLabel jLabelFlechaDerecha;
    private javax.swing.JLabel jLabelFlechaIzquierda;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelPersonal;
    private javax.swing.JLabel jLabelSemana;
    private javax.swing.JLabel jLabelTareas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPaneAbajo;
    private javax.swing.JPanel jPanelArriba;
    private javax.swing.JPanel jPanelIconos;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelMedio;
    private javax.swing.JPanel jPanelSemana;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
