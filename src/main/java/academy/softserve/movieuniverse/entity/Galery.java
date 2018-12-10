package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="galeries")
public class Galery extends AbstractEntity{

	@Column(name = "name_galery")
	private String name;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	public Galery() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
