package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.entity.Movie;
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
    private GenreDtoMapper genreDtoMapper;

    @Autowired
    private MovieMarkMapper movieMarkMapper;

    @Autowired
    private StarActivityInMoviesService starActivityInMoviesService;

    @Autowired
    private StarService starService;

    public Movie mapToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setMovieName(dto.getMovieName());
        movie.setAgeLimitation(dto.getAgeLimitation());
        movie.setCountries(countryMapper.mapCountriesListToEntity(dto.getCountries()));
        movie.setDuration(dto.getDuration());
        movie.setYear(dto.getYear());
        movie.setDescription(dto.getDescription());
        movie.setGenres(genreDtoMapper.mapToEntityList(dto.getGenres()));
        movie.setMovieMarks(movieMarkMapper.mapMovieMarksListToEntity(dto.getMovieMarks()));
        movie.setRoles(dto.getRoles().stream().map(roleId -> starActivityInMoviesService.getStarActivityInMovies(roleId)).collect(Collectors.toList()));
        movie.setStars(dto.getStars().stream().map(starId -> starService.findStarById(starId)).collect(Collectors.toList()));
        movie.setUserReviews(new ArrayList<>());
        return movie;
    }


    public MovieDTO mapToDto(Movie entity) {
        MovieDTO dto = new MovieDTO();
        dto.setMovieName(entity.getMovieName());
        dto.setAgeLimitation(entity.getAgeLimitation());
        dto.setCountries(countryMapper.mapListToDto(entity.getCountries()));
        dto.setDuration(entity.getDuration());
        dto.setYear(entity.getYear());
        dto.setDescription(entity.getDescription());
        dto.setGenres(genreDtoMapper.mapToDtoList(entity.getGenres()));
        dto.setMovieMarks(movieMarkMapper.mapListToDto(entity.getMovieMarks()));
        dto.setRoles(entity.getRoles().stream().map(role -> role.getId()).collect(Collectors.toList()));
        dto.setStars(entity.getStars().stream().map(star -> star.getId()).collect(Collectors.toList()));
        dto.setUserReviews(entity.getUserReviews().stream().map(review -> review.getId()).collect(Collectors.toList()));
        return dto;
    }

    public List<MovieDTO> mapListToDTO(List<Movie> entities) {
        return entities.stream().map(movie -> mapToDto(movie)).collect(Collectors.toList());
    }

}
