package sample.ADMIN;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.OpenNewScene;
import sample.User;
import sample.db.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {

    private ObservableList<User> observableList = FXCollections.observableArrayList();

    @FXML
    private Button exit;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn<User, String> columnLogin;

    @FXML
    private TableColumn<User, String> columnPassword;

    @FXML
    void initialize() {
        initData();
        columnLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));

        tableUsers.setItems(observableList);

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/ADMIN/Admin.fxml");
        });
    }

    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet res = dbHandler.selectAllUsers();
        try {
            while (res.next()) {
                observableList.add(new User(res.getString("login"),res.getString("password")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}


