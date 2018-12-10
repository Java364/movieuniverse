package academy.softserve.movieuniverse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="genres")
public class Genre extends AbstractEntity{
	
	@Column(name = "name_genre")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "movies_genres", joinColumns = @JoinColumn(name = "genre_id"), 
	inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movies = new ArrayList<>();
	
	public Genre() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
