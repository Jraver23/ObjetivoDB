package model;

import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
public class Datos {

    //Definición de atributos privados
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;

    //Constructor publico, inicializa los atributos
    public Datos(ListaArticulos listaArticulos, ListaClientes listaClientes, ListaPedidos listaPedidos) {
        this.listaArticulos = listaArticulos;
        this.listaClientes = listaClientes;
        this.listaPedidos = listaPedidos;
    }

    // GESTIÓN DE ARTICULOS
    //Definición del metodo 'existeArticulo' se comprueba si la lista esta vacia, si es si nos devuleve un 'false'
    public boolean existeArticulo(String codigoA){
        if (listaArticulos.isEmpty()==true){
            return false;
        }
    //El ciclo 'for' itera sobre todos los elementos, al conseguir el codigo del articulo lo compara con el parametro proporcionado
    //Recorre la lista si no encuentra comparacion el articulo no existe
        for(int i =0; i<listaArticulos.getSize(); i++){
            int resultado= listaArticulos.getAt(i).getCodigoalfanumerico().compareTo(codigoA);
            if (resultado==0){
                return true;
            }
        }
        return false;
    }

    //El metodo 'add.Articulo' coge los parametros y los utiliza para crear un nuevo articulo
    //Cuando lo crea lo pone en la lista de articulos
    public void addArticulo(String codigoA,String descripcionA, float precio_de_venta, float gastos_de_envio, long tiempo_de_preparacion){
        Articulo articulo;
        articulo=new Articulo(codigoA, descripcionA, precio_de_venta, gastos_de_envio, tiempo_de_preparacion);
        listaArticulos.add(articulo);
    }
    public String listaA(){
        return this.listaArticulos.toString();
    }


    //GESTIÓN DE CLIENTES
    //En este metodo comienza con verificar si la lista de clientes esta vacia
    public boolean existeCliente(String emailC) {
        if (listaClientes.isEmpty() == true) {
            return false;
        }
        //En este ciclo si el email coincide lo compara con el parametro insertado > muestra
        for (int i = 0; i < listaClientes.getSize(); i++) {
            int resultado=listaClientes.getAt(i).getEmail().compareTo(emailC);
            if(resultado==0) {
                return true;
            }
        }
        return false;
    }

    public void addCliente(String nombre, String domicilio, String nif, String email, String tipoCliente){
        Cliente cliente;
        if (tipoCliente == "ClienteEstandar"){
            cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        } else {
            cliente = new ClientePremium(nombre, domicilio, nif, email);
        }
        listaClientes.add(cliente);
    }
    public void cargaDatos(){
    ClienteEstandar cliente1=new ClienteEstandar("Nordine","BarcelonaCity","3625147Z","nordine@uoc.com");
    listaClientes.add(cliente1);
    ClientePremium cliente2=new ClientePremium("Sergi","BadalonaCity","5654128H","sergi@uoc.com");
    listaClientes.add(cliente2);
    ClientePremium cliente3=new ClientePremium("Jorge","SagradaFamilia","31025214Z","Jorge@uoc.com");
    listaClientes.add(cliente2);
    Articulo articulo1=new Articulo("001","Escritorio",160,20,"1");
    listaArticulos.add(articulo1);
    Articulo articulo2=new Articulo(002,"Mesa",140,10,"5");
    listaArticulos.add(articulo2);
    Articulo articulo3=new Articulo(003,"Silla",100,5,"2");
    listaArticulos.add(articulo3);
    Pedidos pedidos1=new Pedidos(1, cliente1,articulo1,2,"2023,10,10","09:00");
    Pedidos pedidos2=new Pedidos(2,cliente2,articulo2,2,"2023,05,23","10:00");
    Pedidos pedidos3=new Pedidos(3,cliente3,articulo3,1,"2023,06;02","12:00");
    listaPedidos.add(pedidos1);
    listaPedidos.add(pedidos2);
    listaPedidos.add(pedidos3);
    System.out.println("Los datos han sido cargados correctamente");
    }

    public String listaC(){
        return this.listaClientes.toString();
    }

    public String ListaClientesEstandar(){
        Collection<Cliente>listaClientesEstandar=listaClientes.getArrayList().stream().filter(cliente->cliente.tipoCliente().equals("Estandar")).collect(Collectors.toCollection(ArrayList::new));
        return listaClientesEstandar.toString();
    }

    public String ListasClientesP(){
        Collection<Cliente>ListasClientesP=listaClientes.getArrayList().stream().filter(cliente -> cliente.tipoCliente().equals("Premium")).collect(Collectors.toCollection(ArrayList::new));
        return listaClientes.toString();
    }

    public String listaPedidos(){
        return this.listaPedidos.toString();
    }

    public void deletePedido (int numPedido){
        Pedidos pedido;
        for (int i = 0; i < listaPedidos.getSize(); ++i) {
            if (listaPedidos.getAt(i).numero_pedido == numPedido) {
                pedido = listaPedidos(i);
            }
        }
        listaPedidos.Eliminar_pedido(pedido);
        }
    }




