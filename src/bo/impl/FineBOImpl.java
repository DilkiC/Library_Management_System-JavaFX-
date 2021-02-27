package bo.impl;

import bo.custom.FineBO;
import dao.DAOFactory;
import dao.custom.FineDAO;
import dao.impl.FineDAOImpl;
import dto.FineDTO;
import entity.Fine;

import java.sql.SQLException;

public class FineBOImpl implements FineBO {
    FineDAO fineDAO= (FineDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Fine);
    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return fineDAO.getLastId();
    }

    @Override
    public boolean addFine(FineDTO fineDTO) throws SQLException, ClassNotFoundException {
        return fineDAO.add(new Fine(fineDTO.getfId(),fineDTO.getrId(),fineDTO.getTotFine()));
    }
}
