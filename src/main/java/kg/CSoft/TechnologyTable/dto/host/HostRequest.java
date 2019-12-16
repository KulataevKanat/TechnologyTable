package kg.CSoft.TechnologyTable.dto.host;

public class HostRequest {
    private String ipAddress;
    private String description;
    private String login;
    private String password;
    private Long subNetworkId;

    public HostRequest() {
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
