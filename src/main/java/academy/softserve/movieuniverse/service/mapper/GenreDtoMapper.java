package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreDtoMapper {

    private ModelMapper modelMapper;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Genre mapGenreToEntity(GenreDto genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    public GenreDto mapGenreToDto(Genre entity) {
        return modelMapper.map(entity, GenreDto.class);
    }
}
