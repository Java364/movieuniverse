package academy.softserve.movieuniverse.dto.interfaces;

import academy.softserve.movieuniverse.dto.MovieDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import academy.softserve.movieuniverse.dto.genre.GenreDto;

import java.util.List;

@JsonDeserialize(as = MovieDTO.class)
public interface MovieCreateDTO extends  MovieInfoDTO {
    List<GenreDto> getGenres();
    void setGenres(List<GenreDto> genres);
}
