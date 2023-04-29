package pfg;

import java.util.HashMap;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servidorprueba.Grupo;
import servidorprueba.Lugar;
import servidorprueba.Prioridad;

/**
 *
 * @author angel
 */
public class MaperTest {
    
    public MaperTest() {
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
     * Test of getMapaPrioridades method, of class Maper.
     */
    @Test
    public void testGetMapaPrioridades() {
        System.out.println("getMapaPrioridades");
        Maper instance = null;
        HashMap expResult = null;
        HashMap result = instance.getMapaPrioridades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapaPrioridades method, of class Maper.
     */
    @Test
    public void testSetMapaPrioridades() {
        System.out.println("setMapaPrioridades");
        HashMap mapaPrioridades = null;
        Maper instance = null;
        instance.setMapaPrioridades(mapaPrioridades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapaLugares method, of class Maper.
     */
    @Test
    public void testGetMapaLugares() {
        System.out.println("getMapaLugares");
        Maper instance = null;
        HashMap expResult = null;
        HashMap result = instance.getMapaLugares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapaLugares method, of class Maper.
     */
    @Test
    public void testSetMapaLugares() {
        System.out.println("setMapaLugares");
        HashMap mapaLugares = null;
        Maper instance = null;
        instance.setMapaLugares(mapaLugares);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPrioridades method, of class Maper.
     */
    @Test
    public void testGetListaPrioridades() {
        System.out.println("getListaPrioridades");
        Maper instance = null;
        LinkedList<Prioridad> expResult = null;
        LinkedList<Prioridad> result = instance.getListaPrioridades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPrioridades method, of class Maper.
     */
    @Test
    public void testSetListaPrioridades() {
        System.out.println("setListaPrioridades");
        LinkedList<Prioridad> listaPrioridades = null;
        Maper instance = null;
        instance.setListaPrioridades(listaPrioridades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapaGrupos method, of class Maper.
     */
    @Test
    public void testGetMapaGrupos() {
        System.out.println("getMapaGrupos");
        Maper instance = null;
        HashMap<String, Integer> expResult = null;
        HashMap<String, Integer> result = instance.getMapaGrupos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapaGrupos method, of class Maper.
     */
    @Test
    public void testSetMapaGrupos() {
        System.out.println("setMapaGrupos");
        HashMap<String, Integer> mapaGrupos = null;
        Maper instance = null;
        instance.setMapaGrupos(mapaGrupos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaGrupos method, of class Maper.
     */
    @Test
    public void testGetListaGrupos() {
        System.out.println("getListaGrupos");
        Maper instance = null;
        LinkedList<Grupo> expResult = null;
        LinkedList<Grupo> result = instance.getListaGrupos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaGrupos method, of class Maper.
     */
    @Test
    public void testSetListaGrupos() {
        System.out.println("setListaGrupos");
        LinkedList<Grupo> listaGrupos = null;
        Maper instance = null;
        instance.setListaGrupos(listaGrupos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaLugares method, of class Maper.
     */
    @Test
    public void testGetListaLugares() {
        System.out.println("getListaLugares");
        Maper instance = null;
        LinkedList<Lugar> expResult = null;
        LinkedList<Lugar> result = instance.getListaLugares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaLugares method, of class Maper.
     */
    @Test
    public void testSetListaLugares() {
        System.out.println("setListaLugares");
        LinkedList<Lugar> listaLugares = null;
        Maper instance = null;
        instance.setListaLugares(listaLugares);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CrearMapaLugares method, of class Maper.
     */
    @Test
    public void testCrearMapaLugares() {
        System.out.println("CrearMapaLugares");
        LinkedList<Lugar> listaLugares = null;
        Maper instance = null;
        HashMap expResult = null;
        HashMap result = instance.CrearMapaLugares(listaLugares);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CrearMapaPrioridades method, of class Maper.
     */
    @Test
    public void testCrearMapaPrioridades() {
        System.out.println("CrearMapaPrioridades");
        LinkedList<Prioridad> listaPrioridades = null;
        Maper instance = null;
        HashMap expResult = null;
        HashMap result = instance.CrearMapaPrioridades(listaPrioridades);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CrearMapaGrupos method, of class Maper.
     */
    @Test
    public void testCrearMapaGrupos() {
        System.out.println("CrearMapaGrupos");
        LinkedList<Grupo> listaGrupos = null;
        Maper instance = null;
        HashMap expResult = null;
        HashMap result = instance.CrearMapaGrupos(listaGrupos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarMapaPrioridades method, of class Maper.
     */
    @Test
    public void testActualizarMapaPrioridades() {
        System.out.println("ActualizarMapaPrioridades");
        LinkedList<Prioridad> listaPrioridades = null;
        Maper instance = null;
        instance.ActualizarMapaPrioridades(listaPrioridades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarMapaLugares method, of class Maper.
     */
    @Test
    public void testActualizarMapaLugares() {
        System.out.println("ActualizarMapaLugares");
        LinkedList<Lugar> listaLugares = null;
        Maper instance = null;
        instance.ActualizarMapaLugares(listaLugares);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarMapaGrupos method, of class Maper.
     */
    @Test
    public void testActualizarMapaGrupos() {
        System.out.println("ActualizarMapaGrupos");
        LinkedList<Grupo> listaGrupos = null;
        Maper instance = null;
        instance.ActualizarMapaGrupos(listaGrupos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
