package co.za.load.catalogue.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SystemUserListResponse implements Serializable {
    private List<SystemUser> systemUserList;
}
