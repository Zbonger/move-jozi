package co.za.jozi.move.user.resources;

import co.za.jozi.move.user.service.RoleService;
import co.za.jozi.move.user.shared.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RolesResource {

    private RoleService roleService;

    @Autowired
    public RolesResource(final RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public List<RoleType> findAllRoleTypes() {
        return roleService.findAllRoleTypes();
    }
}
