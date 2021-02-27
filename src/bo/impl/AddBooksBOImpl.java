package bo.impl;

import bo.custom.AddBooksBO;
import dao.DAOFactory;
import dao.custom.AuthorDAO;
import dao.custom.BookDAO;
import dao.custom.PublisherDAO;
import dao.custom.SectionDAO;
import dao.impl.AuthorDAOImpl;
import dao.impl.BookDAOImpl;
import dao.impl.PublisherDAOImpl;
import dao.impl.SectionDAOImpl;
import db.DBConnection;
import dto.*;
import entity.*;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

public class AddBooksBOImpl implements AddBooksBO {
    BookDAO bookDAO = (BookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Book);
    SectionDAO sectionDAO = (SectionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Section);
    PublisherDAO publisherDAO = (PublisherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Publisher);
    AuthorDAO authorDAO = (AuthorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Author);

    @Override
    public boolean addBookDetail(AddBookDTO addBookDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        BookDTO bookDTO = addBookDTO.getBookDTO();
        Book book = new Book(bookDTO.getBId(), bookDTO.getBName(), bookDTO.getPrice());
        boolean isAddedB = bookDAO.add(book);

        try {
            if (isAddedB) {
                SectionDTO sectionDTO = addBookDTO.getSectionDTO();
                Section section = new Section(sectionDTO.getSId(), sectionDTO.getBId(), sectionDTO.getSName());
                boolean isAddedS = sectionDAO.add(section);

                if (isAddedS) {
                    PublisherDTO publisherDTO = addBookDTO.getPublisherDTO();
                    Publisher publisher = new Publisher(publisherDTO.getpId(), publisherDTO.getbId(), publisherDTO.getpName(), publisherDTO.getpAddress(), publisherDTO.getpContact());
                    boolean isAddedP = publisherDAO.add(publisher);

                    if (isAddedP) {
                        AuthorDTO authorDTO = addBookDTO.getAuthorDTO();
                        Author author = new Author(authorDTO.getAId(), authorDTO.getBId(), authorDTO.getAName());
                        boolean isAddedA = authorDAO.add(author);

                        if (isAddedA) {
                            connection.commit();
                            return true;
                        } else {
                            connection.rollback();
                            return false;
                        }

                    } else {
                        connection.rollback();
                        return false;
                    }
                } else {
                    connection.rollback();
                    return false;
                }
            }else {
                connection.rollback();
                return false;
            }


    }finally {
            connection.setAutoCommit(true);
        }

    }
}
