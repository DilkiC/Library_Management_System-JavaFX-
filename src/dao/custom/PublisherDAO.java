package dao.custom;

import dao.CrudDAO;
import entity.Publisher;

import java.sql.SQLException;

public interface PublisherDAO extends CrudDAO<Publisher,String> {
    int getRowCount() throws SQLException, ClassNotFoundException;

    Publisher searchDetail(String text) throws SQLException, ClassNotFoundException;
}
