package dto;

public class MemberDTO {
    private String MemId;
    private String MemName;
    private String MemContact;
    private String MemAddress;
    private String MemDate;
    private String MemUpdateType;
    private double MemFee;
    private String MemExpireDate;

    public MemberDTO() {
    }

    public MemberDTO(String memId, String memName, String memContact, String memAddress, String memDate, String memUpdateType, double memFee, String memExpireDate) {
        MemId = memId;
        MemName = memName;
        MemContact = memContact;
        MemAddress = memAddress;
        MemDate = memDate;
        MemUpdateType = memUpdateType;
        MemFee = memFee;
        MemExpireDate = memExpireDate;
    }

    public String getMemId() {
        return MemId;
    }

    public void setMemId(String memId) {
        MemId = memId;
    }

    public String getMemName() {
        return MemName;
    }

    public void setMemName(String memName) {
        MemName = memName;
    }

    public String getMemContact() {
        return MemContact;
    }

    public void setMemContact(String memContact) {
        MemContact = memContact;
    }

    public String getMemAddress() {
        return MemAddress;
    }

    public void setMemAddress(String memAddress) {
        MemAddress = memAddress;
    }

    public String getMemDate() {
        return MemDate;
    }

    public void setMemDate(String memDate) {
        MemDate = memDate;
    }

    public String getMemUpdateType() {
        return MemUpdateType;
    }

    public void setMemUpdateType(String memUpdateType) {
        MemUpdateType = memUpdateType;
    }

    public double getMemFee() {
        return MemFee;
    }

    public void setMemFee(double memFee) {
        MemFee = memFee;
    }

    public String getMemExpireDate() {
        return MemExpireDate;
    }

    public void setMemExpireDate(String memExpireDate) {
        MemExpireDate = memExpireDate;
    }
}
