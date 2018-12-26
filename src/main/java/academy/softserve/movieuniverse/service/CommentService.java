package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Comment;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.repository.CommentRepository;
import academy.softserve.movieuniverse.service.validator.EntityExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private final UserService userService;
    private EntityExistsValidator<Comment, Long> entityExistsValidator;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        entityExistsValidator = new EntityExistsValidator<>(commentRepository, Comment.class);
        this.userService = userService;
    }

    public Comment findById(Long commentId) {
        return commentRepository.findById(commentId)
                                   .orElseThrow(() -> new EntityNotFoundException("Entity doesn't exists"));
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Transactional
    public Comment save(Comment comment) {
        Objects.requireNonNull(comment, "entity must not be null");
        return commentRepository.saveAndFlush(comment);
    }

    @Transactional
    public void deleteById(Long commentId) throws EntityNotFoundException {
        entityExistsValidator.checkIfEntityExists(commentId);
        commentRepository.deleteById(commentId);
    }

    public Comment update(Long commentId, Comment comment) {
        entityExistsValidator.checkIfEntityExists(commentId);
        comment.setId(commentId);
        return save(comment);
    }

    public List<Comment> findAllByUser(Long id){
        return commentRepository.findAllByCommentator(userService.findById(id));
    }
}
