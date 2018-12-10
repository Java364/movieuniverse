package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "star_activity")
public class StarActivityInFilms extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star star;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private StarProfession profession;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public StarActivityInFilms() {
        super();
    }

    public StarActivityInFilms(Star star, StarProfession profession, Movie movie) {
        super();
        this.star = star;
        this.profession = profession;
        this.movie = movie;
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

    public StarProfession getProfession() {
        return profession;
    }

    public void setProfession(StarProfession profession) {
        this.profession = profession;
    }
}
