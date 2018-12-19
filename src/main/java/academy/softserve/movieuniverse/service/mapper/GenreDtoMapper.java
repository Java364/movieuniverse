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
public class GenreDtoMapper implements DtoMapper<GenreDTO, Genre> {
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
    public <T> Genre mapToEntity(T genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }

    @Override
    public <T> List<Genre> mapToEntityList(List<T> genres) {
        return genres.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<GenreDTO> mapToDtoList(List<Genre> genres) {
        return genres.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
