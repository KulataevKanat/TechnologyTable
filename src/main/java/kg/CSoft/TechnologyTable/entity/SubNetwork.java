package kg.CSoft.TechnologyTable.entity;

import javax.persistence.*;

@Entity
@Table(name = "sub_network")
public class SubNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "integer")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar")
    private String name;

    @Column(name = "mask", columnDefinition = "varchar")
    private String mask;

    @Column(name = "address", columnDefinition = "varchar")
    private String address;

    @Column(name = "vlan_id", columnDefinition = "integer")
    private Integer vlanId;

    @Column(name = "vlan_name", columnDefinition = "varchar")
    private String vlanName;

    @Column(name = "description", columnDefinition = "varchar")
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id", columnDefinition = "integer")
    private Project project;

    public SubNetwork() {
    }


    public SubNetwork(String name, String mask, String address, Integer vlanId, String vlanName, String description, Project project) {
        this.name = name;
        this.mask = mask;
        this.address = address;
        this.vlanId = vlanId;
        this.vlanName = vlanName;
        this.description = description;
        this.project = project;
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

    public Integer getVlanId() {
        return vlanId;
    }

    public void setVlanId(Integer vlanId) {
        this.vlanId = vlanId;
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
}


