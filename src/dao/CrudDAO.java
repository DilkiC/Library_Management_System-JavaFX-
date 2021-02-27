package dao;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CrudDAO<T,ID> extends SuperDAO{
    public boolean add(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public T search(ID id) throws SQLException, ClassNotFoundException;
    public ObservableList<T> getAll() throws SQLException, ClassNotFoundException;
}
