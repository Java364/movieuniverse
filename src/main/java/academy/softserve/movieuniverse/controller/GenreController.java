package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.genre.GenreDto;
import academy.softserve.movieuniverse.dto.genre.GenreEditorDto;
import academy.softserve.movieuniverse.dto.genre.GenreViewDto;
import academy.softserve.movieuniverse.repository.GenreRepository;
import academy.softserve.movieuniverse.service.GenreService;
import academy.softserve.movieuniverse.service.mapper.GenreDtoMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/one")
    public ResponseEntity<GenreDto> createGenre() {
        @JsonIgnore;
        return new ResponseEntity<>(new GenreDto(), HttpStatus.OK);
    }
}
