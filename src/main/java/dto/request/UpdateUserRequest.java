package dto.request;

import domain.User;

public record UpdateUserRequest(
        String login,
        String password,
        User.Phone phone,
        User.Email email,
        long id
) {
}
