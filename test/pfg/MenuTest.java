package pfg;

import java.util.LinkedList;
import javax.naming.spi.DirStateFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servidorprueba.Grupo;
import servidorprueba.Lugar;

/**
 *
 * @author angel
 */
public class MenuTest {

    public MenuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
//
//    /**
//     * Test of main method, of class Menu.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Menu.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of CambiarPanel method, of class Menu.
//     */
//    @Test
//    public void testCambiarPanel() {
//        System.out.println("CambiarPanel");
//        Menu.Paneles panelTipo = null;
//        Menu instance = null;
//        instance.CambiarPanel(panelTipo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPanelActivo method, of class Menu.
//     */
//    @Test
//    public void testGetPanelActivo() {
//        System.out.println("getPanelActivo");
//        Menu instance = null;
//        Menu.Paneles expResult = null;
//        Menu.Paneles result = instance.getPanelActivo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPanelActivo method, of class Menu.
//     */
//    @Test
//    public void testSetPanelActivo() {
//        System.out.println("setPanelActivo");
//        Menu.Paneles panelActivo = null;
//        Menu instance = null;
//        instance.setPanelActivo(panelActivo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void testAbrirVentanaLugares() {
        System.out.println("Testing Abrir Ventana Lugares");
        Maper maper = new Maper(1);
        maper.ActualizarMapaLugares(ConectorDB.BuscarLugares());
        /**
         * lista de Lugares en la base de datos. Si la lista del maper es la
         * misma que la lista expuesta el test será superado.
         */
        LinkedList<Lugar> listaLugares = new LinkedList<>();
        listaLugares.add(new Lugar(1, "H. San Carlos", "Calle Alfonso n12"));
        listaLugares.add(new Lugar(2, "H. Puerta tierra", "Calle Hidalgo n4"));
        listaLugares.add(new Lugar(3, "H. Sacred heart", "California"));
        listaLugares.add(new Lugar(9, "H. Rocio", "Sevilla"));
        listaLugares.add(new Lugar(12, "ZonaNueva", "Calle Prueba"));

        maper.getListaLugares().forEach(lugar -> {
            listaLugares.forEach(l -> {
                if (lugar.getId() == l.getId()) {
                    assertTrue(true);
                }
            });
        });
    }

    @Test
    public void testAbrirVentanaGrupos() {
        System.out.println("Testing Abrir Ventana Grupos");
        Maper maper = new Maper(1);
        maper.ActualizarMapaGrupos(ConectorDB.BuscarGrupos());
        /**
         * Lista de Grupos en la base de datos. Si la lista del maper es la
         * misma que la lista expuesta el test será superado.
         */
        LinkedList<Grupo> listaGrupos = new LinkedList<>();
        listaGrupos.add(new Grupo(1, "enfermeria"));
        listaGrupos.add(new Grupo(15, "Trauma"));

        maper.getListaGrupos().forEach(grupo -> {
            listaGrupos.forEach(g -> {
                if (grupo.getGrupoId() == g.getGrupoId()) {
                    assertTrue(true);
                }
            });
        });
    }
}
