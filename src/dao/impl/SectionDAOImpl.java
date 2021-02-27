package dao.impl;

import dao.CrudUtil;
import dao.custom.SectionDAO;
import entity.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionDAOImpl implements SectionDAO {
    @Override
    public boolean add(Section section) throws SQLException, ClassNotFoundException {
       String sql="insert into bsection values(?,?,?)";
       return CrudUtil.executeUpdate(sql,section.getSId(),section.getBId(),section.getSName());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Section section) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Section search(String s) throws SQLException, ClassNotFoundException {
       String sql="select*from bSection where BId=?";
        ResultSet rst= CrudUtil.executeQuery(sql,s);
        if(rst.next()){
            return new Section(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    @Override
    public ObservableList<Section> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public Section searchSecName(String secName) throws SQLException, ClassNotFoundException {
        String sql="select*from bSection where SName=?";
        ResultSet rst= CrudUtil.executeQuery(sql,secName);
        if(rst.next()){
            return new Section(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }
}
