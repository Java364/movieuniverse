package academy.softserve.movieuniverse.entity;

import javax.persistence.*;

@Entity
@Table(name = "cast")
public class Cast extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Star star;

    @Column(name = "character_name")
    private String character;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
