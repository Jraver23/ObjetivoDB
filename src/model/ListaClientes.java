package model;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class ListaClientes extends Lista<ClienteEstandar> {

    ListaClientes listaClientes = new ListaClientes();

    public boolean Añadir_cliente(ClienteEstandar c){

        int size = listaClientes.getSize();
        int posicion = -1;
        for(int i=0; i < size; i++){
            if(listaClientes.getAt(i).getEmail() == c.getEmail()) posicion = i;
        }
        if( posicion != -1){
            return false;
        }
        listaClientes.add(c);
        return true;
    }


}
