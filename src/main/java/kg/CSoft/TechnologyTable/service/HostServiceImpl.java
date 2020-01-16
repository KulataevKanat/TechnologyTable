package kg.CSoft.TechnologyTable.service;

import kg.CSoft.TechnologyTable.dto.host.HostDto;
import kg.CSoft.TechnologyTable.entity.Host;
import kg.CSoft.TechnologyTable.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {
    @Autowired
    private HostRepository hostRepository;

    @Override
    public Host addHost(Host host) {
        return hostRepository.save(host);

    }

    @Override
    public HostDto removeHostById(Long id) {
        hostRepository.deleteById(id);
        return null;
    }

    @Override
    public Host changeHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host getHostsById(Long id) {
        return hostRepository.findById(id).get();
    }

    @Override
    public List<Host> findAllBySubNetworkId(Long subNetworkId) {
        return hostRepository.findAllBySubNetworkId(subNetworkId);
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }
}
