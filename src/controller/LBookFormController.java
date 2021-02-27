package controller;

import bo.BOFactory;
import bo.custom.*;
import bo.impl.AuthorBOImpl;
import bo.impl.PublisherBOImpl;
import bo.impl.QuantityBOImpl;
import bo.impl.SectionBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LBookFormController implements Initializable {

    public JFXTextField txtBookId;
    public JFXTextField txtQuantity;
    public JFXTextField txtBookName;
    public Label lblSid;
    public Label lblPublisher;
    public Label lblAuthor;
    public Label lblSectionName;

    QuantityBO quantityBO= (QuantityBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Quantity);
    BookBO bookBO= (BookBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Book);
    AuthorBO authorBO= (AuthorBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Author);
    PublisherBO publisherBO= (PublisherBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Publisher);
    SectionBO sectionBO= (SectionBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Section);

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void txtGetIdQuantity(ActionEvent actionEvent) {

            //QuantityDTO quantityDTO=quantityBO.searchQuantity(txtBookName.getText());

        try {
            BookDTO bookDTO = bookBO.searchBookId(txtBookName.getText());
            if(bookDTO!=null){
                txtBookId.setText(bookDTO.getBId());
                //txtQuantity.setText(Integer.toString(quantityDTO.getCQuantity()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void txtGetDetail(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        AuthorDTO authorDTO=authorBO.searchAuthor(txtBookId.getText());
        if(authorDTO!=null){
                lblAuthor.setText(authorDTO.getAName());
        }

        PublisherDTO publisherDTO=publisherBO.searchPublisher(txtBookId.getText());
        if(publisherDTO!=null){
            lblPublisher.setText(publisherDTO.getpName());
        }

        SectionDTO sectionDTO=sectionBO.searchSection(txtBookId.getText());
        if(sectionDTO!=null){
            lblSid.setText(sectionDTO.getSId());
            lblSectionName.setText(sectionDTO.getSName());
        }

    }
}
