package entity;

public class Publisher {
    private String pId;
    private String bId;
    private String pName;
    private String pAddress;
    private int pContact;

    public Publisher() {
    }

    public Publisher(String pId, String bId, String pName, String pAddress, int pContact) {
        this.pId = pId;
        this.bId = bId;
        this.pName = pName;
        this.pAddress = pAddress;
        this.pContact = pContact;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public int getpContact() {
        return pContact;
    }

    public void setpContact(int pContact) {
        this.pContact = pContact;
    }
}
