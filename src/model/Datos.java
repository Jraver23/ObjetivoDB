package model;

import dao.connectionDAO;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
public class Datos {

    //Definición de atributos privados
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    private String codigoA;
    private Lista<Pedidos> listaPedidosPendientes;

    private connectionDAO daoManager = new connectionDAO();

    //Constructor publico, inicializa los atributos
    public Datos() {
       /* listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();*/
    }

    // GESTIÓN DE ARTICULOS
    //Definición del metodo 'existeArticulo' se comprueba si la lista esta vacia, si es si nos devuleve un 'false'
    public boolean existeArticulo(String codigoA) {
        if (!(daoManager.getArticulo_dao().select(codigoA) == null)){
            return true;
        }
        return false;
      /*  if (listaArticulos.isEmpty() == true) {
            return false;
        }
        //El ciclo 'for' itera sobre todos los elementos, al conseguir el codigo del articulo lo compara con el parametro proporcionado
        //Recorre la lista si no encuentra comparacion el articulo no existe
        for (int i = 0; i < listaArticulos.getSize(); i++) {
            int resultado = listaArticulos.getAt(i).getCodigoalfanumerico().compareTo(codigoA);
            if (resultado == 0) {
                return true;
            }
        }
        return false;*/
    }

    //El metodo 'add.Articulo' coge los parametros y los utiliza para crear un nuevo articulo
    //Cuando lo crea lo pone en la lista de articulos
    public void addArticulo(String codigoA, String descripcionA, float precio_de_venta, float gastos_de_envio, long tiempo_de_preparacion) {
        Articulo articulo;
        articulo = new Articulo(codigoA, descripcionA, precio_de_venta, gastos_de_envio, tiempo_de_preparacion);
        daoManager.getArticulo_dao().insert(articulo);
        /*  Articulo articulo;
        articulo = new Articulo(codigoA, descripcionA, precio_de_venta, gastos_de_envio, tiempo_de_preparacion);
        listaArticulos.add(articulo);*/
    }

    public String listaA() {
        return daoManager.getArticulo_dao().selectall().toString();
        //return this.listaArticulos.toString();
    }


    //GESTIÓN DE CLIENTES
    //En este metodo comienza con verificar si la lista de clientes esta vacia
    public boolean existeCliente(String emailC) {
        if (!(daoManager.getCliente_dao().select(emailC)==null)){
            return true;
        }
        return false;
        /*
        if (listaClientes.isEmpty() == true) {
            return false;
        }
        //En este ciclo si el email coincide lo compara con el parametro insertado > muestra
        for (int i = 0; i < listaClientes.getSize(); i++) {
            int resultado = listaClientes.getAt(i).getEmail().compareTo(emailC);
            if (resultado == 0) {
                return true;
            }
        }
        return false;*/
    }

    public void addClienteToAList(String nombre, String domicilio, String nif, String email, String tipoCliente) {
        Cliente cliente=null;
        if (tipoCliente.compareTo("Estandar")==0) {
            cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        }
        else if (tipoCliente.compareTo("Premium")==0) {
            cliente = new ClientePremium(nombre, domicilio, nif, email);
        }
        daoManager.getCliente_dao().insert(cliente);

        /* Cliente cliente;
        if (tipoCliente.compareTo("Estandar") == 0) {
            cliente = new ClienteEstandar(nombre, domicilio, nif, email);
            listaClientes.add(cliente);
        } else if (tipoCliente.compareTo("Premium") == 0) {
            cliente = new ClientePremium(nombre, domicilio, nif, email);
            listaClientes.add(cliente);
        }*/
    }


