package academy.softserve.movieuniverse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gallery")
public class Gallery extends AbstractEntity{
	
	@OneToMany(mappedBy = "gallery")
	private List<Image> images = new ArrayList<>();

	public Gallery() {}
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
