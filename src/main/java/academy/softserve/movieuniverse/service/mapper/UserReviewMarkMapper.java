package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.dto.UserReviewMarkDTO;

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
		userReviewMark.setMark(dto.getMark());
		userReviewMark.setReviewer(user.findById(dto.getReviewerId()));
		userReviewMark.setUserReview(userReviewMapper.mapToEntity(userReviewService.findById(dto.getUserReviewId())));
		return userReviewMark;

	}
	public UserReviewMark mapToEntityForSave(UserReviewMarkDTO dto) {
		UserReviewMark userReviewMark = new UserReviewMark();
		userReviewMark.setId(null);
		userReviewMark.setMark(dto.getMark());
		userReviewMark.setReviewer(user.findById(dto.getReviewerId()));
		userReviewMark.setUserReview(userReviewMapper.mapToEntity(userReviewService.findById(dto.getUserReviewId())));
		return userReviewMark;

	}

	public UserReviewMark mapToEntityForUpdate(UserReviewMarkDTO dto, Long userReviewMarkId) {
		UserReviewMark userReviewMark = new UserReviewMark();
		userReviewMark.setId(userReviewMarkId);
		userReviewMark.setMark(dto.getMark());
		userReviewMark.setReviewer(user.findById(dto.getReviewerId()));
		userReviewMark.setUserReview(userReviewMapper.mapToEntity(userReviewService.findById(dto.getUserReviewId())));
		return userReviewMark;
	}
	  public List<UserReviewMarkDTO> mapListToDto(List<UserReviewMark> userReviewMarks) {
	        List<UserReviewMarkDTO> userReviewMarkDTOs = new ArrayList<>();
	        for (UserReviewMark t : userReviewMarks) {
	            userReviewMarkDTOs.add(this.mapToDto(t));
	        }
	        return userReviewMarkDTOs;
	    }
	public UserReviewMarkDTO mapToDto(UserReviewMark entity) {
		UserReviewMarkDTO userReviewMarkDTO = new UserReviewMarkDTO();
		userReviewMarkDTO.setId(entity.getId());
		userReviewMarkDTO.setMark(entity.getMark());
		userReviewMarkDTO.setReviewerId(entity.getReviewer().getId());
		userReviewMarkDTO.setUserReviewId(entity.getUserReview().getId());
		return userReviewMarkDTO;

	}

}
