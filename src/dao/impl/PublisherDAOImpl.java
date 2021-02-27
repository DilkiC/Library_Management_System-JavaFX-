package dao.impl;

import dao.CrudUtil;
import dao.custom.PublisherDAO;
import entity.Publisher;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherDAOImpl implements PublisherDAO {
    @Override
    public boolean add(Publisher publisher) throws SQLException, ClassNotFoundException {
        String sql="insert into publisher values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,publisher.getpId(),publisher.getbId(),publisher.getpName(),publisher.getpAddress(),publisher.getpContact()) ;

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Publisher publisher) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Publisher search(String s) throws SQLException, ClassNotFoundException {
        String sql="select*from publisher where BId=?";
        ResultSet rst=CrudUtil.executeQuery(sql,s);
        if(rst.next()){
            return new Publisher(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5));
        }
        return null;
    }

    @Override
    public ObservableList<Publisher> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="select count(distinct(pid)) from publisher";
        ResultSet rst= CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }

    @Override
    public Publisher searchDetail(String text) throws SQLException, ClassNotFoundException {
        String sql="select*from publisher where PName=?";
        ResultSet rst=CrudUtil.executeQuery(sql,text);
        if(rst.next()){
            return new Publisher(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5));
        }
        return null;
    }
}
