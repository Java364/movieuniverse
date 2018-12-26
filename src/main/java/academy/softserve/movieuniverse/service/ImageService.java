package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.exception.ImageException;
import academy.softserve.movieuniverse.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

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
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (!imageOptional.isPresent()) {
            throw ImageException.createSelectException("no such image", new Exception());
        }
        Image image = imageOptional.get();
        return image;
    }

    public void deleteById(Long id) {
        if (id == null || !imageRepository.findById(id).isPresent())
            throw ImageException.createDeleteException("no exist such image to delete", null);
        imageRepository.deleteById(id);
    }

    public List<Image> findAll() {
        List<Image> images = new ArrayList<>();
        images = imageRepository.findAll();
        return images;
    }
}
