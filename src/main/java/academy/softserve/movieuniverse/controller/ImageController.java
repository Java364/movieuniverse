package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.image.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.ImageService;
import academy.softserve.movieuniverse.service.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/galleries/{galleryId}/images/", produces = "application/hal+json")
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;
    private final GalleryService galleryService;

    @Autowired
     public ImageController(ImageService imageService, ImageMapper imageMapper, GalleryService galleryService) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;
        this.galleryService = galleryService;
    }

    @GetMapping
    public ResponseEntity<List<ImageDTO>> showAll(@PathVariable Long galleryId) {
        List<Image> images = imageService.findAll(galleryService.findById(galleryId));
        if (images.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<ImageDTO> imageDTOs = imageMapper.mapListEntityToDto(images, galleryId);
        return new ResponseEntity<>(imageDTOs, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ImageDTO> create(@RequestBody ImageDTO imageDTO, @PathVariable Long galleryId) {
        Image image = imageMapper.mapToEntity(imageDTO);
        image.setGallery(galleryService.findById(galleryId));
        image = imageService.save(image);
        imageDTO = imageMapper.mapToDto(image, galleryId);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{imageId}")
    ResponseEntity<ImageDTO> update(@PathVariable Long imageId, @RequestBody ImageDTO imageDTO, @PathVariable Long galleryId) {
        Image image = imageMapper.mapToEntity(imageDTO);
        image = imageService.update(image);
        imageDTO = imageMapper.mapToDto(image, galleryId);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<ImageDTO> showById(@PathVariable Long imageId, @PathVariable Long galleryId) {
        Image image = imageService.findById(imageId);
        ImageDTO imageDTO = imageMapper.mapToDto(image, galleryId);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<String> completelyDeleteImage(@PathVariable Long imageId, @PathVariable Long galleryId) {
        imageService.delete(imageId);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
