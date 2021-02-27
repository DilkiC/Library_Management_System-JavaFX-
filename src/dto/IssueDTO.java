package dto;

import javafx.collections.ObservableList;

public class IssueDTO {
    private  String IId;
    private  String MemId;
    private  String BId;
    private  String BName;
    private  String IDate;
    private  String RDate;

    public IssueDTO() {
    }

    public IssueDTO(String IId, String memId, String BId, String BName, String IDate, String RDate) {
        this.IId = IId;
        this.MemId = memId;
        this.BId = BId;
        this.BName = BName;
        this.IDate = IDate;
        this.RDate = RDate;
    }

    public String getIId() {
        return IId;
    }

    public void setIId(String IId) {
        this.IId = IId;
    }

    public String getMemId() {
        return MemId;
    }

    public void setMemId(String memId) {
       this.MemId = memId;
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

    public String getIDate() {
        return IDate;
    }

    public void setIDate(String IDate) {
        this.IDate = IDate;
    }

    public String getRDate() {
        return RDate;
    }

    public void setRDate(String RDate) {
        this.RDate = RDate;
    }
}
