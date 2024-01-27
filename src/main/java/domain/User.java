package domain;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String login;

    private String password;

    private String dateofbirth;

    private String phone;

    private String email;

    public User(long id, String name, String login, String password, String dateofbirth, String phone, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.dateofbirth = dateofbirth;
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
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}




