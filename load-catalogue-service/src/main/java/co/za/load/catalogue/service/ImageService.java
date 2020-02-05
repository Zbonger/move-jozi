package co.za.load.catalogue.service;

import co.za.load.catalogue.model.Image;
import co.za.load.catalogue.model.LoadCatalogue;
import co.za.load.catalogue.repository.ImageRepository;
import co.za.load.catalogue.repository.LoadCatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageService(final ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image addNewImage(final Image image) {
        //TODO: Later to manipulate the object
        return imageRepository.save(image);
    }

    public List<Image> findByLoadId(final Long id) {
        return imageRepository.findByLoadCatalogue_Id(id);
    }
}
