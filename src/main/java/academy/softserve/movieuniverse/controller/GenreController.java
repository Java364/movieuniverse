package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.genre.GenreRequest;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.mapper.GenreMapper;
import academy.softserve.movieuniverse.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@CrossOrigin
public class GenreController {
    private GenreService genreService;
    private GenreMapper genreMapper;

    @Autowired
    public GenreController(GenreService genreService, GenreMapper genreMapper) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> showAll() {
        List<Genre> genres = genreService.findAll();
        List<GenreDTO> resources = genreMapper.mapToDTOList(genres);
        return ResponseEntity.status(HttpStatus.OK).body(resources);
    }

    @PostMapping
    public ResponseEntity<GenreDTO> create(@RequestBody GenreRequest genreRequest) {
        Genre newGenre = genreMapper.mapToEntity(genreRequest);
        Genre genre = genreService.save(newGenre);
        GenreDTO genreDTO = genreMapper.mapToDTO(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable("id") Long genreId, @RequestBody GenreRequest genreRequest) {
        Genre updatedGenre = genreMapper.mapToEntity(genreRequest);
        Genre genre = genreService.update(genreId, updatedGenre);
        GenreDTO genreDTO = genreMapper.mapToDTO(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long genreId) {
        genreService.deleteById(genreId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
