package bo.custom;

import bo.SuperBO;
import dto.IssueDTO;

import dto.IssueFeeDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface IssueBO extends SuperBO {
    String getIid() throws SQLException, ClassNotFoundException;


    boolean IssuFeeDetails(IssueFeeDTO issueBookDTO) throws SQLException, ClassNotFoundException;

    ObservableList<IssueDTO> getLastIssue1(String text) throws SQLException, ClassNotFoundException;
}
