package kg.CSoft.TechnologyTable.model;

import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entity.SubNetwork;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

public class Search {
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Host> hostList = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<SubNetwork> subNetworkList = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private  List<Project> projectList = new ArrayList<>();

    public Search() {
    }

    public List<Host> getHostList() {
        return hostList;
    }

    public void setHostList(List<Host> hostList) {
        this.hostList = hostList;
    }

    public List<SubNetwork> getSubNetworkList() {
        return subNetworkList;
    }

    public void setSubNetworkList(List<SubNetwork> subNetworkList) {
        this.subNetworkList = subNetworkList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
