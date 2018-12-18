package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.userreview.UserReviewDTO;
import academy.softserve.movieuniverse.entity.UserReview;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserReviewDtoMapper {
    private ModelMapper modelMapper;

    @Autowired
    public UserReviewDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserReview mapToEntity(UserReviewDTO dto) {
        return modelMapper.map(dto, UserReview.class);
    }

    public UserReviewDTO mapToDto(UserReview entity) {
        return modelMapper.map(entity, UserReviewDTO.class);
    }
}
