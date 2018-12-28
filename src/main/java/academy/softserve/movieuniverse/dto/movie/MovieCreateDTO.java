package academy.softserve.movieuniverse.dto.movie;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.util.List;

@JsonDeserialize(as = MovieDTO.class)
public interface MovieCreateDTO extends  MovieInfoDTO {
    List<Long> getGenres();
    void setGenres(List<Long> genres);

    List<Long> getCountries();
    void setCountries(List<Long> countries);
}
