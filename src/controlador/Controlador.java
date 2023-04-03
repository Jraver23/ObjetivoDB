package controlador;

import model.*;

import java.sql.Time;
import java.util.Date;


public class Controlador {

    private Datos datos; // instancia de la clase Datos
    private view.GestionOS view;

    public Controlador() {
        this.datos = datos;
        this.view = view;
    }

    // métodos de acceso y manipulación de los datos del modelo

    public String getListaArticulos() {
        return datos.listaA();
    }

    public void addArticuloToList (String codigo, String descripcion, float precio, float gastos, Time tiempo) {
        datos.addArticulo(codigo, descripcion, precio, gastos, tiempo);
    }

    public ListaClientes getListaClientes() {
        return datos.listaC();
    }

    public String getListaClientesPremium() {
        return datos.ListasClientesP();
    }

    public String getListaClientesStandard() {
        return datos.ListaClientesEstandar();
    }

    public void addCliente (String nombre, String domicilio, String nif, String email) {
        datos.addCliente(nombre, domicilio, nif, email);
    }

    public void addClienteToAList (String nombre, String domicilio, String nif, String email, String tipoCliente) {
        datos.addClienteToAList(nombre, domicilio, nif, email, tipoCliente);
    }

    public ListaPedidos getListaPedidos() {
        return datos.listaPedidos();
    }



    public void deletePedidoFromLista (int numPedido) {
        datos.deletePedido(numPedido);
    }

    public void addPedido(int numero_pedido, String cliente, String articulo, int numero_de_articulos, Date fecha, Time hora) {
        datos.addPedido(numero_pedido, cliente, articulo, numero_de_articulos, fecha, hora);
    }
}