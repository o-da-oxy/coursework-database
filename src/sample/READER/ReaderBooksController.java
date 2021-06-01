package sample.READER;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.LIBRARIAN.Books;
import sample.OpenNewScene;
import sample.db.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderBooksController {

    private ObservableList<Books> observableList = FXCollections.observableArrayList();

    @FXML
    private Button exit;

    @FXML
    private TableView<Books> tableBooks;

    @FXML
    private TableColumn<Books, String> columnBook;

    @FXML
    private TableColumn<Books, String> columnAuthor;

    @FXML
    void initialize() {
        initData();
        columnBook.setCellValueFactory(new PropertyValueFactory<Books, String>("nameOfBook"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));

        tableBooks.setItems(observableList);

        exit.setOnAction(event ->{
            OpenNewScene newScene = new OpenNewScene();
            newScene.openWindow(exit, "/sample/READER/Reader.fxml");
        });

    }

    private void initData() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet res = dbHandler.selectAllBooks();
        try {
            while (res.next()) {
                observableList.add(new Books(res.getString("name of book"),res.getString("author")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
