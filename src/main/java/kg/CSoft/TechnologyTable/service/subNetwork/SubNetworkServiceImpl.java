package kg.CSoft.TechnologyTable.service.subNetwork;

import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkDto;
import kg.CSoft.TechnologyTable.entity.SubNetwork;
import kg.CSoft.TechnologyTable.repository.SubNetworkRepository;
import kg.CSoft.TechnologyTable.service.subNetwork.SubNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubNetworkServiceImpl implements SubNetworkService {
    @Autowired
    private SubNetworkRepository subNetworkRepository;


    @Override
    public SubNetwork addSubNetwork(SubNetwork subNetwork) {
        return subNetworkRepository.save(subNetwork);
    }

    @Override
    public SubNetworkDto removeSubNetworkById(Long id) {
        subNetworkRepository.deleteById(id);
        return null;
    }

    @Override
    public SubNetwork changeSubNetwork(SubNetwork subNetwork) {
        return subNetworkRepository.save(subNetwork);
    }

    @Override
    public SubNetwork getSubNetworkById(Long id) {
        return subNetworkRepository.findById(id).get();
    }

    @Override
    public List<SubNetwork> findAllByProjectId(Long projectId) {
        return subNetworkRepository.findAllByProjectId(projectId);
    }


    @Override
    public List<SubNetwork> getAllSubNetworks() {
        return subNetworkRepository.findAll();
    }
}
