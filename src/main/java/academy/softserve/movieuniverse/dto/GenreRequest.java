package academy.softserve.movieuniverse.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GenreDto.class)
public interface GenreRequest {
    String getGenreName();

    void setGenreName(String genreName);
}
