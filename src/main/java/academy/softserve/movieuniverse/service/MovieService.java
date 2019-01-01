package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.*;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final GalleryService galleryService;

    @Autowired
    public MovieService(MovieRepository movieRepository, GalleryService galleryService) {
        this.movieRepository = movieRepository;
        this.galleryService = galleryService;
    }

    public Movie create(Movie movie) {
        if (movie == null) {
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " movie");
        }
        movie = movieRepository.save(movie);
        return movie;
    }

    public Movie saveMovie(Movie movie) {
        if (movie == null) {
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " movie");
        }
        try {
            movie = movieRepository.save(movie);
        } catch (Exception ex) {
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " movie");
        }
        return movie;
    }

    public List<Movie> showAllMovies() {
        List<Movie> result = new ArrayList<>();
        try {
            result.addAll(movieRepository.findAll());
        } catch (Exception ex) {
            throw new NotFoundException(ExceptionType.SELECT.getMessage());
        }
        return result;
    }

    public Movie findMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new NotFoundException(ExceptionType.SELECT.getMessage() + "movie with " + id.toString() + " ID");
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
            if (movie.getGenres() != null && !movie.getGenres().isEmpty()) {
                exist.setGenres(movie.getGenres());
            }
            if (movie.getCountries() != null && !movie.getCountries().isEmpty()) {
                exist.setCountries(movie.getCountries());
            }
            exist = movieRepository.save(exist);
        } catch (Exception ex) {
            throw new NotFoundException(ExceptionType.UPDATE.getMessage() + " movie");
        }
        return exist;
    }

    public void deleteMovie(Long id) {
        try {
            Movie movie = findMovieById(id);
            movieRepository.delete(movie);
        } catch (Exception ex) {
            throw new NotFoundException(ExceptionType.DELETE.getMessage() + "movie with " + id.toString() + " ID");
        }
    }

    private boolean isExist(String value) {
        if (value == null)
            return false;
        return !value.trim().isEmpty();
    }

    public Movie findAllByMovieMarks(MovieMark movieMark) {
        return movieRepository.findAllByMovieMarks(movieMark);
    }

    public Gallery addNewGallery(Long id) {
        Movie movie = findMovieById(id);
        Gallery gallery = galleryService.save();
        movie.getMediaContent().setGallery(gallery);
        updateMovie(movie, id);
        return gallery;
    }

    public List<Country> saveCountries(Long movieId, List<Country> countries) {
        Movie movie = this.findMovieById(movieId);
        movie.setCountries(countries);
        movieRepository.save(movie);
        return countries;
    }

    public List<Genre> saveGenres(Long movieId, List<Genre> genres) {
        Movie movie = this.findMovieById(movieId);
        movie.setGenres(genres);
        movieRepository.save(movie);
        return genres;
    }

    public List<Star> findCreditsByProfession(Long movieId, String profession) {
        return movieRepository.findCreditsByProfession(movieId, profession);
    }
}
