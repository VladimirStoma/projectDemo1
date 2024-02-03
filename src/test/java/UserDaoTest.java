import DAO.ConnectionManager;
import DAO.UserDao;
import DAO.UserDaoImpl;
import domain.User;
import dto.request.CreateUserRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {
    private static Connection connection;
    private static UserDao userDao;

    @BeforeAll
    static void beforeAll() {
        userDao = new UserDaoImpl();
    }

    @BeforeEach
    void beforeEach() {
        connection = ConnectionManager.open();
        try {
            connection.prepareStatement("DELETE FROM users").executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sdajaksf");

    }

    @Test
    void shouldCreateNewUser() {
        final var request = new CreateUserRequest("test", "test", "test", "test",
                new User.Phone("test"), new User.Email("test"));
        final var userId = userDao.createUser(request);
        final var user = userDao.findUserById(userId);
        assertEquals("test", user.getName());
    }
}
