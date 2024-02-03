package domain;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String login;

    private String password;

    private String dateOfBirth;

    private Phone phone;

    private Email email;

    public User(long id, String name, String login, String password, String dateofbirth, Phone phone, Email email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateofbirth;
        this.phone = phone;
        this.email = email;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateofbirth() {
        return dateOfBirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateOfBirth = dateofbirth;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateofbirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Phone {
        String value;

        public String getValue() {
            return value;
        }

        public Phone(String value) {
            if (value.matches("\\+7\\d{10}")) {
                this.value = value;
            } else {
                throw new IllegalArgumentException("Wrong phone number");
            }
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public static class Email {
        String value;

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Email{" +
                    "value='" + value + '\'' +
                    '}';
        }

        public Email(String value) {
            if (value.matches("^.{1,30}@(mail\\.ru|gmail\\.com|yandex\\.ru|bk\\.ru)$")) {
                this.value = value;

            } else {
                throw new IllegalArgumentException("Wrong email");
            }
        }
    }

//    public String phoneValidation(String validPhone) throws IllegalArgumentException {
//        if (validPhone.matches("\\+7\\d{10}")) {
//            System.out.println("phone is valid");
//        } else throw new IllegalArgumentException("Wrong phone number");
//        return validPhone;
//    }

//    public String emailValidation(String validEmail)
//            throws IllegalArgumentException {
//        if (validEmail.matches("^.{1,30}@(mail\\.ru|gmail\\.com|yandex\\.ru|bk\\.ru)$")) {
//            System.out.println("email is valid");
//        } else throw new IllegalArgumentException("Wrong email");
//        return validEmail;
//    }
}




