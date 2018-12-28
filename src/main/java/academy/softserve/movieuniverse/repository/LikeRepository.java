package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
