package bo.impl;

import bo.custom.SectionBO;
import dao.DAOFactory;
import dao.custom.SectionDAO;
import dao.impl.SectionDAOImpl;
import dto.SectionDTO;
import entity.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SectionBOImpl implements SectionBO {
    SectionDAO sectionDAO= (SectionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Section);

    @Override
    public SectionDTO searchSection(String text) throws SQLException, ClassNotFoundException {
        Section section=sectionDAO.search(text);
        return new SectionDTO(section.getSId(),section.getBId(),section.getSName());

    }

    @Override
    public SectionDTO searchSectionName(String secName) throws SQLException, ClassNotFoundException {
        Section section=sectionDAO.searchSecName(secName);
        return new SectionDTO(section.getSId(),section.getBId(),section.getSName());
    }


}
