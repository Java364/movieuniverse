package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.entity.CastAndCrew;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarActivityInMoviesMapper {
    public StarActivityInMoviesDTO mapToDto(CastAndCrew castAndCrewEntity) {
        StarActivityInMoviesDTO starActivityInMoviesDTO = new StarActivityInMoviesDTO();
        starActivityInMoviesDTO.setId(castAndCrewEntity.getId());
        starActivityInMoviesDTO.setMovieId(castAndCrewEntity.getMovie().getId());
        starActivityInMoviesDTO.setMovieName(castAndCrewEntity.getMovie().getMovieName());

        List<Long> ids = new ArrayList<>();
        return starActivityInMoviesDTO;
    }

    public List<StarActivityInMoviesDTO> mapActivityListsToDto(List<CastAndCrew> stars) {
        List<StarActivityInMoviesDTO> starDTOs = new ArrayList<>();
        for (CastAndCrew t : stars) {
            starDTOs.add(this.mapActivityToDto(t));
        }
        return starDTOs;
    }

    public StarActivityInMoviesDTO mapActivityToDto(CastAndCrew entity) {
        StarActivityInMoviesDTO dto = new StarActivityInMoviesDTO();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        return dto;
    }
}
