package model;

import java.time.LocalDateTime;

public class Articulo {

    String codigoA;
    String descripcionA;
    float precio_de_venta;
    float gastos_de_envio;
    long tiempo_de_preparacion;

    // Constructor
    public Articulo(String codigo, String descripcionA, float precio, float gastos, long tiempo) {
        this.codigoA = codigo;
        this.descripcionA = descripcionA;
        this.precio_de_venta = precio;
        this.gastos_de_envio = gastos;
        this.tiempo_de_preparacion = tiempo;
    }

    // Getters
    public String getCodigoalfanumerico() {
        return codigoA;
    }

    public String getDescripcion() {
        return descripcionA;
    }

    public float getPrecio_de_venta() {
        return precio_de_venta;
    }

    public float getGastos_de_envio() {
        return gastos_de_envio;
    }

    public long getTiempo_de_preparacion() {
        return tiempo_de_preparacion;
    }

    // Setters
    public void setCodigoalfanumerico(String codigo) {
        this.codigoA = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionA = descripcion;
    }

    public void setPrecio_de_venta(float precio) {
        this.precio_de_venta = precio;
    }

    public void setGastos_de_envio(float gastos) {
        this.gastos_de_envio = gastos;
    }

    public void setTiempo_de_preparacion(long tiempo) {
        this.tiempo_de_preparacion = tiempo;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Articulo [codigoalfanumerico=" + codigoA + ", descripcion=" + descripcionA
                + ", precio_de_venta=" + precio_de_venta + ", gastos_de_envio=" + gastos_de_envio
                + ", tiempo_de_preparacion=" + tiempo_de_preparacion + "]\n";
    }
}
