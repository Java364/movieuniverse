package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.dto.UserProfileDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public Movie mapToEntity(MovieDTO dto) {
        return modelMapper.map(dto, Movie.class);
    }

    public MovieDTO mapToDto(Movie entity) {
        return modelMapper.map(entity, MovieDTO.class);
    }

    public List<MovieDTO> mapListToDTO(List<Movie> entities) {
        return entities.stream().map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }
}
