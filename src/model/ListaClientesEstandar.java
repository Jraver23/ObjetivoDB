package model;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class ListaClientesEstandar extends Lista<ClienteEstandar> {

    ListaClientesEstandar listaClientesE = new ListaClientesEstandar();

    public boolean Añadir_cliente(ClienteEstandar c){

        int size = listaClientesE.getSize();
        int posicion = -1;
        for(int i=0; i < size; i++){
            if(listaClientesE.getAt(i).getEmail() == c.getEmail()) posicion = i;
        }
        if( posicion != -1){
            return false;
        }
        listaClientesE.add(c);
        return true;
    }


}