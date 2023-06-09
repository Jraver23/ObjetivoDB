package view;

import controlador.Controlador;
import dao.Articulo_DAO;
import dao.Cliente_DAO;
import dao.ConexionBD;
import model.Articulo;
import model.Cliente;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;


//Entrada de tiempo de preparacion a long
//Comprobantes de cada funcion

public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);
    public GestionOS() {
        controlador = new Controlador();
    }
    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    boolean salir2 = false;
                    char opcio2;
                    do {
                        System.out.println("1. Añadir articulo");
                        System.out.println("2. Mostrar Articulo");
                        System.out.println("0. Salir");
                        opcio2 = pedirOpcionArticulo();
                        switch (opcio2) {
                            case '1':
                                String codigoalfanumerico;
                                String descripcion;
                                float precio_de_venta;
                                float gastos_de_envio;
                                long tiempo;

                                Scanner teclado = new Scanner(System.in);
                                System.out.print("Creando nuevo Articulo...\n");
                                System.out.print("Escriba el codigo alfanumerico del nuevo producto:\n");
                                codigoalfanumerico = teclado.nextLine();
                                while(codigoalfanumerico.isEmpty()){
                                    System.out.print("Escriba un codigo:\n");
                                    codigoalfanumerico = teclado.nextLine();
                                }
                                System.out.print("Escriba la descripcion del producto:\n");
                                descripcion = teclado.nextLine();
                                while(descripcion.isEmpty()){
                                    System.out.print("Escriba una descripcion:\n");
                                    descripcion = teclado.nextLine();
                                }
                                System.out.print("Escriba su precio de venta al publico:\n");
                                precio_de_venta = Float.parseFloat(teclado.nextLine());
                                while(precio_de_venta< 1){
                                    System.out.print("Escriba un precio de venta valido:\n");
                                    precio_de_venta = Float.parseFloat(teclado.nextLine());
                                }
                                System.out.print("Escriba el gasto de envio del producto:\n");
                                gastos_de_envio = Float.parseFloat(teclado.nextLine());
                                while(gastos_de_envio< 1){
                                    System.out.print("Escriba un gasto de envio valido:\n");
                                    gastos_de_envio = Float.parseFloat(teclado.nextLine());
                                }
                                System.out.print("Cual es su tiempo de preparacion?: (en horas)\n");
                                tiempo = Long.parseLong(teclado.nextLine());
                                while(tiempo < 0){
                                    System.out.print("Escriba un tiempo de envio valido:\n");
                                    tiempo = Long.parseLong((teclado.nextLine()));
                                }

                                controlador.addArticuloToList(codigoalfanumerico,descripcion,precio_de_venta,gastos_de_envio,tiempo);

                                //Conexion de articulo con la base de dato incluida en la conexionBD
                                /*ConexionBD connection = new ConexionBD();
                                Articulo_DAO articulo_dao = new Articulo_DAO(connection.getConnection());
                                Articulo articulo = new Articulo(codigoalfanumerico, descripcion, precio_de_venta, gastos_de_envio, tiempo);

                                articulo_dao.insert(articulo);*/
                                System.out.print("El articulo se ha guardado.\n");
                                break;
                            case '2':
                                String listaArticulo;
                                listaArticulo = controlador.getListaArticulos();
                                if(listaArticulo.isEmpty()) System.out.print("No hay ningun articulo.\n");
                                else {
                                    System.out.print("Lista de articulos:\n");
                                    System.out.print(listaArticulo);
                                }
                                break;

                            case '0':
                                salir2 = true;
                        }
                    } while (!salir2) ;
                    break;
                case '2':
                    boolean salir3 = false;
                    char opcio3;
                    do {
                        System.out.println("1. Añadir Cliente");
                        System.out.println("2. Mostrar Clientes");
                        System.out.println("3. Mostrar Clientes Estandar");
                        System.out.println("4. Mostrar Clientes Premium");
                        System.out.println("0. Salir");
                        opcio3 = pedirOpcionClienteoPedido();
                        switch (opcio3) {
                            case '1':
                                String nombre;
                                String domicilio;
                                String nif;
                                String email;

                                Scanner teclado = new Scanner(System.in);
                                System.out.print("Creando nuevo Cliente...\n");
                                System.out.print("Escriba el nombre del cliente:\n");
                                nombre = teclado.nextLine();
                                while(nombre.isEmpty()){
                                    System.out.print("Escriba de nuevo el nombre:\n");
                                    nombre = teclado.nextLine();
                                }
                                System.out.print("Escriba el domicilio del cliente:\n");
                                domicilio = teclado.nextLine();
                                while(domicilio.isEmpty()){
                                    System.out.print("Escriba de nuevo el domicilio:\n");
                                    domicilio = teclado.nextLine();
                                }
                                System.out.print("Escriba su NIF:\n");
                                nif = teclado.nextLine();
                                while(nif.isEmpty()){
                                    System.out.print("Escriba de nuevo el nif:\n");
                                    nif = teclado.nextLine();
                                }
                                System.out.print("Escriba el mail del cliente (no debe existir en la BD):\n");
                                email = teclado.nextLine();
                                while(email.isEmpty()){
                                    System.out.print("Escriba de nuevo el email:\n");
                                    email = teclado.nextLine();
                                }
                                System.out.println("De que tipo de cliente se trata? (Por favor escriba: Estandar o Premium)");
                                String tipo;
                                tipo = teclado.nextLine();
                                while ((tipo.isEmpty()) || ((tipo.compareToIgnoreCase("Estandar")!=0) && (tipo.compareToIgnoreCase("Premium")!=0))) {
                                    System.out.println("Escribe de nuevo el tipo:");
                                    tipo = teclado.nextLine();
                                }
                                boolean hecho;
                                hecho = controlador.addClienteToAList(nombre,domicilio, nif, email, tipo);
                                if(hecho==true){

                                    //Aqui tiene que ir la conexion a base de datos

                                    System.out.println("El cliente se ha añadido.");
                                }else{
                                    System.out.println("No se ha añadido el cliente.");
                                }
                                break;
                            case '2':
                                String listaCliente = controlador.getListaClientes();
                                if(listaCliente.isEmpty()) System.out.println("No hay clientes.");
                                else{
                                    System.out.println("Lista de clientes:");
                                    System.out.println(listaCliente);
                                }
                                break;
                            case '3':
                                String listaClienteEstandar = controlador.getListaClientesStandard();
                                if(listaClienteEstandar.isEmpty()) System.out.println("No hay clientes estandar.");
                                else{
                                    System.out.println("Lista de clientes Estandar:");
                                    System.out.println(listaClienteEstandar);
                                }
                                break;
                            case '4':
                                String listaClientePremium = controlador.getListaClientesPremium();
                                if(listaClientePremium.isEmpty()) System.out.println("No hay clientes premium.");
                                else{
                                    System.out.println("Lista de clientes Premium:");
                                    System.out.println(listaClientePremium);
                                }
                            case '0':
                                salir3 = true;
                        }
                    } while (!salir3) ;
                    break;
                case '3':
                    boolean salir4 = false;
                    char opcio4;
                    do {
                        System.out.println("1. Añadir Pedido");
                        System.out.println("2. Eliminar Pedido");
                        System.out.println("3. Mostrar Pedidos pendientes");
                        System.out.println("4. Mostrar Pedidos Enviados");
                        System.out.println("0. Salir");
                        opcio4 = pedirOpcionClienteoPedido();
                        switch (opcio4) {
                            case '1':
                                int numero_pedido = -1;
                                String cliente;
                                String articulo;
                                int numero_de_articulos;

                                Scanner teclado = new Scanner(System.in);
                                System.out.print("Creando nuevo Pedido...\n");
                                System.out.print("Escriba el numero de pedido:\n");
                                numero_pedido = Integer.parseInt(teclado.nextLine());
                                while(numero_pedido == -1){
                                    System.out.print("Escriba el numero de pedido:\n");
                                    numero_pedido = Integer.parseInt(teclado.nextLine());
                                }
                                System.out.print("Escriba el email del cliente:\n");
                                cliente = teclado.nextLine();
                                while(cliente.isEmpty()){
                                    System.out.print("Escriba un email:\n");
                                    cliente = teclado.nextLine();
                                }

                                if (controlador.existeCliente(cliente) == false){
                                    String nombre;
                                    String domicilio;
                                    String nif;
                                    String email;
                                    String tipoCliente;

                                    teclado = new Scanner(System.in);
                                    System.out.print("El cliente no existe, se creará uno nuevo:\n");
                                    System.out.print("Escriba el nombre del cliente:\n");
                                    nombre = teclado.nextLine();
                                    System.out.print("Escriba el domicilio del cliente:\n");
                                    domicilio = teclado.nextLine();
                                    System.out.print("Escriba su NIF:\n");
                                    nif = teclado.nextLine();
                                    System.out.print("Escriba el mail del cliente (no debe existir en la BD):\n");
                                    email = teclado.nextLine();
                                    System.out.print("Escriba el tipo de cliente. Puede ser Estandar o Premium:\n");
                                    tipoCliente = teclado.nextLine();
                                    controlador.addClienteToAList(nombre,domicilio,nif,email, tipoCliente);
                                }
                                try {
                                    System.out.print("Escriba el codigo alfanumerico del articulo:\n");
                                    articulo = teclado.nextLine();
                                    while (articulo.isEmpty()) {
                                        System.out.print("Escriba un codigo alfanumerico:\n");
                                        articulo = teclado.nextLine();
                                    }
                                    System.out.print("Escriba el numero de articulos que desea:\n");
                                    numero_de_articulos = Integer.parseInt(teclado.nextLine());
                                    while (numero_de_articulos < 1) {
                                        System.out.print("Escriba un numero valido:\n");
                                        numero_de_articulos = Integer.parseInt(teclado.nextLine());
                                    }
                                    LocalDateTime fechaactual = LocalDateTime.now();

                                    boolean hecho2;
                                    hecho2 = controlador.addPedido(numero_pedido, cliente, articulo, numero_de_articulos, fechaactual);
                                    if (hecho2 == true) {
                                        System.out.println("El pedido se ha añadido");
                                    } else {
                                        System.out.println("No se ha añadido el pedido");
                                    }
                                }
                                catch (InputMismatchException e){
                                    System.out.println("El código alfanumérico no está bien escrito.");
                                }
                                break;
                            case '2':
                                int numero_pedido2;
                                teclado = new Scanner(System.in);

                                System.out.print("Eliminando Pedido...\n");
                                System.out.print("Escriba el numero de pedido para verificar que no se ha enviado.\n");
                                numero_pedido2 = Integer.parseInt(teclado.nextLine());

                                boolean resultado;
                                resultado = controlador.deletePedidoFromLista(numero_pedido2);
                                if(resultado){
                                    System.out.println("El pedido se ha eliminado.");
                                }else{
                                    System.out.println("No se ha eliminado el pedido.");
                                }
                                break;
                            case '3':
                                boolean salir5 = false;
                                do {
                                    System.out.print("Mostrando Pedidos pendientes de envio...\n");
                                    System.out.print("Elegir una de las dos opciones:\n");
                                    System.out.print("1.Estandar\n");
                                    System.out.print("2.Premium\n");
                                    System.out.print("0.Atrás\n");
                                    char opciopp = pedirOpcionArticulo();
                                    switch (opciopp) {
                                        case '1':
                                            String listaPedidosPendientesEstandar;
                                            listaPedidosPendientesEstandar = controlador.getListaPedidosPendEst();
                                            if (!listaPedidosPendientesEstandar.isEmpty()) {
                                                System.out.println("Pedidos Pendientes de clientes Estandar:");
                                                System.out.println(listaPedidosPendientesEstandar);
                                            } else {
                                                System.out.println("El listado está vacío.");
                                            }
                                            break;
                                        case '2':
                                            String listaPedidosPendientesPremium;
                                            listaPedidosPendientesPremium = controlador.getListaPedidosPendPre();
                                            if (!listaPedidosPendientesPremium.isEmpty()) {
                                                System.out.println("Pedidos Pendientes de clientes Premium:");
                                                System.out.println(listaPedidosPendientesPremium);
                                            } else {
                                                System.out.println("El listado está vacío.");
                                            }
                                            break;
                                        case '0':
                                            salir5=true;
                                    }
                                }while(!salir5);
                                break;
                            case '4':
                                boolean salir6 = false;
                                do {
                                    System.out.print("Mostrando Pedidos enviados...\n");
                                    System.out.print("Elegir una de las dos opciones:\n");
                                    System.out.print("1.Estandar\n");
                                    System.out.print("2.Premium\n");
                                    System.out.print("0.Atrás\n");
                                    char opciope = pedirOpcionArticulo();
                                    switch (opciope) {
                                        case '1':
                                            String listaPedidosEnviadosEstandar;
                                            listaPedidosEnviadosEstandar = controlador.getListaPedidosEnviadosEst();
                                            if (!listaPedidosEnviadosEstandar.isEmpty()) {
                                                System.out.println("Pedidos Enviados de clientes Estandar:");
                                                System.out.println(listaPedidosEnviadosEstandar);
                                            } else {
                                                System.out.println("El listado está vacío.");
                                            }
                                            break;
                                        case '2':
                                            String listaPedidosEnviadosPremium;
                                            listaPedidosEnviadosPremium = controlador.getListaPedidosEnviadosPre();
                                            if (!listaPedidosEnviadosPremium.isEmpty()) {
                                                System.out.println("Pedidos Pendientes de clientes Premium:");
                                                System.out.println(listaPedidosEnviadosPremium);
                                            } else {
                                                System.out.println("El listado está vacío.");
                                            }
                                            break;
                                        case '0':
                                            salir6 = true;
                                    }
                                }while(!salir6);
                                break;
                            case '0':
                                salir4 = true;
                        }
                    } while (!salir4) ;
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir) ;
    }


    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    char pedirOpcionArticulo() {
        String resp;
        System.out.println("Elige una opción (1,2 ó 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    char pedirOpcionClienteoPedido() {
        String resp;
        System.out.println("Elige una opción (1,2,3,4 ó 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
}