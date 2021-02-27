package bo.custom;

import bo.SuperBO;
import dto.QuantityDTO;

import java.sql.SQLException;

public interface QuantityBO extends SuperBO {
    QuantityDTO searchQuantity(String text) throws SQLException, ClassNotFoundException;
}
