package kg.CSoft.TechnologyTable.entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.ldap.odm.annotations.*;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.naming.Name;
import javax.naming.ldap.LdapName;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

@Entry(objectClasses = {"user"}, base = "DC=transkom,DC=local")
public class User implements UserDetails {
    @Id
    private Name dn;

    @Attribute(name = "userPrincipalName")
    private String fullLogin;

    @Attribute(name = "sAMAccountName")
    private String login;

    @Attribute(name = "cn")
    @DnAttribute("cn")
    private String cn;

    @JsonIgnore
    private String password;

    @Attribute(name = "description")
    private String fullName;

    @Attribute(name = "mobile")
    private String phone;

    @Attribute(name = "streetAddress")
    private String address;

    @Attribute(name = "mail")
    private String mail;

    @Attribute(name = "title")
    private String position;

//    @Attribute(name = "memberOf")
//    private Set<String> memberOf;

    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("dn") @JsonDeserialize(as = LdapName.class) Name dn) {
        this.dn = dn;
    }

    private String wrapDN(Name dn) {
        Enumeration<String> allDnElements = dn.getAll();
        StringBuilder dnValue = new StringBuilder();
        while (allDnElements.hasMoreElements()) {
            dnValue.append(allDnElements.nextElement());
            dnValue.append(",");
            dnValue.deleteCharAt(dnValue.length() - 1);
            return dnValue.toString();
        }

//        Enumeration<String> allRoleDnElements = dn.getAll();
//        StringBuilder roleDnValue = new StringBuilder();
//        while (allRoleDnElements.hasMoreElements()) {
//            roleDnValue.append(allRoleDnElements.nextElement());
//            roleDnValue.append(",");
//            roleDnValue.deleteCharAt(roleDnValue.length() - 1);
//            return roleDnValue.toString();
//        }
//
        return null;
    }

    public String getDn() {
        return dn.toString();
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getFullLogin() {
        return fullLogin;
    }

    public void setFullLogin(String fullLogin) {
        this.fullLogin = fullLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