    public void cargaDatos() {
        ClienteEstandar cliente1 = new ClienteEstandar("Nordine", "BarcelonaCity", "3625147Z", "nordine@uoc.com");
        listaClientes.add(cliente1);
        ClientePremium cliente2 = new ClientePremium("Sergi", "BadalonaCity", "5654128H", "sergi@uoc.com");
        listaClientes.add(cliente2);
        ClientePremium cliente3 = new ClientePremium("Jorge", "SagradaFamilia", "31025214Z", "Jorge@uoc.com");
        listaClientes.add(cliente3);
        Articulo articulo1 = new Articulo("001", "Escritorio", 160, 20, 1);
        listaArticulos.add(articulo1);
        Articulo articulo2 = new Articulo("002", "Mesa", 140, 10, 60);
        listaArticulos.add(articulo2);
        Articulo articulo3 = new Articulo("003", "Silla", 100, 5, 30);
        listaArticulos.add(articulo3);
        Pedidos pedidos1 = new Pedidos(1, cliente1, articulo1, 2, LocalDateTime.of(2023,04,03,17,15,23));
        Pedidos pedidos2 = new Pedidos(2, cliente2, articulo2, 2, LocalDateTime.of(2023,04,05,18,00,05));
        Pedidos pedidos3 = new Pedidos(3, cliente3, articulo3, 1, LocalDateTime.of(2023,04,04,19,00,45));
        listaPedidos.add(pedidos1);
        listaPedidos.add(pedidos2);
        listaPedidos.add(pedidos3);
        System.out.println("Los datos han sido cargados correctamente");
    }

    public String ListaClientes() {
        return daoManager.getCliente_dao().selectall().toString();
    }

    public String ListaClientesEstandar() {
        ArrayList<ClienteEstandar> clientesEstandar = new ArrayList<>();
        for (Cliente cliente:daoManager.getCliente_dao().selectall()){
            if (cliente.tipoCliente().equals("Estandar")){
                clientesEstandar.add((ClienteEstandar) cliente);
            }
        }
        return clientesEstandar.toString();
       /* Collection<Cliente> listaClientesEstandar = listaClientes.getArrayList().stream().filter(cliente -> cliente.tipoCliente().equals("Estandar")).collect(Collectors.toCollection(ArrayList::new));
        return listaClientesEstandar.toString();*/
    }

    public String ListasClientesP() {
        ArrayList<ClientePremium> clientesPremium = new ArrayList<>();
        for (Cliente cliente:daoManager.getCliente_dao().selectall()){
            if (cliente.tipoCliente().equals("Premium")){
                clientesPremium.add((ClientePremium) cliente);
            }
        }
        return clientesPremium.toString();

        /*Collection<Cliente> ListasClientesP = listaClientes.getArrayList().stream().filter(cliente -> cliente.tipoCliente().equals("Premium")).collect(Collectors.toCollection(ArrayList::new));
        return ListasClientesP.toString();*/
    }

    //Metodo para obtener un cliente con email
    public Cliente getCliente(String email) {

        return daoManager.getCliente_dao().select(email);
        /*if (listaClientes.isEmpty() == true) {
            return null;
        }
        for(int i=0; i<listaClientes.getSize(); i++){
            Cliente cliente=listaClientes.getAt(i);
        if(cliente.getEmail().equals(email)){
            return cliente;
        }
        }
        return null;*/
    }

    //Metodo para obtener un articulo con el codigo articulo
    public Articulo getArticulo(String codigoA){
        return daoManager.getArticulo_dao().select(codigoA);

   /* if (listaArticulos.isEmpty()==true){
        return null;
    }
    for(int i =0; i<listaArticulos.getSize();i++){
        Articulo articulo=listaArticulos.getAt(i);
        if(articulo.getCodigoalfanumerico().equals(codigoA)){
            return articulo;
        }
    }
    return null;*/
}

