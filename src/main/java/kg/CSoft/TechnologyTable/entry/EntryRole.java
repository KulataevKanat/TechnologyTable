package kg.CSoft.TechnologyTable.entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import javax.naming.ldap.LdapName;

@Entry(objectClasses = {"group"}, base = "DC=transkom,DC=local")
public class EntryRole {
    @Id
    private Name dn;

    @Attribute(name = "cn")
    @DnAttribute("cn")
    private String cn;

    @Attribute(name = "member")
    private String role;

    public EntryRole() {
    }

    @JsonCreator
    public EntryRole(@JsonProperty("dn") @JsonDeserialize(as = LdapName.class) Name dn) {
        this.dn = dn;
    }

    public String getDn() {
        return dn.toString();
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
