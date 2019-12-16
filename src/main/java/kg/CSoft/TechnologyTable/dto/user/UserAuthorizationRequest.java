package kg.CSoft.TechnologyTable.dto.user;

public class UserAuthorizationRequest {
    private String login;
    private String password;

    public UserAuthorizationRequest() {
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
}


