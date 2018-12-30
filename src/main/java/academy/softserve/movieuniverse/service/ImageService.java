package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.exception.ImageException;
import academy.softserve.movieuniverse.repository.GalleryRepository;
import academy.softserve.movieuniverse.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
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
        if (image == null)
            throw ImageException.createSaveException("couldn't save image", null);
        return image;
    }

    public Image update(Image newImage, Long id) {
        if (newImage == null) {
            throw ImageException.createUpdateException("no image to update", null);
        }
        return imageRepository.findById(id).map(image -> {
            image.setName(newImage.getName());
            image.setImageUrl(newImage.getImageUrl());
            image.setEntryLastUpdate(new Date());
            return imageRepository.saveAndFlush(image);
        }).orElseThrow(() -> ImageException.createUpdateException("no image to update", null));

    }

    public Image findById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> ImageException.createSelectException("no such image", new Exception()));
    }

    public void delete(Long id) {
        if (id == null || !imageRepository.findById(id).isPresent()) {
            throw ImageException.createDeleteException("no exist such image to delete", new Exception());
        } else {
            imageRepository.deleteById(id);
        }
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
