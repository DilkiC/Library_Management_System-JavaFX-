package dao.impl;

import dao.CrudUtil;
import dao.custom.BookFeeDAO;
import entity.BookFee;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookFeeDAOImpl implements BookFeeDAO {
    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql="select BFId from BookFee order by BFId desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return  null;
    }

    @Override
    public boolean add(BookFee bookFee) throws SQLException, ClassNotFoundException {
        String sql="insert into bookFee values (?,?,?,?)";
        return  CrudUtil.executeUpdate(sql,bookFee.getBFId(),bookFee.getIId(),bookFee.getNoOfBooks(),bookFee.getTotal());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(BookFee bookFee) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public BookFee search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<BookFee> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
