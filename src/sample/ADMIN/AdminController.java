package sample.ADMIN;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.OpenNewScene;

public class AdminController {

    @FXML
    private Button usersList;

    @FXML
    private Button signUpUsers;

    @FXML
    private Button exit;

    @FXML
    void initialize() {
        usersList.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(usersList, "/sample/ADMIN/UserTable.fxml");
        });

        signUpUsers.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(signUpUsers, "/sample/ADMIN/AdminRegister.fxml");
        });

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/SignIn/sample.fxml");
        });
    }

}
