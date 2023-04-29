package pfg;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    /**
     * Test of main method, of class Menu.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Menu.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CambiarPanel method, of class Menu.
     */
    @Test
    public void testCambiarPanel() {
        System.out.println("CambiarPanel");
        Menu.Paneles panelTipo = null;
        Menu instance = null;
        instance.CambiarPanel(panelTipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPanelActivo method, of class Menu.
     */
    @Test
    public void testGetPanelActivo() {
        System.out.println("getPanelActivo");
        Menu instance = null;
        Menu.Paneles expResult = null;
        Menu.Paneles result = instance.getPanelActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPanelActivo method, of class Menu.
     */
    @Test
    public void testSetPanelActivo() {
        System.out.println("setPanelActivo");
        Menu.Paneles panelActivo = null;
        Menu instance = null;
        instance.setPanelActivo(panelActivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
