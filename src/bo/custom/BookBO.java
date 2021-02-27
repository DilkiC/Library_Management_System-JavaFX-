package bo.custom;

import bo.SuperBO;
import dto.BookDTO;

import java.sql.SQLException;

public interface BookBO extends SuperBO {
    public BookDTO searchBook(String id) throws SQLException, ClassNotFoundException;

    int getRowCount() throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;

    BookDTO searchBookId(String text) throws SQLException, ClassNotFoundException;
}
