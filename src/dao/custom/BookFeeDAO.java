package dao.custom;

import dao.CrudDAO;
import entity.BookFee;

import java.sql.SQLException;

public interface BookFeeDAO extends CrudDAO<BookFee,String> {
    String getLastId() throws SQLException, ClassNotFoundException;
}
