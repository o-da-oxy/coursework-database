package sample.READER;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.OpenNewScene;

public class ReaderController {

    @FXML
    private Button books;

    @FXML
    private Button exit;

    @FXML
    void initialize() {
        books.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(books, "/sample/READER/ReaderBooks.fxml");
        });

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/SignIn/sample.fxml");
        });

    }

}


