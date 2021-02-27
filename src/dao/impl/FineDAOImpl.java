package dao.impl;

import dao.CrudUtil;
import dao.custom.FineDAO;
import entity.Fine;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FineDAOImpl implements FineDAO {
    @Override
    public boolean add(Fine fine) throws SQLException, ClassNotFoundException {
        String sql="insert into fine values(?,?,?)";
        return CrudUtil.executeUpdate(sql,fine.getfId(),fine.getrId(),fine.getTotFine());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Fine fine) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Fine search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Fine> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql="select FId from fine order by FId desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
