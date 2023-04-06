package model;

// subclase que hereda las propiedades y metodos de Cliente
public class ClientePremium extends Cliente {
    public ClientePremium(String nombre, String domicilio, String nif, String email) {
        super(nombre, domicilio, nif, email);
    }

    // Aqui van los constructores y las caracteristicas de cliente premium con sus ecuaciones

    @Override
    public String tipoCliente(){
        return "Premium";

    }
//DUDA
    @Override
    public float calcAnual(){
        return 30*12;

    }
    @Override
    public float descuentoEnv(){
        return (float) 0.2;
    }

    @Override
    public String toString() {
        return "ClientePremium{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                "}\n";
    }

}
