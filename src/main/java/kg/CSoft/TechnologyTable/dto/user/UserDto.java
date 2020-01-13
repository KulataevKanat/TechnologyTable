package kg.CSoft.TechnologyTable.dto.user;

import kg.CSoft.TechnologyTable.entry.User;

import java.util.LinkedList;
import java.util.List;

public class UserDto {
    private String dn;
    private String fullName;
    private String fullLogin;
    private String username;
    private String cn;
    private String phone;
    private String address;
    private String mail;
    private String position;

    public UserDto(User user) {
        this.dn = user.getDn();
        this.fullName = user.getFullName();
        this.fullLogin = user.getFullLogin();
        this.username = user.getUsername();
        this.cn = user.getCn();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.mail = user.getMail();
        this.position = user.getPosition();
    }

    public static List<UserDto> toList(List<User> list) {
        List<UserDto> resultList = new LinkedList<>();
        for (User users : list) {
            resultList.add(new UserDto(users));
        }
        return resultList;
    }


    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getFullLogin() {
        return fullLogin;
    }

    public void setFullLogin(String fullLogin) {
        this.fullLogin = fullLogin;
    }
}

