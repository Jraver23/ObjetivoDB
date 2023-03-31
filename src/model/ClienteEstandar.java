package model;

// subclase que hereda las propiedades y metodos de Cliente
public class ClienteEstandar extends Cliente {
    public ClienteEstandar(String nombre, String domicilio, String nif, String email){
        super(nombre, domicilio, nif, email);
    }

    public String tipoCliente(){
        return "ClienteEstandar";

    }

    public float calcAnual(){
        return 0*12;

    }

    public float descuentoEnv(){
        return 1;
    }

}