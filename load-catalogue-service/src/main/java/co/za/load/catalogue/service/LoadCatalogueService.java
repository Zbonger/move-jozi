package co.za.load.catalogue.service;

import co.za.load.catalogue.exceptions.LoadCatalogueException;
import co.za.load.catalogue.model.LoadCatalogue;
import co.za.load.catalogue.repository.LoadCatalogueRepository;
import co.za.load.catalogue.shared.RoleType;
import co.za.load.catalogue.shared.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class LoadCatalogueService {

    private RestTemplate restTemplate;
    private LoadCatalogueRepository loadCatalogueRepository;
    private DiscoveryClient discoveryClient;
    static final String ERROR_MESSAGE = "ohh ohh! We could not find loads based on your search....";

    @Autowired
    public LoadCatalogueService(final LoadCatalogueRepository loadCatalogueRepository, final RestTemplate restTemplate, final DiscoveryClient discoveryClient) {
        this.loadCatalogueRepository = loadCatalogueRepository;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    public LoadCatalogue addNewLoad(final LoadCatalogue loadCatalogue) {

        if (null != loadCatalogue) {
            if (!Objects.isNull(loadCatalogue.getUserId())) {

//                List<ServiceInstance> serviceInstances = discoveryClient.getInstances("api-gateway");
//                ServiceInstance serviceInstance = serviceInstances.get(0);
//                String baseUrl = serviceInstance.getUri().toString();
//                baseUrl = baseUrl + "user-service/api/v1/user/";

                SystemUser systemUser = restTemplate.getForObject("http://user-service/api/v1/user/" + loadCatalogue.getUserId(), SystemUser.class);
                systemUser.getRoles().forEach(role -> {
                    if (!role.getRoleType().equals(RoleType.CONTRACTEE.getRole())) {
                        throw new LoadCatalogueException("Sorry only contractees are allowed to add load.");
                    }
                });
            }
        }

//        if (!CollectionUtils.isEmpty(loadCatalogue.getImages())) {
//            loadCatalogue.getImages().forEach(image -> {image.setLoadCatalogue(loadCatalogue);});
//        }
        return loadCatalogueRepository.save(loadCatalogue);
    }

    public List<LoadCatalogue> findAllLoad() {
        return (List<LoadCatalogue>) loadCatalogueRepository.findAll();
    }

    public List<LoadCatalogue> findLoadByCompanyName(final String companyName) {
        return loadCatalogueRepository.findByCompanyContainingIgnoreCase(companyName)
                .orElseThrow(() -> new LoadCatalogueException(ERROR_MESSAGE));
    }

    public List<LoadCatalogue> findByFromDestination(final String fromDestination) {
        return loadCatalogueRepository.findByFromDestinationContainingIgnoreCase(fromDestination)
                .orElseThrow(() -> new LoadCatalogueException(ERROR_MESSAGE));
    }

    public List<LoadCatalogue> findLoadByToDestination(final String toDestination) {
        return loadCatalogueRepository.findByToDestinationContainingIgnoreCase(toDestination)
                .orElseThrow(() -> new LoadCatalogueException(ERROR_MESSAGE));
    }

    public List<LoadCatalogue> findLoadByFromDestinationAndToDestination(final String fromDestination, String toDestination) {
        return loadCatalogueRepository.findByFromDestinationContainingIgnoreCaseAndToDestinationContainingIgnoreCase(fromDestination, toDestination)
                .orElseThrow(() -> new LoadCatalogueException("mmmmmhhhh! the destinations does not have loads...can you see? try other ones hey"));
    }

    public List<LoadCatalogue> findLoadBySummary(final String summary) {
        return loadCatalogueRepository.findBySummaryContainingIgnoreCase(summary)
                .orElseThrow(() -> new LoadCatalogueException(ERROR_MESSAGE));
    }

    public List<LoadCatalogue> findLoadByDescription(final String description) {
        return loadCatalogueRepository.findByDescriptionContainingIgnoreCase(description)
                .orElseThrow(() -> new LoadCatalogueException(ERROR_MESSAGE));
    }

    public LoadCatalogue findLoadById(final Long id) {
        return loadCatalogueRepository.findById(id).orElseThrow(() -> new LoadCatalogueException(id));
    }
}
