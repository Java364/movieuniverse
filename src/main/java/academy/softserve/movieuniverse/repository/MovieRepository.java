package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.MovieMark;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	Movie findAllByMovieMarks(MovieMark movieMark);
}
