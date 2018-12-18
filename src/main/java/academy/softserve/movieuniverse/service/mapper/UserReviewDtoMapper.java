package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.userreview.UserReviewDTO;
import academy.softserve.movieuniverse.entity.UserReview;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserReviewDtoMapper implements DtoMapper<UserReview> {
    private ModelMapper modelMapper;

    @Autowired
    public UserReviewDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <D> UserReview mapToEntity(D dto) {
        return modelMapper.map(dto, UserReview.class);
    }

    @Override
    public <D> D mapToDTO(UserReview entity) {
        UserReviewDTO userReviewDTO = new UserReviewDTO();
        modelMapper.map(entity, userReviewDTO);
        return (D) userReviewDTO;
    }

    public <D> List<UserReview> mapToEntityList(List<? extends D> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public <D> List<D> mapToDtoList(List<UserReview> entities) {
        return (List<D>) entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
