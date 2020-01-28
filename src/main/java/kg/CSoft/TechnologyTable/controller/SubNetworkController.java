package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkDto;
import kg.CSoft.TechnologyTable.dto.subNetwork.SubNetworkRequest;
import kg.CSoft.TechnologyTable.endpoint.subNetwork.SubNetworkEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subNetwork")
public class SubNetworkController {
    @Autowired
    private SubNetworkEndpoint subNetworkEndpoint;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SubNetworkDto> addSubNetwork(@RequestBody SubNetworkRequest subNetworkRequest) {
        return new ResponseEntity<>(subNetworkEndpoint.addSubNetwork(subNetworkRequest), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubNetworkDto> removeSubNetworkById(@PathVariable Long id) {
        return new ResponseEntity<>(subNetworkEndpoint.removeSubNetwork(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubNetworkDto> changeSubNetwork(@RequestBody SubNetworkRequest subNetworkRequest, @PathVariable Long id) {
        return new ResponseEntity<>(subNetworkEndpoint.changeSubNetwork(subNetworkRequest, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SubNetworkDto getSubNetworkById(@PathVariable Long id) {
        return subNetworkEndpoint.getSubNetworkById(id);
    }

    @GetMapping("/getById/{projectId}")
    public List<SubNetworkDto> getSubNetworksByProjectId(@PathVariable long projectId) {
        return subNetworkEndpoint.findAllByProjectId(projectId);
    }

    @GetMapping
    public List<SubNetworkDto> getAllSubNetworks() {
        return subNetworkEndpoint.getAllSubNetworks();
    }

}
