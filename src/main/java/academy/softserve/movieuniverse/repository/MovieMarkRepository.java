package academy.softserve.movieuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.MovieMark;

public interface MovieMarkRepository extends JpaRepository<MovieMark, Long> {

}
