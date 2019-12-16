//package kg.CSoft.TechnologyTable.endpoint;
//
//import kg.CSoft.TechnologyTable.dto.search.SearchDto;
//import kg.CSoft.TechnologyTable.service.HostService;
//import kg.CSoft.TechnologyTable.service.ProjectService;
//import kg.CSoft.TechnologyTable.service.SubNetworkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SearchEndpointImpl implements SearchEndpoint {
//    @Autowired
//    private SearchService searchService;
//    @Autowired
//    private HostService hostService;
//    @Autowired
//    private SubNetworkService subNetworkService;
//    @Autowired
//    private ProjectService projectService;
//    @Autowired
//    private HostEndpoint hostEndpoint;
//
//    @Override
//    public List<SearchDto> search(String search) {
//        return SearchDto.toList(searchService.search(search));
//        return SearchDto.toList(searchService.search(search));
//    }
//        return SearchDto.toList(searchService.search(
//                SearchDto.hostList(hostService.hostSearchByLogin(search)),
//                SearchDto.hostList(hostService.hostSearchByIpAddress(search)),
//                SearchDto.subNetworkList(subNetworkService.subNetworkSearchByName(search)),
//                SearchDto.subNetworkList(subNetworkService.subNetworkSearchByMask(search)),
//                SearchDto.subNetworkList(subNetworkService.subNetworkSearchByAddress(search)),
//                SearchDto.subNetworkList(subNetworkService.subNetworkSearchByVlanName(search)),
//                SearchDto.projectList(projectService.projectSearchByName(search))));
//
//    }
//
//}
