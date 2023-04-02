package model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class ListaPedidos extends Lista<Pedidos>{

    ListaPedidos listaPedidos = new ListaPedidos();

    public boolean Añadir_pedido(Pedidos p){

        boolean existe = false;
        for(int i = 0; i < listaPedidos.getSize(); ++i){
            if(listaPedidos.getAt(i) == p) existe = true;
        }
        if(existe){
            return false;
        }
        else{
            listaPedidos.add(p);
            return true;

        }
    }

    public boolean Eliminar_pedido(Pedidos p) {


        boolean existe = false;
        for (int i = 0; i < listaPedidos.getSize(); ++i) {
            if (listaPedidos.getAt(i) == p) existe = true;
        }
        if (existe) {
            Date fechaactual = new Date();
            Articulo a = p.getArticulo();
            Time tiempoprep = a.getTiempo_de_preparacion();


            long diferencia = fechaactual.getTime() - p.getFecha().getTime(); // Usar getTime() para obtener la representación en milisegundos de las fechas

            if (diferencia > tiempoprep.getTime()) {
                listaPedidos.borrar(p);
                return true;
            } else return false;
            //Un pedido puede ser borrado únicamente si no ha sido enviado, es decir, si el tiempo transcurrido
            // a desde la fecha y hora del pedido no supera el tiempo de preparación para el envío del artículo
        }
        else return false;
    }

}
