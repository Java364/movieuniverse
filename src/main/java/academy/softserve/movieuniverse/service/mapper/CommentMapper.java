package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.CommentController;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.dto.userreview.CommentRequest;
import academy.softserve.movieuniverse.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class CommentMapper implements DTOMapper<CommentDTO, CommentRequest, Comment> {
    @Override
    public Comment mapToEntity(CommentRequest dto) {
        Comment comment = new Comment();
        comment.setTitle(dto.getTitle());
        comment.setText(dto.getText());
        return comment;
    }

    @Override
    public CommentDTO mapToDTO(Comment entity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setTitle(entity.getTitle());
        commentDTO.setText(entity.getText());
        commentDTO.add(linkTo(CommentController.class).slash(commentDTO.getCommentId()).withSelfRel());
        return commentDTO;
    }


    @Override
    public List<CommentDTO> mapToDTOList(List<Comment> entities) {
        return  entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


}
