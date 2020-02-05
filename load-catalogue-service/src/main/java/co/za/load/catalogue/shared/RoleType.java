package co.za.load.catalogue.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleType {
 ADMIN("Admin","Able to perform all actions such as insert, delete, update and read"),
 CONTRACTOR("Contractor","Able to perform action such as adding new truck and personal details and updating information related to his/her truck"),
 CONTRACTEE("Contractee","Able to perform actions such as adding load for contractors and view biddings and choose a contractor and view contractors"),
 GUEST("Guest","Guest is a no n-registered user, and can only view trucks and loads");

 private String role;
 private String description;
}
