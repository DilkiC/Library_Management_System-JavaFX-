package bo.impl;

import bo.custom.PublisherBO;
import dao.DAOFactory;
import dao.custom.PublisherDAO;
import dao.impl.PublisherDAOImpl;
import dto.PublisherDTO;
import entity.Publisher;

import java.sql.SQLException;

public class PublisherBOImpl implements PublisherBO {
    PublisherDAO publisherDAO= (PublisherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Publisher);
    @Override
    public int getRowCount() throws SQLException, ClassNotFoundException {
        return publisherDAO.getRowCount();
    }

    @Override
    public PublisherDTO searchPublisher(String text) throws SQLException, ClassNotFoundException {
        Publisher publisher=publisherDAO.search(text);
        return new PublisherDTO(publisher.getpId(),publisher.getbId(),publisher.getpName(),publisher.getpAddress(),publisher.getpContact());
    }

    @Override
    public PublisherDTO searchPublisherDetail(String text) throws SQLException, ClassNotFoundException {
        Publisher publisher=publisherDAO.searchDetail(text);
        return new PublisherDTO(publisher.getpId(),publisher.getbId(),publisher.getpName(),publisher.getpAddress(),publisher.getpContact());


    }
}
