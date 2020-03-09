package co.za.load.catalogue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TruckImage extends AbstractEntity {

    private String descriptionType;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;


    @OneToMany(mappedBy = "truckImage")
    @JsonBackReference
    private List<LoadCatalogue> loadCatalogueList;

}
