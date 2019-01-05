package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.dto.country.CountryDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.dto.trailer.CreateTrailerInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.dto.userreview.CommentDTO;
import academy.softserve.movieuniverse.entity.*;
import academy.softserve.movieuniverse.mapper.*;
import academy.softserve.movieuniverse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.mapListToDTO(movieService.findAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> showById(@PathVariable Long id) {
		Movie movie = movieService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(movieMapper.mapToDto(movie));
	}

	@PostMapping
	public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(movieMapper.mapToDto(movieService.save(movieMapper.mapToEntity(movieDTO))));

	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(movieMapper.mapToDto(movieService.update(movieMapper.mapToEntity(movieDTO), id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		movieService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();

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

	@PostMapping("/{id}/gallery")
	public ResponseEntity<GalleryDTO> createMovieGallery(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(galleryMapper.mapToDTO(movieService.addNewGallery(id)));
	}

	@GetMapping("/{id}/trailers/")
	public ResponseEntity<List<TrailerDTO>> showMovieTrailers(@PathVariable Long id) {
		Movie movie = movieService.findById(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(trailerMapper.maptoDTOList(movie.getMediaContent().getTrailers()));
	}

	@PostMapping("/{id}/trailers/")
	public ResponseEntity<TrailerDTO> createMovieTrailer(@PathVariable Long id, @RequestBody CreateTrailerInfo dto) {
		Trailer trailer = trailerMapper.mapToEntity(dto);
		trailer.setMovie(movieService.findById(id));
		return ResponseEntity.status(HttpStatus.CREATED).body(trailerMapper.mapToDTO(trailerService.save(trailer)));
	}

	@PostMapping("/{id}/poster")
	public ResponseEntity<PosterDTO> createMoviePoster(@RequestBody PosterDTO posterDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(posterMapper.mapToDTO(posterService.save(posterMapper.mapToEntityForSave(posterDTO))));
	}

	@GetMapping("/{id}/poster")
	public ResponseEntity<PosterDTO> showMoviePoster(@PathVariable Long id) {
		Movie movie = movieService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(posterMapper.mapToDTO(movie.getMediaContent().getPoster()));
	}

	@GetMapping("/{id}/comments")
	public ResponseEntity<List<CommentDTO>> showComments(@PathVariable Long id) {
		List<Comment> foundComments = movieService.findComments(id);
		List<CommentDTO> commentDTOS = commentMapper.mapToDTOList(foundComments, commentMapper::mapToDTO);
		return ResponseEntity.status(HttpStatus.OK).body(commentDTOS);
	}

    @PostMapping("/{id}/genres")
    public ResponseEntity<List<GenreDTO>> addGenres(@PathVariable Long id, List<GenreDTO> selectedGenres) {
	    List<Genre> genresToSave = genreMapper.mapToEntityList(selectedGenres, genreMapper::mapToEntity);
        List<Genre> savedGenres = movieService.saveGenres(id, genresToSave);
        List<GenreDTO> savedGenreDTOS = genreMapper.mapToDTOList(savedGenres, genreMapper::mapToDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGenreDTOS);
    }
	
	@GetMapping("/{id}/genres")
	public ResponseEntity<List<GenreDTO>> showGenres(@PathVariable Long id) {
        List<Genre> foundGenres = movieService.findGenres(id);
        List<GenreDTO> genreDTOS = genreMapper.mapToDTOList(foundGenres, genreMapper::mapToDTO);
		return ResponseEntity.status(HttpStatus.OK).body(genreDTOS);
	}

	@GetMapping("/{id}/countries")
	public ResponseEntity<List<CountryDTO>> showCountries(@PathVariable Long id) {
        List<Country> foundCountries = movieService.findCountries(id);
        List<CountryDTO> countryDTOS = countryMapper.mapListToDto(foundCountries);
        return ResponseEntity.status(HttpStatus.OK).body(countryDTOS);
	}

	@PostMapping("/{id}/countries")
	public ResponseEntity<List<CountryDTO>> addCountries(@PathVariable Long id,
														 @RequestBody List<CountryDTO> selectedCountries) {
		List<Country> countries = countryMapper.mapCountriesListToEntity(selectedCountries);
		List<Country> savedCountries = movieService.saveCountries(id, countries);
		List<CountryDTO> countryDTOS = countryMapper.mapListToDto(savedCountries);
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
