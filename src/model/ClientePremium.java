package model;

// subclase que hereda las propiedades y metodos de Cliente
public class ClientePremium extends Cliente {
    public ClientePremium (String nombre, String domicilio, String nif, String email){
        super(nombre, domicilio, nif, email);
    }

<<<<<<< HEAD
    // Aqui van los constructores y las caracteristicas de cliente premium con sus ecuaciones

}
=======
    public String tipoCliente(){
        return "ClientePremium";

    }

    public float calcAnual(){
        return 30*12;

    }

    public float descuentoEnv(){
        return (float) 0.2;
    }

}
>>>>>>> sergi_modelo
