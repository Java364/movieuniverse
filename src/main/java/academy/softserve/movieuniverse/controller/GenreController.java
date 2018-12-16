package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.hateoas.GenreResourceAssembler;
import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.mapper.GenreDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class GenreController {
    private GenreService genreService;
    private GenreDtoMapper genreDtoMapper;

    @Autowired
    public GenreController(GenreService genreService, GenreDtoMapper genreDtoMapper) {
        this.genreService = genreService;
        this.genreDtoMapper = genreDtoMapper;
    }

    @GetMapping(value = "/show/all", produces = "application/hal+json")
    public ResponseEntity<Resources<Resource<GenreDto>>> showAllGenres() {
        final List<Genre> genres = genreService.findAllGenres();
        GenreResourceAssembler genreResourceAssembler = new GenreResourceAssembler(genreDtoMapper);
        List<Resource<GenreDto>> resources = genreResourceAssembler.toResources(genres);
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(resources));
    }

    @GetMapping("/search")
    public ResponseEntity<?> showAllMoviesByGenreName(@RequestParam("genreName") String genreName) {
        // TODO move this endpoint to movie controller
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGenre(@RequestBody GenreDto genreCreateDto) {
        final Genre newGenre = genreDtoMapper.mapGenreCreateDtoToEntity(genreCreateDto);
        genreService.saveGenre(newGenre);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGenre(@PathVariable("id") Long genreId,
                                         @RequestBody GenreDto genreUpdateRequest) {
        Genre updatedGenre = genreDtoMapper.mapGenreUpdateDtoToEntity(genreId, genreUpdateRequest);
        genreService.updateGenre(updatedGenre);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") Long genreId) {
        genreService.deleteGenreById(genreId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
