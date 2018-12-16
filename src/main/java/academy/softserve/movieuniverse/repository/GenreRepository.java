package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.name = :genreName")
    Optional<Genre> findGenreByName(@Param("genreName") String genreName);
}
