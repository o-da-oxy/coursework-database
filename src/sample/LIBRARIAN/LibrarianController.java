package sample.LIBRARIAN;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.OpenNewScene;

public class LibrarianController {

    @FXML
    private Button booksList;

    @FXML
    private Button usersBooks;

    @FXML
    private Button exit;

    @FXML
    void initialize() {
        booksList.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(booksList, "/sample/LIBRARIAN/Books.fxml");
        });

        usersBooks.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(usersBooks, "/sample/LIBRARIAN/UsersBook.fxml");
        });

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/SignIn/sample.fxml");
        });

    }

}

