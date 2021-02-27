package bo.impl;

import bo.custom.IssueBO;
import dao.DAOFactory;
import dao.custom.BookFeeDAO;
import dao.custom.IssueDAO;
import dao.custom.QueryDAO;
import dao.impl.BookFeeDAOImpl;
import dao.impl.IssueDAOImpl;
import dao.impl.QueryDAOImpl;
import db.DBConnection;
import dto.BookFeeDTO;

import dto.IssueFeeDTO;
import dto.IssueDTO;
import entity.BookFee;

import entity.Issue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

public class IssueBOImpl implements IssueBO {

    IssueDAO issueDAO = (IssueDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Issue);
    BookFeeDAO bookFeeDAO = (BookFeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BookFee);


    @Override
    public String getIid() throws SQLException, ClassNotFoundException {
        return issueDAO.getIid();
    }

    @Override
    public boolean IssuFeeDetails(IssueFeeDTO issueBookDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        ObservableList<IssueDTO>issueDTOS = issueBookDTO.getIssueDTOList();
        boolean isAdded = false;
        for (IssueDTO a:issueDTOS) {
            Issue issue = new Issue(a.getIId(), a.getMemId(), a.getBId(), a.getBName(), a.getIDate(), a.getRDate());
             isAdded = issueDAO.add(issue);
        }
        try {
            if (isAdded) {
                BookFeeDTO bookFeeDTO = issueBookDTO.getBookFeeDTO();
                BookFee bookFee = new BookFee(
                        bookFeeDTO.getBFId(),
                        bookFeeDTO.getIId(),
                        bookFeeDTO.getNoOfBooks(),
                        bookFeeDTO.getTotal()
                );
                boolean isAddedBookFee = bookFeeDAO.add(bookFee);
                if (isAddedBookFee) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                connection.rollback();
                return false;
            }
        }finally {
            connection.setAutoCommit(true);
        }
    }


    @Override
    public ObservableList<IssueDTO> getLastIssue1(String text) throws SQLException, ClassNotFoundException {
        ObservableList<Issue>list=issueDAO.getLastIssue(text);
        ObservableList<IssueDTO> issueList = FXCollections.observableArrayList();
        for (Issue c : list) {
            issueList.add(new IssueDTO(c.getIId(),c.getMemId(),c.getBId(),c.getBName(),c.getIDate(),c.getRDate()));

        }
        return issueList;
    }


}
