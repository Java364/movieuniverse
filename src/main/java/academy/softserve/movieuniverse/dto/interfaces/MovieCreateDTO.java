package academy.softserve.movieuniverse.dto.interfaces;

import academy.softserve.movieuniverse.dto.MovieDTO;
import academy.softserve.movieuniverse.dto.genre.GenreDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = MovieDTO.class)
public interface MovieCreateDTO extends  MovieInfoDTO {
    List<GenreDTO> getGenres();
    void setGenres(List<GenreDTO> genres);
}
