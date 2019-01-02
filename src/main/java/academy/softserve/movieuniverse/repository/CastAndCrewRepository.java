package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastAndCrewRepository extends JpaRepository<Crew, Long> {

}
