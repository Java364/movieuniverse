package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.dto.comment.CommentDTO;
import academy.softserve.movieuniverse.dto.comment.CommentRequest;
import academy.softserve.movieuniverse.dto.interfaces.MovieCreateDTO;
import academy.softserve.movieuniverse.dto.interfaces.MovieInfoDTO;
import academy.softserve.movieuniverse.entity.Comment;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.service.CommentService;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.UserService;
import academy.softserve.movieuniverse.service.mapper.CommentMapper;
import academy.softserve.movieuniverse.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    List<MovieDTO> showAllMovies() {
        List<Movie> movies = service.showAllMovies();
        return movieMapper.mapListToDTO(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieInfoDTO> showById(@PathVariable Long id) {
        Movie movie = service.findMovieById(id);
        MovieInfoDTO movieInfoDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieInfoDTO>(movieInfoDTO, HttpStatus.OK);
    }

    @PostMapping("")
    ResponseEntity<MovieCreateDTO> createMovie(@RequestBody MovieCreateDTO movieCreateDTO) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = service.saveMovie(movie);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<MovieCreateDTO> updateMovie(@RequestBody MovieCreateDTO movieCreateDTO, @PathVariable Long id) {
        Movie movie = movieMapper.mapToEntity((MovieDTO) movieCreateDTO);
        movie = service.updateMovie(movie, id);
        movieCreateDTO = movieMapper.mapToDto(movie);
        return new ResponseEntity<MovieCreateDTO>(movieCreateDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentDTO>> showComments(@PathVariable Long id) {
        Movie movie = service.findMovieById(id);
        List<CommentDTO> dtos = commentMapper.mapToDTOList(movie.getComments());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long id, @RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.mapToEntity(commentRequest);
        comment.setCommentedMovie(service.findMovieById(id));
        comment.setCommentator(userService.findById(1L));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentMapper.mapToDTO(
                        commentService.save(comment)
                )

        );
    }
}