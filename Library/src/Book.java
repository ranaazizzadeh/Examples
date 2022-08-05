public class Book {
    private long id;
    private String name;
    private String author;
    private BookStatus status;

    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;

    }

    public Book(String name, String author, BookStatus status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
