package entity;

public class Quantity {
    private String BId;
    private String BName;
    private int BQuantity;
    private int CQuantity;

    public Quantity() {
    }

    public Quantity(String BId, String BName, int BQuantity, int CQuantity) {
        this.BId = BId;
        this.BName = BName;
        this.BQuantity = BQuantity;
        this.CQuantity = CQuantity;
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

    public int getBQuantity() {
        return BQuantity;
    }

    public void setBQuantity(int BQuantity) {
        this.BQuantity = BQuantity;
    }

    public int getCQuantity() {
        return CQuantity;
    }

    public void setCQuantity(int CQuantity) {
        this.CQuantity = CQuantity;
    }
}
