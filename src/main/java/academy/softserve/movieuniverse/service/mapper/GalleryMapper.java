package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryMapper {

    @Autowired
    private ImageService imageService;

    public Gallery mapToEntity(GalleryDTO dto) {
        Gallery gallery = new Gallery();
        gallery.setId(dto.getId());
        gallery.setIsRemoved(false);
        gallery.setImages(mapIdsToImages(dto.getImageIds()));
        return gallery;
    }

    public Gallery mapToEntityForSave(GalleryDTO dto) {
        Gallery gallery = new Gallery();
        gallery.setId(null);
        gallery.setIsRemoved(false);
        gallery.setImages(mapIdsToImages(dto.getImageIds()));
        return gallery;
    }

    public Gallery mapToEntityForUpdate(GalleryDTO dto, Long id) {
        Gallery gallery = new Gallery();
        gallery.setId(id);
        gallery.setIsRemoved(false);
        gallery.setImages(mapIdsToImages(dto.getImageIds()));
        return gallery;
    }

    public GalleryDTO mapToDto(Gallery entity) {
        GalleryDTO galleryDTO = new GalleryDTO();
        galleryDTO.setId(entity.getId());
        galleryDTO.setImageIds(this.mapEntityToId(entity.getImages()));
        return galleryDTO;
    }

    public List<GalleryDTO> mapListEntityToDto(List<Gallery> galleries) {
        List<GalleryDTO> galleryDTOs = new ArrayList<>();
        for (Gallery g : galleries) {
            galleryDTOs.add(this.mapToDto(g));
        }
        return galleryDTOs;
    }

    private List<Long> mapEntityToId(List<Image> images) {
        List<Long> imageIds = new ArrayList<>();
        for (Image i : images) {
            imageIds.add(i.getId());
        }
        return imageIds;
    }

    private List<Image> mapIdsToImages(List<Long> imageIds) {
        List<Image> images = new ArrayList<>();
        for (Long id : imageIds) {
            images.add(imageService.findById(id));
        }
        return images;
    }
}
