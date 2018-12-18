package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.entity.StarProfession;
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
        starActivityInMoviesDTO.setStarId(starActivityInMoviesEntity.getStar().getId());
        starActivityInMoviesDTO.setStarName(starActivityInMoviesEntity.getStar().getFirstName() + " "
                + starActivityInMoviesEntity.getStar().getLastName());

        List<Long> ids = new ArrayList<>();
        List<StarProfession> starProfessions = starActivityInMoviesEntity.getProfessions();
        for (StarProfession profession: starProfessions) {
            ids.add(profession.getId());
        }
        return starActivityInMoviesDTO;
    }
}
