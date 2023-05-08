package pfg.paneles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import pfg.ConectorDB;
import pfg.Menu;
import servidorprueba.Lugar;
import servidorprueba.Tarea;

/**
 * Panel que contine los paneles "dia de la semana" y gestiona la creacion de
 * estos.
 *
 * @author angel
 */
public class PanelSemana extends javax.swing.JPanel {

    private LinkedList<Tarea> listaTareas;
    private String strDate;
    private final DateFormat dateFormat;

    /**
     * Creates new form PanelSemana
     */
    public PanelSemana() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
    }

    public PanelSemana(Date[] semana, LinkedList<Lugar> lugaresGrupo, boolean isAdmin, Menu menu) {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
        for (Date dia : semana) {
            strDate = dateFormat.format(dia);
            Menu.maper.ActualizarMapaLugares(ConectorDB.BuscarLugaresDeUsuario(Menu.usuario.getGrupo()));
            TomarListaTareas(Menu.usuario.isEsAdmin());
            PanelDiaSemana diaSemana = new PanelDiaSemana(dia, lugaresGrupo, isAdmin, listaTareas, menu);
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

    /**
     * En base de si el usuario tiene perfil de administrador o no, se tomara la
     * lista completa de tareas para el dia o solo las tareas asignadas al
     * usuario.
     *
     * @param esAdmin si el usuario es administrador o no.
     */
    private void TomarListaTareas(boolean esAdmin) {
        if (esAdmin) {
            listaTareas = ConectorDB.BuscarTareas(strDate, Menu.usuario.getGrupo());
        } else {
            listaTareas = ConectorDB.BuscarTareasParaUnUsuario(strDate, Menu.usuario.getId());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
