package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;

import academy.softserve.movieuniverse.repository.StarActivityInMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StarActivityInMoviesService {

    private StarActivityInMoviesRepository starActivityInMoviesRepository;

    @Autowired
    public StarActivityInMoviesService(StarActivityInMoviesRepository starActivityInMoviesRepository) {
        this.starActivityInMoviesRepository = starActivityInMoviesRepository;
    }

    public void createStarActivityInMovies(StarActivityInMovies starActivityInMovies) {
        if (starActivityInMovies == null) {
            throw NotFoundException.createSaveException(ExceptionType.SAVE.getMessage() + " StarActivityInMovies");
        }
        starActivityInMoviesRepository.save(starActivityInMovies);
    }

    public StarActivityInMovies getStarActivityInMovies(Long id) {
        Optional<StarActivityInMovies> starActivityInMovies = starActivityInMoviesRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw NotFoundException.createSelectException(ExceptionType.SELECT.getMessage() + "StarActivityInMovies with " + id.toString() + " ID");
        }
        return starActivityInMovies.get();
    }

    public void deleteStarActivityInMovies(Long id) {
        Optional<StarActivityInMovies> starActivityInMovies = starActivityInMoviesRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw NotFoundException.createDeleteException(
                    ExceptionType.DELETE.getMessage() + "StarActivityInMovies with " + id.toString() + " ID");
        }
        starActivityInMoviesRepository.deleteById(id);
    }

    public List<StarActivityInMovies> findAllStarActivityInMovies() {
        return starActivityInMoviesRepository.findAll();
    }
}
