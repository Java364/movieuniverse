package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.UserReviewController;
import academy.softserve.movieuniverse.dto.userreview.UserReviewDTO;
import academy.softserve.movieuniverse.entity.UserReview;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class UserReviewDtoMapper implements DtoMapper<UserReviewDTO, UserReview> {
    private ModelMapper modelMapper;

    @Autowired
    public UserReviewDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <T> UserReview mapToEntity(T dto) {
        return modelMapper.map(dto, UserReview.class);
    }

    @Override
    public UserReviewDTO mapToDTO(UserReview entity) {
        UserReviewDTO userReviewDTO = modelMapper.map(entity, UserReviewDTO.class);
        userReviewDTO.add(linkTo(UserReviewController.class).slash(userReviewDTO.getUserReviewId()).withSelfRel());
        return userReviewDTO;
    }

    public <T> List<UserReview> mapToEntityList(List<T> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public List<UserReviewDTO> mapToDtoList(List<UserReview> entities) {
        return  entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
