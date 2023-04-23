package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  ConexionBD {

    private Connection connection;

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/objetivodb";
    private String username = "root";
    private String password = "";

    private Articulo_DAO articulo_dao = null;
    private Cliente_DAO cliente_dao = null;
    private Pedido_DAO pedido_dao = null;

    public ConexionBD() {
        this.connection = getConnection();
    }

    public Connection getConnection() {

        try {
            // Registrar el driver JDBC
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

        public Articulo_DAO getArticulo_dao () {
            if (articulo_dao == null) {
                articulo_dao = new Articulo_DAO(connection);
            }
            return articulo_dao;
        }

        public Cliente_DAO getCliente_dao () {
            if (cliente_dao == null) {
                cliente_dao = new Cliente_DAO(connection);
            }
            return cliente_dao;
        }

        public Pedido_DAO getPedido_dao () {
            if (pedido_dao == null) {
                pedido_dao = new Pedido_DAO(connection);
            }
            return pedido_dao;
        }
    }

