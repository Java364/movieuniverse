package academy.softserve.movieuniverse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "movie_stars")
public class Star extends Person {

    @Column(name = "star_biography")
    private String biography;

    @Column(name = "star_growth")
    private Double growth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stars_countries", joinColumns = @JoinColumn(name = "star_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> countries = new ArrayList<>();

    @Column(name = "star_city")
    private String cityOfBirth;

    @OneToMany(mappedBy = "star", cascade = CascadeType.ALL)
    private List<StarActivityInMovies> roles = new ArrayList<StarActivityInMovies>();

    @OneToMany(mappedBy = "star", cascade = CascadeType.ALL)
    private List<StarProfession> professions = new ArrayList<StarProfession>();

    @OneToMany(mappedBy = "star"/*, cascade = CascadeType.ALL*/)
    private List<Links> links = new ArrayList<Links>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "star_movie",
            joinColumns = @JoinColumn(name = "star_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies = new ArrayList<Movie>();
    
    @OneToOne
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public Star() {
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<StarActivityInMovies> getRoles() {
        return roles;
    }

    public void setRoles(List<StarActivityInMovies> roles) {
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

    public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
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
