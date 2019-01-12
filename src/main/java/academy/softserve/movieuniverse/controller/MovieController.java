package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.dto.country.CountryDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.dto.movie.MovieSearchRequest;
import academy.softserve.movieuniverse.dto.movie.MovieSearchShortInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.entity.*;
import academy.softserve.movieuniverse.mapper.*;
import academy.softserve.movieuniverse.service.MovieMarkService;
import academy.softserve.movieuniverse.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    private final MovieMapper movieMapper;
    private final GalleryMapper galleryMapper;
    private final TrailerMapper trailerMapper;
    private final CommentMapper commentMapper;
    private final MovieMarkService movieMarkService;
    private final PosterMapper posterMapper;

    @Autowired
    public MovieController(PosterMapper posterMapper, MovieService movieService, MovieMapper movieMapper,
            GalleryMapper galleryMapper, TrailerMapper trailerMapper, CommentMapper commentMapper,
            MovieMarkService movieMarkService) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.galleryMapper = galleryMapper;
        this.trailerMapper = trailerMapper;
        this.commentMapper = commentMapper;
        this.movieMarkService = movieMarkService;
        this.posterMapper = posterMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll() {
        List<Movie> movies = movieService.findAll();
        List<MovieDTO> movieDTOS = movieMapper.mapListToDTO(movies);
        return ResponseEntity.status(HttpStatus.OK).body(movieDTOS);
    }

    @GetMapping("/search")
    public List<MovieSearchShortInfo> showAll(MovieSearchRequest movieSearchRequest) {
        List<Movie> all = movieService.findAll(movieSearchRequest);
        List<MovieSearchShortInfo> movieSearchShortInfos = movieMapper.mapListToMovieSearchShortInfoList(all);
        return movieSearchShortInfos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> showById(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(movieMapper.mapToDto(movie));
    }

    @GetMapping("/mark/{id}")
    public MovieDTO showByMovieMark(@PathVariable Long id) {
        MovieMark movieMark = movieMarkService.findById(id);
        return movieMapper.mapToDto(movieService.findAllByMovieMarks(movieMark));
    }

    @GetMapping("/{id}/gallery")
    public ResponseEntity<GalleryDTO> showMovieGallery(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(galleryMapper.mapToDTO(movie.getMediaContent().getGallery()));
    }

    @GetMapping("/{id}/trailers/")
    public ResponseEntity<List<TrailerDTO>> showMovieTrailers(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(trailerMapper.maptoDTOList(movie.getMediaContent().getTrailers()));
    }

    @GetMapping("/{id}/poster")
    public ResponseEntity<PosterDTO> showMoviePoster(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(posterMapper.mapToDTO(movie.getMediaContent().getPoster()));
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentDTO>> showComments(@PathVariable Long id) {
        List<Comment> foundComments = movieService.findComments(id);
        List<CommentDTO> commentDTOS = commentMapper.mapToDTOList(foundComments);
        return ResponseEntity.status(HttpStatus.OK).body(commentDTOS);
    }


	@GetMapping("/{id}/genres")
	public ResponseEntity<List<GenreDTO>> showGenres(@PathVariable Long id) {
        Set<Genre> foundGenres = movieService.findGenres(id);
		GenreMapper genreMapper = new GenreMapper();
		List<GenreDTO> genreDTOS = genreMapper.mapToDTOList(foundGenres);
		return ResponseEntity.status(HttpStatus.OK).body(genreDTOS);
	}

	@GetMapping("/{id}/countries")
	public ResponseEntity<List<CountryDTO>> showCountries(@PathVariable Long id) {
		CountryMapper countryMapper = new CountryMapper();
        Set<Country> foundCountries = movieService.findCountries(id);
		List<CountryDTO> countryDTOS = countryMapper.mapListToDto(foundCountries);
        return ResponseEntity.status(HttpStatus.OK).body(countryDTOS);
    }

    @GetMapping("/{id}/movieMark")
    public ResponseEntity<Map<Integer, Double>> showMovieMark(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        List<MovieMark> marks = movie.getMovieMarks();
        Double sumOfMarks = 0d;
        for (MovieMark x : marks) {
            sumOfMarks = +x.getMark();
        }
        if (sumOfMarks == 0) {
            map.put(movie.getMovieMarks().size(), sumOfMarks);
        } else {
            map.put(movie.getMovieMarks().size(), sumOfMarks / movie.getMovieMarks().size());
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
