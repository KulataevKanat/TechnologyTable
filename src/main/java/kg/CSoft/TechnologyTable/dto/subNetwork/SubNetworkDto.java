package kg.CSoft.TechnologyTable.dto.subNetwork;

import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
import kg.CSoft.TechnologyTable.entity.SubNetwork;

import java.util.LinkedList;
import java.util.List;

public class SubNetworkDto {
    private Long id;
    private String name;
    private String mask;
    private String address;
    private Integer vlanId;
    private String vlanName;
    private String description;
    private ProjectDto project;

    public SubNetworkDto(SubNetwork subNetwork) {
        this.id = subNetwork.getId();
        this.name = subNetwork.getName();
        this.mask = subNetwork.getMask();
        this.address = subNetwork.getAddress();
        this.vlanId = subNetwork.getVlanId();
        this.vlanName = subNetwork.getVlanName();
        this.description = subNetwork.getDescription();
        this.project = new ProjectDto(subNetwork.getProject());
    }

    public static List<SubNetworkDto> toList(List<SubNetwork> list) {
        List<SubNetworkDto> resultList = new LinkedList<>();
        for (SubNetwork subNetwork : list) {
            resultList.add(new SubNetworkDto(subNetwork));
        }
        return resultList;
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

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
