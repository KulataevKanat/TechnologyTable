package kg.CSoft.TechnologyTable.entity;

import javax.persistence.*;

@Entity
@Table(name = "hosts")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ip_address", columnDefinition = "varchar(20)")
    private String ipAddress;

    @Column(name = "description", columnDefinition = "varchar")
    private String description;

    @Column(name = "login", columnDefinition = "varchar(50)")
    private String login;

    @Column(name = "host_password", columnDefinition = "varchar(100)")
    private String password;

    @ManyToOne
    @JoinColumn(name = "sub_network_id", columnDefinition = "integer")
    private SubNetwork subNetwork;

    public Host() {
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

    public SubNetwork getSubNetwork() {
        return subNetwork;
    }

    public void setSubNetwork(SubNetwork subNetwork) {
        this.subNetwork = subNetwork;
    }
}
