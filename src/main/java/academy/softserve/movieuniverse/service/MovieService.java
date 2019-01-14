package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.movie.MovieSearchRequest;
import academy.softserve.movieuniverse.entity.*;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.MovieRepository;
import academy.softserve.movieuniverse.service.specific.MovieSpecific;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;
    private final GalleryService galleryService;
    private final MovieSpecific movieSpecific;

    @Autowired
    public MovieService(MovieRepository movieRepository, GalleryService galleryService, MovieSpecific movieSpecific) {
        this.movieRepository = movieRepository;
        this.galleryService = galleryService;
        this.movieSpecific = movieSpecific;
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
        return movieRepository.findAll();
    }

    public List<Movie> findAll(MovieSearchRequest movieSearchRequest) {
        Specification<Movie> filter = movieSpecific.filter(movieSearchRequest);
        List<Movie> all = movieRepository.findAll(filter);
        // Page<Movie> all = movieRepository.findAll(filter, PageRequest.of(movieSearchRequest.getPage(),
        // movieSearchRequest.getSize(), movieSearchRequest.getDirection(),
        // movieSearchRequest.getSort().getFieldName()));
        return all;
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

    public Set<Country> findCountries(Long movieId) {
        Movie movie = this.findById(movieId);
        return movie.getCountries();
    }

    @Transactional
    public Set<Country> saveCountries(Long movieId, Set<Country> countries) {
        Movie movie = this.findById(movieId);
        movie.getCountries().addAll(countries);
        movieRepository.save(movie);
        return countries;
    }

    public Set<Genre> findGenres(Long movieId) {
        Movie movie = this.findById(movieId);
        return movie.getGenres();
    }

    @Transactional
    public Set<Genre> saveGenres(Long movieId, Set<Genre> genres) {
        Movie movie = this.findById(movieId);
        movie.getGenres().addAll(genres);
        movieRepository.save(movie);
        return genres;
    }

    public List<Star> findCreditsByProfession(Long movieId, String profession) {
        return movieRepository.findCreditsByProfession(movieId, profession);
    }

    @Transactional
    public void saveCast(Long movieId, List<Cast> cast) {
        Movie movie = movieRepository.getOne(movieId);
        cast.forEach(movie::addStarToCast);
    }

    @Transactional
    public void deleteCastById(Long movieId, Long castId) {
        Movie movie = this.findById(movieId);
        Cast cast = movieRepository.findCastById(castId);
        movie.getCast().remove(cast);
    }

    public List<Movie> findAllByName(String name) {
        return movieRepository.findAllByMovieNameIgnoreCaseContaining(name);
    }
}
