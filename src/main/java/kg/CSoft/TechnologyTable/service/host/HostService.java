package kg.CSoft.TechnologyTable.service.host;

import kg.CSoft.TechnologyTable.dto.host.HostDto;
import kg.CSoft.TechnologyTable.entity.Host;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HostService {
    Host addHost(Host host);

    HostDto removeHostById(Long id);

    Host changeHost(Host host);

    Host getHostsById(Long id);

    List<Host> findAllBySubNetworkId(Long subNetworkId);

    List<Host> getAllHosts();
}
