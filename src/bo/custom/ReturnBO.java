package bo.custom;

import bo.SuperBO;
import com.jfoenix.controls.JFXTextField;
import dto.IssueDTO;
import dto.MemberDTO;
import dto.ReturnDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ReturnBO extends SuperBO {

    String getLastId() throws SQLException, ClassNotFoundException;


    ObservableList<ReturnDTO> getLastReturn(String text) throws SQLException, ClassNotFoundException;

    String getLastDates(String text) throws SQLException, ClassNotFoundException;

    boolean addReturn(ReturnDTO returnDTO) throws SQLException, ClassNotFoundException;


}
