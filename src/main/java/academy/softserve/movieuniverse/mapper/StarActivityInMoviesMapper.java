package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.entity.Crew;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarActivityInMoviesMapper {
    public StarActivityInMoviesDTO mapToDto(Crew crewEntity) {
        StarActivityInMoviesDTO starActivityInMoviesDTO = new StarActivityInMoviesDTO();
        starActivityInMoviesDTO.setId(crewEntity.getId());
        starActivityInMoviesDTO.setMovieId(crewEntity.getMovie().getId());
        starActivityInMoviesDTO.setMovieName(crewEntity.getMovie().getMovieName());

        List<Long> ids = new ArrayList<>();
        return starActivityInMoviesDTO;
    }

    public List<StarActivityInMoviesDTO> mapActivityListsToDto(List<Crew> stars) {
        List<StarActivityInMoviesDTO> starDTOs = new ArrayList<>();
        for (Crew t : stars) {
            starDTOs.add(this.mapActivityToDto(t));
        }
        return starDTOs;
    }

    public StarActivityInMoviesDTO mapActivityToDto(Crew entity) {
        StarActivityInMoviesDTO dto = new StarActivityInMoviesDTO();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        return dto;
    }
}
