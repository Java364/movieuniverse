package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "crew")
public class Crew extends AbstractEntity {
    @ManyToOne
    private StarProfession starProfession;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Crew() {
    }

    public StarProfession getStarProfession() {
        return starProfession;
    }

    public void setStarProfession(StarProfession starProfession) {
        this.starProfession = starProfession;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
