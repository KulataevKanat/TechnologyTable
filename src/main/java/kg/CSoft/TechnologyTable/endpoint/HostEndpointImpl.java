package kg.CSoft.TechnologyTable.endpoint;

import kg.CSoft.TechnologyTable.dto.host.HostDto;
import kg.CSoft.TechnologyTable.dto.host.HostRequest;
import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.entity.SubNetwork;
import kg.CSoft.TechnologyTable.service.HostService;
import kg.CSoft.TechnologyTable.service.SubNetworkService;
import kg.CSoft.TechnologyTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HostEndpointImpl implements HostEndpoint {
    @Autowired
    private HostService hostService;
    @Autowired
    private SubNetworkService subNetworkService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public HostDto addHost(HostRequest hostRequest) {
        SubNetwork subNetwork = subNetworkService.getSubNetworkById(hostRequest.getSubNetworkId());
        Host host = new Host(hostRequest.getIpAddress(), hostRequest.getDescription(), hostRequest.getLogin(), hostRequest.getPassword(), subNetwork);
        hostService.addHost(host);
        return new HostDto(host);

    }

    @Override
    public HostDto removeHostById(Long id) {
        return hostService.removeHostById(id);

    }

    @Override
    public HostDto changeHost(HostRequest hostRequest, Long id) {
        Host host = hostService.getHostsById(id);
        if (hostRequest.getIpAddress() != null) host.setIpAddress(hostRequest.getIpAddress());
        if (hostRequest.getDescription() != null) host.setDescription(hostRequest.getDescription());
        if (hostRequest.getLogin() != null) host.setLogin(hostRequest.getLogin());
        if (hostRequest.getPassword() != null && hostRequest.getPassword().length() > 0)
            host.setPassword(encoder.encode(hostRequest.getPassword()));
        if (hostRequest.getSubNetworkId() != null)
            host.setSubNetwork(subNetworkService.getSubNetworkById(hostRequest.getSubNetworkId()));
        hostService.changeHost(host);
        return new HostDto(host);
    }

    @Override
    public HostDto getHostsById(Long id) {
        return new HostDto(hostService.getHostsById(id));
    }

    @Override
    public List<HostDto> findAllBySubNetworkId(Long subNetworkId) {
        return HostDto.toList(hostService.findAllBySubNetworkId(subNetworkId));
    }

    @Override
    public List<HostDto> getAllHosts() {
        return HostDto.toList(hostService.getAllHosts());
    }
}
