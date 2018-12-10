package academy.softserve.movieuniverse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie_stars")
public class Star extends Person {
	
	
	@Column(name="star_biography")
	private String biography;
	
	@Column(name="star_growth")
	private Double growth;
	
	@Column(name="star_country")
	private String countryOfBirth;
	
	@Column(name="star_city")
	private String cityOfBirth;
	
	@OneToMany(mappedBy = "star")
    private List<StarActivityInFilms> roles = new ArrayList<StarActivityInFilms>();
	
	@OneToMany(mappedBy = "star")
	private List<StarProfession> professions = new ArrayList<StarProfession>();
	
	@OneToMany(mappedBy = "star")
	private List<Links> links = new ArrayList<Links>();
	
	@ManyToMany
	@JoinTable(name = "star_movie", 
	joinColumns = @JoinColumn(name =  "star_id"), 
	inverseJoinColumns = @JoinColumn(name =  "movie_id"))
	private List<Movie> movies = new ArrayList<Movie>();
	
	public Star() {}

	public Star(String biography, Double growth, String countryOfBirth,
			String cityOfBirth, List<StarActivityInFilms> roles,
			List<StarProfession> professions, List<Links> links,
			List<Movie> movies) {
		super();
		this.biography = biography;
		this.growth = growth;
		this.countryOfBirth = countryOfBirth;
		this.cityOfBirth = cityOfBirth;
		this.roles = roles;
		this.professions = professions;
		this.links = links;
		this.movies = movies;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<StarActivityInFilms> getRoles() {
		return roles;
	}

	public void setRoles(List<StarActivityInFilms> roles) {
		this.roles = roles;
	}

	public Double getGrowth() {
		return growth;
	}

	public void setGrowth(Double growth) {
		this.growth = growth;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getCityOfBirth() {
		return cityOfBirth;
	}

	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	public List<StarProfession> getProfessions() {
		return professions;
	}

	public void setProfessions(List<StarProfession> professions) {
		this.professions = professions;
	}
}
