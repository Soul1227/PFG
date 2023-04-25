package pfg.paneles;

import java.util.LinkedList;
import pfg.Menu;
import servidorprueba.Persona;

/*
 * Clase que representa un panel con la lista de personal.
 * Permite visualizar la información de las personas de la lista de personal y
 * realizar ciertas acciones en ellas.
 * @author angel
 */
public class PanelPersonal extends javax.swing.JPanel {

    /**
     * Creates new form PanelPersonal
     */
    public PanelPersonal() {
        initComponents();
    }

    /**
     * Crea un nuevo objeto PanelPersonal con la lista de personas y el menú
     * especificados, y crea una etiqueta personal para cada persona en la
     * lista.
     *
     * @param listaPersonal lista de personas a mostrar en el panel
     * @param menu menú al que pertenece el panel
     */
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
