package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.CastAndCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarActivityInMoviesRepository extends JpaRepository<CastAndCrew, Long> {

}
