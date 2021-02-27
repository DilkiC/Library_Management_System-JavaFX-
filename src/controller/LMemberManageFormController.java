package controller;

import bo.BOFactory;
import bo.custom.MemberBO;
import bo.impl.MemberBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.MemberDTO;
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
import java.util.ResourceBundle;

public class LMemberManageFormController implements Initializable {
    public TableView<MemberDTO> tblRegister;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colDate;
    public TableColumn colUpdateType;
    public TableColumn colFee;
    public TableColumn colExpireDate;
    public JFXTextField txtFee;
    public JFXTextField txtExpireDate;
    public JFXTextField txtMemName;
    public JFXTextField txtMemContact;
    public JFXTextField txtMemAddress;
    public AnchorPane rootRegister;
    public JFXTextField txtId;
    public JFXTextField txtMDate;
    public JFXTextField txtType;


    MemberBO memberBO = (MemberBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Member);

    @Override
    public void initialize(URL location, ResourceBundle resources) {


       colId.setCellValueFactory(new PropertyValueFactory<>("MemId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("MemName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("MemContact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("MemAddress"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("MemDate"));
        colUpdateType.setCellValueFactory(new PropertyValueFactory<>("MemUpdateType"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("MemFee"));
        colExpireDate.setCellValueFactory(new PropertyValueFactory<>("MemExpireDate"));

        try {
            loadAllMembers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }






    public void updateOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = memberBO.updateMember(new MemberDTO(txtId.getText(),txtMemName.getText(),txtMemContact.getText(),txtMemAddress.getText(),txtMDate.getText(),txtType.getText(),Double.parseDouble(txtFee.getText()),txtExpireDate.getText()));
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Member updated successfully",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Member not updated successfully",ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeOnAction(ActionEvent actionEvent) {
        try {
            boolean isRemoved=memberBO.deleteMember(txtId.getText());
            if(isRemoved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Member Removed",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "Member not Removed",ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



    public void dashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) this.rootRegister.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/LDashBoardForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAllMembers() throws SQLException, ClassNotFoundException {
        ObservableList<MemberDTO> allMember = memberBO.getAllMembers();
        tblRegister.setItems(allMember);
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            MemberDTO memberDTO = memberBO.searchMember(txtId.getText());
            if(memberDTO!=null){
                txtMemName.setText(memberDTO.getMemName());
                txtMemContact.setText(memberDTO.getMemContact());
                txtMemAddress.setText(memberDTO.getMemAddress());
                txtMDate.setText(memberDTO.getMemDate());
                txtType.setText(memberDTO.getMemUpdateType());
                txtFee.setText(String.valueOf(memberDTO.getMemFee()));
                txtExpireDate.setText(memberDTO.getMemExpireDate());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void txtGetDateFee(ActionEvent actionEvent) {
        if(txtType.getText()=="Lifetime"){
            txtExpireDate.setText("-");
            txtFee.setText(Double.toString(1000.00));
        }/*else{
            new Alert(Alert.AlertType.CONFIRMATION,"You can get Lifetime Membership",ButtonType.OK).show();
        }*/
    }
}
