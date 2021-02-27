package entity;

public class Section {
    private String SId;
    private String BId;
    private String SName;

    public Section() {
    }

    public Section(String SId, String BId, String SName) {
        this.SId = SId;
        this.BId = BId;
        this.SName = SName;
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }
}
