package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.dto.movie.MovieDTO;import academy.softserve.movieuniverse.dto.movie.MovieFullInfo;
import academy.softserve.movieuniverse.dto.movie.MovieSearchShortInfo;
import academy.softserve.movieuniverse.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class MovieMapper {

	@Autowired
	public MovieMapper() {

	}

	public Movie mapToEntity(MovieDTO dto) {
		Movie movie = new Movie();
		movie.setId(dto.getId());
		movie.setMovieName(dto.getMovieName());
		movie.setAgeLimitation(dto.getAgeLimitation());
		movie.setDuration(dto.getDuration());
		movie.setYear(dto.getYear());
		movie.setDescription(dto.getDescription());
		movie.setComments(new ArrayList<>());
		return movie;
	}

	public MovieDTO mapToDto(Movie entity) {
		MovieDTO dto = new MovieDTO();
		dto.setId(entity.getId());
		dto.setMovieName(entity.getMovieName());
		dto.setAgeLimitation(entity.getAgeLimitation());
		dto.setDuration(entity.getDuration());
		dto.setYear(entity.getYear());
		dto.setDescription(entity.getDescription());
		dto.setSelf(linkTo(methodOn(MovieController.class).showById(entity.getId())).withSelfRel().getHref());
		dto.setCountries(linkTo(methodOn(MovieController.class).showCountries(entity.getId())).withRel("countries")
				.getHref());
		dto.setComments(linkTo(methodOn(MovieController.class).showComments(entity.getId())).withRel("comments")
				.getHref());
		dto.setGallery(
				linkTo(methodOn(MovieController.class).showMovieGallery(entity.getId())).withRel("gallery").getHref());
		dto.setTrailers(linkTo(methodOn(MovieController.class).showMovieTrailers(entity.getId())).withRel("trailers")
				.getHref());
		dto.setGenres(
				linkTo(methodOn(MovieController.class).showGenres(entity.getId())).withRel("genres").getHref());
		dto.setPoster(
				linkTo(methodOn(MovieController.class).showMoviePoster(entity.getId())).withRel("poster").getHref());
        dto.setMovieMark(linkTo(methodOn(MovieController.class).showMovieMark(entity.getId())).withRel("movieMark").getHref());
		return dto;
	}

	public MovieSearchShortInfo mapEntityToMovieSearchShortInfo(Movie movieEntity) {
		MovieSearchShortInfo movieDTO = new MovieDTO();
		movieDTO.setId(movieEntity.getId());
		movieDTO.setMovieName(movieEntity.getMovieName());
		movieDTO.setYear(movieEntity.getYear());
		movieDTO.setSelf(linkTo(methodOn(MovieController.class).showById(movieEntity.getId())).withSelfRel().getHref());
		return movieDTO;
	}

	public List<MovieSearchShortInfo> mapListToMovieSearchShortInfoList(List<Movie> movieEntities) {
		return movieEntities.stream().map(this::mapEntityToMovieSearchShortInfo).collect(Collectors.toList());
	}

	public List<MovieDTO> mapListToMovieDTO(List<Movie> movieEntities) {
		return movieEntities.stream().map(this::mapToDto).collect(Collectors.toList());
	}

}
