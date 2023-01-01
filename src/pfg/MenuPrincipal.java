/*
 * MenuPrincipal.java
 */
package pfg;

import java.awt.Image;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import pfg.resources.PanelDiaSemana;
import pfg.resources.PanelSemana;

/**
 * The application's main frame.
 */
public class MenuPrincipal extends FrameView {
    
    private final Date diaActual;
    private final Calendar calendar;
    private final Date[] dias; 

    public MenuPrincipal(SingleFrameApplication app) {
        super(app);
        dias = new Date[7];
        calendar = Calendar.getInstance();
        diaActual = calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        initComponents();
        PrepararInterface();
        ActualizarSemana();
        AbrirPanelSemana();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();

                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = PFGApp.getApplication().getMainFrame();
            aboutBox = new PFGAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        PFGApp.getApplication().show(aboutBox);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanelArriba = new javax.swing.JPanel();
        jPanelLogo = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelMedio = new javax.swing.JPanel();
        jPanelIconos = new javax.swing.JPanel();
        jLabelHome = new javax.swing.JLabel();
        jLabelTareas = new javax.swing.JLabel();
        jLabelPersonal = new javax.swing.JLabel();
        jLabelCalendario = new javax.swing.JLabel();
        jPanelSemana = new javax.swing.JPanel();
        jLabelFlechaDerecha = new javax.swing.JLabel();
        jLabelSemana = new javax.swing.JLabel();
        jLabelFlechaIzquierda = new javax.swing.JLabel();
        jPanelUsuario = new javax.swing.JPanel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jPaneAbajo = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        jPanelArriba.setName("jPanelArriba"); // NOI18N
        jPanelArriba.setLayout(new java.awt.GridLayout(1, 0));

        jPanelLogo.setName("jPanelLogo"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(MenuPrincipal.class);
        jLabelLogo.setFont(resourceMap.getFont("jLabelLogo.font")); // NOI18N
        jLabelLogo.setText(resourceMap.getString("jLabelLogo.text")); // NOI18N
        jLabelLogo.setName("jLabelLogo"); // NOI18N
        jLabelLogo.setPreferredSize(new java.awt.Dimension(120, 50));

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelArriba.add(jPanelLogo);

        jPanelMedio.setName("jPanelMedio"); // NOI18N

        jPanelIconos.setName("jPanelIconos"); // NOI18N

        jLabelHome.setText(resourceMap.getString("jLabelHome.text")); // NOI18N
        jLabelHome.setName("jLabelHome"); // NOI18N
        jPanelIconos.add(jLabelHome);

        jLabelTareas.setText(resourceMap.getString("jLabelTareas.text")); // NOI18N
        jLabelTareas.setName("jLabelTareas"); // NOI18N
        jPanelIconos.add(jLabelTareas);

        jLabelPersonal.setText(resourceMap.getString("jLabelPersonal.text")); // NOI18N
        jLabelPersonal.setName("jLabelPersonal"); // NOI18N
        jPanelIconos.add(jLabelPersonal);

        jLabelCalendario.setText(resourceMap.getString("jLabelCalendario.text")); // NOI18N
        jLabelCalendario.setName("jLabelCalendario"); // NOI18N
        jPanelIconos.add(jLabelCalendario);

        jPanelSemana.setName("jPanelSemana"); // NOI18N

        jLabelFlechaDerecha.setText(resourceMap.getString("jLabelFlechaDerecha.text")); // NOI18N
        jLabelFlechaDerecha.setName("jLabelFlechaDerecha"); // NOI18N
        jPanelSemana.add(jLabelFlechaDerecha);

        jLabelSemana.setText(resourceMap.getString("jLabelSemana.text")); // NOI18N
        jLabelSemana.setName("jLabelSemana"); // NOI18N
        jPanelSemana.add(jLabelSemana);

        jLabelFlechaIzquierda.setText(resourceMap.getString("jLabelFlechaIzquierda.text")); // NOI18N
        jLabelFlechaIzquierda.setName("jLabelFlechaIzquierda"); // NOI18N
        jPanelSemana.add(jLabelFlechaIzquierda);

        javax.swing.GroupLayout jPanelMedioLayout = new javax.swing.GroupLayout(jPanelMedio);
        jPanelMedio.setLayout(jPanelMedioLayout);
        jPanelMedioLayout.setHorizontalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIconos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMedioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMedioLayout.setVerticalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMedioLayout.createSequentialGroup()
                .addComponent(jPanelIconos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelArriba.add(jPanelMedio);

        jPanelUsuario.setName("jPanelUsuario"); // NOI18N
        jPanelUsuario.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanelUsuario.setRequestFocusEnabled(false);

        jLabelNombreUsuario.setText(resourceMap.getString("jLabelNombreUsuario.text")); // NOI18N
        jLabelNombreUsuario.setName("jLabelNombreUsuario"); // NOI18N

        jButtonActualizar.setText(resourceMap.getString("jButtonActualizar.text")); // NOI18N
        jButtonActualizar.setName("jButtonActualizar"); // NOI18N
        jButtonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonActualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(0, 408, Short.MAX_VALUE)
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

        jPaneAbajo.setMaximumSize(jPaneAbajo.getMaximumSize());
        jPaneAbajo.setName("jPaneAbajo"); // NOI18N
        jPaneAbajo.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jPaneAbajoLayout = new javax.swing.GroupLayout(jPaneAbajo);
        jPaneAbajo.setLayout(jPaneAbajoLayout);
        jPaneAbajoLayout.setHorizontalGroup(
            jPaneAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPaneAbajoLayout.setVerticalGroup(
            jPaneAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, 1517, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelArriba, javax.swing.GroupLayout.DEFAULT_SIZE, 1511, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getActionMap(MenuPrincipal.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualizarMouseClicked
        AbrirPanelSemana();
    }//GEN-LAST:event_jButtonActualizarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabelCalendario;
    private javax.swing.JLabel jLabelFlechaDerecha;
    private javax.swing.JLabel jLabelFlechaIzquierda;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelPersonal;
    private javax.swing.JLabel jLabelSemana;
    private javax.swing.JLabel jLabelTareas;
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

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    private void ActualizarSemana() {
        StringBuilder textoSemana = new StringBuilder();
        DateFormat df = new SimpleDateFormat("dd/MMMMM");
        textoSemana.append("Semana ");
        textoSemana.append(df.format(calendar.getTime())).append(" - ");
        dias[0]=calendar.getTime();
        for (int i = 1; i <= 6; i++) {
           calendar.add(Calendar.DATE, 1); 
           dias[i]=calendar.getTime(); 
        }
        textoSemana.append(df.format(calendar.getTime()));
        jLabelSemana.setText(textoSemana.toString());
        calendar.setTime(diaActual);
    }

    private void AbrirPanelSemana() {
        PanelSemana panel = new PanelSemana(dias);
        panel.setSize(jPaneAbajo.getWidth(), jPaneAbajo.getHeight());
        jPaneAbajo.add(panel);
        jPaneAbajo.updateUI();
    }

    private void PrepararInterface() {
        ImageIcon imageHome = new ImageIcon(new ImageIcon(".\\iconos\\home.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imagePersonal = new ImageIcon(new ImageIcon(".\\iconos\\staff.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageTareas = new ImageIcon(new ImageIcon(".\\iconos\\tasks.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageCalendar = new ImageIcon(new ImageIcon(".\\iconos\\calendar.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageFDerecha = new ImageIcon(new ImageIcon(".\\iconos\\chevronright.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageFIzquierda = new ImageIcon(new ImageIcon(".\\iconos\\chevronleft.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        jLabelFlechaDerecha.setText("");
        jLabelFlechaIzquierda.setText("");
        jLabelHome.setText("");
        jLabelPersonal.setText("");
        jLabelTareas.setText("");
        jLabelCalendario.setText("");
        jLabelHome.setIcon(imageHome);
        jLabelPersonal.setIcon(imagePersonal);
        jLabelTareas.setIcon(imageTareas);
        jLabelCalendario.setIcon(imageCalendar);
        jLabelFlechaDerecha.setIcon(imageFIzquierda);
        jLabelFlechaIzquierda.setIcon(imageFDerecha);
    }
}
