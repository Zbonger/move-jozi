package co.za.jozi.move.user;

import co.za.jozi.move.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StarterPack implements CommandLineRunner {

    private RoleService roleService;

    @Autowired
    public StarterPack(final RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
//        Role adminRole = Role.builder()
//        .roleType(RoleType.ADMIN)
//        .description(RoleType.ADMIN.getDescription())
//                .build();
//
//        Role contractorRole = Role.builder()
//                .roleType(RoleType.CONTRACTOR)
//                .description(RoleType.CONTRACTOR.getDescription())
//                .build();
//
//        Role contracteeRole = Role.builder()
//                .roleType(RoleType.CONTRACTEE)
//                .description(RoleType.CONTRACTEE.getDescription())
//                .build();
//
//        Role guestRole = Role.builder()
//                .roleType(RoleType.GUEST)
//                .description(RoleType.GUEST.getDescription())
//                .build();
//
//        roleService.addRole(adminRole);
//        roleService.addRole(contractorRole);
//        roleService.addRole(contracteeRole);
//        roleService.addRole(guestRole);


    }
}
