package controlador;

import dao.Articulo_DAO;
import dao.Pedido_DAO;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;

import java.sql.Time;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Controlador {

    private Datos datos; // instancia de la clase Datos

    public Controlador() {
        datos = new Datos();
        //datos.cargaDatos();
    }

    // Métodos que pasaran las listas de datos a la vista

    public String getListaArticulos() {
        return datos.listaA();
    }

    public String getListaClientes() {
        return datos.ListaClientes();
    }

    public String getListaClientesPremium() {
        return datos.ListasClientesP();
    }

    public String getListaClientesStandard() {
        return datos.ListaClientesEstandar();
    }

    public String getListaPedidosPendEst() {
        return datos.ListadoPPE();
    }

    public String getListaPedidosPendPre() {
        return datos.ListadoPPP();
    }

    public String getListaPedidosEnviadosEst() {
        return datos.listadoPEE();
    }

    public String getListaPedidosEnviadosPre() {
        return datos.listadoPEP();
    }


    // Adición de datos a las listas
    public boolean addArticuloToList(String codigo, String descripcion, float precio, float gastos, long tiempo) {
        if (datos.existeArticulo(codigo) == true) {
            return false;
        }
        datos.addArticulo(codigo, descripcion, precio, gastos, tiempo);
        return true;
    }

    public boolean addClienteToAList(String nombre, String domicilio, String nif, String email, String tipoCliente) {
        if (datos.existeCliente(email) == true) {
            return false;
        }
        datos.addClienteToAList(nombre, domicilio, nif, email, tipoCliente);
        return true;
    }

    public boolean deletePedidoFromLista(int numPedido) {
        if (datos.eliminarP(numPedido) == true) {
            return true;
        }
        System.out.println("El pedido no existe.");
        return false;
    }

    public boolean addPedido(int numero_pedido, String email, String articulo, int numero_de_articulos, LocalDateTime fecha) {
        if (datos.existeCliente(email) == true) {
            datos.addPedidos(numero_pedido, email, articulo, numero_de_articulos, fecha);
            return true;
        }
        return false;
    }

    public boolean existeCliente(String email) {
        return datos.existeCliente(email);
    }
}