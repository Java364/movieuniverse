package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.entity.Crew;
import academy.softserve.movieuniverse.mapper.StarActivityInMoviesMapper;
import academy.softserve.movieuniverse.service.CastAndCrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StarActivityInMoviesController {

    private CastAndCrewService castAndCrewService;
    private StarActivityInMoviesMapper starActivityInMoviesMapper;

    @Autowired
    public StarActivityInMoviesController(CastAndCrewService castAndCrewService,
            StarActivityInMoviesMapper starActivityInMoviesMapper) {
        this.castAndCrewService = castAndCrewService;
        this.starActivityInMoviesMapper = starActivityInMoviesMapper;
    }

    @GetMapping("/starActivityInMovies")
    public List<StarActivityInMoviesDTO> viewAll() {
        List<Crew> allStarActivityInMovies = castAndCrewService.findAllStarActivityInMovies();
        List<StarActivityInMoviesDTO> allStarActivityInMoviesDTOs = new ArrayList<>();
        for (Crew crew : allStarActivityInMovies) {
            StarActivityInMoviesDTO starActivityInMoviesDTO = starActivityInMoviesMapper.mapToDto(crew);
            allStarActivityInMoviesDTOs.add(starActivityInMoviesDTO);
        }
        return allStarActivityInMoviesDTOs;
    }

    @GetMapping("/starActivityInMovies/{id}")
    public StarActivityInMoviesDTO getStarActivityInMovies(@PathVariable Long id) {
        Crew crew = castAndCrewService.getStarActivityInMovies(id);
        return starActivityInMoviesMapper.mapToDto(crew);
    }

    @DeleteMapping("/starActivityInMovies")
    public ResponseEntity deleteStarActivity(@RequestParam Long id) {
        castAndCrewService.deleteStarActivityInMovies(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
