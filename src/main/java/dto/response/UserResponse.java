package dto.response;

import domain.User;
import domain.User.Phone;
import domain.User.Email;
public record UserResponse(
        long id,
        String name,
        Phone phone,
        Email email,
        String dateOfBirth
) {
    public UserResponse(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getPhone(),
                user.getEmail(),
                user.getDateofbirth()
        );
    }
}
