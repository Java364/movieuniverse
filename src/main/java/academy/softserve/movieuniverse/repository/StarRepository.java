package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

}
