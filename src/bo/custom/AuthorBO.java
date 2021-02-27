package bo.custom;

import bo.SuperBO;
import dto.AuthorDTO;

import java.sql.SQLException;

public interface AuthorBO extends SuperBO {
    AuthorDTO searchAuthor(String text) throws SQLException, ClassNotFoundException;

    AuthorDTO searchAuthorId(String text) throws SQLException, ClassNotFoundException;
}
