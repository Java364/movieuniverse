package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trailers")
public class Trailer extends AbstractEntity {

    @Column(name = "trailer_url")
    private String trailerUrl;
    
    @ManyToOne
	@JoinColumn(name = "movie_id")
    private Movie movie;

    public Trailer() {
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
