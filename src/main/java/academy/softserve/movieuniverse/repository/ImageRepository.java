package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByGalleryAndIsRemovedIsFalse(Gallery gallery);
}
