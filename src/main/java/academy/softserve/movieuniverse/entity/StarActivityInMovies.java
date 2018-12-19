package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "star_activity")
public class StarActivityInMovies extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star star;

    @OneToMany(cascade = CascadeType.ALL)
    private List<StarProfession> professions;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public StarActivityInMovies() {
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<StarProfession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<StarProfession> professions) {
        this.professions = professions;
    }
}
