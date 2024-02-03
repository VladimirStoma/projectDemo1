package dto.request;

import domain.User;
import domain.User.Phone;
import domain.User.Email;

public record CreateUserRequest(
        String name,
        String login,
        String password,
        String dateOfBirth,
        Phone phone,
        Email email) {


}

