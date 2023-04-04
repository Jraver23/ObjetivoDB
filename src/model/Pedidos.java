package model;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Pedidos {

    int numero_pedido;
    Cliente cliente;
    Articulo articulo;
    int numero_de_articulos;
    LocalDateTime fecha;

    public Pedidos(int numero_pedido, Cliente cliente, Articulo articulo, int numero_de_articulos, LocalDateTime fecha) {
        this.numero_pedido = numero_pedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.numero_de_articulos = numero_de_articulos;
        this.fecha = fecha;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Pedidos{" +
                "numero_pedido=" + numero_pedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                ", numero_de_articulos=" + numero_de_articulos +
                ", fecha=" + fecha +
                '}';
    }

    public boolean pedidoEnviado() {
        LocalDateTime fechaPedido = getFecha();
        Duration tiempoPreparacion = Duration.between(LocalTime.MIN, articulo.getTiempo_de_preparacion());
        LocalDateTime fechaEnvio = fechaPedido.plus(tiempoPreparacion);
        return LocalDateTime.now().isAfter(fechaEnvio);
    }


    public float precioEnvio(){
        return numero_pedido*articulo.getPrecio_de_venta();

    }

}
