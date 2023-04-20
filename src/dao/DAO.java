package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T, K> {
    public PreparedStatement getStatement(String query) throws SQLException;
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public T select(K k);
    public ArrayList<T> selectall();
}