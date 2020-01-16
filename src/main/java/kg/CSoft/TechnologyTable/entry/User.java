package kg.CSoft.TechnologyTable.entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.ldap.odm.annotations.*;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.naming.Name;
import javax.naming.ldap.LdapName;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entry(objectClasses = {"user"}, base = "DC=transkom,DC=local")
public class User implements UserDetails {
    @Id
    private Name dn;

    @Attribute(name = "userPrincipalName")
    private String fullLogin;

    @Attribute(name = "sAMAccountName")
    private String username;

    @Attribute(name = "cn")
    @DnAttribute("cn")
    private String cn;

    @Attribute(name = "userPassword")
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

    @Attribute(name = "memberOf")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("dn") @JsonDeserialize(as = LdapName.class) Name dn) {
        this.dn = dn;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public String getPassword() {
        return password;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }


}
