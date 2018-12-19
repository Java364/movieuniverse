package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import academy.softserve.movieuniverse.entity.MovieMark;

import java.util.List;

public interface MovieMarkRepository extends JpaRepository<MovieMark, Long> {
    List<MovieMark> findAllByUser(User user);
}
