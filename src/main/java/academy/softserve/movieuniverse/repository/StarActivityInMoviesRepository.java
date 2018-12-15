package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarActivityInMoviesRepository extends JpaRepository<StarActivityInMovies, Long> {

}
