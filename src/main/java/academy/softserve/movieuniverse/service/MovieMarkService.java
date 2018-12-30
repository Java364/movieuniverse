package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.exception.ExceptionType;

import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.MovieMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieMarkService {

    @Autowired
    private MovieMarkRepository movieMarkRepository;

    public List<MovieMark> findAll() {
        return movieMarkRepository.findAll();
    }

    public List<MovieMark> findAllByUser(User user) {
        return movieMarkRepository.findAllByUser(user);
    }

    @Transactional
    public MovieMark create(MovieMark movieMark) {
        if (movieMark == null) {
            throw NotFoundException.createSaveException(ExceptionType.SAVE.getMessage() + " movieMark");
        }
        return movieMarkRepository.save(movieMark);
    }

    @Transactional
    public void delete(Long id) {
        if (id == null || !movieMarkRepository.findById(id).isPresent()) {
            throw NotFoundException.createDeleteException(
                    ExceptionType.DELETE.getMessage() + " movieMark with " + id.toString() + " ID");
        }
        movieMarkRepository.deleteById(id);
    }

    @Transactional
    public MovieMark update(MovieMark movieMark) {
        MovieMark existMovieMark = movieMarkRepository.getOne(movieMark.getId());
        if (movieMark == null || movieMark.getId() == null || existMovieMark == null) {
            throw NotFoundException.createUpdateException(ExceptionType.UPDATE.getMessage() + " movieMark");
        }
        existMovieMark.setMark(movieMark.getMark());
        existMovieMark.setUser(movieMark.getUser());
        existMovieMark.setMovie(movieMark.getMovie());
        movieMark = movieMarkRepository.save(existMovieMark);
        if (movieMark == null) {
            throw NotFoundException.createUpdateException(ExceptionType.UPDATE.getMessage() + " movieMark");
        }
        return movieMark;
    }

    public MovieMark findById(Long id) {
        Optional<MovieMark> movieMarkOptional = movieMarkRepository.findById(id);
        if (id == null || !movieMarkOptional.isPresent()) {
            throw NotFoundException.createSelectException(
                    ExceptionType.SELECT.getMessage() + " movieMark with " + id.toString() + " ID");
        }
        MovieMark movieMark = movieMarkOptional.get();
        return movieMark;
    }

}
