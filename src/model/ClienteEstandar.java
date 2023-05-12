package model;

// subclase que hereda las propiedades y metodos de Cliente
public class ClienteEstandar extends Cliente {
    public ClienteEstandar(String nombre, String domicilio, String nif, String email){
        super(nombre, domicilio, nif, email);
    }

    public ClienteEstandar(){}

    // Aqui van los constructores y las caracteristicas de cliente estandar


    @Override
    public String tipoCliente(){
        return "Estandar";

    }

    @Override
    public float calcAnual(){
        return 0*12;

    }

    @Override
    public float descuentoEnv(){
        return 1;
    }

    @Override
    public String toString() {
        return "ClienteEstandar{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                "}\n";
    }

}
