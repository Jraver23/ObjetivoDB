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

    public void agregarDato(Dato nuevoDato) {
        datos.agregarDato(nuevoDato);
    }

    public void eliminarDato(Dato datoAEliminar) {
        datos.eliminarDato(datoAEliminar);
    }

    // métodos específicos para subclases de Datos

    public Articulo pedirDatosArticulo(int idArticulo) {
        return datos.obtenerArticulo(idArticulo);
    }

    public Pedido pedirDatosPedido(int idPedido) {
        return datos.obtenerPedido(idPedido);
    }

    public Cliente pedirDatosCliente(int idCliente) {
        return datos.obtenerCliente(idCliente);
    }

}