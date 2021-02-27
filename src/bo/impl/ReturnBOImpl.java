package bo.impl;

import bo.custom.ReturnBO;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.custom.IssueDAO;
import dao.custom.ReturnDAO;
import dao.impl.IssueDAOImpl;
import dao.impl.ReturnDAOImpl;
import dto.IssueDTO;
import dto.ReturnDTO;
import entity.Issue;
import entity.Return;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ReturnBOImpl implements ReturnBO {
    ReturnDAO returnDAO= (ReturnDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Return);
IssueDAO issueDAO=new IssueDAOImpl();

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return returnDAO.getLastId();
    }

    @Override
    public ObservableList<ReturnDTO> getLastReturn(String text) throws SQLException, ClassNotFoundException {
        ObservableList<Return>list=returnDAO.getLastReturn(text);
        ObservableList<ReturnDTO> returnList = FXCollections.observableArrayList();
        for (Return r : list) {
            returnList.add(new ReturnDTO(r.getRId(),r.getIId(),r.getBId(),r.getRDate(),r.getMRDate(),r.getLateDates()));

        }
        return returnList;
    }

    @Override
    public String getLastDates(String text) throws SQLException, ClassNotFoundException {
        return returnDAO.getLastDates(text);
    }

    @Override
    public boolean addReturn(ReturnDTO returnDTO) throws SQLException, ClassNotFoundException {
        return returnDAO.add(new Return(returnDTO.getRId(),returnDTO.getIId(),returnDTO.getBId(),returnDTO.getRDate(),returnDTO.getMRDate(),returnDTO.getLateDates()));
    }


}
