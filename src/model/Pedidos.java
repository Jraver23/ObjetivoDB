package model;

import java.sql.Time;
import java.util.Date;

public class Pedidos {

    int numero_pedido;
    Cliente cliente;
    Articulo articulo;
    int numero_de_articulos;
    Date fecha;
    Time hora;

    public Pedidos(int numero_pedido, Cliente cliente, Articulo articulo, int numero_de_articulos, String fecha, String hora) {
        this.numero_pedido = numero_pedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.numero_de_articulos = numero_de_articulos;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getNumero_de_articulos() {
        return numero_de_articulos;
    }

    public void setNumero_de_articulos(int numero_de_articulos) {
        this.numero_de_articulos = numero_de_articulos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "numero_pedido=" + numero_pedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                ", numero_de_articulos=" + numero_de_articulos +
                ", fecha=" + fecha +
                ", hora=" + hora +
                '}';
    }

    public boolean pedidoEnviado(){
        Date fechaPedido = getFecha();
        Time tiempoPreparacion = articulo.getTiempo_de_preparacion();
        Date fechaEnvio = new Date(fechaPedido.getTime() + tiempoPreparacion.getTime());

        Date fechaActual = new Date();
        if (fechaActual.compareTo(fechaEnvio) > 0) {
            return true;
        } else {
            return false;
        }
    }


    public float precioEnvio(){
        return numero_pedido*articulo.getPrecio_de_venta();

    }

    public Object getNumero() {
    }
}
