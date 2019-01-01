package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.CastAndCrew;
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

    public void createStarActivityInMovies(CastAndCrew castAndCrew) {
        if (castAndCrew == null) {
            throw new  NotFoundException(ExceptionType.SAVE.getMessage() + " CastAndCrew");
        }
        starActivityInMoviesRepository.save(castAndCrew);
    }

    public CastAndCrew getStarActivityInMovies(Long id) {
        Optional<CastAndCrew> starActivityInMovies = starActivityInMoviesRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw new  NotFoundException(ExceptionType.SELECT.getMessage() + "CastAndCrew with " + id.toString() + " ID");
        }
        return starActivityInMovies.get();
    }

    public void deleteStarActivityInMovies(Long id) {
        Optional<CastAndCrew> starActivityInMovies = starActivityInMoviesRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw new
            NotFoundException(
                    ExceptionType.DELETE.getMessage() + "CastAndCrew with " + id.toString() + " ID");
        }
        starActivityInMoviesRepository.deleteById(id);
    }

    public List<CastAndCrew> findAllStarActivityInMovies() {
        return starActivityInMoviesRepository.findAll();
    }
}
