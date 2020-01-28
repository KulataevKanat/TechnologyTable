package kg.CSoft.TechnologyTable.dto.subNetwork;

import kg.CSoft.TechnologyTable.entity.SubNetwork;

import java.util.LinkedList;
import java.util.List;

public class SubNetworkFilter {
    private Long id;
    private String name;
    private String mask;
    private String address;
    private Integer vlanIdentification;
    private String vlanName;
    private String description;
    private Long projectId;

    public SubNetworkFilter(SubNetwork subNetwork) {
        this.id = subNetwork.getId();
        this.name = subNetwork.getName();
        this.mask = subNetwork.getMask();
        this.address = subNetwork.getAddress();
        this.vlanIdentification = subNetwork.getVlanIdentification();
        this.vlanName = subNetwork.getVlanName();
        this.description = subNetwork.getDescription();
        this.projectId = subNetwork.getProject().getId();
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
