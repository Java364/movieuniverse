package academy.softserve.movieuniverse.dto.trailer;

public class TrailerDTO implements CreateTrailerInfo {

    private Long id;
    private String trailerUrl;
    private Long created;
    private Long updated;
    private String self;
    private String movie;

    public TrailerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTrailerUrl() {
        return trailerUrl;
    }

    @Override
    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
