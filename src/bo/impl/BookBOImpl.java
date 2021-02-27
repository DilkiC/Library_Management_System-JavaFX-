package bo.impl;

import bo.custom.BookBO;
import dao.DAOFactory;
import dao.custom.BookDAO;
import dao.impl.BookDAOImpl;
import dto.BookDTO;
import entity.Book;

import java.sql.SQLException;

public class BookBOImpl implements BookBO {

    BookDAO bookDAO= (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Book);

    @Override
    public BookDTO searchBook(String id) throws SQLException, ClassNotFoundException {
        Book book=bookDAO.search(id);
        return new BookDTO(book.getBId(),book.getBName(),book.getPrice());
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        return bookDAO.getRowCount();
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return bookDAO.getLastId();
    }

    @Override
    public BookDTO searchBookId(String text) throws SQLException, ClassNotFoundException {
        Book book=bookDAO.searchBookId(text);
        return new BookDTO(book.getBId(),book.getBName(),book.getPrice());
    }
}
