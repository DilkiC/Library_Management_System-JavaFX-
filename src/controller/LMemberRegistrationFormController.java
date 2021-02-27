package controller;


import bo.BOFactory;
import bo.custom.MemberBO;
import bo.impl.MemberBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.MemberDTO;
import entity.Member;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LMemberRegistrationFormController implements Initializable {

    public JFXTextField txtFee;
    public Label lblId;
    public Label lblDate;
    public JFXComboBox cmbUpdate;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtRegFee;
    public JFXTextField txtExDate;
    public JFXTextField txtCash;
    public JFXTextField txtBalance;

    MemberBO memberBO= (MemberBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.Member);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        getLastId();
        loadComboUpdate();
        setFeeAndExDate();
        setNullValues();
    }

    private void setNullValues() {
        txtName.setText(null);
        txtContact.setText(null);
        txtAddress.setText(null);

        txtRegFee.setText(null);
        txtExDate.setText(null);
        txtFee.setText(null);
        txtCash.setText(null);
        txtBalance.setText(null);
    }

    private void setFeeAndExDate() {
        if (cmbUpdate.getSelectionModel().getSelectedIndex() == 0) {
            txtRegFee.setText(Double.toString(200.00));
            LocalDate expireDate = LocalDate.parse(lblDate.getText()).plusYears(3);
            txtExDate.setText(String.valueOf(expireDate));

        } else {
            txtExDate.setText("-");
            txtRegFee.setText(Double.toString(1000.00));
        }

    }

    private void loadComboUpdate() {
        cmbUpdate.getItems().add("3 Years");
        cmbUpdate.getItems().add("Lifetime");
    }

    private void getLastId() {
        try {
            String id = memberBO.getLastId();
            if(id==null){
                lblId.setText("M1");
            }else {
                id = id.split("[A-Z]")[1];
                id = "M" + (Integer.parseInt(id) + 1);
                lblId.setText(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setDate() {
        String date= String.valueOf(LocalDate.now());
        lblDate.setText(date);
    }

    public void cmbUpdateOnAction(ActionEvent actionEvent) {
        setFeeAndExDate();
    }

    public void registerOnAction(ActionEvent actionEvent) {
        try {
           double regFee= Double.parseDouble(txtRegFee.getText());
            boolean isAdded = memberBO.addMember(new MemberDTO(lblId.getText(),txtName.getText(),txtContact.getText(),txtAddress.getText(),lblDate.getText(),cmbUpdate.getSelectionModel().getSelectedItem().toString(),regFee,txtExDate.getText()));
            if(isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Member registered successfully").show();
                setNullValues();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Member registration failed").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void billOnAction(ActionEvent actionEvent) {

        try {
            InputStream is=this.getClass().getResourceAsStream("/report/MemberFeeBill_A4.jrxml");
            JasperReport jr= JasperCompileManager.compileReport(is);
            HashMap hs= new HashMap();
            hs.put("MemberId", lblId.getText());
            hs.put("Fee",txtRegFee.getText());
            hs.put("Cash",txtCash.getText());
            hs.put("Balance",txtBalance.getText());

            JasperPrint js = JasperFillManager.fillReport(jr,hs, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(js);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (JRException e) {
            e.printStackTrace();
        }
    }


    public void cashOnAction(ActionEvent actionEvent) {

        double regFee= Double.parseDouble(txtRegFee.getText());
        txtFee.setText(Double.toString(regFee));
        double fee= Double.parseDouble(txtFee.getText());


        double cash= Double.parseDouble(txtCash.getText());

        double balance=cash-fee;
        if(cash>=fee) {
            txtBalance.setText(String.valueOf(balance));
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Cannot Pay", ButtonType.OK).show();

        }
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        if(Pattern.compile("^[A-z]{2,}$").matcher(txtName.getText()).matches()){
            txtContact.requestFocus();
        }else{
            txtName.setFocusColor(Paint.valueOf("red"));
        }
    }
}