package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public Genre mapGenreDtoToEntity(GenreDto genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    public Genre mapGenreCreateDtoToEntity(GenreDto genreCreateDto) {
        Genre genre = new Genre();
        genre.setName(genreCreateDto.getGenreName());
        return genre;
    }

    public Genre mapGenreUpdateDtoToEntity(Long genreId, GenreDto genreCreateDto) {
        Genre genre = new Genre();
        genre.setId(genreId);
        genre.setName(genreCreateDto.getGenreName());
        return genre;
    }

    public List<Genre> mapGenreDtosToEntities(List<GenreDto> genres) {
        return genres.stream().map(this::mapGenreDtoToEntity).collect(Collectors.toList());
    }

    public List<GenreDto> mapGenresToGenreDtoList(List<Genre> genres) {
        return genres.stream().map(this::mapGenreEntityToGenreDto).collect(Collectors.toList());
    }
}
