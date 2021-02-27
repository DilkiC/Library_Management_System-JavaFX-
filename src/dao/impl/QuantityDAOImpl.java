package dao.impl;

import dao.CrudUtil;
import dao.custom.QuantityDAO;
import entity.Quantity;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class QuantityDAOImpl implements QuantityDAO {
    @Override
    public boolean add(Quantity quantity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Quantity quantity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Quantity search(String s) throws SQLException, ClassNotFoundException {
        String sql="select*from quantity where BName=?";
        ResultSet rst= CrudUtil.executeQuery(sql,s);
        if(rst.next()){
            return new Quantity(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getInt(4));
        }
        return null;
    }

    @Override
    public ObservableList<Quantity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
