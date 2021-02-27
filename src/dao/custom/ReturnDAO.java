package dao.custom;

import dao.CrudDAO;
import entity.Return;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ReturnDAO extends CrudDAO<Return,String> {
    String getLastId() throws SQLException, ClassNotFoundException;


    ObservableList<Return> getLastReturn(String text) throws SQLException, ClassNotFoundException;

    String getLastDates(String text) throws SQLException, ClassNotFoundException;
}
