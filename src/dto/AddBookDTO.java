package dto;

public class AddBookDTO {
    private BookDTO bookDTO;
    private SectionDTO sectionDTO;
    private PublisherDTO publisherDTO;
    private AuthorDTO authorDTO;

    public AddBookDTO() {
    }

    public AddBookDTO(BookDTO bookDTO, SectionDTO sectionDTO, PublisherDTO publisherDTO, AuthorDTO authorDTO) {
        this.bookDTO = bookDTO;
        this.sectionDTO = sectionDTO;
        this.publisherDTO = publisherDTO;
        this.authorDTO = authorDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public SectionDTO getSectionDTO() {
        return sectionDTO;
    }

    public void setSectionDTO(SectionDTO sectionDTO) {
        this.sectionDTO = sectionDTO;
    }

    public PublisherDTO getPublisherDTO() {
        return publisherDTO;
    }

    public void setPublisherDTO(PublisherDTO publisherDTO) {
        this.publisherDTO = publisherDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
