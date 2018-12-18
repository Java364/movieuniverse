package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.dto.GenreRequest;
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
import java.net.URISyntaxException;
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
    public ResponseEntity<Resources<GenreDto>> showAllGenres() {
        List<Genre> genres = genreService.findAllGenres();
        List<GenreDto> resources = genreDtoMapper.mapToDtoList(genres);
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(resources));
    }

    @PostMapping("/create")
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreRequest genreCreateDto) throws URISyntaxException {
        Genre newGenre = genreDtoMapper.fromEntityCreateRequest(genreCreateDto);
        Genre genre = genreService.saveGenre(newGenre);
        GenreDto genreDto = genreDtoMapper.mapToDTO(genre);
        return ResponseEntity.created(new URI(genreDto.getId().expand().getHref())).body(genreDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDto> updateGenre(@PathVariable("id") Long genreId, @RequestBody GenreRequest genreRequest)
            throws URISyntaxException {
        Genre updatedGenre = genreDtoMapper.fromEntityUpdateRequest(genreRequest, genreId);
        Genre genre = genreService.updateGenre(updatedGenre);
        GenreDto genreDto = genreDtoMapper.mapToDTO(genre);
        return ResponseEntity.created(new URI(genreDto.getId().expand().getHref())).body(genreDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") Long genreId) {
        genreService.deleteGenreById(genreId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
