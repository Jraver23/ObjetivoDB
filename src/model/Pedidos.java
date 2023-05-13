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

    public Pedidos(){}

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
                "}\n";
    }

    public boolean pedidoEnviado() {
        if(fecha.plusDays(this.articulo.tiempo_de_preparacion).isBefore(LocalDateTime.now())) {
            return false;
        }
        return true;
    }


    public float precioEnvio(){
        if (cliente instanceof ClientePremium) {
            return (this.articulo.getPrecio_de_venta() * this.getNumero_de_articulos()) + (this.articulo.getGastos_de_envio() * (1 - ((ClientePremium) cliente).descuentoEnv()/100));
        } else {
            return (this.articulo.getPrecio_de_venta() * this.getNumero_de_articulos()) + this.articulo.getGastos_de_envio();
        }

    }

}
