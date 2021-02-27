package dao.custom;

import dao.CrudDAO;
import entity.Member;

import java.sql.SQLException;

public interface MemberDAO extends CrudDAO<Member,String> {
    String getLastId() throws SQLException, ClassNotFoundException;

    int getRowCount() throws SQLException, ClassNotFoundException;
}
