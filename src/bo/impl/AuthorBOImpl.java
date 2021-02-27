package bo.impl;

import bo.custom.AuthorBO;
import dao.DAOFactory;
import dao.custom.AuthorDAO;
import dao.impl.AuthorDAOImpl;
import dto.AuthorDTO;
import entity.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorBOImpl implements AuthorBO {
    AuthorDAO authorDAO= (AuthorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Author);
    @Override
    public AuthorDTO searchAuthor(String text) throws SQLException, ClassNotFoundException {
        Author author=authorDAO.search(text);
        return new AuthorDTO(author.getAId(),author.getBId(),author.getAName());

    }

    @Override
    public AuthorDTO searchAuthorId(String text) throws SQLException, ClassNotFoundException {
        Author author=authorDAO.searchAId(text);
        return new AuthorDTO(author.getAId(),author.getBId(),author.getAName());
    }
}
