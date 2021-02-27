package dao.impl;

import dao.CrudUtil;
import dao.custom.AuthorDAO;
import entity.Author;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public boolean add(Author author) throws SQLException, ClassNotFoundException {
        String sql="insert into author values(?,?,?)";
        return CrudUtil.executeUpdate(sql,author.getAId(),author.getBId(),author.getAName());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Author author) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Author search(String s) throws SQLException, ClassNotFoundException {
        String sql="select*from author where BId=?";
        ResultSet rst= CrudUtil.executeQuery(sql,s);
        if(rst.next()){
            return new Author(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    @Override
    public ObservableList<Author> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Author searchAId(String text) throws SQLException, ClassNotFoundException {
        String sql="select*from author where AName=?";
        ResultSet rst= CrudUtil.executeQuery(sql,text);
        if(rst.next()){
            return new Author(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }
}
