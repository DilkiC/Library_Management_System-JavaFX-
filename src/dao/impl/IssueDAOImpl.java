package dao.impl;

import dao.CrudUtil;
import dao.custom.IssueDAO;
import entity.Issue;
import entity.Return;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueDAOImpl implements IssueDAO {
    @Override
    public String getIid() throws SQLException, ClassNotFoundException {
        String sql="select IId from Issue order by IId desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public ObservableList<Issue> getLastIssue(String text) throws SQLException, ClassNotFoundException {
        String sql="select IId,MemId,BId,BName,IDate,RDate from Issue where MemId=? order by IId desc";
        ResultSet rst = CrudUtil.executeQuery(sql,text);
        ObservableList<Issue> list = FXCollections.observableArrayList();
        while(rst.next()){
            list.add(new Issue(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
return list;
    }


    @Override
    public boolean add(Issue issue) throws SQLException, ClassNotFoundException {
        String sql="insert into issue values(?,?,?,?,?,?)";
        return  CrudUtil.executeUpdate(sql,issue.getIId(),issue.getMemId(),issue.getBId(),issue.getBName(),issue.getIDate(),issue.getRDate());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Issue issue) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Issue search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Issue> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
