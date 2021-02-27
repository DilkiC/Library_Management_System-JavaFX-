package dao.impl;

import dao.CrudUtil;
import dao.custom.MemberDAO;
import entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public boolean add(Member member) throws SQLException, ClassNotFoundException {
        String sql="Insert into Member values(?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,member.getMemId(),member.getMemName(),member.getMemContact(),member.getMemAddress(),member.getMemDate(),member.getMemUpdateType(),member.getMemFee(),member.getMemExpireDate());
    }

    @Override
    public boolean update(Member member) throws SQLException, ClassNotFoundException {
        String sql="update Member set memName=?,memContact=?,memAddress=?,memDate=?,memUpdateType=?,memFee=?,memExpireDate=? where memId=?" ;
        return CrudUtil.executeUpdate(sql,member.getMemName(),member.getMemContact(),member.getMemAddress(),member.getMemDate(),member.getMemUpdateType(),member.getMemFee(),member.getMemExpireDate(),member.getMemId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql="delete from member where MemId=?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public Member search(String s) throws SQLException, ClassNotFoundException {
        String sql="select*from member where MemId=?";
        ResultSet rst=CrudUtil.executeQuery(sql,s);
        if(rst.next()){
            return new Member(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getDouble(7),rst.getString(8));
        }
        return null;
    }

    @Override
    public ObservableList<Member> getAll() throws SQLException, ClassNotFoundException {
        String sql="select*from member";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ObservableList<Member>all=FXCollections.observableArrayList();
        while(rst.next()){
            all.add(new Member(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getDouble(7),rst.getString(8)));
        }
        return  all;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql="select MemId from member order by MemId desc limit 1";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        String sql="select count(MemId) from member";
        ResultSet rst=CrudUtil.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }
}
