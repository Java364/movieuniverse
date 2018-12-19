package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.GenreController;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class GenreDtoMapper implements DtoMapper<Genre> {
    private ModelMapper modelMapper;

    @Autowired
    public GenreDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <D> D mapToDTO(Genre genre) {
        GenreDTO genreDto = modelMapper.map(genre, GenreDTO.class);
        Link selfRelLink = linkTo(GenreController.class).slash(genre.getId()).withSelfRel();
        return (D) genreDto;
    }

    @Override
    public <D> Genre mapToEntity(D genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    @Override
    public <D> List<Genre> mapToEntityList(List<? extends D> genres) {
        return genres.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public <D> List<D> mapToDtoList(List<Genre> genres) {
        return (List<D>) genres.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
