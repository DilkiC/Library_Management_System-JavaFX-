package bo.custom;

import bo.SuperBO;
import dto.FineDTO;

import java.sql.SQLException;

public interface FineBO extends SuperBO {

    String getLastId() throws SQLException, ClassNotFoundException;

    boolean addFine(FineDTO fineDTO) throws SQLException, ClassNotFoundException;
}
