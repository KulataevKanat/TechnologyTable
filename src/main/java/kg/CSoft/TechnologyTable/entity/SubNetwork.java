package kg.CSoft.TechnologyTable.entity;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "sub_network")
public class SubNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar")
    private String name;

    @Column(name = "mask", columnDefinition = "varchar")
    private String mask;

    @Column(name = "address", columnDefinition = "varchar")
    private String address;

    @Column(name = "vlan_identification ", columnDefinition = "integer")
    private Integer vlanIdentification;

    @Column(name = "vlan_name", columnDefinition = "varchar")
    private String vlanName;

    @Column(name = "description", columnDefinition = "varchar")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", columnDefinition = "int4")
    private Project project;

    @OneToMany(mappedBy = "subNetwork", cascade = CascadeType.ALL)
    private List<Host> hosts;

    public SubNetwork() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVlanIdentification() {
        return vlanIdentification;
    }

    public void setVlanIdentification(Integer vlanIdentification) {
        this.vlanIdentification = vlanIdentification;
    }

    public String getVlanName() {
        return vlanName;
    }

    public void setVlanName(String vlanName) {
        this.vlanName = vlanName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }
}


