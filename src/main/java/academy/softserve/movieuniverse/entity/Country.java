package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country extends AbstractEntity {

    @Column(name = "name_country")
    private String name;

    @ManyToMany
    @JoinTable(name = "movies_countries", joinColumns = @JoinColumn(name = "country_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "stars_countries", joinColumns = @JoinColumn(name = "country_id"), inverseJoinColumns = @JoinColumn(name = "star_id"))
    private List<Star> stars = new ArrayList<Star>();

    public Country() {
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }

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
