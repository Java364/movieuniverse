package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.repository.MovieRepository;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieMarkMapper {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    public MovieMark mapToEntityForSave(MovieMarkDTO dto) {
        MovieMark movieMark = new MovieMark();
//      movieMark.setId(dto.getId());
        movieMark.setMark(dto.getMark());
        movieMark.setMovie(movieRepository.getOne(dto.getMovieId()));
        movieMark.setUser(userRepository.getOne(dto.getUserId()));
        return movieMark;
    }

    public MovieMark mapToEntityForUpdate(MovieMarkDTO dto, Long id) {
        MovieMark movieMark = new MovieMark();
        movieMark.setId(id);
        movieMark.setMark(dto.getMark());
        movieMark.setMovie(movieRepository.getOne(dto.getMovieId()));
        movieMark.setUser(userRepository.getOne(dto.getUserId()));
        return movieMark;
    }

    public MovieMarkDTO mapToDto(MovieMark entity) {
        MovieMarkDTO movieMarkDTO = new MovieMarkDTO();
//        movieMarkDTO.setId(entity.getId());
        movieMarkDTO.setMark(entity.getMark());
        movieMarkDTO.setMovieId(entity.getMovie().getId());
        movieMarkDTO.setUserId(entity.getUser().getId());
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
