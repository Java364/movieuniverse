package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarActivityInMoviesMapper {
    public StarActivityInMoviesDTO mapToDto(StarActivityInMovies starActivityInMoviesEntity) {
        StarActivityInMoviesDTO starActivityInMoviesDTO = new StarActivityInMoviesDTO();
        starActivityInMoviesDTO.setId(starActivityInMoviesEntity.getId());
        starActivityInMoviesDTO.setMovieId(starActivityInMoviesEntity.getMovie().getId());
        starActivityInMoviesDTO.setMovieName(starActivityInMoviesEntity.getMovie().getMovieName());


        List<Long> ids = new ArrayList<>();
        return starActivityInMoviesDTO;
    }

    public List<StarActivityInMoviesDTO> mapActivityListsToDto(List<StarActivityInMovies> stars) {
        List<StarActivityInMoviesDTO> starDTOs = new ArrayList<>();
        for (StarActivityInMovies t : stars) {
            starDTOs.add(this.mapActivityToDto(t));
        }
        return starDTOs;
    }

    public StarActivityInMoviesDTO mapActivityToDto(StarActivityInMovies entity) {
        StarActivityInMoviesDTO dto = new StarActivityInMoviesDTO();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        return dto;
    }
}
