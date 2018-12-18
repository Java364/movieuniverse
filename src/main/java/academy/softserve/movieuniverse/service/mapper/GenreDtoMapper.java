package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.GenreController;
import academy.softserve.movieuniverse.dto.GenreDTO;
import academy.softserve.movieuniverse.dto.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class GenreDtoMapper implements DtoMapper<GenreDTO, Genre>, DTOEntityRequestMapper<GenreRequest, Genre, Long> {
    private ModelMapper modelMapper;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GenreDTO mapToDTO(Genre genre) {
        GenreDTO genreDto = modelMapper.map(genre, GenreDTO.class);
        Link selfRelLink = linkTo(GenreController.class).slash(genre.getId()).withSelfRel();
        genreDto.add(selfRelLink);
        return genreDto;
    }

    @Override
    public Genre mapToEntity(GenreDTO genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    @Override
    public List<Genre> mapToEntityList(List<GenreDTO> genres) {
        return genres.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<GenreDTO> mapToDtoList(List<Genre> genres) {
        return genres.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public Genre fromEntityCreateRequest(GenreRequest genreCreateDto) {
        Genre genre = new Genre();
        genre.setName(genreCreateDto.getGenreName());
        return genre;
    }

    @Override
    public Genre fromEntityUpdateRequest(GenreRequest genreCreateDto, Long genreId) {
        Genre genre = new Genre();
        genre.setId(genreId);
        genre.setName(genreCreateDto.getGenreName());
        return genre;
    }
}
