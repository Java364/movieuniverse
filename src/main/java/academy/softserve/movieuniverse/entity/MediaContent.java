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

	@OneToMany
	@JoinColumn(name = "movie_id")
	private List<Trailer> trailers;

	@OneToMany
	private List<Image> gallery;
		
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

	public List<Image> getGallery() {
		return gallery;
	}

	public void setGallery(List<Image> gallery) {
		this.gallery = gallery;
	}

}
