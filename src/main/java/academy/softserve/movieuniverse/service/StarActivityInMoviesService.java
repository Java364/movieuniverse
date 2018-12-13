package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.repository.StarActivityInMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarActivityInMoviesService {

    private StarActivityInMoviesRepository starActivityInMoviesRepository;

    @Autowired
    public StarActivityInMoviesService(StarActivityInMoviesRepository starActivityInMoviesRepository) {
        this.starActivityInMoviesRepository = starActivityInMoviesRepository;
    }

    public void createStarActivityInMovies(StarActivityInMovies starActivityInMovies) {
        starActivityInMoviesRepository.save(starActivityInMovies);
    }

    public StarActivityInMovies getStarActivityInMovies(Long id) {
        return starActivityInMoviesRepository.getOne(id);
    }

    public void deleteStarActivityInMovies(Long id) {
        starActivityInMoviesRepository.deleteById(id);
    }

    public List<StarActivityInMovies> findAllStarActivityInMovies() {
        return starActivityInMoviesRepository.findAll();
    }

}
