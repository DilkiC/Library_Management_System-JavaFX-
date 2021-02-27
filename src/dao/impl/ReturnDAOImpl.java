package dao.impl;

import dao.CrudUtil;
import dao.custom.ReturnDAO;
import entity.Issue;
import entity.Return;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnDAOImpl implements ReturnDAO {
    @Override
    public boolean add(Return aReturn) throws SQLException, ClassNotFoundException {
        String sql="insert into returnBook values(?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,aReturn.getRId(),aReturn.getIId(),aReturn.getBId(),aReturn.getRDate(),aReturn.getMRDate(),aReturn.getLateDates());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Return aReturn) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Return search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<Return> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql="select RId from returnBook order by RId desc limit 1";
        ResultSet rst= CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public ObservableList<Return> getLastReturn(String text) throws SQLException, ClassNotFoundException {
        String sql="select distinct RId,IId,BId,RDate,MRDate,LateDates from returnBook where IId=? order by IId desc";
        ResultSet rst = CrudUtil.executeQuery(sql,text);
        ObservableList<Return> list = FXCollections.observableArrayList();
        while(rst.next()){
            list.add(new Return(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6)));
        }
        return list;
    }

    @Override
    public String getLastDates(String text) throws SQLException, ClassNotFoundException {
        String sql=" select datediff(curdate(),rdate) from Issue where MemId=? order by IId desc limit 1";
        ResultSet rst=CrudUtil.executeQuery(sql,text);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }


}
