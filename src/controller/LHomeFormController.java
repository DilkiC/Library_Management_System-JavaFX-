package controller;

import bo.BOFactory;
import bo.custom.BookBO;
import bo.custom.MemberBO;
import bo.custom.PublisherBO;
import bo.impl.BookBOImpl;
import bo.impl.MemberBOImpl;
import bo.impl.PublisherBOImpl;
import dao.custom.MemberDAO;
import dao.impl.MemberDAOImpl;
import entity.Publisher;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LHomeFormController implements Initializable {

    public Label lblTotMem;
    public Label lblTotBook;
    public Label lblPublisher;
    public AnchorPane rootHome;

    MemberBO memberBO= (MemberBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Member);
    BookBO bookBO= (BookBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Book);
    PublisherBO publisherBO= (PublisherBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Publisher);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTotalMembers();
        loadTotalBooks();
        loadTotalPublishers();
    }

    private void loadTotalPublishers() {
        try {
           int count = publisherBO.getRowCount();
            lblPublisher.setText(Integer.toString(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadTotalBooks() {
        try {
            int count=bookBO.getRowCount();
            lblTotBook.setText(Integer.toString(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadTotalMembers() {
        try {
            int count = memberBO.getRowCount();
            lblTotMem.setText(Integer.toString(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
