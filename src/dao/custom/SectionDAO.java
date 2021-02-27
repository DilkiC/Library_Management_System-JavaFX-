package dao.custom;

import dao.CrudDAO;
import entity.Section;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SectionDAO extends CrudDAO<Section,String> {
    Section searchSecName(String secName) throws SQLException, ClassNotFoundException;
}
