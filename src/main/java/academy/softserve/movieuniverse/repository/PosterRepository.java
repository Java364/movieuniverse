package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Poster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosterRepository extends JpaRepository<Poster, Long> {

}
