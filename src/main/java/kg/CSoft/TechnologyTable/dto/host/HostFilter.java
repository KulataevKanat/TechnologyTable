package kg.CSoft.TechnologyTable.dto.host;

import kg.CSoft.TechnologyTable.entity.Host;

public class HostFilter {
    private Long id;
    private String ipAddress;
    private String description;
    private String login;
    private String password;
    private Long subNetworkId;

    public HostFilter(Host host) {
        this.id = host.getId();
        this.ipAddress = host.getIpAddress();
        this.description = host.getDescription();
        this.login = host.getLogin();
        this.password = host.getPassword();
        this.subNetworkId = host.getSubNetwork().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getSubNetworkId() {
        return subNetworkId;
    }

    public void setSubNetworkId(Long subNetworkId) {
        this.subNetworkId = subNetworkId;
    }
}
