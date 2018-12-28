package academy.softserve.movieuniverse.dto.trailer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = TrailerDTO.class)
public interface CreateTrailerInfo {

    String getTrailerUrl();

    void setTrailerUrl(String trailerUrl);
}
