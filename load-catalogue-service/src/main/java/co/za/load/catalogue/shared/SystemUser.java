package co.za.load.catalogue.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SystemUser {

    private String name;
    private String surname;
    private String emailAddress;
    private String address;
    private String contactNumber;
    private String password;
    private List<Role> roles;

}
