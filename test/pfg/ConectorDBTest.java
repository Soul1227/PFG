package pfg;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servidorprueba.Grupo;
import servidorprueba.Lugar;
import servidorprueba.Persona;
import servidorprueba.Prioridad;
import servidorprueba.Tarea;

/**
 *
 * @author angel
 */
public class ConectorDBTest {

    public ConectorDBTest() {
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
     * Test of BuscarPersonal method, of class ConectorDB.
     */
    @Test
    public void testBuscarPersonal() {
        System.out.println("BuscarPersonal");
        int num_grupo = 1;
        //Copia de las personas actuales en la base de datos para el grupo 1.
        LinkedList<Persona> expResult = new LinkedList<>();
        Persona persona1 = new Persona(4, "Paco", "Navarro", "pacnav001", "1234", "paconavarro@gmail.com", "123456789", 1, "admin", true);
        Persona persona2 = new Persona(5, "Maria", "Ruiz", "marrui005", "lechuga", "mariaruiz@gmail.com", "456789123", 1, "admin", false);
        Persona persona3 = new Persona(35, "Angy", "Ruiz", "Angy025", "chorizo", "54752@email.com", "789654123", 1, "Paco Navarro", false);
        expResult.add(persona1);
        expResult.add(persona2);
        expResult.add(persona3);

        LinkedList<Persona> result = ConectorDB.BuscarPersonal(num_grupo);

        //Sí los ids de los objetos personas son el mismo, se dará el test por superado.
        result.forEach(persona -> {
            expResult.forEach(p -> {
                if (p.getId() == persona.getId()) {
                    assertEquals(p.getId(), persona.getId());
                }
            });
        });
    }

    /**
     * Test of BuscarPersonalFueraDeTarea method, of class ConectorDB.
     */
    @Test
    public void testBuscarPersonalFueraDeTarea() {
        System.out.println("BuscarPersonalFueraDeTarea");
        //Id de una tarea existente en la base de datos
        LinkedList<Integer> idTarea = new LinkedList();
        idTarea.add(23);
        //Copia de las personas actuales en la base de datos para el grupo 1.
        LinkedList expResult = new LinkedList();
        Persona persona1 = new Persona(4, "Paco", "Navarro", "pacnav001", "1234", "paconavarro@gmail.com", "123456789", 1, "admin", true);
        Persona persona2 = new Persona(5, "Maria", "Ruiz", "marrui005", "lechuga", "mariaruiz@gmail.com", "456789123", 1, "admin", false);
        Persona persona3 = new Persona(35, "Angy", "Ruiz", "Angy025", "chorizo", "54752@email.com", "789654123", 1, "Paco Navarro", false);
        expResult.add(persona1);
        expResult.add(persona2);
        expResult.add(persona3);

        LinkedList<Persona> result = ConectorDB.BuscarPersonalFueraDeTarea(idTarea);
        /**
         * La tarea con id 23 solo tiene asignada una persona, en este caso la
         * representada con persona2. El test se considerará superado, si la
         * lista obtenida no contiene a la persona2.
         */
        result.forEach(persona -> {
            assertFalse(persona.getId() == persona2.getId());
        });
    }

//    /**
//     * Test of CrearTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearTarea() {
//        System.out.println("CrearTarea");
//        Tarea tarea = null;
//        Boolean expResult = null;
//        Boolean result = ConectorDB.CrearTarea(tarea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of CrearEmpleado method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearEmpleado() {
//        System.out.println("CrearEmpleado");
//        LinkedList<Persona> datosNuevoEmpleado = null;
//        Persona expResult = null;
//        Persona result = ConectorDB.CrearEmpleado(datosNuevoEmpleado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of BuscarLugaresDeUsuario method, of class ConectorDB.
     */
    @Test
    public void testBuscarLugaresDeUsuario() {
        System.out.println("BuscarLugaresDeUsuario");
        int grupo = 0;
        LinkedList<Lugar> expResult = null;
        LinkedList<Lugar> result = ConectorDB.BuscarLugaresDeUsuario(grupo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPrioridades method, of class ConectorDB.
     */
    @Test
    public void testBuscarPrioridades() {
        System.out.println("BuscarPrioridades");
        LinkedList<Prioridad> expResult = null;
        LinkedList<Prioridad> result = ConectorDB.BuscarPrioridades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of ActualizarGrupoLugares method, of class ConectorDB.
//     */
//    @Test
//    public void testActualizarGrupoLugares() {
//        System.out.println("ActualizarGrupoLugares");
//        int idLugar = 0;
//        int idGrupo = 0;
//        ConectorDB.ActualizarGrupoLugares(idLugar, idGrupo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of EliminarLugaresParaUnGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarLugaresParaUnGrupo() {
//        System.out.println("EliminarLugaresParaUnGrupo");
//        int idGrupo = 0;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarLugaresParaUnGrupo(idGrupo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of EliminarTareasDelGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarTareasDelGrupo() {
//        System.out.println("EliminarTareasDelGrupo");
//        int idGrupo = 0;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarTareasDelGrupo(idGrupo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of Login method, of class ConectorDB.
     */
    @Test
    public void testLogin() {
        System.out.println("Login");
        LinkedList credenciales = null;
        Persona expResult = null;
        Persona result = ConectorDB.Login(credenciales);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarTareasGuardadas method, of class ConectorDB.
     */
    @Test
    public void testBuscarTareasGuardadas() {
        System.out.println("BuscarTareasGuardadas");
        LinkedList<Tarea> expResult = null;
        LinkedList<Tarea> result = ConectorDB.BuscarTareasGuardadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of CrearGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearGrupo() {
//        System.out.println("CrearGrupo");
//        String nombreGrupo = "";
//        boolean expResult = false;
//        boolean result = ConectorDB.CrearGrupo(nombreGrupo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of BuscarUsuariosEnGrupoNoAdmin method, of class ConectorDB.
     */
    @Test
    public void testBuscarUsuariosEnGrupoNoAdmin() {
        System.out.println("BuscarUsuariosEnGrupoNoAdmin");
        int grupoid = 0;
        boolean expResult = false;
        boolean result = ConectorDB.BuscarUsuariosEnGrupoNoAdmin(grupoid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of EliminarGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarGrupo() {
//        System.out.println("EliminarGrupo");
//        int grupoid = 0;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarGrupo(grupoid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of EliminarAdminsDeGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarAdminsDeGrupo() {
//        System.out.println("EliminarAdminsDeGrupo");
//        int grupoid = 0;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarAdminsDeGrupo(grupoid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of BuscarLugaresParaUnGrupo method, of class ConectorDB.
     */
    @Test
    public void testBuscarLugaresParaUnGrupo() {
        System.out.println("BuscarLugaresParaUnGrupo");
        int grupoid = 0;
        boolean expResult = false;
        boolean result = ConectorDB.BuscarLugaresParaUnGrupo(grupoid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarGrupos method, of class ConectorDB.
     */
    @Test
    public void testBuscarGrupos() {
        System.out.println("BuscarGrupos");
        LinkedList<Grupo> expResult = null;
        LinkedList<Grupo> result = ConectorDB.BuscarGrupos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of CrearNuevoLugar method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearNuevoLugar() {
//        System.out.println("CrearNuevoLugar");
//        Lugar lugar = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.CrearNuevoLugar(lugar);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of BuscarLugares method, of class ConectorDB.
     */
    @Test
    public void testBuscarLugares() {
        System.out.println("BuscarLugares");
        LinkedList<Lugar> expResult = null;
        LinkedList<Lugar> result = ConectorDB.BuscarLugares();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarTareas method, of class ConectorDB.
     */
    @Test
    public void testBuscarTareas() {
        System.out.println("BuscarTareas");
        String fecha = "";
        LinkedList<Tarea> expResult = null;
        LinkedList<Tarea> result = ConectorDB.BuscarTareas(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarTareaPorId method, of class ConectorDB.
     */
    @Test
    public void testBuscarTareaPorId() {
        System.out.println("BuscarTareaPorId");
        Tarea tarea = null;
        Tarea expResult = null;
        Tarea result = ConectorDB.BuscarTareaPorId(tarea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of ActualizarPersonal method, of class ConectorDB.
//     */
//    @Test
//    public void testActualizarPersonal() {
//        System.out.println("ActualizarPersonal");
//        Persona persona = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.ActualizarPersonal(persona);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of EliminarPersonal method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarPersonal() {
//        System.out.println("EliminarPersonal");
//        Persona persona = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarPersonal(persona);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of ActualizarTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testActualizarTarea() {
//        System.out.println("ActualizarTarea");
//        Tarea tarea = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.ActualizarTarea(tarea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of AñadirPersonalATarea method, of class ConectorDB.
//     */
//    @Test
//    public void testAñadirPersonalATarea() {
//        System.out.println("AñadirPersonalATarea");
//        Persona persona = null;
//        Tarea tarea = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.AñadirPersonalATarea(persona, tarea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of EliminarPersonalDeTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarPersonalDeTarea() {
//        System.out.println("EliminarPersonalDeTarea");
//        Persona persona = null;
//        Tarea tarea = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarPersonalDeTarea(persona, tarea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of EliminarTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarTarea() {
//        System.out.println("EliminarTarea");
//        Tarea tarea = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.EliminarTarea(tarea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
