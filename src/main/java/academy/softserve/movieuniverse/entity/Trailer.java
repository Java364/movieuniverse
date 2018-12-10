package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trailers")
public class Trailer extends AbstractEntity{

	@Column(name = "trailer_url")
	private String trailerUrl;
	
	public Trailer() {}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

}
