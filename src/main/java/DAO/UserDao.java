package DAO;

import domain.User;

import java.util.Date;

//методы для взаимодействия с БД (например, создание таблицы)
public interface UserDao {
    void createUsersTable();

    void createUser(String name, String login, String password, String dataofbirth, String phone, String email);

    void updateUserbyid(String name, String login,String password, String dataofbirth, String phone, String email, long id);

    void  deleteUserbyid(long id);

    User getUserById(long id);


}
