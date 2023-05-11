package model;

import dao.ConexionBD;

//import dao.connectionDAO;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import com.mysql.cj.Session;



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
        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Articulo> criteria = builder.createQuery(Articulo.class);
            criteria.from(Articulo.class);
            List<Articulo> entityList = session.createQuery(criteria).getResultList();
            for (Articulo e : entityList) {
                resultado =resultado.concat("\n" + e.toString());
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;
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
            cliente = (Cliente)session.get(Cliente.class,emailC);

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


   /*public void cargaDatos() {
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
        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            List<Cliente> entityList = session.createQuery(criteria).getResultList();
            for (Cliente e : entityList) {
                resultado =resultado.concat("\n" + e.toString());
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;

    }

    public String ListaClientesEstandar() {
        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            List<Cliente> entityList = session.createQuery(criteria).getResultList();
            for (Cliente e : entityList) {
                if(e.tipoCliente().compareTo("Estandar")==0) {
                    resultado =resultado.concat("\n" + e.toString());
                }
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;

    }

    public String ListasClientesP() {
        //nose si esto es correcto o no.
        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            List<Cliente> entityList = session.createQuery(criteria).getResultList();
            for (Cliente e : entityList) {
                if(e.tipoCliente().compareTo("Premium")==0) {
                    resultado =resultado.concat("\n" + e.toString());
                }
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;

    }

    //Metodo para obtener un cliente con email
    public Cliente getCliente(String email) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = null;

        try {
            tx = session.beginTransaction();
            cliente = session.get(Cliente.class, email);
        } catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return cliente;

    }


    //Metodo para obtener un articulo con el codigo articulo
    public Articulo getArticulo(String codigoA){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Articulo articulo = null;

        try {
            tx = session.beginTransaction();
            articulo = session.get(Articulo.class, codigoA);
        } catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
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
        Transaction transaction = null;

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

        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pedidos> criteria = builder.createQuery(Pedidos.class);
            criteria.from(Pedidos.class);
            List<Pedidos> entityList = session.createQuery(criteria).getResultList();
            for (Pedidos e : entityList) {
                if(e.pedidoEnviado()==false && e.getCliente().tipoCliente().compareTo("Estandard")==0 ) {
                    resultado =resultado.concat("\n" + e.toString());
                }
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;

    }



    public String ListadoPPP(){

        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pedidos> criteria = builder.createQuery(Pedidos.class);
            criteria.from(Pedidos.class);
            List<Pedidos> entityList = session.createQuery(criteria).getResultList();
            for (Pedidos e : entityList) {
                if(e.pedidoEnviado()==false && e.getCliente().tipoCliente().compareTo("Premium")==0 ) {
                    resultado =resultado.concat("\n" + e.toString());
                }
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;

    }
    public String listadoPEE(){
        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pedidos> criteria = builder.createQuery(Pedidos.class);
            criteria.from(Pedidos.class);
            List<Pedidos> entityList = session.createQuery(criteria).getResultList();
            for (Pedidos e : entityList) {
                if(e.pedidoEnviado()==true && e.getCliente().tipoCliente().compareTo("Estandard")==0 ) {
                    resultado =resultado.concat("\n" + e.toString());
                }
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;
    }

    }

    public String listadoPEP(){

        String resultado ="";


        Transaction tx = null;
        //Get the session object.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pedidos> criteria = builder.createQuery(Pedidos.class);
            criteria.from(Pedidos.class);
            List<Pedidos> entityList = session.createQuery(criteria).getResultList();
            for (Pedidos e : entityList) {
                if(e.pedidoEnviado()==true && e.getCliente().tipoCliente().compareTo("Premium")==0 ) {
                    resultado =resultado.concat("\n" + e.toString());
                }
            }
        }catch (HibernateException e) {
            if(tx!=null){
                //Roll back if any exception occurs.
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            //Close hibernate session.
            session.close();
        }
        return resultado;
    }
}








