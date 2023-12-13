/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfg;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servidorprueba.Persona;

/**
 *
 * @author angel
 */
public class LoginTest {

    public LoginTest() {
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

    @Test
    public void testLoginIntegration() {
        System.out.println("Integracion Login - ConectorDB");
        /**
         * El objeto persona es una copia de uno existente en la base de datos.
         * se usan sus credenciales y se comprueba que el recivido de la base de
         * datos tiene los mismos valores.
         */
        Persona persona = new Persona(4, "Paco", "Navarro", "pacnav001", "1234", "paconavarro@gmail.com", "123456789", 1, "admin", true);
        LinkedList<String> credenciales = new LinkedList<>();
        credenciales.add(persona.getNombreUsuario());
        credenciales.add(persona.getPass());

        Persona usuario = ConectorDB.Login(credenciales);

        assertNotNull(persona);
        assertEquals(usuario.getNombre(), persona.getNombre());
        assertEquals(usuario.getApellidos(), persona.getApellidos());
        assertEquals(usuario.getEmail(), persona.getEmail());
        assertEquals(usuario.getGrupo(), persona.getGrupo());
        assertEquals(usuario.getEditadoPor(), persona.getEditadoPor());
        assertEquals(usuario.getTelefono(), persona.getTelefono());
    }
}
