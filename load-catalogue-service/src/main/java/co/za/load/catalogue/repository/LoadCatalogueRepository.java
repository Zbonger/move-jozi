package co.za.load.catalogue.repository;

import co.za.load.catalogue.model.LoadCatalogue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoadCatalogueRepository extends CrudRepository<LoadCatalogue, Long> {
    Optional<List<LoadCatalogue>> findByCompanyContainingIgnoreCase(String companyName);

    Optional<List<LoadCatalogue>> findByFromDestinationContainingIgnoreCase(String fromDestination);

    Optional<List<LoadCatalogue>> findByToDestinationContainingIgnoreCase(String toDestination);

    Optional<List<LoadCatalogue>> findByFromDestinationContainingIgnoreCaseAndToDestinationContainingIgnoreCase(String fromDestination, String toDestination);

    Optional<List<LoadCatalogue>> findBySummaryContainingIgnoreCase(String summary);

    Optional<List<LoadCatalogue>> findByDescriptionContainingIgnoreCase(String description);
}
