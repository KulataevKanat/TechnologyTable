package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entity.SubNetwork;
import kg.CSoft.TechnologyTable.repository.HostRepository;
import kg.CSoft.TechnologyTable.repository.ProjectRepository;
import kg.CSoft.TechnologyTable.repository.SubNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private SubNetworkRepository subNetworkRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public List<Host> hostSearch(String search) {
        return hostRepository.hostSearch(search);
    }

    @Override
    public List<SubNetwork> subNetworkSearch(String search) {
        return subNetworkRepository.subNetworkSearch(search);
    }

    @Override
    public List<Project> projectSearch(String search) {
        return projectRepository.projectSearch(search);
    }
}
