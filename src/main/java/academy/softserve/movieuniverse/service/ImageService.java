package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.exception.GalleryException;
import academy.softserve.movieuniverse.exception.ImageException;
import academy.softserve.movieuniverse.repository.GalleryRepository;
import academy.softserve.movieuniverse.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final GalleryRepository galleryRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository, GalleryRepository galleryRepository) {
        this.imageRepository = imageRepository;
        this.galleryRepository = galleryRepository;
    }

    public Image save(Image image) {
        if (image == null || image.getId() != null)
            throw ImageException.createSaveException("couldn't save image", null);
        image = imageRepository.save(image);
        if (image == null) throw ImageException.createSaveException("couldn't save image", null);
        return image;
    }

    public Image update(Image image) {
        if (image == null || image.getId() == null || !imageRepository.findById(image.getId()).isPresent())
            throw ImageException.createUpdateException("no image to update", null);
        image = imageRepository.save(image);
        if (image == null) throw ImageException.createUpdateException("couldn't update image", null);
        return image;
    }

    public Image findById(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> ImageException.createSelectException("no such image", new Exception()));
    }

    public void delete(Long id) {
        if (id == null || !imageRepository.findById(id).isPresent()) {
            throw ImageException.createDeleteException("no exist such image to delete", new Exception());
        } else {
            imageRepository.deleteById(id);
        }
    }

    public List<Image> findAll(Gallery gallery) {
        return imageRepository.findAllByGalleryAndIsRemovedIsFalse(gallery);
    }
}
