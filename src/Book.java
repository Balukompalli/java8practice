
public class Book {

    private Long bookId;

    public Book(Long bookId, String bookName, Integer price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    private String bookName;
    private Integer price;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
