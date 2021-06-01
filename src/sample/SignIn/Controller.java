package sample.SignIn;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.User;
import sample.anim.Shake;
import sample.db.DatabaseHandler;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signUp; //registration

    @FXML
    private Button singIn;

    @FXML
    void initialize() {

        singIn.setOnAction(event -> {
            String loginText = login.getText().trim();
            String loginPassword = password.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            }
            else {
                System.out.println("Логин и пароль не заполнены");
            }
        });

        signUp.setOnAction(event -> {
            openNewScene("/sample/SignUp/signUp.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user=new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        //посчитать кол-во пользователей
        int counter =0;
        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if(counter>=1 && user.getLogin().equals("admin")){
            openNewScene("/sample/ADMIN/Admin.fxml");
        }
        if(counter>=1 && user.getLogin().equals("librarian")){
            openNewScene("/sample/LIBRARIAN/LIBRARIAN.fxml");
        }
        if(counter>=1 && !user.getLogin().equals("admin") && !user.getLogin().equals("librarian")){
            openNewScene("/sample/READER/Reader.fxml");
        }
        else {
            Shake userLoginAnim = new Shake(login);
            Shake userPassAnim = new Shake(password);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
        
    }

    public void openNewScene(String window) {
        signUp.getScene().getWindow().hide();

        //отобразить нужный fxml файл

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
