package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.StarActivityInMoviesService;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieMapper {
    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private MovieMarkMapper movieMarkMapper;

    @Autowired
    private StarActivityInMoviesService starActivityInMoviesService;

    @Autowired
    private StarService starService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private GenreService genreService;

    public Movie mapToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setMovieName(dto.getMovieName());
        movie.setAgeLimitation(dto.getAgeLimitation());
        movie.setCountries(dto.getCountries().stream().map((countryId -> countryService.findById(countryId))).collect(Collectors.toList()));
        movie.setDuration(dto.getDuration());
        movie.setYear(dto.getYear());
        movie.setDescription(dto.getDescription());
        movie.setGenres(dto.getGenres().stream().map(genreId -> genreService.findById(genreId)).collect(Collectors.toList()));
        movie.setMovieMarks(movieMarkMapper.mapMovieMarksListToEntity(dto.getMovieMarks()));
        movie.setRoles(dto.getRoles().stream().map(roleId -> starActivityInMoviesService.getStarActivityInMovies(roleId)).collect(Collectors.toList()));
        movie.setStars(dto.getStars().stream().map(starId -> starService.findById(starId)).collect(Collectors.toList()));
        movie.setComments(new ArrayList<>());
        return movie;
    }


    public MovieDTO mapToDto(Movie entity) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setMovieName(entity.getMovieName());
        dto.setAgeLimitation(entity.getAgeLimitation());
        dto.setCountries(entity.getCountries().stream().map(country -> country.getId()).collect(Collectors.toList()));
        dto.setDuration(entity.getDuration());
        dto.setYear(entity.getYear());
        dto.setDescription(entity.getDescription());
        dto.setGenres(entity.getGenres().stream().map(genre -> genre.getId()).collect(Collectors.toList()));
        dto.setMovieMarks(movieMarkMapper.mapListToDto(entity.getMovieMarks()));
        dto.setRoles(entity.getRoles().stream().map(role -> role.getId()).collect(Collectors.toList()));
        dto.setStars(entity.getStars().stream().map(star -> star.getId()).collect(Collectors.toList()));
        dto.setComments(entity.getComments().stream().map(review -> review.getId()).collect(Collectors.toList()));
        return dto;
    }

    public List<MovieDTO> mapListToDTO(List<Movie> entities) {
        return entities.stream().map(movie -> mapToDto(movie)).collect(Collectors.toList());
    }

}
