package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.userreview.UserReviewDTO;
import academy.softserve.movieuniverse.entity.UserReview;
import academy.softserve.movieuniverse.repository.UserReviewRepository;
import academy.softserve.movieuniverse.service.mapper.UserReviewDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService {
    private UserReviewRepository userReviewRepository;
    private UserReviewDtoMapper userReviewDtoMapper;

    @Autowired
    public UserReviewService(UserReviewRepository userReviewRepository, UserReviewDtoMapper userReviewDtoMapper) {
        this.userReviewRepository = userReviewRepository;
        this.userReviewDtoMapper = userReviewDtoMapper;
    }

    public Optional<UserReviewDTO> findById(Long userReviewId) {
        Optional<UserReview> userReviewOptional = userReviewRepository.findById(userReviewId);
        return userReviewOptional.map(userReview -> userReviewDtoMapper.mapToDTO(userReview));
    }

    
    public List<UserReviewDTO> findAllUserReviewsByMovieId(Long movieId) {
        return null;
    }

    @Transactional
    public UserReviewDTO saveUserReview(UserReviewDTO userReviewDto) {
        UserReview userReview = userReviewDtoMapper.mapToEntity(userReviewDto);
        userReview = userReviewRepository.save(userReview);
        return userReviewDtoMapper.mapToDTO(userReview);
    }

    @Transactional
    public void deleteUserReviewById(Long userReviewId) {
        userReviewRepository.deleteById(userReviewId);
    }

}
