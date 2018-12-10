package academy.softserve.movieuniverse.entity;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Embeddable
public class MediaContent {

	@OneToOne
	@JoinColumn(name = "poster_id")
	private Poster poster;
	@OneToMany()
	private List<Trailer> trailers;
	@OneToMany()
	private List<Galery> galeries;
		
	public Poster getPoster() {
		return poster;
	}

	public void setPoster(Poster poster) {
		this.poster = poster;
	}

	public List<Trailer> getTrailers() {
		return trailers;
	}

	public void setTrailers(List<Trailer> trailers) {
		this.trailers = trailers;
	}

	public List<Galery> getGaleries() {
		return galeries;
	}

	public void setGaleries(List<Galery> galeries) {
		this.galeries = galeries;
	}

}
