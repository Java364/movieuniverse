package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
