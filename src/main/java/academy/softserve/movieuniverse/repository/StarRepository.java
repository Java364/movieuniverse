package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    Star findByLinks(Links links);
    List<Star> findAllByFirstNameContainingOrLastNameContainingAllIgnoreCase(String firstName, String lastName);
}
