package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.interfaces.MovieCreateDTO;
import academy.softserve.movieuniverse.dto.interfaces.MovieInfoDTO;
import academy.softserve.movieuniverse.dto.trailer.CreateTrailerInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.TrailerService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;
import academy.softserve.movieuniverse.service.mapper.MovieMapper;
import academy.softserve.movieuniverse.service.mapper.TrailerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    private final MovieMapper movieMapper;
    private final GalleryMapper galleryMapper;
    private final TrailerMapper trailerMapper;
    private final TrailerService trailerService;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper, GalleryMapper galleryMapper, TrailerMapper trailerMapper, TrailerService trailerService) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.galleryMapper = galleryMapper;
        this.trailerMapper = trailerMapper;
        this.trailerService = trailerService;
    }

    @GetMapping("")
    List<MovieDTO> showAllMovies() {
        List<Movie> movies = movieService.showAllMovies();
        return movieMapper.mapListToDTO(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieInfoDTO> showById(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        MovieInfoDTO movieInfoDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieInfoDTO>(movieInfoDTO, HttpStatus.OK);
    }

    @PostMapping("")
    ResponseEntity<MovieCreateDTO> createMovie(@RequestBody MovieCreateDTO movieCreateDTO) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = movieService.saveMovie(movie);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<MovieCreateDTO> updateMovie(@RequestBody MovieCreateDTO movieCreateDTO, @PathVariable Long id) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = movieService.updateMovie(movie, id);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
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

    @GetMapping("/{id}/trailers/")
    public ResponseEntity<List<TrailerDTO>> showMovieTrailers(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(trailerMapper.maptoDTOList(movie.getMediaContent().getTrailers()));
    }

    @PostMapping("/{id}/trailers/")
    public ResponseEntity<TrailerDTO> createMovieTrailer(@PathVariable Long id, @RequestBody CreateTrailerInfo dto) {
        Trailer trailer = trailerMapper.mapToEntity(dto);
        trailer.setMovie(movieService.findMovieById(id));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trailerMapper.mapToDTO(trailerService.save(trailer)));
    }
}