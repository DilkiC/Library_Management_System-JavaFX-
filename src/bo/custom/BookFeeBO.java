package bo.custom;

import bo.SuperBO;

import java.sql.SQLException;

public interface BookFeeBO extends SuperBO {
    String getLastId() throws SQLException, ClassNotFoundException;
}
