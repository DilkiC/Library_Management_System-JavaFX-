package bo.impl;

import bo.custom.BookFeeBO;
import dao.DAOFactory;
import dao.custom.BookFeeDAO;
import dao.impl.BookFeeDAOImpl;

import java.sql.SQLException;

public class BookFeeBOImpl implements BookFeeBO {
    BookFeeDAO bookFeeDAO= (BookFeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BookFee);

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return bookFeeDAO.getLastId();
    }
}
