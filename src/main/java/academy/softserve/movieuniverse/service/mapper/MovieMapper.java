package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.service.CastAndCrewService;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class MovieMapper {
    @Autowired
    private CountryMapper      countryMapper;

    @Autowired
    private GenreMapper        genreMapper;

    @Autowired
    private MovieMarkMapper    movieMarkMapper;

    @Autowired
    private CastAndCrewService castAndCrewService;

    @Autowired
    private StarService        starService;

    @Autowired
    private CountryService     countryService;

    @Autowired
    private GenreService       genreService;

    public Movie mapToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setMovieName(dto.getMovieName());
        movie.setAgeLimitation(dto.getAgeLimitation());
        movie.setDuration(dto.getDuration());
        movie.setYear(dto.getYear());
        movie.setDescription(dto.getDescription());
        movie.setComments(new ArrayList<>());
        return movie;
    }



    public MovieDTO mapToDto(Movie entity) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setMovieName(entity.getMovieName());
        dto.setAgeLimitation(entity.getAgeLimitation());
        dto.setDuration(entity.getDuration());
        dto.setYear(entity.getYear());
        dto.setDescription(entity.getDescription());
        dto.setSelf(linkTo(methodOn(MovieController.class).showById(entity.getId())).withSelfRel().getHref());
        dto.setCountries(linkTo(methodOn(MovieController.class).showMovieCountries(entity.getId())).withRel("countries").getHref());
        return dto;
    }

    public List<MovieDTO> mapListToDTO(List<Movie> entities) {
        return entities.stream().map(movie -> mapToDto(movie)).collect(Collectors.toList());
    }

}
