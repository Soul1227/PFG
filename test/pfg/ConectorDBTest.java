package pfg;

import java.sql.Date;
import java.time.LocalDate;
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

//    /**
//     * Test of BuscarPersonal method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarPersonal() {
//        System.out.println("BuscarPersonal");
//        int num_grupo = 1;
//        //Copia de las personas actuales en la base de datos para el grupo 1.
//        LinkedList<Persona> expResult = new LinkedList<>();
//        Persona persona1 = new Persona(4, "Paco", "Navarro", "pacnav001", "1234", "paconavarro@gmail.com", "123456789", 1, "admin", true);
//        Persona persona2 = new Persona(5, "Maria", "Ruiz", "marrui005", "lechuga", "mariaruiz@gmail.com", "456789123", 1, "admin", false);
//        Persona persona3 = new Persona(35, "Angy", "Ruiz", "Angy025", "chorizo", "54752@email.com", "789654123", 1, "Paco Navarro", false);
//        expResult.add(persona1);
//        expResult.add(persona2);
//        expResult.add(persona3);
//        
//        LinkedList<Persona> result = ConectorDB.BuscarPersonal(num_grupo);
//
//        //Sí los ids de los objetos personas son el mismo, se dará el test por superado.
//        result.forEach(persona -> {
//            expResult.forEach(p -> {
//                if (p.getId() == persona.getId()) {
//                    assertEquals(p.getId(), persona.getId());
//                }
//            });
//        });
//    }
//
//    /**
//     * Test of BuscarPersonalGrupoNoexiste method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarPersonalGrupoNoexiste() {
//        System.out.println("BuscarPersonal");
//        int num_grupo = 5;
//        //Copia de las personas actuales en la base de datos para el grupo 1.
//        LinkedList<Persona> expResult = new LinkedList<>();
//        Persona persona1 = new Persona(4, "Paco", "Navarro", "pacnav001", "1234", "paconavarro@gmail.com", "123456789", 1, "admin", true);
//        Persona persona2 = new Persona(5, "Maria", "Ruiz", "marrui005", "lechuga", "mariaruiz@gmail.com", "456789123", 1, "admin", false);
//        Persona persona3 = new Persona(35, "Angy", "Ruiz", "Angy025", "chorizo", "54752@email.com", "789654123", 1, "Paco Navarro", false);
//        expResult.add(persona1);
//        expResult.add(persona2);
//        expResult.add(persona3);
//        
//        LinkedList<Persona> result = ConectorDB.BuscarPersonal(num_grupo);
//        if (result.isEmpty()) {
//            assertTrue(true);
//        }
//    }
//    /**
//     * Test of BuscarPersonalFueraDeTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarPersonalFueraDeTarea() {
//        System.out.println("BuscarPersonalFueraDeTarea");
//        //Id de una tarea existente en la base de datos
//        LinkedList<Integer> argumentos = new LinkedList();
//        argumentos.add(23);//id de la tarea.
//        argumentos.add(23); //id del grupo.
//        //Copia de las personas actuales en la base de datos para el grupo 1.
//        LinkedList expResult = new LinkedList();
//        Persona persona1 = new Persona(4, "Paco", "Navarro", "pacnav001", "1234", "paconavarro@gmail.com", "123456789", 1, "admin", true);
//        Persona persona2 = new Persona(5, "Maria", "Ruiz", "marrui005", "lechuga", "mariaruiz@gmail.com", "456789123", 1, "admin", false);
//        Persona persona3 = new Persona(35, "Angy", "Ruiz", "Angy025", "chorizo", "54752@email.com", "789654123", 1, "Paco Navarro", false);
//        expResult.add(persona1);
//        expResult.add(persona2);
//        expResult.add(persona3);
//        
//        LinkedList<Persona> result = ConectorDB.BuscarPersonalFueraDeTarea(argumentos);
//        /**
//         * La tarea con id 23 solo tiene asignada una persona, en este caso la
//         * representada con persona2. El test se considerará superado, si la
//         * lista obtenida no contiene a la persona2.
//         */
//        result.forEach(persona -> {
//            assertFalse(persona.getId() == persona2.getId());
//        });
//    }
//    /**
//     * Test of BuscarLugaresDeUsuario method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarLugaresDeUsuario() {
//        System.out.println("BuscarLugaresDeUsuario");
//        int grupo = 1;
//        //Copia de los lugares asignados al grupo 1 en la base de datos.
//        LinkedList<Lugar> expResult = new LinkedList<>();
//        expResult.add(new Lugar(1, "H. San Carlos", "Calle Alfonso n12"));
//        expResult.add(new Lugar(3, "H.Sacred heart", "California"));
//        /**
//         * En la base de datos existen 4 lugares, solo 2 han sido asignados al
//         * grupo 1. Si la lista de lugares obtenida tiene algun lugar con id
//         * diferente a 1 o 3 el test no se considerará superado.
//         */
//        LinkedList<Lugar> result = ConectorDB.BuscarLugaresDeUsuario(grupo);
//        result.forEach(lugar -> {
//            if (lugar.getId() != 1 || lugar.getId() != 3) {
//                assertFalse(false);
//            }
//        });
//    }
//
//    /**
//     * Test of BuscarPrioridades method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarPrioridades() {
//        System.out.println("BuscarPrioridades");
//        /**
//         * Prioridades existentes actualmente en la base de datos.
//         */
//        LinkedList<Prioridad> expResult = new LinkedList<>();
//        expResult.add(new Prioridad(1, "baja"));
//        expResult.add(new Prioridad(2, "media"));
//        expResult.add(new Prioridad(3, "alta"));
//        LinkedList<Prioridad> result = ConectorDB.BuscarPrioridades();
//        
//        assertEquals(expResult.size(), result.size());
//        assertTrue(result.containsAll(expResult) && expResult.containsAll(result));
    // }
