package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;
import academy.softserve.movieuniverse.dto.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;

public class GalleryMapper{

	private ImageMapper imageMapper = new ImageMapper();

	public Gallery mapToEntity(GalleryDTO dto) {
		Gallery gallery = new Gallery();
		gallery.setId(dto.getId());
		gallery.setIsRemoved(false);
		gallery.setImages(imageMapper.mapListDtoToEntity(dto.getImages()));
		return gallery;
	}

	public GalleryDTO mapToDto(Gallery entity) {
		GalleryDTO galleryDTO = new GalleryDTO();
		galleryDTO.setId(entity.getId());
		galleryDTO.setImages(imageMapper.mapListEntityToDto(entity.getImages()));
		return galleryDTO;
	}

	public List<GalleryDTO> mapListEntityToDto(List<Gallery> galleries) {
		List<GalleryDTO> galleryDTOs = new ArrayList<>();
		for(Gallery g: galleries) {
			galleryDTOs.add(this.mapToDto(g));
		}
		return galleryDTOs;
	}
}
