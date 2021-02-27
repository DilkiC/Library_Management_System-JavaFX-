package entity;

public class Author {
    private String AId;
    private String BId;
    private String AName;

    public Author() {
    }

    public Author(String AId, String BId, String AName) {
        this.AId = AId;
        this.BId = BId;
        this.AName = AName;
    }

    public String getAId() {
        return AId;
    }

    public void setAId(String AId) {
        this.AId = AId;
    }

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }
}
