package academy.softserve.movieuniverse.dto.movie;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = MovieSearchShortInfo.class)
public interface MovieSearchShortInfo {

    Long getId();

    void setId(Long id);

    String getMovieName();

    void setMovieName(String movieName);

    String getSelf();

    void setSelf(String self);

    int getYear();

    void setYear(int year);
}
