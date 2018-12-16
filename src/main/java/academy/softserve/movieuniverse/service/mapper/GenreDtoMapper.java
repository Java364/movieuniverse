package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.hateoas.GenreResourceAssembler;
import academy.softserve.movieuniverse.dto.genre.GenreCreateDto;
import academy.softserve.movieuniverse.dto.genre.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreDtoMapper {
    private ModelMapper modelMapper;
    private GenreResourceAssembler genreResourceAssembler;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper, GenreResourceAssembler genreResourceAssembler) {
        this.modelMapper = modelMapper;
        this.genreResourceAssembler = genreResourceAssembler;
    }

    public GenreDto mapGenreEntityToGenreDto(Genre genre) {
        return modelMapper.map(genre, GenreDto.class);
    }

    public Genre mapGenreCreateDtoToEntity(GenreCreateDto genreCreateDto) {
        Genre genre = new Genre();
        genre.setName(genreCreateDto.getGenreName());
        return genre;
    }

    public Genre mapGenreUpdateDtoToEntity(Long genreId, GenreCreateDto genreCreateDto) {
        Genre genre = new Genre();
        genre.setId(genreId);
        genre.setName(genreCreateDto.getGenreName());
        return genre;
    }

    public List<Resource<GenreDto>> mapEntitiesToGenreDtoList(List<Genre> genres) {
        return genres.stream().map(genreResourceAssembler::toResource)
                     .collect(Collectors.toList());
    }
}
