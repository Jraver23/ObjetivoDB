package view;

import controlador.Controlador;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                                Time tiempo_de_preparacion;

                                Scanner teclado = new Scanner(System.in);
                                System.out.print("Creando nuevo Articulo...\n");
                                System.out.print("Escriba el numero alfanumerico del nuevo producto:\n");
                                codigoalfanumerico = teclado.nextLine();
                                System.out.print("Escriba la descripcion del producto:\n");
                                descripcion = teclado.nextLine();
                                System.out.print("Escriba su precio de venta al publico:\n");
                                precio_de_venta = Float.parseFloat(teclado.nextLine());
                                System.out.print("Escriba el gasto de envio del producto:\n");
                                gastos_de_envio = Float.parseFloat(teclado.nextLine());
                                String tiempo;
                                System.out.print("Cual es su tiempo de preparacion?: (hh:mm:ss)\n");
                                tiempo = teclado.nextLine();
                                Pattern patronHora = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");
                                boolean esFormatoHoraValido = patronHora.matcher(tiempo).matches();
                                if (esFormatoHoraValido) {
                                    tiempo_de_preparacion = Time.valueOf(tiempo);
                                } else {
                                    System.out.println("El formato de hora no es válido");
                                    break;
                                }
                                controlador.addArticuloToList(codigoalfanumerico,descripcion,precio_de_venta,gastos_de_envio,tiempo_de_preparacion);
                                break;
                            case '2':
                                controlador.getListaArticulos();
                                break;

                            case '0':
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
                                        System.out.print("Escriba el domicilio del cliente:\n");
                                        domicilio = teclado.nextLine();
                                        System.out.print("Escriba su NIF:\n");
                                        nif = teclado.nextLine();
                                        System.out.print("Escriba el mail del cliente (no debe existir en la BD):\n");
                                        email = teclado.nextLine();
                                        controlador.addCliente(nombre,domicilio,nif,email);
                                        break;
                                    case '2':
                                        controlador.getListaClientes();
                                        break;
                                    case '3':
                                        controlador.getListaClientesStandard();
                                        break;
                                    case '4':
                                        controlador.getListaClientesPremium();
                                    case '0':
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
                                        int numero_pedido;
                                        String cliente;
                                        String articulo;
                                        int numero_de_articulos;
                                        Date fecha;
                                        Time hora;

                                        Scanner teclado = new Scanner(System.in);
                                        System.out.print("Creando nuevo Pedido...\n");
                                        numero_pedido = controlador.getListaPedidos().getSize() + 1;
                                        System.out.print("Escriba el email del cliente:\n");
                                        cliente = teclado.nextLine();
                                        //Esto no es mio, es del controlador
                                        boolean existe = false;
                                        for(int i = 0; i < controlador.getListaClientes().getSize();++i){
                                            if(controlador.getListaClientes().getAt(i).getEmail() == cliente) existe = true;
                                        }
                                        if(!existe) {
                                            String nombre;
                                            String domicilio;
                                            String nif;
                                            String email;
                                            String tipoCliente;

                                            Scanner teclado = new Scanner(System.in);
                                            System.out.print("Creando nuevo Cliente...\n");
                                            System.out.print("Escriba el nombre del cliente:\n");
                                            nombre = teclado.nextLine();
                                            System.out.print("Escriba el domicilio del cliente:\n");
                                            domicilio = teclado.nextLine();
                                            System.out.print("Escriba su NIF:\n");
                                            nif = teclado.nextLine();
                                            System.out.print("Escriba el mail del cliente (no debe existir en la BD):\n");
                                            email = teclado.nextLine();
                                            System.out.print("Escriba el tipo de cliente. Puede ser ClienteEstandar o ClientePremium:\n");
                                            tipoCliente = teclado.nextLine();
                                            controlador.addClienteToAList(nombre,domicilio,nif,email, tipoCliente);
                                        }

                                        System.out.print("Escriba el codigo alfanumerico del articulo:\n");
                                        articulo = teclado.nextLine();
                                        //deberia mostrar codigalfanumericos de articulos?
                                        System.out.print("Escriba el numero de articulos que desea:\n");
                                        numero_de_articulos = Integer.parseInt(teclado.nextLine());
                                        fecha = new Date();
                                        hora = new Time(System.currentTimeMillis());
                                        controlador.addPedido(numero_pedido,cliente,articulo,numero_de_articulos,fecha,hora);
                                        break;
                                    case '2':
                                        int numero_pedido2;
                                        Scanner teclado = new Scanner(System.in);
                                        System.out.print("Eliminando Pedido...\n");
                                        System.out.print("Escriba el numero de pedido para verificar que no se ha enviado\n");
                                        numero_pedido2 = Integer.parseInt(teclado.nextLine());
                                        controlador.deletePedidoFromLista(numero_pedido2);

                                        break;
                                    case '3':
                                        //Aqui hay dudas, que devuelvo?
                                        System.out.print("Mostrando Pedidos pendientes de envio...\n");
                                        controlador.getListaPedidos();
                                        /*for(int i = 0; controlador.getListaPedidos().getSize(); ++i){


                                        }*/
                                        System.out.print("Por que cliente (email) quiere filtrar?\n");
                                        String email;
                                        Scanner teclado = new Scanner(System.in);
                                        email = teclado.nextLine();
                                        controlador.getListaPedidosPendientesPorCliente(email);
                                        break;
                                    case '4':
                                        System.out.print("Mostrando Pedidos enviados...\n");
                                        controlador.getListaPedidosEnviados();
                                        System.out.print("Por que cliente (email) quiere filtrar?\n");
                                        String email;
                                        Scanner teclado = new Scanner(System.in);
                                        email = teclado.nextLine();
                                        controlador.getListaPedidosEnviadosPorCliente(email);
                                    case '0':
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
