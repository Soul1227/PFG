package pfg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Clase encargada de generar el archivo .txt donde se almacena la ip del
 * servidor, acceder a este y comprobar que la ip es valida.
 *
 * @author angel
 */
public class ControladorIP {

    private static final File archivoIP = new File("." + File.separator + "ServerIP.txt");

    public ControladorIP() {
    }

    public static File getArchivoIP() {
        return archivoIP;
    }

    /**
     * Valida que la direccion IP introducida es correcta.
     *
     * @param ip direccion ip a la que conectar.
     * @return si es valida true, de lo contrario false.
     */
    public static boolean validarIP(String ip) {
        String patron = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    /**
     * Toma la Ip del server del archivo donde esta se almacena.
     *
     * @return IP a la que conectarse o "" en caso de que no hubiese.
     */
    public static String TomarIp() {
        if (archivoIP.exists()) {
            try {
                FileReader fr = new FileReader(archivoIP);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();
                if (linea != null) {
                    br.close();
                    fr.close();
                    return linea;
                } else {
                    br.close();
                    fr.close();
                    return "";
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return "";
    }

    /**
     * Crea un nuevo archivo IP.
     */
    public static void CrearArchivoIP() {
        if (!archivoIP.exists()) {
            try {
                archivoIP.createNewFile();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    /**
     * Guarda una nueva ip en el archivoIP, para futuras conexiones.
     *
     * @param nuevaIP nueva ip a ser guardada.
     */
    public static void GuardarNuevaIP(String nuevaIP) {
        if (validarIP(nuevaIP)) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivoIP));
                writer.write(nuevaIP);
                writer.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "La ip: " + nuevaIP + "\n No es una ip valida, por favor introduzca una ip valida.");
        }
    }
}
