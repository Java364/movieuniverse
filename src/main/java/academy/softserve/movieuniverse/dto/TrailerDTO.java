package academy.softserve.movieuniverse.dto;

import javax.validation.constraints.NotBlank;

public class TrailerDTO {

    private Long id;
    private String trailerUrl;
    @NotBlank
    private Long movieId;

    public TrailerDTO() {
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

}
