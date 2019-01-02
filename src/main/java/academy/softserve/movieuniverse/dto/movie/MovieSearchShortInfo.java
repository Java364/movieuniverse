package academy.softserve.movieuniverse.dto.movie;

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
