package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.genre.GenreDto;
import academy.softserve.movieuniverse.dto.genre.GenreEditorDto;
import academy.softserve.movieuniverse.dto.genre.GenreViewDto;
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

    public GenreDto mapGenreEntityToGenreDto(Genre genre) {
        return modelMapper.map(genre, GenreDto.class);
    }

}
