package co.za.jozi.move.user.service;

import co.za.jozi.move.user.exceptions.RoleErrorException;
import co.za.jozi.move.user.exceptions.SystemUserNotFoundException;
import co.za.jozi.move.user.model.SystemUser;
import co.za.jozi.move.user.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserService {

    private SystemUserRepository systemUserRepository;

    @Autowired
    public SystemUserService(final SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    public SystemUser addSystemUser(final SystemUser systemUser) {
        if (null != systemUser) {
            if(null == systemUser.getId()) {
                //update
                assert false;
                SystemUser foundSystemUser = systemUserRepository.findById(systemUser.getId())
                    .orElseThrow(() -> new SystemUserNotFoundException("Ooops...something went wrong, system user was not found and cannot add a new user because ID was passed and not found aswell. Remove the ID maybe it will work... Who knows hey" + systemUser.getId()));

                foundSystemUser.setAddress(systemUser.getAddress());
                foundSystemUser.setContactNumber(systemUser.getContactNumber());
                foundSystemUser.setEmailAddress(systemUser.getEmailAddress());
                foundSystemUser.setName(systemUser.getName());
                foundSystemUser.setSurname(systemUser.getSurname());
                return systemUserRepository.save(foundSystemUser);
            }

            systemUser.getRoles().forEach(role -> role.setSystemUser(systemUser));
            return systemUserRepository.save(systemUser);
        }
        throw new RoleErrorException("oohhh Lawd!! The user could be added because there was nothing to add..null is not a good user. Thanks for understanding");
    }

    public List<SystemUser> findAll() {
        return (List<SystemUser>) systemUserRepository.findAll();
    }

    public List<SystemUser> findByName(final String name) {
        return systemUserRepository.findByNameContainingIgnoreCase(name).
                orElseThrow(() -> new SystemUserNotFoundException("Eishhhh!! User not found hey sorry,  try a different user maybe"));
    }

    public List<SystemUser> findBySurname(final String surname) {
        return systemUserRepository.findBySurnameContainingIgnoreCase(surname).
                orElseThrow(() -> new SystemUserNotFoundException("Eishhhh!! User not found hey sorry,  try a different user maybe"));
    }

    public List<SystemUser> findByEmailAddress(final String emailAddress) {
        return systemUserRepository.findByEmailAddressContainingIgnoreCase(emailAddress).
                orElseThrow(() -> new SystemUserNotFoundException("Eishhhh!! User not found hey sorry,  try a different user maybe"));
    }

    public SystemUser findById(final Long id) {
         return systemUserRepository.findById(id).
        orElseThrow(() -> new SystemUserNotFoundException("Eishhhh!! User not found hey sorry,  try a different user maybe"));
    }
}
