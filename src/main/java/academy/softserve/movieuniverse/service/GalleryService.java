package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.exception.GalleryException;
import academy.softserve.movieuniverse.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Gallery save() {
        return galleryRepository.saveAndFlush(new Gallery());
    }

    public Gallery findById(Long id) {
        Optional<Gallery> galleryOptional = galleryRepository.findById(id);
        if (!galleryOptional.isPresent()) {
            throw GalleryException.createSelectException("no such gallery");
        }
        return galleryOptional.get();
    }

    public void deleteById(Long id) {
        if (id == null || !galleryRepository.findById(id).isPresent())
            throw GalleryException.createDeleteException("no exist such gallery to delete");
        galleryRepository.deleteById(id);
    }

    public List<Gallery> findAll() {
        return galleryRepository.findAll();
    }

}
