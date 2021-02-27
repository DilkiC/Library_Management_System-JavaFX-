package dao.custom;

import dao.CrudDAO;
import entity.Author;

import java.sql.SQLException;

public interface AuthorDAO extends CrudDAO<Author,String> {
    Author searchAId(String text) throws SQLException, ClassNotFoundException;
}
