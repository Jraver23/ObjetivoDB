package model;

import java.sql.Time;

public class Articulo {

    String codigoalfanumerico;
    String descripcion;
    float precio_de_venta;
    float gastos_de_envio;
    Time tiempo_de_preparacion;

    // Constructor
    public Articulo(String codigo, String descripcion, float precio, float gastos, Time tiempo) {
        this.codigoalfanumerico = codigo;
        this.descripcion = descripcion;
        this.precio_de_venta = precio;
        this.gastos_de_envio = gastos;
        this.tiempo_de_preparacion = tiempo;
    }

    // Getters
    public String getCodigoalfanumerico() {
        return codigoalfanumerico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio_de_venta() {
        return precio_de_venta;
    }

    public float getGastos_de_envio() {
        return gastos_de_envio;
    }

    public Time getTiempo_de_preparacion() {
        return tiempo_de_preparacion;
    }

    // Setters
    public void setCodigoalfanumerico(String codigo) {
        this.codigoalfanumerico = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio_de_venta(float precio) {
        this.precio_de_venta = precio;
    }

    public void setGastos_de_envio(float gastos) {
        this.gastos_de_envio = gastos;
    }

    public void setTiempo_de_preparacion(Time tiempo) {
        this.tiempo_de_preparacion = tiempo;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Articulo [codigoalfanumerico=" + codigoalfanumerico + ", descripcion=" + descripcion
                + ", precio_de_venta=" + precio_de_venta + ", gastos_de_envio=" + gastos_de_envio
                + ", tiempo_de_preparacion=" + tiempo_de_preparacion + "]";
    }
}
