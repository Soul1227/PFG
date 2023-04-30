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
        /**
         * El metodo crea un Hashmap a partir de una LinkedList. El test se
         * considera superado si el hashmap creado es igual al expResult.
         */
        LinkedList<Lugar> listaLugares = new LinkedList<>();
        listaLugares.add(new Lugar(1, "lugar1", "direccion1"));
        listaLugares.add(new Lugar(2, "lugar2", "direccion2"));
        listaLugares.add(new Lugar(3, "lugar3", "direccion3"));
        listaLugares.add(new Lugar(4, "lugar4", "direccion4"));
        listaLugares.add(new Lugar(5, "lugar5", "direccion5"));
        Maper instance = new Maper(0);
        HashMap expResult = new HashMap();
        expResult.put("lugar1", 1);
        expResult.put("lugar2", 2);
        expResult.put("lugar3", 3);
        expResult.put("lugar4", 4);
        expResult.put("lugar5", 5);
        HashMap result = instance.CrearMapaLugares(listaLugares);

        listaLugares.forEach(lugar -> {
            if (expResult.get(lugar.getNombre()) == result.get(lugar.getNombre())) {
                assertTrue(true);
            }
        });
    }

    /**
     * Test of CrearMapaPrioridades method, of class Maper.
     */
    @Test
    public void testCrearMapaPrioridades() {
        System.out.println("CrearMapaPrioridades");
        /**
         * El metodo crea un Hashmap a partir de una LinkedList. El test se
         * considera superado si el hashmap creado es igual al expResult.
         */
        LinkedList<Prioridad> listaPrioridades = new LinkedList<>();
        listaPrioridades.add(new Prioridad(1, "baja"));
        listaPrioridades.add(new Prioridad(2, "media"));
        listaPrioridades.add(new Prioridad(2, "alta"));
        Maper instance = new Maper(0);
        HashMap expResult = new HashMap();
        expResult.put("baja", 1);
        expResult.put("media", 2);
        expResult.put("alta", 3);
        HashMap result = instance.CrearMapaPrioridades(listaPrioridades);
        listaPrioridades.forEach(prioridad -> {
            if (expResult.get(prioridad.getNombre()) == result.get(prioridad.getNombre())) {
                assertTrue(true);
            }
        });
    }

    /**
     * Test of CrearMapaGrupos method, of class Maper.
     */
    @Test
    public void testCrearMapaGrupos() {
        System.out.println("CrearMapaGrupos");
        /**
         * El metodo crea un Hashmap a partir de una LinkedList. El test se
         * considera superado si el hashmap creado es igual al expResult.
         */
        LinkedList<Grupo> listaGrupos = new LinkedList<>();
        listaGrupos.add(new Grupo(1, "grupo1"));
        listaGrupos.add(new Grupo(2, "grupo2"));
        listaGrupos.add(new Grupo(3, "grupo3"));
        listaGrupos.add(new Grupo(4, "grupo4"));
        Maper instance = new Maper(0);
        HashMap expResult = new HashMap();
        expResult.put("grupo1", 1);
        expResult.put("grupo2", 2);
        expResult.put("grupo3", 3);
        expResult.put("grupo4", 4);
        HashMap result = instance.CrearMapaGrupos(listaGrupos);
        listaGrupos.forEach(grupo -> {
            if (expResult.get(grupo.getGrupoNombre()) == result.get(grupo.getGrupoNombre())) {
                assertTrue(true);
            }
        });
    }

    /**
     * Test of CrearMapaGrupos method, of class Maper.
     */
    @Test
    public void testCrearMapaGrupos2() {
        System.out.println("CrearMapaGrupos - null");
        /**
         * El metodo crea un Hashmap a partir de una LinkedList. El test se
         * considera superado si el hashmap creado esta vacio.
         */
        LinkedList<Grupo> listaGrupos = null;
        Maper instance = new Maper(0);
        HashMap result = instance.CrearMapaGrupos(listaGrupos);
        if (result.isEmpty()) {
            assertTrue(true);
        }
    }

    /**
     * Test of CrearMapaPrioridades method, of class Maper.
     */
    @Test
    public void testCrearMapaPrioridades2() {
        System.out.println("CrearMapaPrioridades - null");
        /**
         * El metodo crea un Hashmap a partir de una LinkedList. El test se
         * considera superado si el hashmap creado esta vacio.
         */
        LinkedList<Prioridad> listaPrioridades = null;
        Maper instance = new Maper(0);
        HashMap result = instance.CrearMapaPrioridades(listaPrioridades);
        if (result.isEmpty()) {
            assertTrue(true);
        }
    }

    /**
     * Test of CrearMapaLugares method, of class Maper.
     */
    @Test
    public void testCrearMapaLugares2() {
        System.out.println("CrearMapaLugares - null");
        /**
         * El metodo crea un Hashmap a partir de una LinkedList. El test se
         * considera superado si el hashmap creado esta vacio.
         */
        LinkedList<Lugar> listaLugares = null;
        Maper instance = new Maper(0);
        HashMap result = instance.CrearMapaLugares(listaLugares);
        if (result.isEmpty()) {
            assertTrue(true);
        }
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
