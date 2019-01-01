package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cast_and_crew")
public class CastAndCrew extends AbstractEntity {
    @ManyToOne
    private StarProfession profession;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie          movie;

    public CastAndCrew() {
    }

    public StarProfession getProfession() {
        return profession;
    }

    public void setProfession(StarProfession profession) {
        this.profession = profession;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
