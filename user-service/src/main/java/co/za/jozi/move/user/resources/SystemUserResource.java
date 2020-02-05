package co.za.jozi.move.user.resources;

import co.za.jozi.move.user.model.SystemUser;
import co.za.jozi.move.user.service.SystemUserService;
import co.za.jozi.move.user.shared.SystemUserListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class SystemUserResource {

    private SystemUserService systemUserService;

    @Autowired
    public SystemUserResource(final SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PostMapping("/add")
    public SystemUser addNewUser(HttpServletRequest request, @RequestBody SystemUser systemUser) {
        return systemUserService.addSystemUser(systemUser);
    }

    @GetMapping("/all")
    public SystemUserListResponse all() {
        SystemUserListResponse userListResponse= new SystemUserListResponse();
        userListResponse.setSystemUserList(systemUserService.findAll());
        return userListResponse;
    }

    @GetMapping("/{id}")
    public SystemUser findUserById(HttpServletRequest request, @PathVariable Long id) {
        return systemUserService.findById(id);
    }

    @GetMapping("/name/{name}")
    public SystemUserListResponse findUserByName(@RequestHeader HttpHeaders headers, @PathVariable String name) {
        SystemUserListResponse userListResponse= new SystemUserListResponse();
        userListResponse.setSystemUserList(systemUserService.findByName(name));
        return userListResponse;
    }

    @GetMapping("/surname/{surname}")
    public SystemUserListResponse findLoadByFromDestination(@RequestHeader HttpHeaders headers, @PathVariable String surname) {
        SystemUserListResponse userListResponse= new SystemUserListResponse();
        userListResponse.setSystemUserList(systemUserService.findBySurname(surname));
        return userListResponse;
    }
}
