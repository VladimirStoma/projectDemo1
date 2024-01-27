package service;

import DAO.UserDao;
import domain.User;

import java.util.Date;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createTable() {
        userDao.createUsersTable();
    }
    public void createUser(String name, String login, String password, String dataofbirth, String phone, String email){
        userDao.createUser(name, login, password, dataofbirth, phone, email);
    }

    public void deleteUserbyid(long id) {
        userDao.deleteUserbyid(id);
    }
    public void updateUser(String name, String login, String password, String dataofbirth, String phone, String email, long id){
        userDao.updateUserbyid(name, login, password, dataofbirth, phone, email, id);
    }
   public User getUserById(long id){
        return userDao.getUserById(id);
   }


    }

