package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.repository.StarActivityInMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarActivityInMoviesService {

    private StarActivityInMoviesRepository starActivityInMoviesRepository;

    @Autowired
    public void createStarActivityInMovies(StarActivityInMovies starActivityInMovies) {
        starActivityInMoviesRepository.save(starActivityInMovies);
    }

    public StarActivityInMovies getStarActivityInMoviesById(Long id) {
        return starActivityInMoviesRepository.getOne(id);
    }

    public void completelyDelete (Long id) {
        starActivityInMoviesRepository.deleteById(id);
    }

    public List<StarActivityInMovies> findAllStarActivityInMovies() {
        return starActivityInMoviesRepository.findAll();
    }
}
