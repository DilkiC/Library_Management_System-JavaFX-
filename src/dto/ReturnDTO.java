package dto;

public class ReturnDTO {
    private String RId;
    private String IId;
    private String BId;
    private String RDate;
    private String MRDate;
    private int LateDates;

    public ReturnDTO() {
    }

    public ReturnDTO(String RId, String IId, String BId, String RDate, String MRDate, int lateDates) {
        this.RId = RId;
        this.IId = IId;
        this.BId = BId;
        this.RDate = RDate;
        this.MRDate = MRDate;
        LateDates = lateDates;
    }

    public String getRId() {
        return RId;
    }

    public void setRId(String RId) {
        this.RId = RId;
    }

    public String getIId() {
        return IId;
    }

    public void setIId(String IId) {
        this.IId = IId;
    }

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    public String getRDate() {
        return RDate;
    }

    public void setRDate(String RDate) {
        this.RDate = RDate;
    }

    public String getMRDate() {
        return MRDate;
    }

    public void setMRDate(String MRDate) {
        this.MRDate = MRDate;
    }

    public int getLateDates() {
        return LateDates;
    }

    public void setLateDates(int lateDates) {
        LateDates = lateDates;
    }
}
