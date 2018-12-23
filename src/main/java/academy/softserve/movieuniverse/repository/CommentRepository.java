package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Comment;
import academy.softserve.movieuniverse.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select ur from Comments ur where ur.commentator.id = :userId")
    Optional<Comment> findCommentByUserId(@Param("userId") Long userId);

    List<Comment> findAllByReviewer(User user);
}
