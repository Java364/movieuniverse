package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.dto.movie.MovieSearchShortInfo;
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
    private final CountryMapper countryMapper;

    private final GenreMapper genreMapper;

    private final MovieMarkMapper movieMarkMapper;

    private final CastAndCrewService castAndCrewService;

    private final StarService starService;

    private final CountryService countryService;

    private final GenreService genreService;

    @Autowired
    public MovieMapper(CountryMapper countryMapper, GenreMapper genreMapper, MovieMarkMapper movieMarkMapper,
            CastAndCrewService castAndCrewService, StarService starService, CountryService countryService,
            GenreService genreService) {
        this.countryMapper = countryMapper;
        this.genreMapper = genreMapper;
        this.movieMarkMapper = movieMarkMapper;
        this.castAndCrewService = castAndCrewService;
        this.starService = starService;
        this.countryService = countryService;
        this.genreService = genreService;
    }

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
        dto.setCountries(linkTo(methodOn(MovieController.class).showMovieCountries(entity.getId())).withRel("countries")
                .getHref());
        return dto;
    }

    public MovieSearchShortInfo mapEntityToMovieSearchShortInfo(Movie movieEntity) {
        MovieSearchShortInfo movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setMovieName(movieEntity.getMovieName());
        movieDTO.setYear(movieEntity.getYear());
        movieDTO.setSelf(linkTo(methodOn(MovieController.class).showById(movieEntity.getId())).withSelfRel().getHref());
        return movieDTO;
    }

    public List<MovieSearchShortInfo> mapListToMovieSearchShortInfoList(List<Movie> movieEntities) {
        return movieEntities.stream().map(this::mapEntityToMovieSearchShortInfo).collect(Collectors.toList());
    }

    public List<MovieDTO> mapListToDTO(List<Movie> entities) {
        return entities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

}