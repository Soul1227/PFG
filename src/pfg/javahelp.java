package pfg;

import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

/**
 * Esta clase proporciona métodos estáticos para mostrar la ayuda durante la
 * ejecución de la aplicación. Utiliza un archivo HelpSet y un mapa para mostrar
 * las páginas de ayuda.
 *
 * @author angel
 */
public class javahelp {

    private static HelpSet helpSet;
    private static HelpBroker helpBroker;

    /**
     * Carga el archivo HelpSet y crea un objeto HelpBroker para mostrar la
     * ayuda.
     */
    static {
        try {
            URL url = javahelp.class.getResource("/pfg/help/help.hs");
            helpSet = new HelpSet(null, url);
            helpBroker = helpSet.createHelpBroker();
        } catch (HelpSetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la página de ayuda con el ID especificado.
     *
     * @param helpID El ID de la página de ayuda a mostrar.
     */
    public static void showHelp(String helpID) {
        if (helpSet == null) {
            System.out.println("No se ha encontrado el archivo de ayuda");
            return;
        }
        helpBroker.setCurrentID(helpID);
        helpBroker.setDisplayed(true);
    }
}
