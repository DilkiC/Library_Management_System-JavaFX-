package dao.custom;

import dao.CrudDAO;
import entity.Issue;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface IssueDAO extends CrudDAO<Issue,String> {
    String getIid() throws SQLException, ClassNotFoundException;


    ObservableList<Issue> getLastIssue(String text) throws SQLException, ClassNotFoundException;
}
