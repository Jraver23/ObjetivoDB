package controlador;

import model.*;


public class Controlador {

    private Datos datos; // instancia de la clase Datos
    private StoreView view;

    public Controlador(Datos datos, StoreView view) {
        this.datos = datos;
        this.view = view;
    }

    // métodos de acceso y manipulación de los datos del modelo

    public String getListaArticulos() {
        return datos.listaA();
    }

    public void addArticuloToList (String codigo, String descripcion, float precio, float gastos, long tiempo) {
        datos.addArticulo(codigo, descripcion, precio, gastos, tiempo);
    }

    public String getListaClientes() {
        return datos.listaC();
    }

    public String getListaClientesPremium() {
        return datos.ListasClientesP();
    }

    public String getListaClientesStandard() {
        return datos.ListaClientesEstandar();
    }

    public void addClienteToList (String nombre, String domicilio, String nif, String email, String tipoCliente) {
        datos.addCliente(nombre, domicilio, nif, email, tipoCliente);
    }

    public String getListaPedidos() {
        return datos.listaPedidos();
    }

    public void deletePedidoFromLista (int numPedido) {
        datos.deletePedido(numPedido);
    }

}