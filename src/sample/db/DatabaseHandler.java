package sample.db;

import sample.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    //соединение с БД
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {
        //SQL запрос чтобы занести в таблицу данные при регистрации
        String insert = "INSERT INTO " +
                Const.USER_TABLE + "(" + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")" +
                "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //возвращает пользователя
    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }



    public ResultSet selectAllUsers() {
        ResultSet result = null;
        String select = "SELECT * FROM " + dbName + "." + Const.USER_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            result = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet selectAllBooks() {
        ResultSet result = null;
        String select = "SELECT * FROM " + dbName + "." + Const.BOOK_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            result = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


    public ResultSet selectAllUsersBook() {
        ResultSet result = null;
        String select = "SELECT * FROM " + dbName + "." + Const.USER_BOOK_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            result = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }



}
