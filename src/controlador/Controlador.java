package controlador;

import view.*;
import model.*;


public class Controlador {

    private Datos datos; // instancia de la clase Datos
    private StoreView view;

    public Controlador(Datos datos, StoreView view) {
        this.datos = datos;
        this.view = view;
    }

    // métodos de acceso y manipulación de los datos del modelo

    public List<Articulo> getListaArticulos() {
        return datos.getArticulos();
    }

    public void addArticuloToList (Articulo articulo) {
        datos.getListaArticulos().addArticulo(articulo);
    }

    public List<Cliente> getListaClientes() {
        return datos.getClientes();
    }

    public List<Cliente> getListaClientesPremium() {
        return datos.getClientesPremium();
    }

    public List<Cliente> getListaClientesStandard() {
        return datos.getClientesStandard();
    }

    public void addClienteToList (Cliente cliente) {
        datos.getListaClientes().addCliente(cliente);
    }

    public List<Pedidos> getListaPedidosPendientes() {
        return datos.getPedidosPendientes();
    }

    public List<Pedidos> getListaPedidosEnviados() {
        return datos.getPedidosEnviados();
    }

    public List<Pedidos> getListaPedidosPendientesPorCliente(String email) {
        return datos.getPedidosPendientes(email);
    }

    public List<Pedidos> getListaPedidosEnviadosPorCliente(String email) {
        return datos.getPedidosEnviados(email);
    }

    public deletePedidoFromLista (String numPedido) {
        datos.deletePedido(numPedido);
    }

}