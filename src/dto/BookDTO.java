package dto;

public class BookDTO {
    private  String BId;
    private  String BName;
    private  double Price;

    public BookDTO() {
    }

    public BookDTO(String BId, String BName, double price) {
        this.BId = BId;
        this.BName = BName;
        Price = price;
    }

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
