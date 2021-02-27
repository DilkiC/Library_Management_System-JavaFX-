package entity;

public class BookFee {
    String BFId;
    String IId;
    int NoOfBooks;
    double Total;

    public BookFee() {
    }

    public BookFee(String BFId, String IId, int noOfBooks, double total) {
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
