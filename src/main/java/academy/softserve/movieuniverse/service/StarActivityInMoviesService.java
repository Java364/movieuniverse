package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.exception.StarActivityInMoviesException;
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
            throw StarActivityInMoviesException.createSaveException("StarActivityInMovies was not saved", null);
        }
        starActivityInMoviesRepository.save(starActivityInMovies);
    }

    public StarActivityInMovies getStarActivityInMovies(Long id) {
        Optional<StarActivityInMovies> starActivityInMovies = starActivityInMoviesRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw StarActivityInMoviesException.createSelectException("Can't find StarActivityInMovies with ID:" + id,
                    null);
        }
        return starActivityInMovies.get();
    }

    public void deleteStarActivityInMovies(Long id) {
        Optional<StarActivityInMovies> starActivityInMovies = starActivityInMoviesRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw StarActivityInMoviesException.createDeleteException(
                    "Can't delete StarActivityInMovies with ID:" + id + "ID doesn't exist", null);
        }
        starActivityInMoviesRepository.deleteById(id);
    }

    public List<StarActivityInMovies> findAllStarActivityInMovies() {
        return starActivityInMoviesRepository.findAll();
    }
}
