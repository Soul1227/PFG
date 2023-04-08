package pfg.paneles;

import java.util.LinkedList;
import pfg.Menu;
import servidorprueba.Persona;

/**
 *
 * @author angel
 */
public class PanelPersonal extends javax.swing.JPanel {
    /**
     * Creates new form PanelPersonal
     */
    public PanelPersonal() {
        initComponents();
    }

    public PanelPersonal(LinkedList<Persona> listaPersonal, Menu menu) {
        this.setAutoscrolls(true);
        for (Persona p : listaPersonal) {
            EtiquetaPersonal etiquetaPersona = new EtiquetaPersonal(p, false, menu);
            this.add(etiquetaPersona);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
