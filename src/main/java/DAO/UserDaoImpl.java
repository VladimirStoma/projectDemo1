package DAO;

import DAO.exception.UserCreateException;
import domain.User;

import java.sql.*;
import java.util.Date;

import static java.lang.String.format;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUsersTable() {
        try (Connection connection = ConnectionManager.open(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE users " +
                    "(id SERIAL PRIMARY KEY, " +
                    " name VARCHAR(10), " +
                    " login VARCHAR(255)," +
                    " password VARCHAR(30),"+
                    " dateofbirth VARCHAR(10),"+
                    " phone VARCHAR(11)," +
                    " email VARCHAR(30))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void createUser(String name, String login, String password, String dateofbirth, String phone, String email) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (name, login ,password ,dateofbirth,phone,email)" +
                            " VALUES (?, ?, ? ,? ,? ,?)"
            );
            statement.setString(1, name);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setString(4, dateofbirth);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserbyid(String name, String login, String password, String dateofbirth,
                           String phone, String email,long id) {
  try (Connection connection = ConnectionManager.open()){
      PreparedStatement statement = connection.prepareStatement(
              "UPDATE users " +
                      "SET name = ?,login = ?,password = ?, " +
                      "dateofbirth = ?,phone = ?,email = ? " +
                      "WHERE id = ?");
      statement.setString(1, name);
      statement.setString(2, login);
      statement.setString(3, password);
      statement.setString(4, dateofbirth);
      statement.setString(5, phone);
      statement.setString(6, email);
      statement.setLong(7, id);
      statement.executeUpdate();
  } catch (SQLException e) {
      throw new RuntimeException(e);
  }
    }

    @Override
    public void deleteUserbyid(long id) {
        try (Connection connection = ConnectionManager.open()){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM users WHERE id = ?");
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public User getUserById(long id){
        User user= new User();
        try (Connection connection = ConnectionManager.open()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
             user.setId(resultSet.getLong("id"));
             user.setName(resultSet.getString("name"));
             user.setLogin(resultSet.getString("login"));
             user.setPassword(resultSet.getString("password"));
             user.setDateofbirth(resultSet.getString("dateofbirth"));
             user.setPhone(resultSet.getString("phone"));
             user.setEmail(resultSet.getString("email"));}
            System.out.println(user.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
