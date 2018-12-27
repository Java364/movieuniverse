package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.GalleryController;
import academy.softserve.movieuniverse.controller.ImageController;
import academy.softserve.movieuniverse.dto.image.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class ImageMapper {

    public <T> Image mapToEntity(T dto) {
        ImageDTO imageDTO = (ImageDTO) dto;
        Image entity = new Image();
        entity.setImageUrl(imageDTO.getImageUrl());
        entity.setName(imageDTO.getName());
        return entity;
    }

    public ImageDTO mapToDTO(Image entity) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(entity.getId());
        imageDTO.setImageUrl(entity.getImageUrl());
        imageDTO.setName(entity.getName());
        imageDTO.setCreated(entity.getEntryCreationDate().getTime());
        imageDTO.setUpdated(entity.getEntryLastUpdate().getTime());
        imageDTO.setSelf(linkTo(methodOn(ImageController.class).showById(entity.getId())).withSelfRel().getHref());
        imageDTO.setGallery(linkTo(methodOn(GalleryController.class).showById(entity.getGallery().getId())).withRel("gallery").getHref());
        return imageDTO;
    }

    public <T> List<Image> mapToEntityList(List<T> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

    public List<ImageDTO> mapToDTOList(List<Image> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
