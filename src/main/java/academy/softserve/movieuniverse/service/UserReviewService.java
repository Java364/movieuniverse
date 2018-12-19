package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.UserReview;
import academy.softserve.movieuniverse.repository.UserReviewRepository;
import academy.softserve.movieuniverse.service.validator.EntityExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Service
public class UserReviewService {
    private UserReviewRepository userReviewRepository;
    private EntityExistsValidator<UserReview, Long> entityExistsValidator;

    @Autowired
    public UserReviewService(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
        entityExistsValidator = new EntityExistsValidator<>(userReviewRepository, UserReview.class);
    }

    @Transactional
    public UserReview saveUserReview(UserReview userReview) {
        Objects.requireNonNull(userReview, "entity must not be null");
        return userReviewRepository.save(userReview);
    }

    @Transactional
    public void deleteUserReviewById(Long userReviewId) throws EntityNotFoundException {
        entityExistsValidator.checkIfEntityExists(userReviewId);
        userReviewRepository.deleteById(userReviewId);
    }

    public UserReview updateUserReview(Long userReviewId, UserReview userReview) {
        entityExistsValidator.checkIfEntityExists(userReviewId);
        userReview.setId(userReviewId);
        return saveUserReview(userReview);
    }
}
