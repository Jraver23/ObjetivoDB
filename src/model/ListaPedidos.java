package model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class ListaPedidos extends Lista<Pedidos>{

    ListaPedidos listaPedidos = new ListaPedidos();

    public void Añadir_pedido(){

        int numero_pedido;
        Cliente cliente;
        Articulo articulo;
        int numero_de_articulos;
        Date fecha;
        Time hora;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Creando nuevo pedido...\n");
        //nif = teclado.nextLine();
        if (listaPedidos.isEmpty()) {
            numero_pedido = 1;
        }
        else{
            int size = listaPedidos.getSize();
            int ultimo_num = listaPedidos.getAt(size).numero_pedido;
            numero_pedido = ultimo_num + 1;
        }

        System.out.print("Cuantos artículos quieres?\n");
        // Aqui tiene que haber una excepcion
        numero_de_articulos = Integer.parseInt(teclado.nextLine());

        //cliente añadir
        System.out.print("Introduzca el mail de su cuenta (en caso de no tener cuenta, se le añadira como nuevo cliente) :\n");
        String mail = teclado.nextLine();
        ListaCliente lc= new ListaCliente();
        int size = lc.size();
        int posicion = -1;
        for(int i=0; i < size; i++){
            if(lc.getAt(i).mail == mail) posicion = i;
        }
        if( posicion == -1) //Crear nuevo cliente
            else Cliente c = lc.getAt(posicion);

        //articulo añadir
        System.out.print("Introduzca el codigo alfanumerico del artículo :\n");
        String codigo = teclado.nextLine();
        ListaArticulos la= new ListaArticulos();
        Articulo a = new Articulo;
        int sizeA = la.size();
        for(int i=0; i < size; i++){
            if(lc.getAt(i).codigo_alfanumerico == codigo){
                Articulo a = la.getAt(i);
                break;
            }
        }

        fecha = new Date();
        hora = new Time(System.currentTimeMillis());
        Pedidos p = new Pedidos(numero_pedido,c,a,numero_de_articulos,fecha,hora);
        listaPedidos.add(p);

    }

    public void Eliminar_pedido(){

        Scanner teclado = new Scanner(System.in);
        System.out.print("Que pedido quieres eliminar? (indica el numero de pedido)\n");
        int numeroaeliminar = Integer.parseInt(teclado.nextLine());
        Pedidos p = listaPedidos.getAt(numeroaeliminar);

        Date fechaactual= new Date();
        Articulo a = p.getArticulo();
        int tiempoprep = a.gettiempo_preparacion();

        // Calcular la diferencia en milisegundos entre las dos fechas y horas
        int diferencia = fechaactual.compareTo(p.getFecha());

        if(diferencia > 0){
            listaPedidos.borrar(p);
            System.out.print("Pedido eliminador correctamente \n)");
        }
        else System.out.print("No se puede eliminar el pedido porque la hora del pedido no supera el tiempo de preparacón del envío del articulo \n)");

        //Un pedido puede ser borrado únicamente si no ha sido enviado, es decir, si el tiempo transcurrido
        // a desde la fecha y hora del pedido no supera el tiempo de preparación para el envío del artículo

    }

}
