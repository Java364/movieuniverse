package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.exception.LocationHeaderCreationException;
import academy.softserve.movieuniverse.controller.util.ControllerHateoasUtil;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.genre.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.mapper.GenreDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping(value = "/show/all")
    public ResponseEntity<Resources<GenreDTO>> showAllGenres() {
        List<Genre> genres = genreService.findAllGenres();
        List<GenreDTO> resources = genreDtoMapper.mapToDtoList(genres);
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(resources));
    }

    @PostMapping("/create")
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreRequest genreRequest)
            throws LocationHeaderCreationException {
        Genre newGenre = genreDtoMapper.mapToEntity(genreRequest);
        Genre genre = genreService.saveGenre(newGenre);
        GenreDTO genreDto = genreDtoMapper.mapToDTO(genre);
        URI locationHeaderUri = ControllerHateoasUtil.createLocationHeaderUri(genreDto);
        return ResponseEntity.created(locationHeaderUri).body(genreDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable("id") Long genreId,
                                                @RequestBody GenreRequest genreRequest)
            throws LocationHeaderCreationException {
        Genre updatedGenre = genreDtoMapper.mapToEntity(genreRequest);
        Genre genre = genreService.updateGenre(genreId, updatedGenre);
        GenreDTO genreDto = genreDtoMapper.mapToDTO(genre);
        URI locationHeaderUri = ControllerHateoasUtil.createLocationHeaderUri(genreDto);
        return ResponseEntity.created(locationHeaderUri).body(genreDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") Long genreId) {
        genreService.deleteGenreById(genreId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
