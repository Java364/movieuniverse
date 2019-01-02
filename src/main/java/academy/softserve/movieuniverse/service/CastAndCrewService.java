package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.CastAndCrew;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.CastAndCrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastAndCrewService {

    private CastAndCrewRepository castAndCrewRepository;

    @Autowired
    public CastAndCrewService(CastAndCrewRepository castAndCrewRepository) {
        this.castAndCrewRepository = castAndCrewRepository;
    }

    public void createStarActivityInMovies(CastAndCrew castAndCrew) {
        if (castAndCrew == null) {
            throw new NotFoundException(ExceptionType.SAVE.getMessage() + " CastAndCrewDTO");
        }
        castAndCrewRepository.save(castAndCrew);
    }

    public CastAndCrew getStarActivityInMovies(Long id) {
        Optional<CastAndCrew> starActivityInMovies = castAndCrewRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw new NotFoundException(
                    ExceptionType.SELECT.getMessage() + "CastAndCrewDTO with " + id.toString() + " ID");
        }
        return starActivityInMovies.get();
    }

    public void deleteStarActivityInMovies(Long id) {
        Optional<CastAndCrew> starActivityInMovies = castAndCrewRepository.findById(id);
        if (!starActivityInMovies.isPresent()) {
            throw new NotFoundException(
                    ExceptionType.DELETE.getMessage() + "CastAndCrewDTO with " + id.toString() + " ID");
        }
        castAndCrewRepository.deleteById(id);
    }

    public List<CastAndCrew> findAllStarActivityInMovies() {
        return castAndCrewRepository.findAll();
    }
}
