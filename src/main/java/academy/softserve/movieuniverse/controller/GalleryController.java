package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.ImageService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/galleries", produces = "application/hal+json")
public class GalleryController {

    private final GalleryService galleryService;
    private final GalleryMapper galleryMapper;
    private final ImageService imageService;

    @Autowired
    public GalleryController(GalleryService galleryService, GalleryMapper galleryMapper, ImageService imageService) {
        this.galleryService = galleryService;
        this.galleryMapper = galleryMapper;
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<List<GalleryDTO>> showAll() {
        List<Gallery> galleries = galleryService.findAll();
        if (galleries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<GalleryDTO> galleryDTOs = galleryMapper.mapListEntityToDto(galleries);
        return new ResponseEntity<>(galleryDTOs, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<GalleryDTO> create(@RequestBody GalleryDTO galleryDTO) {
        Gallery gallery = galleryMapper.mapToEntityForSave(galleryDTO);
        gallery = galleryService.save(gallery);
        galleryDTO = galleryMapper.mapToDto(gallery);
        return new ResponseEntity<>(galleryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<GalleryDTO> update(@PathVariable("id") Long id, @RequestBody GalleryDTO galleryDTO) {
        Gallery gallery = galleryMapper.mapToEntityForUpdate(galleryDTO, id);
        gallery = galleryService.update(gallery);
        galleryDTO = galleryMapper.mapToDto(gallery);
        return new ResponseEntity<>(galleryDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GalleryDTO> showById(@PathVariable Long id) {
        Gallery gallery = galleryService.findById(id);
        GalleryDTO galleryDTO = galleryMapper.mapToDto(gallery);
        return new ResponseEntity<>(galleryDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity completelyDelete(@PathVariable Long id) {

        galleryService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/{id}/")
    public Gallery showByImage(Long id) {
        Gallery byImage = galleryService.findByImage(imageService.findById(id));
        return byImage;
    }
}
