package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.dto.country.CountryDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.dto.trailer.CreateTrailerInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.service.*;
import academy.softserve.movieuniverse.mapper.*;
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
	private final CountryService countryService;
	private final CommentMapper commentMapper;
	private final CountryMapper countryMapper;
	private final MovieMarkService movieMarkService;
	private final PosterService posterService;
	private final PosterMapper posterMapper;
	private final GenreMapper genreMapper;

	@Autowired
	public MovieController(PosterMapper posterMapper, MovieService movieService, MovieMapper movieMapper,
			GalleryMapper galleryMapper, TrailerMapper trailerMapper, TrailerService trailerService,
			CountryService countryService, CommentMapper commentMapper, CountryMapper countryMapper,
			MovieMarkService movieMarkService, PosterService posterService, GenreMapper genreMapper) {
		this.movieService = movieService;
		this.movieMapper = movieMapper;
		this.galleryMapper = galleryMapper;
		this.trailerMapper = trailerMapper;
		this.trailerService = trailerService;
		this.countryService = countryService;
		this.commentMapper = commentMapper;
		this.countryMapper = countryMapper;
		this.movieMarkService = movieMarkService;
		this.posterService = posterService;
		this.posterMapper = posterMapper;
		this.genreMapper = genreMapper;
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>> showAll() {
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.mapListToDTO(movieService.showAllMovies()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> showById(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.mapToDto(movie));
	}

	@PostMapping
	public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(movieMapper.mapToDto(movieService.create(movieMapper.mapToEntity(movieDTO))));

	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(movieMapper.mapToDto(movieService.updateMovie(movieMapper.mapToEntity(movieDTO), id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@GetMapping("/mark/{id}")
	public MovieDTO showByMovieMark(@PathVariable Long id) {
		MovieMark movieMark = movieMarkService.findById(id);
		return movieMapper.mapToDto(movieService.findAllByMovieMarks(movieMark));
	}

	@GetMapping("/{id}/gallery")
	public ResponseEntity<GalleryDTO> showMovieGallery(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(galleryMapper.mapToDTO(movie.getMediaContent().getGallery()));
	}

	@PostMapping("/{id}/gallery")
	public ResponseEntity<GalleryDTO> createMovieGallery(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(galleryMapper.mapToDTO(movieService.addNewGallery(id)));
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
		return ResponseEntity.status(HttpStatus.CREATED).body(trailerMapper.mapToDTO(trailerService.save(trailer)));
	}

	@PostMapping("/{id}/poster")
	public ResponseEntity<PosterDTO> createMoviePoster(@RequestBody PosterDTO posterDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(posterMapper.mapToDTO(posterService.save(posterMapper.mapToEntityForSave(posterDTO))));
	}

	@GetMapping("/{id}/poster")
	public ResponseEntity<PosterDTO> showMoviePoster(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(posterMapper.mapToDTO(movie.getMediaContent().getPoster()));
	}

	@GetMapping("/{id}/comments")
	public ResponseEntity<List<CommentDTO>> showMovieComments(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(commentMapper.mapToDTOList(movie.getComments()));
	}

	@GetMapping("/{id}/genres")
	public ResponseEntity<List<GenreDTO>> showMovieGenres(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(genreMapper.mapToDTOList(movie.getGenres()));
	}

	@GetMapping("/{id}/countries")
	public ResponseEntity<List<CountryDTO>> showMovieCountries(@PathVariable Long id) {
		Movie movie = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(countryMapper.mapListToDto(movie.getCountries()));
	}

	@PostMapping("/{id}/countries")
	public ResponseEntity<List<CountryDTO>> addMovieCountries(@PathVariable Long id,
			@RequestBody List<CountryDTO> countryDTOS) {
		Movie movie = movieService.findMovieById(id);
		List<Country> countries = countryMapper.mapCountriesListToEntity(countryDTOS);
		movie.setCountries(countries);
		movieService.updateMovie(movie, id);
		return ResponseEntity.status(HttpStatus.OK).body(countryMapper.mapListToDto(movie.getCountries()));
	}
}
