package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findGenreByName(String genreName);
}
