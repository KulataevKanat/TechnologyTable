//package kg.CSoft.TechnologyTable.dto.search;
//
//import kg.CSoft.TechnologyTable.dto.host.HostFilter;
//import kg.CSoft.TechnologyTable.dto.project.ProjectDto;
//import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkDto;
//import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkFilter;
//import kg.CSoft.TechnologyTable.entity.Project;
//import kg.CSoft.TechnologyTable.entity.Host;
//import kg.CSoft.TechnologyTable.entity.SubNetwork;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class SearchDto {
//    private HostFilter host;
//    private SubNetworkFilter subNetwork;
//    private ProjectDto project;
//
//    public SearchDto() {
//    }
//
//    public SearchDto(Search search) {
//        this.host = new HostFilter(search.getHost());
//        this.subNetwork = new SubNetworkFilter(search.getSubNetwork());
//        this.project = new ProjectDto(search.getProject());
//    }
//
//    public static List<SearchDto> toList(List<Search> list) {
//        List<SearchDto> resultList = new LinkedList<>();
//        for (Search search: list) {
//            resultList.add(new SearchDto(search));
//        }
//        return resultList;
//    }
//
//
//    public static List<HostFilter> hostList(List<Host> list) {
//        List<HostFilter> resultList = new LinkedList<>();
//        for (Host host : list) {
//            resultList.add(new HostFilter(host));
//        }
//        return resultList;
//    }
//
//    public static List<SubNetworkDto> subNetworkList(List<SubNetwork> list) {
//        List<SubNetworkDto> resultList = new LinkedList<>();
//        for (SubNetwork subNetwork : list) {
//            resultList.add(new SubNetworkDto(subNetwork));
//        }
//        return resultList;
//    }
//
//    public static List<ProjectDto> projectList(List<Project> list) {
//        List<ProjectDto> resultList = new LinkedList<>();
//        for (Project project : list) {
//            resultList.add(new ProjectDto(project));
//        }
//        return resultList;
//    }
//
//    public HostFilter getHost() {
//        return host;
//    }
//
//    public void setHost(HostFilter host) {
//        this.host = host;
//    }
//
//    public SubNetworkFilter getSubNetwork() {
//        return subNetwork;
//    }
//
//    public void setSubNetwork(SubNetworkFilter subNetwork) {
//        this.subNetwork = subNetwork;
//    }
//
//    public ProjectDto getProject() {
//        return project;
//    }
//
//    public void setProject(ProjectDto project) {
//        this.project = project;
//    }
//}
