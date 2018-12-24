package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.exception.LocationHeaderCreationException;
import academy.softserve.movieuniverse.controller.util.ControllerHateoasUtil;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.genre.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.mapper.GenreMapper;

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
@CrossOrigin
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class GenreController {
    private GenreService genreService;
    private GenreMapper genreMapper;

    @Autowired
    public GenreController(GenreService genreService, GenreMapper genreMapper) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Resources<GenreDTO>> showAllGenres() {
        List<Genre> genres = genreService.findAllGenres();
        List<GenreDTO> resources = genreMapper.mapToDTOList(genres);
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(resources));
    }

    @PostMapping
    public ResponseEntity<GenreDTO> create(@RequestBody GenreRequest genreRequest)
            throws LocationHeaderCreationException {
        Genre newGenre = genreMapper.mapToEntity(genreRequest);
        Genre genre = genreService.saveGenre(newGenre);
        GenreDTO genreDTO = genreMapper.mapToDTO(genre);
        URI locationHeaderUri = ControllerHateoasUtil.createLocationHeaderUri(genreDTO);
        return ResponseEntity.created(locationHeaderUri).body(genreDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable("id") Long genreId,
                                                @RequestBody GenreRequest genreRequest)
            throws LocationHeaderCreationException {
        Genre updatedGenre = genreMapper.mapToEntity(genreRequest);
        Genre genre = genreService.updateGenre(genreId, updatedGenre);
        GenreDTO genreDTO = genreMapper.mapToDTO(genre);
        URI locationHeaderUri = ControllerHateoasUtil.createLocationHeaderUri(genreDTO);
        return ResponseEntity.created(locationHeaderUri).body(genreDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long genreId) {
        genreService.deleteGenreById(genreId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
