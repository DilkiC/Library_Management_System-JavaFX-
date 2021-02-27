package entity;

public class Fine {
    private String fId;
    private String rId;
    private double totFine;

    public Fine() {
    }

    public Fine(String fId, String rId, double totFine) {
        this.fId = fId;
        this.rId = rId;
        this.totFine = totFine;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public double getTotFine() {
        return totFine;
    }

    public void setTotFine(double totFine) {
        this.totFine = totFine;
    }
}
