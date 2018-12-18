package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.exception.MovieException;
import academy.softserve.movieuniverse.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        if (movie == null) {
            throw MovieException.movieSaveException("Can't save null object", null);
        }
        try {
            movie = movieRepository.save(movie);
        } catch (Exception ex) {
            throw MovieException.movieSaveException("Can't save movie object", ex);
        }
        return movie;
    }

    public List<Movie> showAllMovies() {
        List<Movie> result = new ArrayList<>();
        try {
            result.addAll(movieRepository.findAll());
        } catch (Exception ex) {
            throw MovieException.movieSelectException("Can't get movies", ex);
        }
        return result;
    }

    public Movie findMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw MovieException.movieSelectException("Movie with id:" + id + " not found", null);
        }
        return movie.get();
    }

    public Movie updateMovie(Movie movie, Long id) {
        Movie exist = findMovieById(id);
        try {
            if (isExist(movie.getMovieName()))
                exist.setMovieName(movie.getMovieName());
            if (isExist(movie.getDescription()))
                exist.setDescription(movie.getDescription());
            if (isExist(movie.getAgeLimitation()))
                exist.setAgeLimitation(movie.getAgeLimitation());
            if (movie.getDuration() != null && movie.getDuration() > 0)
                exist.setDuration(movie.getDuration());
            if (movie.getYear() > 1888)
                exist.setYear(movie.getYear());
            if (movie.getGenres() !=null && !movie.getGenres().isEmpty()) {
                exist.setGenres(movie.getGenres());
            }
            exist = movieRepository.save(exist);
        } catch (Exception ex) {
            throw MovieException.movieUpdateException("Can't update movie", ex);
        }
        return  exist;
    }

    public void deleteMovie(Long id) {
        try {
            Movie movie = findMovieById(id);
            movieRepository.delete(movie);
        } catch (Exception ex) {
            throw MovieException.movieDeleteException("Can't delete movie", ex);
        }
    }

    private boolean isExist(String value) {
        if (value == null)
            return false;
        return  !value.trim().isEmpty();
    }

}
