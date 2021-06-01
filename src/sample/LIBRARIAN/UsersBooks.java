package sample.LIBRARIAN;

public class UsersBooks {
    private String nameOfUser;
    private String nameOfUsersBook;

    public UsersBooks() {
    }

    public UsersBooks(String nameOfUser, String nameOfUsersBook) {
        this.nameOfUser = nameOfUser;
        this.nameOfUsersBook = nameOfUsersBook;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getNameOfUsersBook() {
        return nameOfUsersBook;
    }

    public void setNameOfUsersBook(String nameOfUsersBook) {
        this.nameOfUsersBook = nameOfUsersBook;
    }
}
