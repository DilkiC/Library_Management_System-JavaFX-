package dto;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class BookFeeDTO {
        private String BFId;
        private String IId;
        private int NoOfBooks;
        private double Total;

    public BookFeeDTO() {
    }

    public BookFeeDTO(String BFId, String IId, int noOfBooks, double total) {
        this.BFId = BFId;
        this.IId = IId;
        NoOfBooks = noOfBooks;
        Total = total;
    }

    public String getBFId() {
        return BFId;
    }

    public void setBFId(String BFId) {
        this.BFId = BFId;
    }

    public String getIId() {
        return IId;
    }

    public void setIId(String IId) {
        this.IId = IId;
    }

    public int getNoOfBooks() {
        return NoOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        NoOfBooks = noOfBooks;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
