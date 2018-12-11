package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.softserve.movieuniverse.entity.Star;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

}
