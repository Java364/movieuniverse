package academy.softserve.movieuniverse.dto;

import java.util.ArrayList;
import java.util.List;

public class GalleryDTO {
	
	private Long id;
	private List<Long> imageIds = new ArrayList<>();
	
	public GalleryDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getImageIds() {
		return imageIds;
	}

	public void setImageIds(List<Long> imageIds) {
		this.imageIds = imageIds;
	}
	
}
