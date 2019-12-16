package kg.CSoft.TechnologyTable.dto.role;

import kg.CSoft.TechnologyTable.entry.EntryRole;

import java.util.LinkedList;
import java.util.List;

public class EntryRoleDto {
    private String dn;
    private String cn;
    private String userDn;

    public EntryRoleDto(EntryRole entryRole) {
        this.dn = entryRole.getDn();
        this.cn = entryRole.getCn();
        this.userDn = entryRole.getRole();
    }

    public static List<EntryRoleDto> toList(List<EntryRole> list) {
        List<EntryRoleDto> resultList = new LinkedList<>();
        for (EntryRole entryRole : list) {
            resultList.add(new EntryRoleDto(entryRole));
        }
        return resultList;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getUserDn() {
        return userDn;
    }

    public void setUserDn(String userDn) {
        this.userDn = userDn;
    }
}
