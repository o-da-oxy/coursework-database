package sample.LIBRARIAN;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.OpenNewScene;
import sample.db.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersBooksTable {

    private ObservableList<UsersBooks> observableList = FXCollections.observableArrayList();

    @FXML
    private Button exit;

    @FXML
    private TableView<UsersBooks> tableUsersBooks;

    @FXML
    private TableColumn<UsersBooks, String> columnNameOfUser;

    @FXML
    private TableColumn<UsersBooks, String> columnBook;

    @FXML
    void initialize() {
        initData();
        //данные из класса UsersBooks
        columnBook.setCellValueFactory(new PropertyValueFactory<UsersBooks, String>("nameOfUsersBook"));
        columnNameOfUser.setCellValueFactory(new PropertyValueFactory<UsersBooks, String>("nameOfUser"));

        tableUsersBooks.setItems(observableList);

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/LIBRARIAN/Librarian.fxml");
        });

    }

    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet res = dbHandler.selectAllUsersBook();
        try {
            while (res.next()) {
                //данные из колонок БД
                observableList.add(new UsersBooks(res.getString("name"),res.getString("book")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
