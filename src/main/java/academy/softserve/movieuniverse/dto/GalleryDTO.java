package academy.softserve.movieuniverse.dto;

import java.util.ArrayList;
import java.util.List;

public class GalleryDTO {
	
	private Long id;
	private List<ImageDTO> images = new ArrayList<>();
	
	public GalleryDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}
}
