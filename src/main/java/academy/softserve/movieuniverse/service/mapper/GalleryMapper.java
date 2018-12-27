package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.GalleryController;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class GalleryMapper implements DTOMapper<GalleryDTO, Gallery> {


    @Override
    public <T> Gallery mapToEntity(T dto) {
        GalleryDTO galleryDTO = (GalleryDTO) dto;
        Gallery gallery = new Gallery();
        return gallery;
    }

    @Override
    public GalleryDTO mapToDTO(Gallery gallery) {
        GalleryDTO galleryDTO = new GalleryDTO();
        galleryDTO.setId(gallery.getId());
        galleryDTO.setCreated(gallery.getEntryCreationDate().getTime());
        galleryDTO.setUpdated(gallery.getEntryLastUpdate().getTime());
        galleryDTO.setSelf(linkTo(methodOn(GalleryController.class).showById(gallery.getId())).withSelfRel().getHref());
        galleryDTO.setImages(linkTo(methodOn(GalleryController.class).showImagesByGalleryId(gallery.getId())).withRel("images").getHref());
        return galleryDTO;
    }

    @Override
    public <T> List<Gallery> mapToEntityList(List<T> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public List<GalleryDTO> mapToDTOList(List<Gallery> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
