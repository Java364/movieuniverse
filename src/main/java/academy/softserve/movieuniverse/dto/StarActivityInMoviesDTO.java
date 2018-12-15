package academy.softserve.movieuniverse.dto;

import java.util.List;

public class StarActivityInMoviesDTO {

    private long id;
    private long starId;
    private long movieId;
    private String starName;
    private String movieName;
    private List<Long> professionIds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStarId() {
        return starId;
    }

    public void setStarId(long starId) {
        this.starId = starId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Long> getProfessionIds() {
        return professionIds;
    }

    public void setProfessionIds(List<Long> professionIds) {
        this.professionIds = professionIds;
    }
}
