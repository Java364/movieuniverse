package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.CommentController;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class CommentMapper implements DTOMapper<CommentDTO, Comment> {
    private ModelMapper modelMapper;

    @Autowired
    public CommentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <T> Comment mapToEntity(T dto) {
        return modelMapper.map(dto, Comment.class);
    }

    @Override
    public CommentDTO mapToDTO(Comment entity) {
        CommentDTO commentDTO = modelMapper.map(entity, CommentDTO.class);
        commentDTO.add(linkTo(CommentController.class).slash(commentDTO.getCommentId()).withSelfRel());
        return commentDTO;
    }

    public <T> List<Comment> mapToEntityList(List<T> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public List<CommentDTO> mapToDTOList(List<Comment> entities) {
        return  entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
