package academy.softserve.movieuniverse.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.dto.UserReviewMarkDTO;
import academy.softserve.movieuniverse.dto.UserReviewMarkDTO;
import academy.softserve.movieuniverse.entity.UserReviewMark;
import academy.softserve.movieuniverse.entity.UserReviewMark;
import academy.softserve.movieuniverse.service.UserReviewService;
import academy.softserve.movieuniverse.service.UserService;

@Service
public class UserReviewMarkMapper {

	@Autowired
	private UserReviewDtoMapper userReviewMapper;
	@Autowired
	private UserReviewService userReviewService;

	@Autowired
	private UserService user;

	public UserReviewMark mapToEntity(UserReviewMarkDTO dto) {
		UserReviewMark userReviewMark = new UserReviewMark();
		userReviewMark.setId(dto.getId());
		userReviewMark.setLiked(dto.isLiked());
		userReviewMark.setReviewer(user.getUser(dto.getReviewerId()));
		userReviewMark
				.setUserReview(userReviewMapper.mapToEntity(userReviewService.findById(dto.getUserReviewId()).get()));
		return userReviewMark;

	}

	public UserReviewMark mapToEntityForUpdate(UserReviewMarkDTO dto, Long userReviewMarkId) {
		UserReviewMark userReviewMark = new UserReviewMark();
		userReviewMark.setId(userReviewMarkId);
		userReviewMark.setLiked(dto.isLiked());
		userReviewMark.setReviewer(user.getUser(dto.getReviewerId()));
		userReviewMark
				.setUserReview(userReviewMapper.mapToEntity(userReviewService.findById(dto.getUserReviewId()).get()));
		return userReviewMark;
	}

	public UserReviewMarkDTO mapToDto(UserReviewMark entity) {
		UserReviewMarkDTO userReviewMarkDTO = new UserReviewMarkDTO();
		userReviewMarkDTO.setId(entity.getId());
		userReviewMarkDTO.setLiked(entity.isLiked());
		userReviewMarkDTO.setReviewerId(entity.getReviewer().getId());
		userReviewMarkDTO.setUserReviewId(entity.getUserReview().getId());
		return userReviewMarkDTO;

	}

}