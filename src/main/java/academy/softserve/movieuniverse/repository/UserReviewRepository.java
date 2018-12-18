package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    @Query("select ur from UserReview ur where ur.reviewer.id = :userId")
    Optional<UserReview> findUserReviewByByUserId(@Param("userId") Long userId);
}
