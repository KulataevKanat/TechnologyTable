package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkDto;
import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkRequest;
import kg.CSoft.TechnologyTable.entity.Project;
import kg.CSoft.TechnologyTable.entity.SubNetwork;
import kg.CSoft.TechnologyTable.service.ProjectService;
import kg.CSoft.TechnologyTable.service.SubNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubNetworkEndpointImpl implements SubNetworkEndpoint {
    @Autowired
    private SubNetworkService subNetworkService;
    @Autowired
    private ProjectService projectService;

    @Override
    public SubNetworkDto addSubNetwork(SubNetworkRequest subNetworkRequest) {
        Project project = projectService.getProjectById(subNetworkRequest.getProjectId());
        SubNetwork subNetwork = new SubNetwork(subNetworkRequest.getName(), subNetworkRequest.getMask(), subNetworkRequest.getAddress(), subNetworkRequest.getVlanId(), subNetworkRequest.getVlanName(), subNetworkRequest.getDescription(), project);
        subNetworkService.addSubNetwork(subNetwork);
        return new SubNetworkDto(subNetwork);
    }

    @Override
    public SubNetworkDto removeSubNetwork(Long id) {
        return subNetworkService.removeSubNetworkById(id);

    }

    @Override
    public SubNetworkDto changeSubNetwork(SubNetworkRequest subNetworkRequest, Long id) {
        SubNetwork subNetwork = subNetworkService.getSubNetworkById(id);
        if (subNetworkRequest.getName() != null) subNetwork.setName(subNetworkRequest.getName());
        if (subNetworkRequest.getMask() != null) subNetwork.setMask(subNetworkRequest.getMask());
        if (subNetworkRequest.getAddress() != null) subNetwork.setAddress(subNetworkRequest.getAddress());
        if (subNetworkRequest.getVlanId() != null) subNetwork.setVlanId(subNetworkRequest.getVlanId());
        if (subNetworkRequest.getVlanName() != null) subNetwork.setVlanName(subNetworkRequest.getVlanName());
        if (subNetworkRequest.getDescription() != null)
            subNetwork.setDescription(subNetworkRequest.getDescription());
        if (subNetworkRequest.getProjectId() != null)
            subNetwork.setProject(projectService.getProjectById(subNetworkRequest.getProjectId()));
        subNetworkService.changeSubNetwork(subNetwork);
        return new SubNetworkDto(subNetwork);
    }


    @Override
    public SubNetworkDto getSubNetworkById(Long id) {
        return new SubNetworkDto(subNetworkService.getSubNetworkById(id));
    }

    @Override
    public List<SubNetworkDto> findAllByProjectId(Long projectId) {
        return SubNetworkDto.toList(subNetworkService.findAllByProjectId(projectId));
    }


    @Override
    public List<SubNetworkDto> getAllSubNetworks() {
        return SubNetworkDto.toList(subNetworkService.getAllSubNetworks());
    }
}
