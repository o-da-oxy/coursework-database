package sample.LIBRARIAN;

public class Books {
    private String nameOfBook;
    private String author;

    public Books() {
    }

    public Books(String nameOfBook, String author) {
        this.nameOfBook = nameOfBook;
        this.author = author;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
