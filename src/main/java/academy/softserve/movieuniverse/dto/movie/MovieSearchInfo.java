package academy.softserve.movieuniverse.dto.movie;

public interface MovieSearchInfo {

    Long getId();

    void setId(Long id);

    String getMovieName();

    void setMovieName(String movieName);

    String getSelf();

    void setSelf(String self);

    String getPoster();

    void setPoster(String poster);

    int getYear();

    void setYear(int year);

}
