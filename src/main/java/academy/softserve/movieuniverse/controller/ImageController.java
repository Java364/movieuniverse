package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.ImageService;
import academy.softserve.movieuniverse.service.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageMapper imageMapper;

    @GetMapping("/all")
    public ResponseEntity<List<ImageDTO>> showAll() {
        List<Image> images = imageService.findAll();
        if (images.isEmpty()) {
            return new ResponseEntity<List<ImageDTO>>(HttpStatus.NO_CONTENT);
        }
        List<ImageDTO> imageDTOs = imageMapper.mapListEntityToDto(images);
        return new ResponseEntity<List<ImageDTO>>(imageDTOs, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ImageDTO> create(@RequestBody ImageDTO imageDTO) {
        Image image = imageMapper.mapToEntityForSave(imageDTO);
        image = imageService.save(image);
        imageDTO = imageMapper.mapToDto(image);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<ImageDTO> update(@PathVariable("id") Long id, @RequestBody ImageDTO imageDTO) {
        Image image = imageMapper.mapToEntityForUpdate(imageDTO, id);
        image = imageService.update(image);
        imageDTO = imageMapper.mapToDto(image);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> showById(@PathVariable Long id) {
        Image image = imageService.findById(id);
        ImageDTO imageDTO = imageMapper.mapToDto(image);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        imageService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
