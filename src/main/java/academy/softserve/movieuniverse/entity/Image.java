package academy.softserve.movieuniverse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image extends AbstractEntity {

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;
    
    @ManyToOne
   	@JoinColumn(name = "gallery_id")
    private Gallery gallery;

    public Image() {
    }

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

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
}
