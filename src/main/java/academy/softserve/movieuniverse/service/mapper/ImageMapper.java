package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.dto.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.GalleryService;
@Service
public class ImageMapper {

	@Autowired
	private GalleryService galleryService;

	public Image mapToEntityForSave(ImageDTO dto) {
		Image image = new Image();
		image.setGallery(galleryService.findGalleryById(dto.getGalleryId()));
		image.setId(null);
		image.setImageUrl(dto.getImageUrl());
		image.setIsRemoved(new Boolean(false));
		image.setName(dto.getName());
		return null;
	}
	
	public Image mapToEntity(ImageDTO dto) {
		Image image = new Image();
		image.setGallery(galleryService.findGalleryById(dto.getGalleryId()));
		image.setId(dto.getId());
		image.setImageUrl(dto.getImageUrl());
		image.setIsRemoved(new Boolean(false));
		image.setName(dto.getName());
		return null;
	}
	
	public Image mapToEntityForUpdate(ImageDTO dto, Long id) {
		Image image = new Image();
		image.setGallery(galleryService.findGalleryById(dto.getGalleryId()));
		image.setId(id);
		image.setImageUrl(dto.getImageUrl());
		image.setIsRemoved(new Boolean(false));
		image.setName(dto.getName());
		return null;
	}

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
