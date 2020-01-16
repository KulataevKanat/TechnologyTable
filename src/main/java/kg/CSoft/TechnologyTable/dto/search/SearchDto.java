package kg.CSoft.TechnologyTable.dto.search;

import kg.CSoft.TechnologyTable.dto.host.HostFilter;
import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkFilter;
import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entity.SubNetwork;

import java.util.LinkedList;
import java.util.List;

public class SearchDto {
    private Host host;
    private SubNetwork subNetwork;
    private Project project;

    public SearchDto(Host host, SubNetwork subNetwork, Project project) {
        this.host = host;
        this.subNetwork = subNetwork;
        this.project = project;
    }

    public static List<SearchDto> toList(List<Host> hostList, List<SubNetwork> subNetworkList, List<Project> projectList) {
        List<SearchDto> result = new LinkedList<>();
        for (Host host : hostList) {
            for (SubNetwork subNetwork : subNetworkList) {
                for (Project project : projectList) {
                    result.add(new SearchDto(host, subNetwork, project));
                }
            }
        }
        return result;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public SubNetwork getSubNetwork() {
        return subNetwork;
    }

    public void setSubNetwork(SubNetwork subNetwork) {
        this.subNetwork = subNetwork;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
