package pfg;

import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

/**
 *
 * @author angel
 */
public class javahelp {

    private static HelpSet helpSet;
    private static HelpBroker helpBroker;

    static {
        try {
            URL url = javahelp.class.getResource("/pfg/help/help.hs");
            helpSet = new HelpSet(null, url);
            helpBroker = helpSet.createHelpBroker();
        } catch (HelpSetException e) {
            e.printStackTrace();
        }
    }

    public static void showHelp(String helpID) {
        if (helpSet == null) {
            System.out.println("No se ha encontrado el archivo de ayuda");
            return;
        }
        helpBroker.setCurrentID(helpID);
        helpBroker.setDisplayed(true);
    }
}
