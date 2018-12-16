package academy.softserve.movieuniverse.controller.hateoas;

import academy.softserve.movieuniverse.controller.GenreController;
import academy.softserve.movieuniverse.dto.genre.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.service.mapper.GenreDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class GenreResourceAssembler implements ResourceAssembler<Genre, Resource<GenreDto>> {
    private GenreDtoMapper genreDtoMapper;

    @Autowired
    public GenreResourceAssembler(GenreDtoMapper genreDtoMapper) {
        this.genreDtoMapper = genreDtoMapper;
    }

    @Override
    public Resource<GenreDto> toResource(Genre genre) {
        Long genreId = genre.getId();
        Link selfRelLink = linkTo(GenreController.class).slash(genreId).withSelfRel();
        String formattedGenreName = genre.getName().toLowerCase();
        Link searchMoviesRel = linkTo(methodOn(GenreController.class).showAllMoviesByGenreName(formattedGenreName))
                .withRel("search.movies");
        return new Resource<>(genreDtoMapper.mapGenreEntityToGenreDto(genre), selfRelLink, searchMoviesRel);
    }
}
