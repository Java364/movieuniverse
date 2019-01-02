package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.controller.MovieMarkController;
import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.MovieRepository;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieMarkMapper {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    public MovieMark mapToEntityForSave(MovieMarkDTO dto, User user, Movie movie) {
        MovieMark movieMark = new MovieMark();
        movieMark.setUser(user);
        movieMark.setMovie(movie);
        movieMark.setMark(dto.getMark());
        return movieMark;
    }

    public MovieMark mapToEntityForSave(MovieMarkDTO dto) {
        MovieMark movieMark = new MovieMark();
        movieMark.setMark(dto.getMark());
        return movieMark;
    }

    public MovieMark mapToEntityForUpdate(MovieMarkDTO dto, Long id) {
        MovieMark movieMark = new MovieMark();
        movieMark.setId(id);
        movieMark.setMark(dto.getMark());
        return movieMark;
    }

    public MovieMarkDTO mapToDto(MovieMark movieMark) {
        MovieMarkDTO movieMarkDTO = new MovieMarkDTO();
        movieMarkDTO.setMark(movieMark.getMark());
        movieMarkDTO.setSelf(
                linkTo(methodOn(MovieMarkController.class).showById(movieMark.getId())).withSelfRel().getHref());
        movieMarkDTO.setMovie(linkTo(methodOn(MovieController.class).showById(movieMark.getMovie().getId()))
                .withRel("movie").getHref());
        movieMarkDTO.setUser(
                linkTo(methodOn(UserController.class).showById(movieMark.getUser().getId())).withRel("user").getHref());
        return movieMarkDTO;
    }

    public List<MovieMarkDTO> mapToDTOList(List<MovieMark> movieMarks) {
        List<MovieMarkDTO> movieMarkDTOs = new ArrayList<>();
        for (MovieMark m : movieMarks) {
            movieMarkDTOs.add(this.mapToDto(m));
        }
        return movieMarkDTOs;
    }

    public List<MovieMark> mapMovieMarksListToEntity(List<MovieMarkDTO> movieMarksDTOs) {
        List<MovieMark> marks = new ArrayList<>();
        for (MovieMarkDTO m : movieMarksDTOs) {
            marks.add(this.mapToEntityForSave(m));
        }
        return marks;
    }

}
