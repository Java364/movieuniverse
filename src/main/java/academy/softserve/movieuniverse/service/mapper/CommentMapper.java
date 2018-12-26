package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.CommentController;
import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.comment.CommentDTO;
import academy.softserve.movieuniverse.dto.comment.CommentRequest;
import academy.softserve.movieuniverse.entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CommentMapper {
    private ModelMapper modelMapper;

    @Autowired
    public CommentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }



    public Comment mapToEntity(CommentRequest dto) {
        return modelMapper.map(dto, Comment.class);
    }


    public CommentDTO mapToDTO(Comment entity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText(entity.getText());
        commentDTO.setTitle(entity.getTitle());
        commentDTO.setCreationTime(entity.getEntryCreationDate().toInstant(ZoneOffset.ofTotalSeconds(0)).getEpochSecond());
        commentDTO.setLastUpdate(entity.getEntryLastUpdate().toInstant(ZoneOffset.ofTotalSeconds(0)).getEpochSecond());
        commentDTO.setUserName(entity.getCommentator().getUsername());
        commentDTO.setMovieName(entity.getCommentedMovie().getMovieName());
        commentDTO.setSelf(linkTo(methodOn(CommentController.class)
                .showById(entity.getId())).withSelfRel().getHref());
        commentDTO.setUser(linkTo(methodOn(UserController.class)
                .showById(entity.getCommentator().getId())).withRel("user").getHref());
        commentDTO.setMovie(linkTo(methodOn(MovieController.class)
                .showById(entity.getCommentedMovie().getId())).withRel("movie").getHref());
        return commentDTO;
    }

    public List<Comment> mapToEntityList(List<CommentDTO> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public List<CommentDTO> mapToDTOList(List<Comment> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
