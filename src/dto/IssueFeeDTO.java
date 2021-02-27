package dto;

import javafx.collections.ObservableList;

public class IssueFeeDTO {
    //issue fee........
    private ObservableList<IssueDTO> issueDTOList;
    private BookFeeDTO bookFeeDTO;
    //issue fee........

    public IssueFeeDTO() {
    }

    public IssueFeeDTO(ObservableList<IssueDTO> issueDTOList, BookFeeDTO bookFeeDTO) {
        this.issueDTOList = issueDTOList;
        this.bookFeeDTO = bookFeeDTO;
    }

    public ObservableList<IssueDTO> getIssueDTOList() {
        return issueDTOList;
    }

    public void setIssueDTOList(ObservableList<IssueDTO> issueDTOList) {
        this.issueDTOList = issueDTOList;
    }

    public BookFeeDTO getBookFeeDTO() {
        return bookFeeDTO;
    }

    public void setBookFeeDTO(BookFeeDTO bookFeeDTO) {
        this.bookFeeDTO = bookFeeDTO;
    }
}
