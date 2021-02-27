package bo.impl;

import bo.custom.MemberBO;
import dao.DAOFactory;
import dao.custom.MemberDAO;
import dao.impl.MemberDAOImpl;
import dto.MemberDTO;
import entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;


public class MemberBOImpl implements MemberBO {
    MemberDAO memberDAO= (MemberDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Member);


    @Override
    public boolean addMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return memberDAO.add(new Member(memberDTO.getMemId(),memberDTO.getMemName(),memberDTO.getMemContact(),memberDTO.getMemAddress(),memberDTO.getMemDate(),memberDTO.getMemUpdateType(),memberDTO.getMemFee(),memberDTO.getMemExpireDate()));
    }

    @Override
    public boolean updateMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return memberDAO.update(new Member(memberDTO.getMemId(),memberDTO.getMemName(),memberDTO.getMemContact(),memberDTO.getMemAddress(),memberDTO.getMemDate(),memberDTO.getMemUpdateType(),memberDTO.getMemFee(),memberDTO.getMemExpireDate()));
    }

    @Override
    public boolean deleteMember(String id) throws SQLException, ClassNotFoundException {
        return memberDAO.delete(id);
    }

    @Override
    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException {
        Member member=memberDAO.search(id);
        return new MemberDTO(member.getMemId(),member.getMemName(),member.getMemContact(),member.getMemAddress(),member.getMemDate(),member.getMemUpdateType(),member.getMemFee(),member.getMemExpireDate());

    }

    @Override
    public ObservableList<MemberDTO> getAllMembers() throws SQLException, ClassNotFoundException {
        ObservableList<Member>all=memberDAO.getAll();
        ObservableList<MemberDTO>allMembers= FXCollections.observableArrayList();
        for (Member member:all) {
            allMembers.add(new MemberDTO(member.getMemId(),member.getMemName(),member.getMemContact(),member.getMemAddress(),member.getMemDate(),member.getMemUpdateType(),member.getMemFee(),member.getMemExpireDate()));

        }
        return allMembers;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return memberDAO.getLastId();
    }

    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        return memberDAO.getRowCount();
    }
}
