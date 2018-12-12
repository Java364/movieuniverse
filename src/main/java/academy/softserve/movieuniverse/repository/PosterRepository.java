package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import academy.softserve.movieuniverse.entity.Poster;

public interface PosterRepository extends JpaRepository<Poster, Long> {

}
