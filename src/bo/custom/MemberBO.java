package bo.custom;

import bo.SuperBO;
import dto.MemberDTO;
import entity.Member;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface MemberBO extends SuperBO {
 public boolean addMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException;
 public boolean updateMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException;
 public boolean deleteMember(String id) throws SQLException, ClassNotFoundException;
 public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException;
 public ObservableList<MemberDTO>getAllMembers() throws SQLException, ClassNotFoundException;

 String getLastId() throws SQLException, ClassNotFoundException;

    int getRowCount() throws SQLException, ClassNotFoundException;


}
