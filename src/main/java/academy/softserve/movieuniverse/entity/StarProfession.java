package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "star_profession")
public class StarProfession extends AbstractEntity {

    @OneToMany(mappedBy = "starProfession")
    List<Crew> crew;

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
