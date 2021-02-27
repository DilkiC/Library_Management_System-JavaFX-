package controller;

import bo.BOFactory;
import bo.custom.FineBO;
import bo.custom.IssueBO;
import bo.custom.ReturnBO;
import bo.impl.FineBOImpl;
import bo.impl.IssueBOImpl;
import bo.impl.ReturnBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.FineDTO;
import dto.IssueDTO;
import dto.ReturnDTO;
import entity.Issue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.ResourceBundle;

public class LReturnFormController implements Initializable {
    public AnchorPane rootReturn;
    public Label lblDate;
    public JFXComboBox cmbNoOfBooks;
    public Label lblRid;
    public Label lblFineId;
    public Label lblTotFine;
    public JFXTextField txtCash;
    public Label lblBalance;
    public Label lblMRDate;
    public JFXTextField txtMemId;
    public Label lblLateDates;
    public TableView tblLastIssue;
    public TableColumn colIid;
    public TableColumn colBId;
    public TableColumn colBName;
    public TableColumn colIDate;
    public TableColumn colRDate;
    public TableColumn colMemid;
    public TableColumn colMemId;
    public Label lblReturnDate;

    ReturnBO returnBO= (ReturnBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Return);
    FineBO fineBO= (FineBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Fine);
    IssueBO issueBO= (IssueBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Issue);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTodayDate();
        loadNoOfBook();
        setRId();
        setFineId();


    }





    private void setTodayDate() {
        String date=LocalDate.now().toString();
        lblMRDate.setText(date);
    }

    private void setFineId() {

        try {
            String id = fineBO.getLastId();
            if(id!=null){
                id=id.split("[A-Z]")[1];
                id="F"+(Integer.parseInt(id)+1);
                lblFineId.setText(id);
            }else{
                lblFineId.setText("F1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setRId() {
        try {
            String id = returnBO.getLastId();
            if(id!=null){
                id=id.split("[A-Z]")[1];
                id="R"+(Integer.parseInt(id)+1);
                lblRid.setText(id);
            }else{
                lblRid.setText("R1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadNoOfBook() {
        cmbNoOfBooks.getItems().add(1);
        cmbNoOfBooks.getItems().add(2);
        cmbNoOfBooks.getItems().add(3);
    }



    public void txtBalanceOnAction(ActionEvent actionEvent) {
        double tot= Double.parseDouble(lblTotFine.getText());
        double cash= Double.parseDouble(txtCash.getText());
        double balance=cash-tot;
        if(cash>=tot) {
            lblBalance.setText(String.valueOf(balance));
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Cannot Pay", ButtonType.OK).show();

        }
    }

    public void cmbGetTotFine(ActionEvent actionEvent) {
        int late= Integer.parseInt(lblLateDates.getText());
        if(cmbNoOfBooks.getSelectionModel().getSelectedIndex()==0){
            lblTotFine.setText(Integer.toString(2*1*late));
        }else if(cmbNoOfBooks.getSelectionModel().getSelectedIndex()==1){
            lblTotFine.setText(Integer.toString(2*2*late));
        }else{
            lblTotFine.setText(Integer.toString(2*3*late));
        }

    }


    public void txtLastIssueOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ObservableList<IssueDTO>list = issueBO.getLastIssue1(txtMemId.getText());
        tblLastIssue.setItems(list);
        colIid.setCellValueFactory(new PropertyValueFactory<>("IId"));
        colBId.setCellValueFactory(new PropertyValueFactory<>("BId"));
        colBName.setCellValueFactory(new PropertyValueFactory<>("BName"));
        colIDate.setCellValueFactory(new PropertyValueFactory<>("IDate"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("RDate"));
        colMemId.setCellValueFactory(new PropertyValueFactory<>("MemId"));


        String lateDates=returnBO.getLastDates(txtMemId.getText());
        lblLateDates.setText(lateDates);


    }

    public void saveDetailOnAction(ActionEvent actionEvent) {

        IssueDTO selectedRow= (IssueDTO) tblLastIssue.getSelectionModel().getSelectedItem();
        String rId=lblRid.getText();
        String iid=selectedRow.getIId();
        String bId=selectedRow.getBId();
        String rDate=selectedRow.getRDate();
        String mrDate=lblMRDate.getText();
        int lateDates= Integer.parseInt(lblLateDates.getText());


        try {
            ReturnDTO returnDTO=new ReturnDTO(rId,iid,bId,rDate,mrDate,lateDates);
            boolean isAdded=returnBO.addReturn(returnDTO);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Added successfully",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Failed",ButtonType.OK).show();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void btnPayOnAction(ActionEvent actionEvent) {
        String fid=lblFineId.getText();
        String rid=lblRid.getText();
        double totFine= Double.parseDouble(lblTotFine.getText());



        try {
            FineDTO fineDTO=new FineDTO(fid,rid,totFine);
            boolean isAdded=fineBO.addFine(fineDTO);
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Thank you for your payment",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"your payement is not completed",ButtonType.OK).show();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
