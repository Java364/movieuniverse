package academy.softserve.movieuniverse.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.controller.PosterController;
import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.service.MovieService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PosterMapper {
    @Autowired
    MovieService movieService;

    public Poster mapToEntityForSave(PosterDTO dto) {
        Poster poster = new Poster();
        poster.setImageUrl(dto.getImageUrl());
        poster.setIsRemoved(new Boolean(false));
        poster.setName(dto.getName());
        poster.setMovie(movieService.findMovieById(dto.getMovieId()));
        return poster;
    }

    public Poster mapToEntityForUpdate(PosterDTO dto, Long posterId) {
        Poster poster = new Poster();
        poster.setImageUrl(dto.getImageUrl());
        poster.setIsRemoved(new Boolean(false));
        poster.setId(posterId);
        poster.setName(dto.getName());
        poster.setMovie(movieService.findMovieById(dto.getMovieId()));
        return poster;
    }

    public PosterDTO mapToDTO(Poster poster) {
        PosterDTO dto = new PosterDTO();
        dto.setId(poster.getId());
        dto.setName(poster.getName());
        dto.setImageUrl(poster.getImageUrl());
        dto.setMovieId(poster.getMovie().getId());
        dto.setSelf(linkTo(methodOn(PosterController.class).showById(poster.getId())).withSelfRel().getHref());
        dto.setMovie(
                linkTo(methodOn(MovieController.class).showById(poster.getMovie().getId())).withRel("movie").getHref());
        return dto;
    }
}
