package academy.softserve.movieuniverse.controller.admin;

import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.dto.country.CountryDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;
import academy.softserve.movieuniverse.dto.trailer.CreateTrailerInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.mapper.*;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.PosterService;
import academy.softserve.movieuniverse.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin/movie")
public class MovieAdminController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private TrailerService trailerService;

    @Autowired
    private PosterService posterService;

    @Autowired
    private MovieMapper movieMapper;

    @PostMapping
    public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) {
        Movie movieToSave = movieMapper.mapToEntity(movieDTO);
        Movie createdMovie = movieService.save(movieToSave);
        MovieDTO createdMovieDTO = movieMapper.mapToDto(createdMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovieDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        Movie movieToUpdate = movieMapper.mapToEntity(movieDTO);
        Movie updatedMovie = movieService.update(movieToUpdate, id);
        MovieDTO updatedMovieDTO = movieMapper.mapToDto(updatedMovie);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMovieDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PostMapping("/{id}/genres")
    public ResponseEntity<List<GenreDTO>> addGenres(@PathVariable Long id, @RequestBody List<GenreDTO> selectedGenres) {
        GenreMapper genreMapper = new GenreMapper();
        Set<Genre> genresToSave = genreMapper.mapToEntitySet(selectedGenres, GenreMapper::mapToEntity);
        Set<Genre> savedGenres = movieService.saveGenres(id, genresToSave);
        List<GenreDTO> savedGenreDTOS = genreMapper.mapToDTOList(savedGenres);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGenreDTOS);
    }

    @PostMapping("/{id}/countries")
    public ResponseEntity<List<CountryDTO>> addCountries(@PathVariable Long id,
            @RequestBody List<CountryDTO> selectedCountries) {
        CountryMapper countryMapper = new CountryMapper();
        Set<Country> countries = countryMapper.mapCountriesListToEntity(selectedCountries);
        Set<Country> savedCountries = movieService.saveCountries(id, countries);
        List<CountryDTO> countryDTOS = countryMapper.mapListToDto(savedCountries);
        return ResponseEntity.status(HttpStatus.OK).body(countryDTOS);
    }

    @PostMapping("/{id}/gallery")
    public ResponseEntity<GalleryDTO> addGallery(@PathVariable Long id) {
        GalleryMapper galleryMapper = new GalleryMapper();
        return ResponseEntity.status(HttpStatus.CREATED).body(galleryMapper.mapToDTO(movieService.addNewGallery(id)));
    }

    @PostMapping("/{id}/trailers/")
    public ResponseEntity<TrailerDTO> addTrailer(@PathVariable Long id, @RequestBody CreateTrailerInfo dto) {
        TrailerMapper trailerMapper = new TrailerMapper();
        Trailer trailer = trailerMapper.mapToEntity(dto);
        trailer.setMovie(movieService.findById(id));
        return ResponseEntity.status(HttpStatus.CREATED).body(trailerMapper.mapToDTO(trailerService.save(trailer)));
    }

    @PostMapping("/{id}/poster")
    public ResponseEntity<PosterDTO> addPoster(@RequestBody PosterDTO posterDTO) {
        PosterMapper posterMapper = new PosterMapper();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(posterMapper.mapToDTO(posterService.save(posterMapper.mapToEntityForSave(posterDTO))));
    }

}
