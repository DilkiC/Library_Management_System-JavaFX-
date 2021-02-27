package bo.custom;

import bo.SuperBO;
import bo.impl.PublisherBOImpl;
import dto.PublisherDTO;

import java.sql.SQLException;

public interface PublisherBO extends SuperBO {
    int getRowCount() throws SQLException, ClassNotFoundException;

    PublisherDTO searchPublisher(String text) throws SQLException, ClassNotFoundException;

    PublisherDTO searchPublisherDetail(String text) throws SQLException, ClassNotFoundException;
}
