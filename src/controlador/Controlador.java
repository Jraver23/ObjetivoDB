package controlador;

import model.*;

import java.sql.Time;
import java.util.Date;


public class Controlador {

    private Datos datos; // instancia de la clase Datos
    private view.GestionOS view;

    public Controlador() {
        new Datos();
    }

    // métodos de acceso y manipulación de los datos del modelo

    public ListaArticulos getListaArticulos() {
        return datos.listaA();
    }

    public ListaClientes getListaClientes() {
        return datos.listaClientes();
    }

    public ListaClientesPremium getListaClientesPremium() {
        return datos.ListasClientesP();
    }

    public ListaClientesEstandar getListaClientesStandard() {
        return datos.ListaClientesEstandar();
    }

    public ListaPedidos getListaPedidos() {
        return datos.listaPedidos();
    }

    public void addArticuloToList (String codigo, String descripcion, float precio, float gastos, Time tiempo) {
        datos.addArticulo(codigo, descripcion, precio, gastos, tiempo);
    }

    public void addClienteToAList (String nombre, String domicilio, String nif, String email, String tipoCliente) {
        datos.addClienteToAList(nombre, domicilio, nif, email, tipoCliente);
    }

    public void deletePedidoFromLista (int numPedido) {
        datos.eliminarP(numPedido);
    }

    public void addPedido(int numero_pedido, String cliente, String articulo, int numero_de_articulos, Date fecha, Time hora) {
        datos.addPedidos(numero_pedido, cliente, articulo, numero_de_articulos, fecha, hora);
    }
}