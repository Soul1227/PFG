package pfg.paneles;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import pfg.Dialogs.VentanaCrearTarea;
import pfg.Menu;
import servidorprueba.Lugar;
import servidorprueba.Tarea;

/**
 * Esta clase define un panel que representa visualmente un día de la semana,
 * con su fecha y lista de tareas.
 */
public class PanelDiaSemana extends javax.swing.JPanel {

    public Date fecha;
    public LinkedList<Lugar> listaLugares;
    public Menu menu;
    DateFormat df = new SimpleDateFormat("EEEEE");

    /**
     * constructor por defecto que inicializa los componentes del panel.
     */
    public PanelDiaSemana() {
        initComponents();
    }

    /**
     * Constructor que inicializa los componentes del panel y asigna la fecha,
     * lista de lugares, si el usuario es administrador, lista de tareas y el
     * menú pasados como argumentos.
     *
     * @param fecha La fecha del día de la semana que se muestra en este panel.
     * @param listaLugares La lista de lugares que se muestran en este panel.
     * @param isAdmin Booleano que indica si el usuario es administrador.
     * @param listaTareas La lista de tareas que se muestran en este panel.
     * @param menu El menú que se muestra en este panel.
     */
    public PanelDiaSemana(Date fecha, LinkedList<Lugar> listaLugares, boolean isAdmin, LinkedList<Tarea> listaTareas, Menu menu) {
        this.fecha = fecha;
        this.menu = menu;
        this.listaLugares = listaLugares;
        initComponents();
        if (!isAdmin) {
            jButtonAñadirTarea.setVisible(false);
        }
        String diaSemana = df.format(fecha.getTime());
        Border borde = BorderFactory.createEtchedBorder();
        Border bordeTitulado = BorderFactory.createTitledBorder(borde, diaSemana, TitledBorder.CENTER, TitledBorder.TOP);
        this.setBorder(bordeTitulado);
        jPanel2.setSize(this.getWidth(), HEIGHT);
        jPanel2.setAlignmentY(TOP_ALIGNMENT);
        for (Tarea tarea : listaTareas) {
            EtiquetaTarea etiquetaTarea = new EtiquetaTarea(tarea, menu);
            jPanel2.add(etiquetaTarea);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAñadirTarea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelDiaSemana.class);
        jButtonAñadirTarea.setText(resourceMap.getString("jButtonAñadirTarea.text")); // NOI18N
        jButtonAñadirTarea.setName("jButtonAñadirTarea"); // NOI18N
        jButtonAñadirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirTareaActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jPanel2.setMinimumSize(getPreferredSize());
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonAñadirTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAñadirTarea))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirTareaActionPerformed
        JDialog nuevaTarea = new VentanaCrearTarea(null, true, this.fecha, listaLugares);
        nuevaTarea.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                menu.CambiarPanel(Menu.Paneles.Semana);
            }
        });
        nuevaTarea.setVisible(true);
    }//GEN-LAST:event_jButtonAñadirTareaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirTarea;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
