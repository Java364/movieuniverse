package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "star_profession")
public class StarProfession extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star star;

    @ManyToOne
    @JoinColumn(name = "star_profession_id")
    private Profession profession;

    public StarProfession() {
    }

    public StarProfession(Star star, Profession profession) {
        super();
        this.star = star;
        this.profession = profession;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
