package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Comment;
import academy.softserve.movieuniverse.exception.NoSuchEntityException;
import academy.softserve.movieuniverse.repository.CommentRepository;
import academy.softserve.movieuniverse.service.validator.EntityExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class CommentService {
    private CommentRepository commentRepository;
    private EntityExistsValidator<Comment, Long> entityExistsValidator;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        entityExistsValidator = new EntityExistsValidator<>(commentRepository, Comment.class);
    }

    public Comment findById(Long commentId) {
        NoSuchEntityException noSuchEntityException = new NoSuchEntityException(
                "Unable to find " + getClass().getName() + " with id " + commentId);
        return commentRepository.findById(commentId).orElseThrow(() -> noSuchEntityException);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Transactional
    public Comment save(Comment comment) {
        Objects.requireNonNull(comment, "entity must not be null");
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteById(Long commentId) throws EntityNotFoundException {
        entityExistsValidator.checkIfEntityExists(commentId);
        commentRepository.deleteById(commentId);
    }

    @Transactional
    public Comment update(Long commentId, Comment comment) {
        entityExistsValidator.checkIfEntityExists(commentId);
        comment.setId(commentId);
        return save(comment);
    }
}
