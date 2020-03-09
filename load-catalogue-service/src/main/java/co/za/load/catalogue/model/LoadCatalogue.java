package co.za.load.catalogue.model;

import co.za.load.catalogue.shared.JobType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "load")
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "truck_image_id", nullable = true)
    @JsonManagedReference
    private TruckImage truckImage;
}
