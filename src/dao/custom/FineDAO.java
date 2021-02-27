package dao.custom;

import dao.CrudDAO;
import entity.Fine;

import java.sql.SQLException;

public interface FineDAO extends CrudDAO<Fine,String> {
    String getLastId() throws SQLException, ClassNotFoundException;
}
