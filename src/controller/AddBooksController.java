package controller;

import bo.BOFactory;
import bo.custom.*;
import bo.impl.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBooksController implements Initializable {
    public Label lblBookId;
    public JFXTextField txtBName;
    public JFXTextField txtBPrice;
    public JFXComboBox cmbSecName;
    public JFXComboBox cmbPubName;
    public JFXTextField txtSectionId;
    public JFXTextField txtPubid;
    public JFXTextField txtPubcontact;
    public JFXTextField txtPubaddress;
    public JFXTextField txtPubName;
    public JFXTextField txtAuthorName;
    public JFXTextField txtAuthorId;
    public JFXTextField txtBookId;


    BookBO bookBO= (BookBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Book);
    SectionBO sectionBO= (SectionBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Section);
    PublisherBO publisherBO= (PublisherBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Publisher);
    AuthorBO authorBO= (AuthorBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Author);
    AddBooksBO addBooksBO= (AddBooksBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.AddBooks);

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //book table data
        String bid=txtBookId.getText();
        String bname=txtBName.getText();
        double price= Double.parseDouble(txtBPrice.getText());

        BookDTO bookDTO=new BookDTO(bid,bname,price);

        //section table data
        String sid=txtSectionId.getText();
        String sname=cmbSecName.getSelectionModel().getSelectedItem().toString();

        SectionDTO sectionDTO=new SectionDTO(sid,bid,sname);

        //publisher table data
        String pid=txtPubid.getText();
        String pname=txtPubName.getText();
        String paddress=txtPubaddress.getText();
        int pcontact= Integer.parseInt(txtPubcontact.getText());

        PublisherDTO publisherDTO=new PublisherDTO(pid,bid,pname,paddress,pcontact);

        //author table data
        String aid=txtAuthorId.getText();
        String aname=txtAuthorName.getText();

        AuthorDTO authorDTO=new AuthorDTO(aid,bid,aname);

        AddBookDTO addBookDTO=new AddBookDTO(bookDTO,sectionDTO,publisherDTO,authorDTO);

        boolean isAdded=addBooksBO.addBookDetail(addBookDTO);
        if(isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"The Book is Added").show();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Failed").show();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateBookId();
        loadcmbSection();


    }



    private void loadcmbSection() {
        cmbSecName.getItems().add("Translation");
        //cmbSecName.getItems().add("Science");
        cmbSecName.getItems().add("Sinhala Novels");
        cmbSecName.getItems().add("Sinhala Short Stories");
        cmbSecName.getItems().add("Positive Thinking");
        cmbSecName.getItems().add("Law");
        cmbSecName.getItems().add("Computer Science");
        cmbSecName.getItems().add("English Novels");
        cmbSecName.getItems().add("English  Short Stories");
        //cmbSecName.getItems().add("Languages");
    }


    private void generateBookId() {

        try {
           String id = bookBO.getLastId();
            if(id!=null){
                id=id.split("[A-Z]")[1];
                id="B"+(Integer.parseInt(id)+1);
                txtBookId.setText(id);
            }else{
                txtBookId.setText("B1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void cmbSecNameOnAciton(ActionEvent actionEvent)  {

            String secName=cmbSecName.getSelectionModel().getSelectedItem().toString();
            try {
           SectionDTO sectionDTO = sectionBO.searchSectionName(secName);
            if(sectionDTO!=null){
                txtSectionId.setText(sectionDTO.getSId());
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Incorrect Book Id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void txtPubNameOnAction(ActionEvent actionEvent) {


        try {
            PublisherDTO publisherDTO = publisherBO.searchPublisherDetail(txtPubName.getText());
            if(publisherDTO!=null){
                txtPubid.setText(publisherDTO.getpId());
                txtPubaddress.setText(publisherDTO.getpAddress());
                txtPubcontact.setText(String.valueOf(publisherDTO.getpContact()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void txtANameOnAction(ActionEvent actionEvent) {

        try {
            AuthorDTO  authorDTO = authorBO.searchAuthorId(txtAuthorName.getText());
            if(authorDTO!=null){
                txtAuthorId.setText(authorDTO.getAId());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
