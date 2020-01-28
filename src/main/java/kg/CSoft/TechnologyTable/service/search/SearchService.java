package kg.CSoft.TechnologyTable.service.search;

import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entity.SubNetwork;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchService {
    //Host
    List<Host> hostSearch(String search);

    //SubNetwork
    List<SubNetwork> subNetworkSearch(String search);

    //Project
    List<Project> projectSearch(String search);

}
