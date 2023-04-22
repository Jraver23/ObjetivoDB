package dao;

import model.Articulo;
import model.Cliente;
import model.ClienteEstandar;
import model.ClientePremium;

import java.sql.*;
import java.util.ArrayList;

public class Cliente_DAO implements DAO<Cliente, String> {

    ConexionBD Manager = new ConexionBD();
    private String select = "SELECT * FROM cliente WHERE email=?;";
    private String insert = "INSERT INTO cliente (nombre, domicilio, nif, email, tipo_cliente) VALUES (?, ?, ?, ?, ?);";
    private String update = "UPDATE cliente SET nombre=?, domicilio=?, nif=?, email=? WHERE tipo_cliente=?;";
    private String delete = "DELETE FROM cliente WHERE email=?;";
    private String selectall = "SELECT * FROM cliente;";

    private Connection connection;

    public Cliente_DAO(Connection connection) {
        try {
            this.connection= Manager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
            //e.printStackTrace();

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
    public Cliente select(String s) {
        try {
            PreparedStatement ps = getStatement(select);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String nif = rs.getString("nif");
                String email = rs.getString("email");
                String tipoCliente = rs.getString("tipo_cliente");

                if (tipoCliente.equals("Estandar")){
                    return new ClienteEstandar(nombre, domicilio, nif, email);
                }
                else if (tipoCliente.equals("Premium")){
                    return new ClientePremium( nombre, domicilio, nif, email);
                }
                else {
                    return null;
                }
            }
            ps.close();
            return null;
        }
        catch (SQLException e) {
            System.out.println("Error al seleccionar " + e);
            return null;
        }
    }


    @Override
    public void insert(Cliente cliente) {
        try {
            PreparedStatement ps = getStatement(insert);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDomicilio());
            ps.setString(3, cliente.getNif());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.tipoCliente());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al insertar " + e);
        }
    }

    @Override
    public void update(Cliente cliente) {
        try {
            PreparedStatement ps = getStatement(update);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDomicilio());
            ps.setString(3, cliente.getNif());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.tipoCliente());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al ejecutar el update " + e);
        }
    }

    @Override
    public void delete(Cliente cliente) {
        try {
            PreparedStatement ps = getStatement(delete);
            ps.setString(1, cliente.getEmail());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al eliminar " + e);
        }
    }


    @Override
    public ArrayList<Cliente> selectall() {
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            PreparedStatement ps = getStatement(selectall);
            ResultSet rs = ps.executeQuery();
            Cliente cliente = null;
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                String nif = rs.getString("nif");
                String email = rs.getString("email");
                String tipoCliente = rs.getString("tipo_cliente");

                if (tipoCliente.equals("Estandar")){
                    cliente = new ClienteEstandar(nombre, domicilio, nif,email);
                }
                else if (tipoCliente.equals("Premium")){
                    cliente = new ClientePremium(nombre, domicilio, nif,email);
                }
                else {
                    return null;
                }
            }
            clientes.add(cliente);
            ps.close();
            return null;
        }
        catch (SQLException e) {
            System.out.println("Error al seleccionar " + e);
            return null;
        }
    }
}

