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
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;
    private final GalleryService galleryService;

    @Autowired
    public MovieService(MovieRepository movieRepository, GalleryService galleryService) {
        this.movieRepository = movieRepository;
        this.galleryService = galleryService;
    }

    @Transactional
    public Movie save(Movie movie) {
        if (movie == null) {
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " movie");
        }
        movie = movieRepository.save(movie);
        return movie;
    }

    public List<Movie> findAll() {
        List<Movie> result = new ArrayList<>();
        try {
            result.addAll(movieRepository.findAll());
        } catch (Exception ex) {
            throw new NotFoundException(ExceptionType.SELECT.getMessage());
        }
        return result;
    }

    public Movie findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new NotFoundException(ExceptionType.SELECT.getMessage() + "movie with " + id.toString() + " ID");
        }
        return movie.get();
    }

    @Transactional
    public Movie update(Movie movie, Long id) {
        Movie exist = findById(id);
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

    @Transactional
    public void delete(Long id) {
        try {
            Movie movie = findById(id);
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

    @Transactional
    public Gallery addNewGallery(Long id) {
        Movie movie = findById(id);
        Gallery gallery = galleryService.save();
        movie.getMediaContent().setGallery(gallery);
        update(movie, id);
        return gallery;
    }

    public List<Comment> findComments(Long movieId) {
        Movie movie = this.findById(movieId);
        return movie.getComments();
    }

    public List<Country> findCountries(Long movieId) {
        Movie movie = this.findById(movieId);
        return movie.getCountries();
    }

    @Transactional
    public List<Country> saveCountries(Long movieId, List<Country> countries) {
        Movie movie = this.findById(movieId);
        movie.setCountries(countries);
        movieRepository.save(movie);
        return countries;
    }

    public List<Genre> findGenres(Long movieId) {
        Movie movie = this.findById(movieId);
        return movie.getGenres();
    }

    @Transactional
    public List<Genre> saveGenres(Long movieId, List<Genre> genres) {
        Movie movie = this.findById(movieId);
        movie.setGenres(genres);
        movieRepository.save(movie);
        return genres;
    }

    public List<Star> findCreditsByProfession(Long movieId, String profession) {
        return movieRepository.findCreditsByProfession(movieId, profession);
    }

    public List<Movie> findAllByName(String name) {
        return movieRepository.findAllByMovieNameIgnoreCaseContaining(name);
    }
}
