package academy.softserve.movieuniverse.dto.interfaces;

import academy.softserve.movieuniverse.dto.GenreDto;

import java.util.List;

public interface MovieCreateDTO extends  MovieInfoDTO {
    public List<GenreDto> getGenres();
    public void setGenres(List<GenreDto> genres);
}
