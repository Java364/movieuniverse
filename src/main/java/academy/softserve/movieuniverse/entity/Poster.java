package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posters")
public class Poster extends AbstractEntity {

	@Column(name = "name_poster")
	private String name;

	@Column(name = "image_url")
	private String imageUrl;
	@OneToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
