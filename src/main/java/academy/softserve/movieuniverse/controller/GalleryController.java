package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.dto.image.ImageCreateInfo;
import academy.softserve.movieuniverse.dto.image.ImageDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.ImageService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;
import academy.softserve.movieuniverse.service.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/gallery", produces = "application/hal+json")
public class GalleryController {

    private final GalleryService galleryService;
    private final GalleryMapper galleryMapper;
    private final ImageMapper imageMapper;
    private final ImageService imageService;

    @Autowired
    public GalleryController(GalleryService galleryService, GalleryMapper galleryMapper, ImageService imageService,
            ImageMapper imageMapper) {
        this.galleryService = galleryService;
        this.galleryMapper = galleryMapper;
        this.imageService = imageService;
        this.imageMapper = imageMapper;
    }

    @GetMapping
    public ResponseEntity<List<GalleryDTO>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(galleryMapper.mapToDTOList(galleryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GalleryDTO> showById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(galleryMapper.mapToDTO(galleryService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity completelyDelete(@PathVariable Long id) {

        galleryService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<List<ImageDTO>> showImagesByGalleryId(@PathVariable Long id) {
        Gallery gallery = galleryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(imageMapper.mapToDTOList(gallery.getImages()));
    }

    @PostMapping("/{id}/images")
    public ResponseEntity<ImageDTO> createImage(@PathVariable Long id, @RequestBody ImageDTO imageDTO) {
        Image image = imageMapper.mapToEntity(imageDTO);
        image.setGallery(galleryService.findById(id));
        return ResponseEntity.status(HttpStatus.CREATED).body(imageMapper.mapToDTO(imageService.save(image)));
    }
}
