package dao;

import model.Articulo;

import java.sql.*;
import java.util.ArrayList;

public class Articulo_DAO implements DAO<Articulo, String> {
    ConexionBD Manager = new ConexionBD();
    private String select = "SELECT * FROM articulo WHERE codigo=?;";
    private String insert = "INSERT INTO articulo (codigo, descripcion, precio_venta, gestion_envio, tiempo_preparacion) VALUES (?, ?, ?, ?, ?);";
    private String update = "UPDATE articulo SET descripcion=?, precio_venta=?, gestion_envio=?, tiempo_preparacion=? WHERE codigo=?;";
    private String delete = "DELETE FROM articulo WHERE codigo=?;";
    private String selectall = "SELECT * FROM articulo;";

    private Connection connection;

    public Articulo_DAO(Connection connection) {
        try {
            this.connection = Manager.getConnection();
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
    public Articulo select(String s) {
        try {
            PreparedStatement ps = getStatement(select);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String codigo = rs.getString("codigo");
                String descripcion = rs.getString("descripcion");
                Float precio_venta = rs.getFloat("precio_venta");
                Float gastos_envio = rs.getFloat("gestion_envio");
                Long tiempo_preparacion = rs.getLong("tiempo_preparacion");
                return new Articulo(codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion);

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
    public void insert(Articulo articulo) {
        try {
            PreparedStatement ps = getStatement(insert);
            ps.setString(1, articulo.getCodigoalfanumerico());
            ps.setString(2, articulo.getDescripcion());
            ps.setFloat(3, articulo.getPrecio_de_venta());
            ps.setFloat(4, articulo.getGastos_de_envio());
            ps.setLong(5, articulo.getTiempo_de_preparacion());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al insertar " + e);
        }
    }

    @Override
    public void update(Articulo articulo) {
        try {
            PreparedStatement ps = getStatement(update);
            ps.setString(1, articulo.getDescripcion());
            ps.setFloat(2, articulo.getPrecio_de_venta());
            ps.setFloat(3, articulo.getGastos_de_envio());
            ps.setLong(4, articulo.getTiempo_de_preparacion());
            ps.setString(5, articulo.getCodigoalfanumerico());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al ejecutar el update " + e);
        }
    }
    @Override
    public void delete(Articulo articulo) {
        try {
            PreparedStatement ps = getStatement(delete);
            ps.setString(1, articulo.getCodigoalfanumerico());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e) {
            System.out.println("Error al eliminar " + e);
        }
    }


    @Override
    public ArrayList<Articulo> selectall() {
        ArrayList<Articulo> articulos = new ArrayList();
        try {
            PreparedStatement ps = getStatement(selectall);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String codigo = rs.getString("codigo");
                String descripcion = rs.getString("descripcion");
                Float precio_venta = rs.getFloat("precio_venta");
                Float gastos_envio = rs.getFloat("gestion_envio");
                Long tiempo_preparacion = rs.getLong("tiempo_preparacion");
                articulos.add(new Articulo(codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion));
            }
            ps.close();
            return articulos;
        }
        catch (SQLException e) {
            System.out.println("Error al seleccionar todos " + e);
            return null;
        }
    }
}
