package academy.softserve.movieuniverse.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gallery")
public class Gallery extends AbstractEntity {

    @OneToMany(mappedBy = "gallery")
    private List<Image> images = new ArrayList<>();

    public Gallery() {
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Gallery{" + super.toString() + "images=" + images + '}';
    }
}
