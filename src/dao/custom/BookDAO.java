package dao.custom;

import dao.CrudDAO;
import entity.Book;

import java.sql.SQLException;

public interface BookDAO extends CrudDAO<Book,String> {
    int getRowCount() throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;

    Book searchBookId(String text) throws SQLException, ClassNotFoundException;
}
