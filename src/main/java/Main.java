

import DAO.UserDao;
import DAO.UserDaoImpl;
import domain.User;
import domain.User.Phone;
import dto.request.CreateUserRequest;
import dto.request.DeleteUserByPasswordRequest;
import service.UserService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserService(userDao);
        User user1 = new User();
     //   userService.createTable();
    userService.createUser(new CreateUserRequest("Vovan","Pohui","qwerty","22.02.1982",
 new Phone("+79168484856"), new User.Email("Vovan@yandex.ru")));
        //      user1.emailValidation("sobaka@gmail.com");
////////       userService.updateUser(new UpdateUserRequest("qwerty","654321","954632352","dgkdgk@;jly",28));
// userService.deleteUserByid(1);
      //  System.out.println(userService.getUserById(4));
     // System.out.println(userService.deleteUserByPassword(new DeleteUserByPasswordRequest("qwerty")));

//
   }
}