package sample.ADMIN;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.OpenNewScene;
import sample.User;
import sample.db.DatabaseHandler;

public class AdminRegisterController {

    @FXML
    private Button signUpUser;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpLogin;

    @FXML
    private Button exit;

    @FXML
    void initialize() {

        signUpUser.setOnAction(event -> {
            signUpNewUser();
        });

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/ADMIN/Admin.fxml");
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String login = signUpLogin.getText();
        String password = signUpPassword.getText();

        User user = new User(login, password);

        dbHandler.signUpUser(user);
    }

}
