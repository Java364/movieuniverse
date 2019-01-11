package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends AbstractEntity {

    @Column(name = "name_country")
    private String name;

    @ManyToMany(mappedBy = "countries")
    private Set<Movie> movies = new HashSet<>();

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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

}
