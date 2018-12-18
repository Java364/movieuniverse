package academy.softserve.movieuniverse.dto.genre;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GenreDTO.class)
public interface GenreRequest {
    String getGenreName();

    void setGenreName(String genreName);
}
