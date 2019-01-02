package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findAllByMovieMarks(MovieMark movieMark);

    @Query("select sp.star from CastAndCrew cac" + " inner join cac.starProfession sp"
            + " where cac.movie.id = :movieId and sp.profession.professionType = :profession")
    List<Star> findCreditsByProfession(@Param("movieId") Long movieId, @Param("profession") String profession);

    List<Movie> findAllByMovieNameIgnoreCase(String name);
}
