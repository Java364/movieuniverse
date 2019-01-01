package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.entity.CastAndCrew;
import academy.softserve.movieuniverse.service.CastAndCrewService;
import academy.softserve.movieuniverse.service.mapper.StarActivityInMoviesMapper;
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
        List<CastAndCrew> allStarActivityInMovies = castAndCrewService.findAllStarActivityInMovies();
        List<StarActivityInMoviesDTO> allStarActivityInMoviesDTOs = new ArrayList<>();
        for (CastAndCrew castAndCrew : allStarActivityInMovies) {
            StarActivityInMoviesDTO starActivityInMoviesDTO = starActivityInMoviesMapper.mapToDto(castAndCrew);
            allStarActivityInMoviesDTOs.add(starActivityInMoviesDTO);
        }
        return allStarActivityInMoviesDTOs;
    }

    @GetMapping("/starActivityInMovies/{id}")
    public StarActivityInMoviesDTO getStarActivityInMovies(@PathVariable Long id) {
        CastAndCrew castAndCrew = castAndCrewService.getStarActivityInMovies(id);
        return starActivityInMoviesMapper.mapToDto(castAndCrew);
    }

    @DeleteMapping("/starActivityInMovies")
    public ResponseEntity deleteStarActivity(@RequestParam Long id) {
        castAndCrewService.deleteStarActivityInMovies(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
