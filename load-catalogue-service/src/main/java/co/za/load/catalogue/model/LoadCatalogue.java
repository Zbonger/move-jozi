package co.za.load.catalogue.model;

import co.za.load.catalogue.shared.JobType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "load")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "images")
public class LoadCatalogue extends AbstractEntity {

    private String summary;
    @Column(length = 1000)
    private String description;
    private JobType jobType;
    private String fromDestination;
    private String toDestination;
    private String company;
    private String address;
    private Long userId;
    private Double startBiddingPrice;

    @OneToMany(mappedBy = "loadCatalogue", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Image> images;
}
