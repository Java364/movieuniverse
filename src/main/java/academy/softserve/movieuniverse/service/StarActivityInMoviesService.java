package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.repository.StarActivityInMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StarActivityInMoviesService {

    @Autowired
    private StarActivityInMoviesRepository starActivityInMoviesRepository;

    public void createStarActivityInMovies(StarActivityInMovies starActivityInMovies) {
        starActivityInMoviesRepository.save(starActivityInMovies);
    }

    public StarActivityInMovies getStarActivityInMovies(Long id) {
        return starActivityInMoviesRepository.getOne(id);
    }

    public void delete (Long id) {
        starActivityInMoviesRepository.deleteById(id);
    }

    public List<StarActivityInMovies> findAllStarActivityInMovies() {
        return starActivityInMoviesRepository.findAll();
    }
}
