package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.GalleryController;
import academy.softserve.movieuniverse.controller.ImageController;
import academy.softserve.movieuniverse.dto.image.ImageCreateInfo;
import academy.softserve.movieuniverse.dto.image.ImageDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class ImageMapper {

    @Autowired
    public ImageMapper() {

    }


    public Image mapToEntity(ImageCreateInfo imageDTO) {
        Image image = new Image();
        image.setImageUrl(imageDTO.getImageUrl());
        image.setName(imageDTO.getName());
        return image;
    }

    public ImageDTO mapToDto(Image entity, Long galleryId) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageUrl(entity.getImageUrl());
        imageDTO.setName(entity.getName());
        imageDTO.add(linkTo(methodOn(ImageController.class).showById(entity.getId(), galleryId)).withSelfRel());
        imageDTO.add(linkTo(methodOn(GalleryController.class).showById(galleryId)).withRel("gallery"));
        return imageDTO;
    }

    public List<ImageDTO> mapListEntityToDto(List<Image> images, Long galleryId) {
        return images.stream().map((Image entity) -> mapToDto(entity, galleryId)).collect(Collectors.toList());
    }

    public List<Image> mapListDtoToEntity(List<ImageDTO> imageDTOs) {
        return imageDTOs.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

}
