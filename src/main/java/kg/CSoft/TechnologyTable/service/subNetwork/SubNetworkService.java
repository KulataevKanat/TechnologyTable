package kg.CSoft.TechnologyTable.service.subNetwork;

import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkDto;
import kg.CSoft.TechnologyTable.entity.SubNetwork;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubNetworkService {

    SubNetwork addSubNetwork(SubNetwork subNetwork);

    SubNetworkDto removeSubNetworkById(Long id);

    SubNetwork changeSubNetwork(SubNetwork subNetwork);

    SubNetwork getSubNetworkById(Long id);

    List<SubNetwork> findAllByProjectId(Long projectId);

    List<SubNetwork> getAllSubNetworks();
}
