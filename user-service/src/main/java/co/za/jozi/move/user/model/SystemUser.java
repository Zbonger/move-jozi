package co.za.jozi.move.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SystemUser extends AbstractEntity {

    private String name;
    private String surname;
    private String emailAddress;
    private String address;
    private String contactNumber;
    private String password;

    @OneToMany(mappedBy = "systemUser", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty("roles")
    private List<Role> roles;

}
