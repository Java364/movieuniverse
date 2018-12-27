package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    Gallery findByImages(Image image);

}
