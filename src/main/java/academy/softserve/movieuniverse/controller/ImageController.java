package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.image.ImageCreateInfo;
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
@RequestMapping(value = "/images/", produces = "application/hal+json")
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @Autowired
    public ImageController(ImageService imageService, ImageMapper imageMapper, GalleryService galleryService) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;
    }

    @GetMapping
    public ResponseEntity<List<ImageDTO>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(imageMapper.mapToDTOList(imageService.findAll()));
    }

    @PutMapping("/{id}")
    ResponseEntity<ImageDTO> update(@PathVariable Long id, @RequestBody ImageCreateInfo imageDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageMapper.mapToDTO(imageService.update(imageMapper.mapToEntity(imageDTO), id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> showById(@PathVariable Long id) {
        Image image = imageService.findById(id);
        ImageDTO imageDTO = imageMapper.mapToDTO(image);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> completelyDeleteImage(@PathVariable Long imageId, @PathVariable Long galleryId) {
        imageService.delete(imageId);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
