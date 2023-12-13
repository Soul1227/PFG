package pfg.paneles;

import pfg.Dialogs.VentanaDetallesTarea;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import pfg.Maper;
import pfg.Menu;
import servidorprueba.Prioridad;
import servidorprueba.Tarea;

/**
 * Esta clase define un panel que representa visualmente una tarea con su
 * nombre, hora de inicio/fin y color asociado.
 */
public class EtiquetaTarea extends javax.swing.JPanel {

    private Tarea tarea;
    private Maper maper;
    private Menu menu;

    /**
     * constructor por defecto que inicializa los componentes del panel.
     */
    public EtiquetaTarea() {
        initComponents();
    }

    /**
     * constructor que inicializa los componentes del panel y asigna la tarea
     * pasada como argumento.
     *
     * @param tarea tarea cuya informacion se mostrara en la etiqueta.
     */
    public EtiquetaTarea(Tarea tarea) {
        initComponents();
        this.tarea = tarea;
        this.maper = Menu.maper;
        this.menu = null;
        maper.setMapaPrioridades(maper.CrearMapaPrioridades(maper.getListaPrioridades()));
        jLabelNombreTarea.setText(tarea.getNombre());
        if (tarea.getHoraInicio() != null) {
            jLabelHora.setText(tarea.getHoraInicio() + ":" + tarea.getHoraFin());
        } else {
            for (Prioridad p : maper.getListaPrioridades()) {
                if (p.getId() == tarea.getPrioridad()) {
                    jLabelHora.setText("Prioridad: " + p.getNombre());
                }
            }
        }
        jPanelColor.setBackground(Color.decode(tarea.getColor()));
    }

    /**
     * constructor que inicializa los componentes del panel y asigna la tarea y
     * el menú pasado como argumento.
     *
     * @param tarea cuya informacion se mostrara en la etiqueta. 
     * @param menu con acceso a la clase maper.
     */
    public EtiquetaTarea(Tarea tarea, Menu menu) {
        initComponents();
        this.tarea = tarea;
        this.maper = Menu.maper;
        this.menu = menu;
        jLabelNombreTarea.setText(tarea.getNombre());

        if (tarea.getHoraInicio() != null) {
            jLabelHora.setText(tarea.getHoraInicio() + ":" + tarea.getHoraFin());
        } else {
            for (Prioridad p : maper.getListaPrioridades()) {
                if (p.getId() == tarea.getPrioridad()) {
                    jLabelHora.setText("Prioridad: " + p.getNombre());
                }
            }
        }
        jPanelColor.setBackground(Color.decode(tarea.getColor()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreTarea = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jPanelColor = new javax.swing.JPanel();

        setName("Form"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(EtiquetaTarea.class);
        jLabelNombreTarea.setText(resourceMap.getString("jLabelNombreTarea.text")); // NOI18N
        jLabelNombreTarea.setName("jLabelNombreTarea"); // NOI18N

        jLabelHora.setText(resourceMap.getString("jLabelHora.text")); // NOI18N
        jLabelHora.setName("jLabelHora"); // NOI18N

        jPanelColor.setName("jPanelColor"); // NOI18N
        jPanelColor.setPreferredSize(new java.awt.Dimension(15, 100));

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombreTarea, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (menu == null) {

        } else {
            VentanaDetallesTarea detalles = new VentanaDetallesTarea(null, true, tarea);
            detalles.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    menu.CambiarPanel(menu.getPanelActivo());
                }
            });
            detalles.setVisible(true);
        }
    }//GEN-LAST:event_formMouseClicked

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNombreTarea;
    private javax.swing.JPanel jPanelColor;
    // End of variables declaration//GEN-END:variables
}
