package kg.CSoft.TechnologyTable.controller;

import kg.CSoft.TechnologyTable.dto.role.EntryRoleDto;
import kg.CSoft.TechnologyTable.endpoint.RoleEndpoint;
import kg.CSoft.TechnologyTable.entry.EntryRole;
import kg.CSoft.TechnologyTable.service.EntryRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleEntryController {
    @Autowired
    private RoleEndpoint roleEndpoint;

    @GetMapping
    public List<EntryRoleDto> findAll() {
        return roleEndpoint.findAllRoles();
    }
}
