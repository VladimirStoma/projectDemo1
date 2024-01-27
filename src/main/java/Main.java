

import DAO.UserDao;
import DAO.UserDaoImpl;
import service.UserService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserService(userDao);
      // userService.createTable();
        // userService.createUser("коля","Коля123","12345","22.02.1982",
           //    "89168484856","dagadgag");
       // userService.updateUser("Жора","Вася123","123454321","22.02.1982",
                //     "89168484856","dagadgag",1);
      //  userService.deleteUserbyid(1);
        userService.getUserById(2);
    }
}