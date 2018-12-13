package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
