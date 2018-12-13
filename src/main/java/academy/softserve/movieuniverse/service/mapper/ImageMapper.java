package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import academy.softserve.movieuniverse.dto.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.GalleryService;

public class ImageMapper implements ReversableDtoMapper<Image, ImageDTO>{

	@Autowired
	private GalleryService galleryService;
	
	@Override
	public Image mapToEntity(ImageDTO dto) {
		Image image = new Image();
		image.setGallery(galleryService.getGallery(dto.getGalleryId()));
		image.setId(dto.getId());
		image.setImageUrl(dto.getImageUrl());
		image.setIsRemoved(false);
		image.setName(dto.getName());
		return null;
	}

	@Override
	public ImageDTO mapToDto(Image entity) {
		ImageDTO imageDTO = new ImageDTO();
		imageDTO.setGalleryId(entity.getGallery().getId());
		imageDTO.setId(entity.getId());
		imageDTO.setImageUrl(entity.getImageUrl());
		imageDTO.setName(entity.getName());
		return imageDTO;
	}
	
	public List<ImageDTO> mapListEntityToDto(List<Image> images) {
		List<ImageDTO> imageDTOs = new ArrayList<>();
		for(Image i: images) {
			imageDTOs.add(this.mapToDto(i));
		}
		return imageDTOs;
	}
	
	public List<Image> mapListDtoToEntity(List<ImageDTO> imageDTOs) {
		List<Image> images = new ArrayList<>();
		for(ImageDTO i: imageDTOs) {
			images.add(this.mapToEntity(i));
		}
		return images;
	}

}
