package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.exception.ExceptionType;

import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GalleryService {
    private final GalleryRepository galleryRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Gallery save() {
        return galleryRepository.saveAndFlush(new Gallery());
    }

    public Gallery update(Gallery gallery) {
        if (gallery == null || gallery.getId() == null || !galleryRepository.findById(gallery.getId()).isPresent())
            throw new  NotFoundException(ExceptionType.UPDATE.getMessage() + " gallery");
        gallery = galleryRepository.save(gallery);
        if (gallery == null) throw new NotFoundException(ExceptionType.UPDATE.getMessage() + " gallery");
        return gallery;

    }




    public Gallery findById(Long id) {
        Optional<Gallery> galleryOptional = galleryRepository.findById(id);
        if (!galleryOptional.isPresent()) {
            throw new  NotFoundException(ExceptionType.SELECT.getMessage() + "gallery with " + id.toString() + " ID");
        }
        return galleryOptional.get();
    }

    public void deleteById(Long id) {
        if (id == null || !galleryRepository.findById(id).isPresent())
            throw new
        NotFoundException(ExceptionType.DELETE.getMessage() + "gallery with " + id.toString() + " ID");
        galleryRepository.deleteById(id);
    }

    public List<Gallery> findAll() {
        return galleryRepository.findAll();

    }

   /* public Gallery findByImage(Image image) {
        return galleryRepository.findByImages(image);

    }*/

}
