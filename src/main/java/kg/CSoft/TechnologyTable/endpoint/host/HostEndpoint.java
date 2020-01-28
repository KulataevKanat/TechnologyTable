package kg.CSoft.TechnologyTable.endpoint.host;

import kg.CSoft.TechnologyTable.dto.host.HostDto;
import kg.CSoft.TechnologyTable.dto.host.HostRequest;

import java.util.List;

public interface HostEndpoint {
    HostDto addHost(HostRequest hostRequest);

    HostDto removeHostById(Long id);

    HostDto changeHost(HostRequest hostRequest, Long id);

    HostDto getHostsById(Long id);

    List<HostDto> findAllBySubNetworkId(Long subNetworkId);

    List<HostDto> getAllHosts();


}
