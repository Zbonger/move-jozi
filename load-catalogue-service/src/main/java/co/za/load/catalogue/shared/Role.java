package co.za.load.catalogue.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Role {
    private String roleType;
    private String description;
}
