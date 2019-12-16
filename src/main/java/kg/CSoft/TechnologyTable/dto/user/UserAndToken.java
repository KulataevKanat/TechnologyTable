package kg.CSoft.TechnologyTable.dto.user;

import kg.CSoft.TechnologyTable.entry.User;

import java.util.List;

public class UserAndToken {
    private String login;
    private String fullName;
    private String token;

    public UserAndToken() {
    }

    public UserAndToken(List<User> user, String token) {
        this.login = user.iterator().next().getLogin();
        this.fullName = user.iterator().next().getFullName();
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

