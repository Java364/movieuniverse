package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.UserReviewMark;
import academy.softserve.movieuniverse.exception.UserReviewMarkException;
import academy.softserve.movieuniverse.repository.UserReviewMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserReviewMarkService {
    @Autowired
    private UserReviewMarkRepository userReviewMarkRepository;

    public UserReviewMark saveUserReviewMark(UserReviewMark userReviewMark) {
        userReviewMark = userReviewMarkRepository.save(userReviewMark);
        if (userReviewMark == null)
            throw UserReviewMarkException.createSaveException("couldn't save userReviewMark", null);
        return userReviewMark;
    }

    public UserReviewMark updateUserReviewMark(UserReviewMark userReviewMark) {
        userReviewMark = userReviewMarkRepository.save(userReviewMark);
        if (userReviewMark == null)
            throw UserReviewMarkException.createUpdateException("couldn't update userReviewMark", null);
        return userReviewMark;
    }

    public UserReviewMark findUserReviewMarkById(Long id) {
        Optional<UserReviewMark> userReviewMarkOptional = userReviewMarkRepository.findById(id);
        if (!userReviewMarkOptional.isPresent()) {
            throw UserReviewMarkException.createSelectException("no such userReviewMark", new Exception());
        }
        UserReviewMark userReviewMark = userReviewMarkOptional.get();
        return userReviewMark;
    }

    public void deleteUserReviewMark(Long id) {
        if (id == null || findUserReviewMarkById(id) == null)
            throw UserReviewMarkException.createDeleteException("no exist such userReviewMark to delete", null);
        userReviewMarkRepository.deleteById(id);
    }
}
