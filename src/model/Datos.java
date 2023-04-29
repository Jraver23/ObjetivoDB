package model;

import com.mysql.cj.Session;
import dao.ConexionBD;
//import dao.connectionDAO;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.persistence.criteria.CriteriaBuilder;
import java.persistence.criteria.CriteriaQuery;




public class Datos {

    //Definición de atributos privados
   /* private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;*/
    private String codigoA;
    //private Lista<Pedidos> listaPedidosPendientes;

   // private ConexionBD daoManager = new ConexionBD();

    //Constructor publico, inicializa los atributos
    public Datos() {
      /* listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();*/
    }

    // GESTIÓN DE ARTICULOS
    //Definición del metodo 'existeArticulo' se comprueba si la lista esta vacia, si es si nos devuleve un 'false'
    public boolean existeArticulo(String codigoA) {

        Articulo articulo = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            articulo = (Articulo)session.get(Articulo.class,codigoA);

        }catch (HibernateException e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        if(articulo==null){
            return false;
        } else{
            return true;
        }
    }

    //El metodo 'add.Articulo' coge los parametros y los utiliza para crear un nuevo articulo
    //Cuando lo crea lo pone en la lista de articulos
    public void addArticulo(String codigoA, String descripcionA, float precio_de_venta, float gastos_de_envio, long tiempo_de_preparacion) {
        Articulo articulo = new Articulo(codigoA,descripcionA,precio_de_venta,gastos_de_envio,tiempo_de_preparacion);

        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();

            session.save(articulo);

            transaction.commit();

        }catch (HibernateException e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    public String listaA() {
        //Como se hace?
        ArrayList<Articulo> listArticulos = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Articulo> query = session.createQuery("from Articulo", Articulo.class);
            listArticulos = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return listArticulos.toString();
       /* return daoManager.getArticulo_dao().selectall().toString();*/
        //return this.listaArticulos.toString();
    }


    //GESTIÓN DE CLIENTES
    //En este metodo comienza con verificar si la lista de clientes esta vacia
    public boolean existeCliente(String emailC) {
        Cliente cliente = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            cliente = (Cliente)session.get(Articulo.class,emailC);

        }catch (HibernateException e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        if(cliente==null){
            return false;
        } else{
            return true;
        }
    }

    public void addClienteToAList(String nombre, String domicilio, String nif, String email, String tipoCliente) {

        Cliente cliente=null;
        if (tipoCliente.compareTo("Estandar")==0) {
            cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        }
        else if (tipoCliente.compareTo("Premium")==0) {
            cliente = new ClientePremium(nombre, domicilio, nif, email);
        }
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();

            session.save(cliente);

            transaction.commit();

        }catch (HibernateException e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }

    }


   /* public void cargaDatos() {
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
    }*/

    public String ListaClientes() {
        ArrayList<Cliente> listClientes = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Cliente> query = session.createQuery("from Cliente", Cliente.class);
            listClientes = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return listClientes.toString();

        }

    public String ListaClientesEstandar() {
        ArrayList<ClienteEstandar> listaClientesEstandar = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<ClienteEstandar> query = session.createQuery("from ClienteEstandar", ClienteEstandar.class);
            listaClientesEstandar = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return listaClientesEstandar.toString();

    }

    public String ListasClientesP() {
        //nose si esto es correcto o no.
        ArrayList<ClientePremium> listaClientesPremium = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<ClientePremium> query = session.createQuery("from ClientePremium", ClientePremium.class);
            listaClientesPremium = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return listaClientesPremium.toString();

    }

    //Metodo para obtener un cliente con email
    public Cliente getCliente(String email) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = null;

        try {
            cliente = session.get(Cliente.class, email);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return cliente;

    }


    //Metodo para obtener un articulo con el codigo articulo
    public Articulo getArticulo(String codigoA){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Articulo articulo = null;

        try {
            articulo = session.get(Articulo.class, codigoA);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return articulo;

    }
        //return daoManager.getArticulo_dao().select(codigoA);

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


    public void addPedidos (int numero_pedido, String email, String codigoA, int numero_de_articulo, LocalDateTime fecha){

        Pedidos pedido;
        Cliente cliente = getCliente(email);
        Articulo articulo = getArticulo(codigoA);
        pedido = new Pedidos(numero_pedido,cliente,articulo,numero_de_articulo,fecha);

        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();

            session.save(pedido);

            transaction.commit();

        }catch (HibernateException e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    public boolean eliminarP(int numero_pedido){

        boolean resultado = false;
        Transaction transaction = nul;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            transaction = session.beginTransaction();
            Serializable id = new Integer(numero_pedido);
            Object persistentInstance = session.load(Pedidos.class,id);

            if(persistentInstance != null){
                session.delete(persistentInstance);
                transaction.commit();
                resultado = true;

            }
        }catch (HibernateException e){
            if(transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return resultado;
    }

    public String ListadoPPE(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Pedidos> query = session.createQuery("from Pedido p where p.enviado = false and type(p.cliente) = ClienteEstandar", Pedidos.class);
            ArrayList<Pedidos> resultado = query.getResultList();
            ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>(resultado);
            return listaPedidosPendientes.toString();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;

    }



    public String ListadoPPP(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Pedidos> query = session.createQuery("from Pedido p where p.enviado = false and type(p.cliente) = ClientePremium", Pedidos.class);
            ArrayList<Pedidos> resultado = query.getResultList();
            ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>(resultado);
            return listaPedidosPendientes.toString();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;

    }
    public String listadoPEE(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Pedidos> query = session.createQuery("from Pedido p where p.enviado = true and type(p.cliente) = ClienteEstandar", Pedidos.class);
            ArrayList<Pedidos> resultado = query.getResultList();
            ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>(resultado);
            return listaPedidosPendientes.toString();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;

    }

    public String listadoPEP(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Pedidos> query = session.createQuery("from Pedido p where p.enviado = true and type(p.cliente) = ClientePremium", Pedidos.class);
            ArrayList<Pedidos> resultado = query.getResultList();
            ArrayList<Pedidos> listaPedidosPendientes = new ArrayList<>(resultado);
            return listaPedidosPendientes.toString();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
        
    }
}










