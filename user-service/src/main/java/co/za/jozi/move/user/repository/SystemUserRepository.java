package co.za.jozi.move.user.repository;

import co.za.jozi.move.user.model.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

    public Optional<List<SystemUser>> findByNameContainingIgnoreCase(String name);
    public Optional<List<SystemUser>> findBySurnameContainingIgnoreCase(final String surname);
    public Optional<List<SystemUser>> findByEmailAddressContainingIgnoreCase(final String emailAddress);
}
