package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.service.StarActivityInMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarActivityInMoviesController {

    private StarActivityInMoviesService starActivityInMoviesService;

    @Autowired
    public StarActivityInMoviesController(StarActivityInMoviesService starActivityInMoviesService) {
        this.starActivityInMoviesService = starActivityInMoviesService;
    }

    @GetMapping("/api/star-activity-in-movies")
    public List<StarActivityInMovies> viewAll() {
        return starActivityInMoviesService.findAllStarActivityInMovies();
    }

    @GetMapping("/api/star-activity-in-movies/{id}")
    public StarActivityInMovies getStarActivityInMovies(@PathVariable Long id) {
        return starActivityInMoviesService.getStarActivityInMoviesById(id);
    }

    @DeleteMapping
    public ResponseEntity completeDeleteResponseEntity(@PathVariable Long id) {
        starActivityInMoviesService.completelyDelete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
