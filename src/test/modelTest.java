package test;
import model.*;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class modelTest {

    // Test que comprueba que el getter del nombre del cliente funcione correctamente.
    @Test
    public void testGetNombre() {
        ClientePremium cliente = new ClientePremium("Fernando", "Rambla Catalunya 14", "12345678A", "fernando@gmail.com");
        assertEquals("Fernando", cliente.getNombre());
    }

    // Test que funciona que el setter del email funcione correctamente.
    @Test
    public void testSetEmail() {
        ClienteEstandar cliente = new ClienteEstandar("Juan", "Calle Francia 37", "45873256A", "juanf@gmail.com");
        cliente.setEmail("juanfco@gmail.com");
        assertEquals("juanfco@gmail.com", cliente.getEmail());
    }

    // Test que comprueba que el getter del nif funcione correctamente.
    @Test
    public void testGetNif() {
        ClientePremium cliente = new ClientePremium("David", "Calle Prim 156", "4681278A", "dfer@gmail.com");
        assertEquals("4681278A", cliente.getNif());
    }

    // Test que comprueba la función pedidoEnviado()
    @Test
    public void testPedidoNoEnviado() {
        // Crear un pedido con fecha de hoy y tiempo de preparación de 2 días
        ClienteEstandar cliente = new ClienteEstandar("Juan", "Calle Francia 37", "45873256A", "juanf@gmail.com");
        Articulo articulo = new Articulo("14", "Mesa", 45.0F, 10.0F, 2);
        Pedidos pedido = new Pedidos(50, cliente, articulo, 2,LocalDateTime.of(2023,04,05,18,00,05));

        // Simular que ha pasado un día desde la creación del pedido
        LocalDateTime fechaSimulada = LocalDateTime.now().plusDays(1);

        // Comprobar que el método devuelve false, ya que no han pasado más de 2 días desde la creación del pedido
        assertFalse(pedido.pedidoEnviado());
    }
}