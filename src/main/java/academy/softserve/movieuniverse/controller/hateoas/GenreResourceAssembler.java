package academy.softserve.movieuniverse.controller.hateoas;

import academy.softserve.movieuniverse.controller.GenreController;
import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.service.mapper.GenreDtoMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class GenreResourceAssembler implements ResourceAssembler<Genre, Resource<GenreDto>> {
    private GenreDtoMapper genreDtoMapper;

    public GenreResourceAssembler(GenreDtoMapper genreDtoMapper) {
        this.genreDtoMapper = genreDtoMapper;
    }

    @Override
    public Resource<GenreDto> toResource(Genre genre) {
        Long genreId = genre.getId();
        String formattedGenreName = genre.getName().toLowerCase();
        Link selfRelLink = linkTo(GenreController.class).slash(genreId).withSelfRel();
        Link searchMoviesRel = linkTo(methodOn(GenreController.class).showAllMoviesByGenreName(formattedGenreName))
                .withRel("search.movies");
        return new Resource<>(genreDtoMapper.mapGenreEntityToGenreDto(genre), selfRelLink, searchMoviesRel);
    }

    public List<Resource<GenreDto>> toResources(List<Genre> genres) {
        return genres.stream().map(this::toResource)
              .collect(Collectors.toList());
    }
}
