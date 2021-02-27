package bo.impl;

import bo.custom.QuantityBO;
import dao.DAOFactory;
import dao.custom.QuantityDAO;
import dao.impl.QuantityDAOImpl;
import dto.QuantityDTO;
import entity.Quantity;

import java.sql.SQLException;

public class QuantityBOImpl implements QuantityBO {
    QuantityDAO quantityDAO= (QuantityDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Quantity);
    @Override
    public QuantityDTO searchQuantity(String text) throws SQLException, ClassNotFoundException {
        Quantity quantity=quantityDAO.search(text);
        return  new QuantityDTO(quantity.getBId(),quantity.getBName(),quantity.getBQuantity(),quantity.getCQuantity());
    }
}
