package dao;


import model.Articulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class connectionDAO {

    private Connection connection;
    private Articulo_DAO articulo_dao = null;
    private Cliente_DAO cliente_dao = null;
    private Pedido_DAO pedido_dao = null;

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/objetivodb?serverTimezone = UTC";
    private String username = "root";
    private String password = "";

    //Generamos el constructor
    public connectionDAO() {
        try {
            this.connection = getConnection();
        } catch (SQLDataException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Agregación de capsula throw para indicar que el metodo puede arrojar excepciones SQLException
    public Connection getConnection() throws SQLDataException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            //Manejo de excepción para ClassNotFoundException
            System.out.println("No se puede encontrar el driver de la base de datos");
            throw e;
        } catch (SQLException e) {
            //Manejo de excepción para SQLException
            System.out.println("No se pudo conectar a la vase de datos");
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return connection;
    }


    public Articulo_DAO getArticulo_dao() {
        if (articulo_dao == null) {
            articulo_dao = new Articulo_DAO(connection);
        }
        return articulo_dao;
    }

    public Cliente_DAO getCliente_dao(){
        if (cliente_dao == null){
            cliente_dao = new Cliente_DAO(connection);
        }
        return cliente_dao;
    }

    public Pedido_DAO getPedido_dao() {
        if (pedido_dao == null){

        }
        return pedido_dao;
    }
}