package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.UserReviewDto;
import academy.softserve.movieuniverse.entity.UserReview;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserReviewDtoMapper implements ReversibleDtoMapper<UserReview, UserReviewDto> {
    private ModelMapper modelMapper;

    @Autowired
    public UserReviewDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserReview mapToEntity(UserReviewDto dto) {
        return modelMapper.map(dto, UserReview.class);
    }

    @Override
    public UserReviewDto mapToDto(UserReview entity) {
        return modelMapper.map(entity, UserReviewDto.class);
    }
}