//    /**
//     * Test of Login method, of class ConectorDB.
//     */
//    @Test
//    public void testLogin() {
//        System.out.println("Login");
//        /**
//         * Si en el servidor no se encuentra ningun ususario con el nombre y
//         * contraseña introducidos, el server duevuelve un objeto persona con
//         * nombre "1" y apellidos "1".
//         */
//        Persona expResult = new Persona("1", "1", true);
//        LinkedList credenciales = new LinkedList();
//        credenciales.add("pacnav001");
//        credenciales.add("1234");
//        Persona result = ConectorDB.Login(credenciales);
//        if (result.getNombre().equals(expResult.getNombre())) {
//            assertFalse(true);
//        } else {
//            assertTrue(true);
//        }
//    }
//    /**
//     * Test of BuscarTareasGuardadas method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarTareasGuardadas() {
//        System.out.println("BuscarTareasGuardadas");
//        /**
//         * Las tareas guardadas se caracterizan por tener un boolean "guardada".
//         * Si en la lista resultante se obtiene alguna tarea con el campo
//         * "guardada" en false no se considerará el test superado.
//         */
//        LinkedList<Tarea> result = ConectorDB.BuscarTareasGuardadas(1);
//        result.forEach(tarea -> {
//            if (!tarea.isGuardada()) {
//                assertFalse(true);
//            }
//        });
//    }
//    /**
//     * Test of BuscarUsuariosEnGrupoNoAdmin method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarUsuariosEnGrupoNoAdmin() {
//        System.out.println("BuscarUsuariosEnGrupoNoAdmin");
//        /**
//         * El servidor devuelve true si encuentra algun usuario del grupo 1 con
//         * el valor "admin" en false, y false si no encuentra a ninguno.
//         */
//        int grupoid = 1;
//        boolean result = ConectorDB.BuscarUsuariosEnGrupoNoAdmin(grupoid);
//        if (result) {
//            assertTrue(true);
//        } else {
//            assertTrue(true);
//        }        
//    }
//    /**
//     * Test of BuscarLugaresParaUnGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarLugaresParaUnGrupo() {
//        System.out.println("BuscarLugaresParaUnGrupo");
//        int grupoid = 0;
//        boolean expResult = false;
//        boolean result = ConectorDB.BuscarLugaresParaUnGrupo(grupoid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of BuscarGrupos method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarGrupos() {
//        System.out.println("BuscarGrupos");
//        LinkedList<Grupo> expResult = null;
//        LinkedList<Grupo> result = ConectorDB.BuscarGrupos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of BuscarLugares method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarLugares() {
//        System.out.println("BuscarLugares");
//        LinkedList<Lugar> expResult = null;
//        LinkedList<Lugar> result = ConectorDB.BuscarLugares();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of BuscarTareas method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarTareas() {
//        System.out.println("BuscarTareas");
//        String fecha = "";
//        LinkedList<Tarea> expResult = null;
//        LinkedList<Tarea> result = ConectorDB.BuscarTareas(fecha);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of BuscarTareaPorId method, of class ConectorDB.
//     */
//    @Test
//    public void testBuscarTareaPorId() {
//        System.out.println("BuscarTareaPorId");
//        Tarea tarea = null;
//        Tarea expResult = null;
//        Tarea result = ConectorDB.BuscarTareaPorId(tarea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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
//     * Test of ActualizarTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testActualizarTarea() {
//        System.out.println("ActualizarTarea");
//        Tarea tarea = null;
//        boolean expResult = false;
//        boolean result = ConectorDB.ActualizarTarea(tarea);
//        assertEquals(expResult, result);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * TEST INSERT
//     */
//    /**
//     * Test of AñadirPersonalATarea method, of class ConectorDB.
//     */
//    @Test
//    public void testAñadirPersonalATarea() {
//        System.out.println("AñadirPersonalATarea");
//        /**
//         * Para hacer uso del método "AñadirPersonalATarea", solo necesitamos
//         * que ambos objetos tengan una id. El método devuelve true si ha
//         * conseguido llevarse a cabo sin problemas.
//         */
//        Persona persona = new Persona(52, null, null, null, null, null, null, 0, null, true);
//        Tarea tarea = new Tarea(23, null, null, null, 0, 0, true, 0, null, null, null, null);
//        boolean result = ConectorDB.AñadirPersonalATarea(persona, tarea);
//        assertTrue(result);
//    }
//
//    /**
//     * Test of CrearNuevoLugar method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearNuevoLugar() {
//        System.out.println("CrearNuevoLugar");
//        Lugar lugar = new Lugar(0, "ZonaNueva", "Calle Prueba");
//        boolean expResult = true;
//        boolean result = ConectorDB.CrearNuevoLugar(lugar);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of CrearGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearGrupo() {
//        System.out.println("CrearGrupo");
//        String nombreGrupo = "Grupo de prueba";
//        boolean expResult = true;
//        boolean result = ConectorDB.CrearGrupo(nombreGrupo);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of CrearTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearTarea() {
//        System.out.println("CrearTarea");
//        Tarea tarea = new Tarea("prueba", "#FFFFFF", Date.valueOf(LocalDate.now()), 1, 1, false, 1, new LinkedList<>(), null, null, "admin");
//        Boolean expResult = true;
//        Boolean result = ConectorDB.CrearTarea(tarea);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of CrearEmpleado method, of class ConectorDB.
//     */
//    @Test
//    public void testCrearEmpleado() {
//        System.out.println("CrearEmpleado");
//        LinkedList<Persona> datosNuevoEmpleado = new LinkedList<>();
//        Persona persona = new Persona("PersonaPrueba", "apellidosPrueba", "prupru", "1256", "pru@gmail.com", "459876328", true, 1, "admin");
//        datosNuevoEmpleado.add(persona);
//        boolean expResult = true;
//        boolean result = ConectorDB.CrearEmpleado(datosNuevoEmpleado);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of ActualizarGrupoLugares method, of class ConectorDB.
//     */
//    @Test
//    public void testActualizarGrupoLugares() {
//        System.out.println("ActualizarGrupoLugares");
//        /**
//         * Actualmente existen un lugar con id 3 y un grupo con id 2 en la base
//         * de datos.
//         */
//        int idLugar = 3;
//        int idGrupo = 2;
//        boolean expResult = true;
//        boolean result = ConectorDB.ActualizarGrupoLugares(idLugar, idGrupo);
//        assertEquals(expResult, result);
//    }
//    /**
//     * DELETE
//     */
//    /**
//     * Test of EliminarLugaresParaUnGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarLugaresParaUnGrupo() {
//        System.out.println("EliminarLugaresParaUnGrupo");
//        /**
//         * Se eliminan todos los lugares relacionados con el grupo 2.
//         */
//        int idGrupo = 2;
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarLugaresParaUnGrupo(idGrupo);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of EliminarPersonalDeTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarPersonalDeTarea() {
//        System.out.println("EliminarPersonalDeTarea");
//        /**
//         * El metodo solo requiere de la id de ambos objetos. Se asignará a un
//         * ususario que existe actualmente en la base de datos a una tarea que
//         * igualmente ya existe. Posteriormente esa relacion sera eliminada.
//         */
//        Persona persona = new Persona(35, null, null, null, null, null, null, 0, null, true);
//        Tarea tarea = new Tarea(3, null, null, null, 0, 0, true, 0, null, null, null, null);
//        ConectorDB.AñadirPersonalATarea(persona, tarea);
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarPersonalDeTarea(persona, tarea);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of EliminarTarea method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarTarea() {
//        System.out.println("EliminarTarea");
//        /**
//         * Para la eliminacion de la tarea necesitamos la id de esta, debido a
//         * que la id le es asignada por la base de datos en su creacion,
//         * usaremos una tarea ya existente en la base de datos.
//         */
//        Tarea tarea = new Tarea(15, null, null, null, 0, 0, true, 0, null, null, null, null);
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarTarea(tarea);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of EliminarPersonal method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarPersonal() {
//        System.out.println("EliminarPersonal");
//        /**
//         * Para la eliminacion necesitamos la id de la persona. La id le es
//         * asiganada por la base de datos en el momento de su creacion. Por
//         * tanto usaremos ya una existente en la base de datos.
//         */
//        Persona persona = new Persona(51, null, null, null, null, null, null, 0, null, true);
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarPersonal(persona);
//        assertEquals(expResult, result);
//    }
//    /**
//     * Test of EliminarAdminsDeGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarAdminsDeGrupo() {
//        System.out.println("EliminarAdminsDeGrupo");
//        /**
//         * Introducimos un nuevo usuario administrador en el grupo 15. El
//         * booleano en el constructor de Persona indica si tiene rango de admin
//         * o no.
//         */
//        Persona persona = new Persona("Paco", "Gonzalez", "admin", "admin", "admin@gmail.com", "456823971", true, 15, "admin");
//        ConectorDB.CrearEmpleado(persona);
//        int grupoid = 15;
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarAdminsDeGrupo(grupoid);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of EliminarGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarGrupo() {
//        System.out.println("EliminarGrupo");
//        /**
//         * Elimina el grupo creado en el test crear grupo, resultó tener id 15.
//         */
//        int grupoid = 15;
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarGrupo(grupoid);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of EliminarTareasDelGrupo method, of class ConectorDB.
//     */
//    @Test
//    public void testEliminarTareasDelGrupo() {
//        System.out.println("EliminarTareasDelGrupo");
//        /**
//         * El grupo 2 se encuentra actualmente sin tareas. crea dos tareas para
//         * este grupo, y las elimina.
//         */
//        Tarea tarea1 = new Tarea("Prueba", "#FFFFFF", Date.valueOf(LocalDate.now()), 1, 2, true, 2, new LinkedList<Persona>(), null, null, "admin");
//        Tarea tarea2 = new Tarea("Prueba1", "#FFFFFF", Date.valueOf(LocalDate.now()), 1, 2, true, 2, new LinkedList<Persona>(), null, null, "admin");
//        ConectorDB.CrearTarea(tarea1);
//        ConectorDB.CrearTarea(tarea2);
//        int idGrupo = 2;
//        boolean expResult = true;
//        boolean result = ConectorDB.EliminarTareasDelGrupo(idGrupo);
//        assertEquals(expResult, result);
//    }
    /**
     * 
     */
}
