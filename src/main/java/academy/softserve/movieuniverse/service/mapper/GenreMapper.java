package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.GenreController;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.genre.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class GenreMapper implements DTOMapper<GenreDTO, GenreRequest,  Genre> {
    private ModelMapper modelMapper;

    @Autowired
    public GenreMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GenreDTO mapToDTO(Genre genre) {
        GenreDTO genreDTO = modelMapper.map(genre, GenreDTO.class);
        Link selfRelLink = linkTo(GenreController.class).slash(genre.getId()).withSelfRel();
        genreDTO.add(selfRelLink);
        return genreDTO;
    }

    @Override
    public Genre mapToEntity(GenreRequest dto) {
        return modelMapper.map(dto, Genre.class);

    }
}