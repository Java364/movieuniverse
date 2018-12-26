package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.controller.LikeController;
import academy.softserve.movieuniverse.dto.like.LikeDTO;
import academy.softserve.movieuniverse.entity.Like;
import academy.softserve.movieuniverse.service.CommentService;
import academy.softserve.movieuniverse.service.UserService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class LikeMapper {

	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	public Like mapToEntity(LikeDTO dto) {
		Like like = new Like();
		like.setMark(dto.getMark());
		like.setCommentator(userService.findById(dto.getCommentatorId()));
		like.setComment(commentMapper.mapToEntity(commentService.findById(dto.getCommentId())));
		return like;

	}

	public Like mapToEntityForSave(LikeDTO dto) {
		Like like = new Like();
		like.setMark(dto.getMark());
		like.setCommentator(userService.findById(dto.getCommentatorId()));
		like.setComment(commentMapper.mapToEntity(commentService.findById(dto.getCommentId())));
		return like;
	}

	public Like mapToEntityForUpdate(LikeDTO dto, Long likeId) {
		Like like = new Like();
		like.setId(likeId);
		like.setMark(dto.getMark());
		like.setCommentator(userService.findById(dto.getCommentatorId()));
		like.setComment(commentMapper.mapToEntity(commentService.findById(dto.getCommentId())));
		return like;
	}

	public List<LikeDTO> mapListToDto(List<Like> likes) {
		List<LikeDTO> likeDTOs = new ArrayList<>();
		for (Like t : likes) {
			likeDTOs.add(this.mapToDto(t));
		}
		return likeDTOs;
	}

	public LikeDTO mapToDto(Like entity) {
		LikeDTO likeDTO = new LikeDTO();
		likeDTO.setMark(entity.getMark());
		likeDTO.setCommentatorId(entity.getCommentator().getId());
		likeDTO.setCommentId(entity.getComment().getId());
		likeDTO.add((linkTo(methodOn(LikeController.class).showAll()).withRel("likes")));
		likeDTO.add( linkTo(methodOn(LikeController.class).showById(entity.getId())).withSelfRel());
		return likeDTO;

	}

}
