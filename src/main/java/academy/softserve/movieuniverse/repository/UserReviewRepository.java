package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
