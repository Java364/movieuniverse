package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.genre.GenreCreateDto;
import academy.softserve.movieuniverse.dto.genre.GenreDto;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.repository.GenreRepository;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.mapper.GenreDtoMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    private GenreService genreService;
    private GenreDtoMapper genreDtoMapper;

    @Autowired
    public GenreController(GenreService genreService, GenreDtoMapper genreDtoMapper) {
        this.genreService = genreService;
        this.genreDtoMapper = genreDtoMapper;
    }

    @GetMapping("/show/all")
    public ResponseEntity<List<GenreDto>> showAllGenres() {
        final List<Genre> allGenres = genreService.findAllGenres();
        final List<GenreDto> genresResponse = genreDtoMapper.mapEntitiesToGenreDtoList(allGenres);
        return ResponseEntity.status(HttpStatus.OK).body(genresResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGenre(@RequestBody GenreCreateDto genreCreateDto) {
        final Genre newGenre = genreDtoMapper.mapGenreCreateDtoToEntity(genreCreateDto);
        genreService.saveGenre(newGenre);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGenre(@PathVariable("id") Long genreId,
                                         @RequestBody GenreCreateDto genreUpdateRequest) {
        Genre updatedGenre = genreDtoMapper.mapGenreUpdateDtoToEntity(genreId, genreUpdateRequest);
        genreService.updateGenre(updatedGenre);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
