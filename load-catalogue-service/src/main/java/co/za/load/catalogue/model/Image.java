package co.za.load.catalogue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image extends AbstractEntity {

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "load_id",  nullable = false)
    @JsonBackReference
    private LoadCatalogue loadCatalogue;
}
