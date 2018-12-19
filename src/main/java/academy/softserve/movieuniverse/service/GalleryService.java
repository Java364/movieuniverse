package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.exception.GalleryException;
import academy.softserve.movieuniverse.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    public Gallery saveGallery(Gallery gallery) {
        if (gallery == null || gallery.getId() != null)
            throw GalleryException.createSaveException("couldn't save gallery", null);
        gallery = galleryRepository.save(gallery);
        if (gallery == null) throw GalleryException.createSaveException("couldn't save gallery", null);
        return gallery;
    }

    public Gallery updateGallery(Gallery gallery) {
        if (gallery == null || gallery.getId() == null || !galleryRepository.findById(gallery.getId()).isPresent())
            throw GalleryException.createUpdateException("no gallery to update", null);
        gallery = galleryRepository.save(gallery);
        if (gallery == null) throw GalleryException.createUpdateException("couldn't update gallery", null);
        return gallery;
    }

    public Gallery findGalleryById(Long id) {
        Optional<Gallery> galleryOptional = galleryRepository.findById(id);
        if (!galleryOptional.isPresent()) {
            throw GalleryException.createSelectException("no such gallery", new Exception());
        }
        Gallery trailer = galleryOptional.get();
        return trailer;
    }

    public void deleteGallery(Long id) {
        if (id == null || !galleryRepository.findById(id).isPresent())
            throw GalleryException.createDeleteException("no exist such gallery to delete", null);
        galleryRepository.deleteById(id);
    }

    public List<Gallery> findAll() {
        List<Gallery> galleries = new ArrayList<>();
        galleries = galleryRepository.findAll();
        return galleries;
    }
}
