package co.za.jozi.move.user.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Role extends AbstractEntity {
    private String roleType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id",  nullable = false)
    @JsonBackReference
    private SystemUser systemUser;
}
