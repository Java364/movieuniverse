package academy.softserve.movieuniverse.dto.interfaces;

import academy.softserve.movieuniverse.dto.GenreDto;
import academy.softserve.movieuniverse.dto.MovieDTO;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = MovieDTO.class)
public interface MovieCreateDTO extends  MovieInfoDTO {
    public List<GenreDto> getGenres();
    public void setGenres(List<GenreDto> genres);
}
