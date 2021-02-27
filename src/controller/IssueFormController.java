package controller;

import bo.BOFactory;
import bo.custom.*;
import bo.impl.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import dto.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssueFormController implements Initializable {
    public AnchorPane rootIssue;
    public JFXTextField txtMemId;
    public JFXTreeTableView tblLastIssueDetails;
    public Label lblExpireDate;
    public Label lblDate;
    public Label lblIssueId;
    public JFXTextField txtBookName;
    public JFXTextField txtBookId;
    public TableView tblIssueToday;
    public TableColumn colIid;
    public TableColumn colMemId;
    public TableColumn colBookId;
    public TableColumn colBookName;
    public TableColumn colIDate;
    public TableColumn colReturnDate;
    public JFXTextField txtReturn;
    public JFXComboBox cmbWeeks;
    public Label lblBookFeeId;
    public JFXComboBox cmbNoOfBooks;
    public Label lblTotalFee;
    public Label lblBalance;
    public JFXTextField txtCash;

    public TableView tblLastIssue;
    public TableColumn clmLastIId;
    public TableColumn clmLastBId;
    public TableColumn clmLastBName;
    public TableColumn clmLastIDate;
    public TableColumn clmLastRDate;
    public TableColumn clmLastRId;
    public TableColumn clmLastMemId;
    public JFXTextField txtLastIid;
    public TableView tblLastReturn;
    public TableColumn columnRid;
    public TableColumn columnIid;
    public TableColumn columnBid;
    public TableColumn columnRDate;
    public TableColumn columnMRDate;
    public TableColumn columnLateDates;

    IssueBO issueBO= (IssueBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Issue);
    ReturnBO returnBO= (ReturnBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Return);
    BookBO bookBO= (BookBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Book);
    BookFeeBO bookFeeBO= (BookFeeBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.BookFee);
    MemberBO memberBO= (MemberBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Member);

    public void updateOnAction(ActionEvent actionEvent) {
        try {
            Stage stage= (Stage) this.rootIssue.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LMemberManageForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTableOnAction(ActionEvent actionEvent) {
        ArrayList<IssueDTO>issueDTOArrayList=new ArrayList<>();
        IssueDTO issueDTO=new IssueDTO(lblIssueId.getText(),txtMemId.getText(),txtBookId.getText(),txtBookName.getText(),lblDate.getText(),txtReturn.getText()) ;
        issueDTOArrayList.add(issueDTO);
        tblIssueToday.getItems().add(issueDTO);

    }

    public void removeTableOnAction(ActionEvent actionEvent) {
        int selectedRow=tblIssueToday.getSelectionModel().getSelectedIndex();
        tblIssueToday.getItems().remove(selectedRow);
    }



    public void cmbWeeksOnAction(ActionEvent actionEvent) {
        setReturnDate();
    }

    public void billOnAction(ActionEvent actionEvent) {
    }

    public void saveDetailsOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        //issue table data.....(add table details to arraylist)
        ObservableList<IssueDTO> issueDTOList = FXCollections.observableArrayList();

        for (int i = 0; i <tblIssueToday.getItems().size() ; i++) {
            String iid= String.valueOf(colIid.getCellData(i));
            String mid= String.valueOf(colMemId.getCellData(i));
            String bid= String.valueOf(colBookId.getCellData(i));
            String bname= String.valueOf(colBookName.getCellData(i));
            String idate= String.valueOf(colIDate.getCellData(i));
            String rdate= String.valueOf(colReturnDate.getCellData(i));

            IssueDTO issueDTO=new IssueDTO(iid,mid,bid,bname,idate,rdate);
            issueDTOList.add(issueDTO);
        }


        //book fee table date...
        String bfid=lblBookFeeId.getText();
        String iid=lblIssueId.getText();
        int noofbooks= (int) cmbNoOfBooks.getSelectionModel().getSelectedItem();
        double tot= Double.parseDouble(lblTotalFee.getText());
        BookFeeDTO bookFeeDTO=new BookFeeDTO(bfid,iid,noofbooks,tot);

        IssueFeeDTO issueBookDTO = new IssueFeeDTO(issueDTOList, bookFeeDTO);

        boolean isAdded = issueBO.IssuFeeDetails(issueBookDTO);
        if(isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Failed").show();
        }

    }

    public void cmbTotal(ActionEvent actionEvent) {
        getTotal();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIssueId();
        setTodayDate();
        loadWeeks();
        setReturnDate();
        setBookFeeId();
        loadNoOfBooks();
        getTotal();
        colIid.setCellValueFactory(new PropertyValueFactory<>("IId"));
        colMemId.setCellValueFactory(new PropertyValueFactory<>("MemId"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("BId"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("BName"));
        colIDate.setCellValueFactory(new PropertyValueFactory<>("IDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("RDate"));

        clmLastIId.setCellValueFactory(new PropertyValueFactory<>("IId"));
        clmLastBId.setCellValueFactory(new PropertyValueFactory<>("BId"));
        clmLastBName.setCellValueFactory(new PropertyValueFactory<>("BName"));
        clmLastIDate.setCellValueFactory(new PropertyValueFactory<>("IDate"));
        clmLastRDate.setCellValueFactory(new PropertyValueFactory<>("RDate"));
        clmLastMemId.setCellValueFactory(new PropertyValueFactory<>("MemId"));

        columnRid.setCellValueFactory(new PropertyValueFactory<>("RId"));
        columnIid.setCellValueFactory(new PropertyValueFactory<>("IId"));
        columnBid.setCellValueFactory(new PropertyValueFactory<>("BId"));
        columnRDate.setCellValueFactory(new PropertyValueFactory<>("RDate"));
        columnMRDate.setCellValueFactory(new PropertyValueFactory<>("MRDate"));
        columnLateDates.setCellValueFactory(new PropertyValueFactory<>("LateDates"));

    }

    private void getTotal() {
        if(cmbNoOfBooks.getSelectionModel().getSelectedIndex()==0){
            double total=1*10;
            lblTotalFee.setText(Double.toString(total));
        }else if(cmbNoOfBooks.getSelectionModel().getSelectedIndex()==1){
            double total=2*10;
            lblTotalFee.setText(Double.toString(total));
        }else{
            double total=3*10;
            lblTotalFee.setText(Double.toString(total));
        }

    }

    private void loadNoOfBooks() {
        cmbNoOfBooks.getItems().add(1);
        cmbNoOfBooks.getItems().add(2);
        cmbNoOfBooks.getItems().add(3);
    }

    private void setBookFeeId() {
        try {
            String id = bookFeeBO.getLastId();
            if(id!=null){
                id=id.split("[A-Z]")[2];
                id="BF"+(Integer.parseInt(id)+1);
                lblBookFeeId.setText(id);
            }else{
                lblBookFeeId.setText("BF1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setReturnDate() {
        if(cmbWeeks.getSelectionModel().getSelectedIndex()==0){
            LocalDate expireDate = LocalDate.parse(lblDate.getText()).plusWeeks(1);
            txtReturn.setText(String.valueOf(expireDate));
        }else if(cmbWeeks.getSelectionModel().getSelectedIndex()==1){
            LocalDate expireDate = LocalDate.parse(lblDate.getText()).plusWeeks(2);
            txtReturn.setText(String.valueOf(expireDate));
        }else{
            LocalDate expireDate = LocalDate.parse(lblDate.getText()).plusWeeks(3);
            txtReturn.setText(String.valueOf(expireDate));
        }
    }

    private void loadWeeks() {
        cmbWeeks.getItems().add(1);
        cmbWeeks.getItems().add(2);
        cmbWeeks.getItems().add(3);

    }

    private void setTodayDate() {
        String date= String.valueOf(LocalDate.now());
        lblDate.setText(date);
    }

    private void setIssueId() {
        try {
            String id = issueBO.getIid();
            if(id!=null){
                id=id.split("[A-Z]")[1];
                id="I"+(Integer.parseInt(id)+1);
                lblIssueId.setText(id);
            }else{
                lblIssueId.setText("I1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getBNameOnAction(ActionEvent actionEvent) {
        try {
            BookDTO bookDTO=bookBO.searchBook(txtBookId.getText());
            if(bookDTO!=null){
                txtBookName.setText(bookDTO.getBName());
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Incorrect Book Id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void CashOnAction(ActionEvent actionEvent) {
        double tot= Double.parseDouble(lblTotalFee.getText());
        double cash= Double.parseDouble(txtCash.getText());
        double balance=cash-tot;
        if(cash>=tot) {
            lblBalance.setText(String.valueOf(balance));
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Cannot Pay", ButtonType.OK).show();

        }
    }


    public void txtGetLastIssue(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ObservableList<IssueDTO>list = issueBO.getLastIssue1(txtMemId.getText());
        tblLastIssue.setItems(list);

        MemberDTO memberDTO=memberBO.searchMember(txtMemId.getText());
        if(memberDTO!=null){
            lblExpireDate.setText(memberDTO.getMemExpireDate());
        }else{
            lblExpireDate.setText("LifeTime");
        }

    }

    public void txtLastReturnOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ObservableList<ReturnDTO>list=returnBO.getLastReturn(txtLastIid.getText());
        tblLastReturn.setItems(list);
    }
}
