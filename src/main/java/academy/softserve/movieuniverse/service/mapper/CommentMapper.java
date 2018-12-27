package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.CommentController;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.dto.userreview.CommentRequest;
import academy.softserve.movieuniverse.entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class CommentMapper implements DTOMapper<CommentDTO, CommentRequest, Comment> {
    private ModelMapper modelMapper;

    @Autowired
    public CommentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Comment mapToEntity(CommentRequest dto) {
        return modelMapper.map(dto, Comment.class);
    }

    @Override
    public CommentDTO mapToDTO(Comment entity) {
        CommentDTO commentDTO = modelMapper.map(entity, CommentDTO.class);
        commentDTO.add(linkTo(CommentController.class).slash(commentDTO.getCommentId()).withSelfRel());
        return commentDTO;
    }
}
