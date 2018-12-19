package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.UserReviewMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewMarkRepository extends JpaRepository<UserReviewMark, Long> {
}