    public void addPedidos (int numero_pedido, String email, String codigoA, int numero_de_articulo, LocalDateTime fecha){
        Pedidos pedido;
        //Se obtienen el Cliente y el Artículo por sus identificadores únicos
        Cliente cliente = getCliente(email);
        Articulo articulo = getArticulo(codigoA);
        //Se agrega el pedido de acuerdo a su método constructor
        pedido = new Pedidos(numero_pedido, cliente, articulo, numero_de_articulo, fecha);
        daoManager.getPedido_dao().insert(pedido);

        /*Pedidos pedidos;
    //Da como resultado Cliente y Articulo por los parametros unicos
        Cliente cliente=getCliente(email);
        Articulo articulo=getArticulo(codigoA);
    //Se agrega el pedido por su metodo constructor
        pedidos=new Pedidos(numero_pedido, cliente, articulo, numero_de_articulo, fecha);
        listaPedidos.add(pedidos);*/
    }

    public boolean eliminarP(int numero_pedido){

        try{
            Pedidos pedido = daoManager.getPedido_dao().select(numero_pedido);
            daoManager.getPedido_dao().delete(pedido);
            return true;
        }
        catch(Exception e){
            System.out.println("Error al eliminar");
        }
        return false;
       /* if(listaPedidos.isEmpty()){
            return false;
        }
        for(int i=0; i<listaPedidos.getSize();i++){
            if(listaPedidos.getAt(i).numero_pedido == numero_pedido){
                listaPedidos.borrar(listaPedidos.getAt(i));
                return true;
            }
        }
        return false;*/
    }

    public String ListadoPPE(){
        ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>();
        for(Pedidos pedido:daoManager.getPedido_dao().selectall()){
            if (pedido.pedidoEnviado()==false && pedido.cliente instanceof ClienteEstandar){
                listaPedidosPendientes.add(pedido);
            }
        }
        return listaPedidosPendientes.toString();

    /*ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>();
    for(Pedidos pedidos:listaPedidos.lista){
        if(!pedidos.pedidoEnviado() &&pedidos.cliente instanceof ClienteEstandar){
            listaPedidosPendientes.add(pedidos);
        }
    }
    return listaPedidosPendientes.toString();*/
    }
    public String ListadoPPP(){
        ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>();
        for(Pedidos pedido:daoManager.getPedido_dao().selectall()){
            if (pedido.pedidoEnviado()==false && pedido.cliente instanceof ClientePremium){
                listaPedidosPendientes.add(pedido);
            }
        }
        return listaPedidosPendientes.toString();

        /*ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>();
        for(Pedidos pedidos:listaPedidos.lista){
            if(!pedidos.pedidoEnviado() && pedidos.cliente instanceof ClientePremium){
                listaPedidosPendientes.add(pedidos);
            }
        }
        return listaPedidosPendientes.toString();*/
    }
    public String listadoPEE(){
        ArrayList<Pedidos> listaPedidosEnviados = new ArrayList<>();
        for(Pedidos pedido:daoManager.getPedido_dao().selectall()){
            if (pedido.pedidoEnviado()==true && pedido.cliente instanceof ClienteEstandar){
                listaPedidosEnviados.add(pedido);
            }
        }
        return listaPedidosEnviados.toString();

        /*ArrayList<Pedidos> listaPedidosEnviados = new ArrayList<>();
        for(Pedidos pedido:listaPedidos.lista){
            if (pedido.pedidoEnviado()==true && pedido.cliente instanceof ClienteEstandar){
                listaPedidosEnviados.add(pedido);
            }
        }
        return listaPedidosEnviados.toString();*/
    }

    public String listadoPEP(){

        ArrayList<Pedidos> listaPedidosEnviados = new ArrayList<>();
        for(Pedidos pedido:daoManager.getPedido_dao().selectall()){
            if (pedido.pedidoEnviado()==true && pedido.cliente instanceof ClientePremium){
                listaPedidosEnviados.add(pedido);
            }
        }
        return listaPedidosEnviados.toString();
        /*ArrayList<Pedidos> listaPedidosEnviados = new ArrayList<>();
        for(Pedidos pedido:listaPedidos.lista){
            if (pedido.pedidoEnviado()==true && pedido.cliente instanceof ClientePremium){
                listaPedidosEnviados.add(pedido);
            }
        }
        return listaPedidosEnviados.toString();*/
    }
}










