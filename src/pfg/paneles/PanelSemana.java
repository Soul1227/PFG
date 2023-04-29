package pfg.paneles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import pfg.ConectorDB;
import pfg.Menu;
import servidorprueba.Lugar;

/**
 *
 * @author angel
 */
public class PanelSemana extends javax.swing.JPanel {

    /**
     * Creates new form PanelSemana
     */
    public PanelSemana() {
        initComponents();
    }

    public PanelSemana(Date[] semana, LinkedList<Lugar> lugaresGrupo, boolean isAdmin, Menu menu) {
        initComponents();
        for (Date d : semana) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(d);
            menu.maper.ActualizarMapaLugares(ConectorDB.BuscarLugaresDeUsuario(menu.usuario.getGrupo()));
            PanelDiaSemana diaSemana = new PanelDiaSemana(d, lugaresGrupo, isAdmin, ConectorDB.BuscarTareas(strDate, menu.usuario.getGrupo()), menu);
            diaSemana.setSize(WIDTH, this.getHeight());
            diaSemana.setMaximumSize(this.getSize());
            diaSemana.setAutoscrolls(true);
            this.add(diaSemana);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pfg.PFGApp.class).getContext().getResourceMap(PanelSemana.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setName("Form"); // NOI18N
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
