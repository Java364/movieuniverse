package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.controller.exception.LocationHeaderCreationException;
import academy.softserve.movieuniverse.controller.util.ControllerHateoasUtil;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.movie.MovieCreateDTO;
import academy.softserve.movieuniverse.dto.movie.MovieInfoDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;
import academy.softserve.movieuniverse.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/movie", produces = "application/hal+json")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final GalleryMapper galleryMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper, GalleryMapper galleryMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.galleryMapper = galleryMapper;
    }

    @GetMapping("")
    public List<MovieDTO> showAllMovies() {
        List<Movie> movies = movieService.showAllMovies();
        return movieMapper.mapListToDTO(movies);

    }

    @GetMapping(value = "/all")
    public ResponseEntity<Resources<MovieDTO>> showAllGenres() {
        List<Movie> movies = movieService.showAllMovies();
        List<MovieDTO> resources = movieMapper.mapListToDTO(movies);
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(resources));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieInfoDTO> showOneMovie(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        MovieInfoDTO movieInfoDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieInfoDTO>(movieInfoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) throws LocationHeaderCreationException {

        return ResponseEntity.status(HttpStatus.CREATED).body(movieMapper.mapToDto(
                        movieService.create(
                                movieMapper.mapToEntity(movieDTO)
                        )
                ));


    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieCreateDTO> updateMovie(@RequestBody MovieCreateDTO movieCreateDTO, @PathVariable Long id) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = movieService.updateMovie(movie, id);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}/gallery")
    public ResponseEntity<GalleryDTO> showMovieGallery(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(galleryMapper.mapToDTO(movie.getMediaContent().getGallery()));
    }

    @PostMapping("/{id}/gallery")
    public ResponseEntity<GalleryDTO> createMovieGallery(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(galleryMapper.mapToDTO(movieService.addNewGallery(id)));
    }

//    @GetMapping("/{id}/trailers/")
//    public ResponseEntity<GalleryDTO> showMovieTrailers(@PathVariable Long id) {
//        Movie movie = movieService.findMovieById(id);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(galleryMapper.mapToDTO(movie.getMediaContent().getGallery()));
//    }
//
//    @PostMapping("/{id}/trailers/")
//    public ResponseEntity<GalleryDTO> createMovieTrailer(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(galleryMapper.mapToDTO(movieService.addNewGallery(id)));
//    }
}