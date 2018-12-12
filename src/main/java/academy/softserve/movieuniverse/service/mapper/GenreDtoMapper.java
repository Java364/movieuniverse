package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreDtoMapper implements ReversibleDtoMapper<Genre, GenreDto> {

    private ModelMapper modelMapper;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Genre mapToEntity(GenreDto genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    @Override
    public GenreDto mapToDto(Genre entity) {
        return modelMapper.map(entity, GenreDto.class);
    }
}
