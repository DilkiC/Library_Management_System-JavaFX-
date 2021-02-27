package bo.custom;

import bo.SuperBO;
import dto.SectionDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SectionBO extends SuperBO {
    SectionDTO searchSection(String text) throws SQLException, ClassNotFoundException;

    SectionDTO searchSectionName(String secName) throws SQLException, ClassNotFoundException;
}
