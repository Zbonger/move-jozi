package co.za.jozi.move.user.service;

import co.za.jozi.move.user.exceptions.RoleErrorException;
import co.za.jozi.move.user.exceptions.RoleNotFoundException;
import co.za.jozi.move.user.model.Role;
import co.za.jozi.move.user.repository.RoleRepository;
import co.za.jozi.move.user.shared.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addUserRole(final Role  role) {
        if (null != role) {
            if(null == role.getId()) {
                //update
                assert false;
                Role foundRole = roleRepository.findById(role.getId())
                    .orElseThrow(() -> new RoleNotFoundException("Ooops...something went wrong, role was not found and cannot add a new role because ID was passed with role. Remove the ID maybe it will work... Who knows hey" + role.getId()));

                foundRole.setDescription(role.getDescription());
                foundRole.setRoleType(role.getRoleType());
                return roleRepository.save(role);
            }

            if(null != role.getRoleType()) {
                //Create a new role
                return roleRepository.save(role);
            }
        }
        throw new RoleErrorException("oohhh Lawd!! The Role cannot be added because there was nothing to add..null is not a good role. Thanks for understanding");
    }

    public List<RoleType> findAllRoleTypes() {
        List<RoleType> roleTypes = new ArrayList<>();
        roleTypes.add(RoleType.CONTRACTEE);
        roleTypes.add(RoleType.ADMIN);
        roleTypes.add(RoleType.CONTRACTOR);
        roleTypes.add(RoleType.GUEST);
        return  roleTypes;
    }
}
