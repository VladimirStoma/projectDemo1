package DAO;

import domain.User;
import dto.request.CreateUserRequest;
import dto.request.DeleteUserByPasswordRequest;
import dto.request.UpdateUserRequest;

import java.sql.SQLException;

//методы для взаимодействия с БД (например, создание таблицы)
public interface UserDao {
    void createUsersTable();

    long  createUser(CreateUserRequest createUserRequest);

    void updateUserByid(UpdateUserRequest updateUserRequest);

    void  deleteUserByid(long id);

    User findUserById(long id);

    boolean deleteUserByPassword(DeleteUserByPasswordRequest deleteUserByPasswordRequest) throws SQLException;


}
