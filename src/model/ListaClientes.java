package model;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class ListaClientes extends Lista<Cliente> {

    ListaClientes listaClientes = new ListaClientes();

    public void Añadir_cliente(){

        String nombre;
        String domicilio;
        String nif;
        String email;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Creando nuevo cliente...\n");
        System.out.print("Por favor, introduzca su mail para comprovar si es usted un nuevo cliente:\n");
        email = teclado.nextLine();

        int size = listaClientes.getSize();
        int posicion = -1;
        for(int i=0; i < size; i++){
            if(listaClientes.getAt(i).getEmail() == email) posicion = i;
        }
        if( posicion != -1){
            System.out.print("Error: Este cliente ya existe en la base de datos\n");
            return;
        }
        System.out.print("Creando nuevo cliente...\n");
        System.out.print("Por favor, introduzca su nombre:\n");
        nombre = teclado.nextLine();
        System.out.print("Por favor, introduzca su domicilio:\n");
        domicilio = teclado.nextLine();
        System.out.print("Por favor, introduzca su nif:\n");
        nif = teclado.nextLine();

        Cliente c = new Cliente(nombre,domicilio,nif,email);

        listaClientes.add(c);

    }


}
