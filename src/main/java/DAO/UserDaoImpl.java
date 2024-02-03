package DAO;

import domain.User;
import dto.request.CreateUserRequest;
import dto.request.DeleteUserByPasswordRequest;
import dto.request.UpdateUserRequest;

import java.sql.*;

import static java.lang.String.format;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUsersTable() {
        try (Connection connection = ConnectionManager.open(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE users " +
                    "(id SERIAL PRIMARY KEY, " +
                    " name VARCHAR(10), " +
                    " login VARCHAR(255)," +
                    " password VARCHAR(30)," +
                    " dateofbirth VARCHAR(10)," +
                    " phone VARCHAR(12)," +
                    " email VARCHAR(30))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public long createUser(CreateUserRequest createUserRequest) {
        long id = 0;
        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (name, login ,password ,dateofbirth,phone,email)" +
                            " VALUES (?, ?, ? ,? ,? ,?)", Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, createUserRequest.name());
            statement.setString(2, createUserRequest.login());
            statement.setString(3, createUserRequest.password());
            statement.setString(4, createUserRequest.dateOfBirth());
            statement.setString(5, createUserRequest.phone().getValue());
            statement.setString(6, createUserRequest.email().getValue());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong("id");
            }
            System.out.println(id + "  &&&&");
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateUserByid(UpdateUserRequest updateUserRequest) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users " +
                            "SET login = ?,password = ?, " +
                            "phone = ?,email = ? " +
                            "WHERE id = ?");
            statement.setString(1, updateUserRequest.login());
            statement.setString(2, updateUserRequest.password());
            statement.setString(3, updateUserRequest.phone().getValue());
            statement.setString(4, updateUserRequest.email().getValue());
            statement.setLong(5, updateUserRequest.id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUserByid(long id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM users WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User findUserById(long id) {
        User user = new User();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setDateofbirth(resultSet.getString("dateofbirth"));
                user.setPhone(new User.Phone(resultSet.getString("phone")));
                user.setEmail(new User.Email(resultSet.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean deleteUserByPassword(DeleteUserByPasswordRequest deleteUserByPasswordRequest) throws SQLException {
        try (Connection connection = ConnectionManager.open()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE password = ?");
            preparedStatement.setString(1, deleteUserByPasswordRequest.password());
            preparedStatement.executeUpdate();
        }
        return true;
    }
}
