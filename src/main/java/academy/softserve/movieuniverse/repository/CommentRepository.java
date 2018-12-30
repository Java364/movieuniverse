package academy.softserve.movieuniverse.repository;

import academy.softserve.movieuniverse.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
