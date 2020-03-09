package co.za.load.catalogue.resources;

import co.za.load.catalogue.model.LoadCatalogue;
import co.za.load.catalogue.service.LoadCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/load")
public class LoadCatalogueResource {

    private LoadCatalogueService loadCatalogueService;

    @Autowired
    public LoadCatalogueResource(final LoadCatalogueService loadCatalogueService) {
        this.loadCatalogueService = loadCatalogueService;
    }

    @PostMapping("/add")
    public LoadCatalogue addNewLoad(HttpServletRequest request, @RequestBody LoadCatalogue loadCatalogue) {
        return loadCatalogueService.addNewLoad(loadCatalogue);
    }

    @GetMapping("/all")
    public List<LoadCatalogue> all() {
        return loadCatalogueService.findAllLoad();
    }

    @GetMapping("/{id}")
    public LoadCatalogue findLoadById(HttpServletRequest request, @PathVariable String id) {
        return loadCatalogueService.findLoadById(Long.getLong(id));
    }

    @GetMapping("/company/{company}")
    public List<LoadCatalogue> findLoadByCompanyName(@RequestHeader HttpHeaders headers, @PathVariable String company) {
        return loadCatalogueService.findLoadByCompanyName(company);
    }

    @GetMapping("/fromDestination/{fromDestination}")
    public List<LoadCatalogue> findLoadByFromDestination(@RequestHeader HttpHeaders headers, @PathVariable String fromDestination) {
        return loadCatalogueService.findByFromDestination(fromDestination);
    }

    @GetMapping("/toDestination/{toDestination}")
    public List<LoadCatalogue> findLoadByToDestination(@RequestHeader HttpHeaders headers, @PathVariable String toDestination) {
        return loadCatalogueService.findLoadByToDestination(toDestination);
    }

    @GetMapping("/destinations/{fromDestination}/{toDestination}")
    public List<LoadCatalogue> findLoadByFromDestinationAndToDestination(@RequestHeader HttpHeaders headers, @PathVariable String fromDestination, @PathVariable String toDestination) {
        return loadCatalogueService.findLoadByFromDestinationAndToDestination(fromDestination, toDestination);
    }

    @GetMapping("/summary/{summary}")
    public List<LoadCatalogue> findLoadBySummary(@RequestHeader HttpHeaders headers, @PathVariable String summary) {
        return loadCatalogueService.findLoadBySummary(summary);
    }

    @GetMapping("/description/{description}")
    public List<LoadCatalogue> findLoadByDescription(@RequestHeader HttpHeaders headers, @PathVariable String description) {
        return loadCatalogueService.findLoadByDescription(description);
    }
}
