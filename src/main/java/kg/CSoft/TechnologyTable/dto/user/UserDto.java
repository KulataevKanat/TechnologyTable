package kg.CSoft.TechnologyTable.dto.user;

import kg.CSoft.TechnologyTable.entry.User;
import java.util.LinkedList;
import java.util.List;

public class UserDto {
    private String dn;
    private String fullName;
    private String userPrincipalName;
    private String sAMAccountName;
    private String cn;
    private String phone;
    private String address;
    private String mail;
    private String position;
    private List<String> role;

    public UserDto(User user) {
        this.dn = user.getDn();
        this.fullName = user.getFullName();
        this.userPrincipalName = user.getFullLogin();
        this.sAMAccountName = user.getUsername();
        this.cn = user.getCn();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.mail = user.getMail();
        this.position = user.getPosition();
        this.role = user.getRoles();
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

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getsAMAccountName() {
        return sAMAccountName;
    }

    public void setsAMAccountName(String sAMAccountName) {
        this.sAMAccountName = sAMAccountName;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
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

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}

