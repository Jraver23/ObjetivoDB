package model;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class ListaClientesPremium extends Lista<ClientePremium> {

    ListaClientesPremium listaClientesP = new ListaClientesPremium();

    public boolean Añadir_cliente(ClientePremium c){

        int size = listaClientesP.getSize();
        int posicion = -1;
        for(int i=0; i < size; i++){
            if(listaClientesP.getAt(i).getEmail() == c.getEmail()) posicion = i;
        }
        if( posicion != -1){
            return false;
        }
        listaClientesP.add(c);
        return true;
    }
    
}