package dao.impl;

import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.BookDAO;
import entity.Book;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean add(Book book) throws SQLException, ClassNotFoundException {
        String sql="insert into book values(?,?,?)";
        return CrudUtil.executeUpdate(sql,book.getBId(),book.getBName(),book.getPrice());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Book search(String s) throws SQLException, ClassNotFoundException {
        String sql="select * from Book where BId=?";
        ResultSet rst= CrudUtil.executeQuery(sql,s);
        if(rst.next()){
            return new Book(rst.getString("BId"),rst.getString("BName"),rst.getDouble("Price"));
        }
        return null;
    }

    @Override
    public ObservableList<Book> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="select count(BId) from book";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql="select BId from book order by BId desc limit 1";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if(rst.next()){
           return rst.getString(1);
        }
        return null;
    }

    @Override
    public Book searchBookId(String text) throws SQLException, ClassNotFoundException {
        String sql="select * from Book where BName=?";
        ResultSet rst= CrudUtil.executeQuery(sql,text);
        if(rst.next()){
            return new Book(rst.getString("BId"),rst.getString("BName"),rst.getDouble("Price"));
        }
        return null;
    }
}
