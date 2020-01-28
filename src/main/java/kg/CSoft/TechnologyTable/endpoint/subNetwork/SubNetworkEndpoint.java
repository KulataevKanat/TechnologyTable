package kg.CSoft.TechnologyTable.endpoint.subNetwork;

import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkDto;
import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkRequest;

import java.util.List;

public interface SubNetworkEndpoint {
    SubNetworkDto addSubNetwork(SubNetworkRequest subNetworkRequest);

    SubNetworkDto removeSubNetwork(Long id);

    SubNetworkDto changeSubNetwork(SubNetworkRequest subNetworkRequest, Long id);

    SubNetworkDto getSubNetworkById(Long id);

    List<SubNetworkDto> findAllByProjectId(Long projectId);

    List<SubNetworkDto> getAllSubNetworks();

}
