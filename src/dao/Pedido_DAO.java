package dao;

import model.Pedidos;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido_DAO implements DAO<Pedidos, Integer>{

    connectionDAO Manager = new connectionDAO();
    private String select = "SELECT * FROM pedido WHERE numero_pedido=?;";
    private String insert = "INSERT INTO pedido (numero_pedido, email_cliente, codigo_articulo, numero_articulo, fecha) VALUES (?, ?, ?, ?, ?);";
    private String update = "UPDATE pedido SET email_cliente=?, codigo_articulo=?, numero_articulo=?, fecha=? WHERE numero_pedido=?;";
    private String delete = "DELETE FROM pedido WHERE numero_pedido=?;";
    private String selectall = "SELECT * FROM pedido;";

    private Connection connection;

    public Pedido_DAO(Connection connection) {
        try {
            this.connection = Manager.getConnection();
        } catch (SQLDataException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getStatement(String query) {
        try {
            return this.connection.prepareStatement(query);
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    @Override
    public void insert(Pedidos pedido) {
        try {
            PreparedStatement ps = getStatement(insert);
            ps.setInt(1, pedido.getNumero_pedido());
            ps.setString(2, pedido.getCliente().getEmail());
            ps.setString(3, pedido.getArticulo().getCodigoalfanumerico());
            ps.setFloat(4, pedido.getNumero_de_articulos());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(pedido.getFecha()));
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al insertar " + e);
        }
    }

    @Override
    public void update(Pedidos pedido) {
        try {
            PreparedStatement ps = getStatement(update);
            ps.setString(1, pedido.getCliente().getEmail());
            ps.setString(2, pedido.getArticulo().getCodigoalfanumerico());
            ps.setInt(3, pedido.getNumero_de_articulos());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(pedido.getFecha()));
            ps.setInt(5, pedido.getNumero_pedido());
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void delete(Pedidos pedido) {
        try {
            PreparedStatement ps = getStatement(delete);
            ps.setInt(1, pedido.getNumero_pedido());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al eliminar " + e);
        }
    }


    @Override
    public Pedidos select(Integer integer) {
        try {
            PreparedStatement ps = getStatement(select);
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Integer numero_pedido = rs.getInt("numero_pedido");
                String email_cliente = rs.getString("email_cliente");
                String codigo_articulo = rs.getString("codigo_articulo");
                Integer numero_articulo = rs.getInt("numero_articulo");
                LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
                return new Pedidos(numero_pedido, Manager.getCliente_dao().select(email_cliente), Manager.getArticulo_dao().select(codigo_articulo), numero_articulo, fecha);
            }
            ps.close();
            return null;
        }

        catch (SQLException e) {
            System.out.println("Error al consultar " + e);
            return null;
        }
    }

    @Override
    public ArrayList<Pedidos> selectall() {
        ArrayList<Pedidos> pedidos = new ArrayList();
        try {
            PreparedStatement ps = getStatement(selectall);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer numero_pedido = rs.getInt("numero_pedido");
                String email_cliente = rs.getString("email_cliente");
                String codigo_articulo = rs.getString("codigo_articulo");
                Integer numero_articulo = rs.getInt("numero_articulo");
                LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();
                pedidos.add(new Pedidos(numero_pedido, Manager.getCliente_dao().select(email_cliente), Manager.getArticulo_dao().select(codigo_articulo), numero_articulo, fecha));
            }
            ps.close();
            return pedidos;
        }
        catch (SQLException e) {
            System.out.println("Error al consultar " + e);
            return null;
        }
    }
}
