package bo.custom;

import bo.SuperBO;
import dto.AddBookDTO;

import java.sql.SQLException;

public interface AddBooksBO extends SuperBO {
    boolean addBookDetail(AddBookDTO addBookDTO) throws SQLException, ClassNotFoundException;
}
