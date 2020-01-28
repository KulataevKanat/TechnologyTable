package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.host.HostDto;
import kg.CSoft.TechnologyTable.dto.host.HostRequest;
import kg.CSoft.TechnologyTable.endpoint.host.HostEndpoint;
import kg.CSoft.TechnologyTable.service.host.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/host")
public class HostController {
    @Autowired
    private HostEndpoint hostEndpoint;
    @Autowired
    private HostService hostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HostDto> addHost(@RequestBody HostRequest hostRequest) {
        return new ResponseEntity<>(hostEndpoint.addHost(hostRequest), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HostDto> removeHostById(@PathVariable Long id) {
        return new ResponseEntity<>(hostEndpoint.removeHostById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<HostDto> changeHost(@RequestBody HostRequest hostRequest, @PathVariable Long id) {
        return new ResponseEntity<>(hostEndpoint.changeHost(hostRequest, id), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public HostDto getHostsById(@PathVariable Long id) {
        return hostEndpoint.getHostsById(id);
    }

    @GetMapping("/getById/{subNetworkId}")
    public List<HostDto> findAllBySubNetworkId(@PathVariable Long subNetworkId) {
        return hostEndpoint.findAllBySubNetworkId(subNetworkId);
    }

    @GetMapping
    public List<HostDto> getAllHosts() {
        return hostEndpoint.getAllHosts();
    }
}
