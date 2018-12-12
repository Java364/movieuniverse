package academy.softserve.movieuniverse.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "star_activity")
public class StarActivityInMovies extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star star;

    @OneToMany
    private List<StarProfession> professions;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public StarActivityInMovies() {
        super();
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
