package service;

import DAO.UserDao;
import dto.request.CreateUserRequest;
import dto.request.DeleteUserByPasswordRequest;
import dto.request.UpdateUserRequest;
import dto.response.UserResponse;

import java.sql.SQLException;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createTable() {
        userDao.createUsersTable();
    }
    public void createUser(CreateUserRequest createUserRequest){
        userDao.createUser(createUserRequest);
    }

    public void deleteUserByid(long id) {
        userDao.deleteUserByid(id);
    }
    public void updateUser(UpdateUserRequest updateUserRequest){
        userDao.updateUserByid(updateUserRequest);
    }
   public UserResponse getUserById(long id){
        final var user = userDao.findUserById(id);
        return new UserResponse(user);
   }
   public boolean deleteUserByPassword(DeleteUserByPasswordRequest deleteUserByPasswordRequest) throws SQLException {
        userDao.deleteUserByPassword(deleteUserByPasswordRequest);
       return true;
   }


    }

