package academy.softserve.movieuniverse.dto.genre;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GenreDto.class)
public interface GenreCreateDto {
    String getGenreName();

    void setGenreName(String genreName);
}
