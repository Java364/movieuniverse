package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import academy.softserve.movieuniverse.dto.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.ImageService;
import academy.softserve.movieuniverse.service.mapper.ImageMapper;

@RestController
public class ImageController {
	@Autowired
	private ImageService imageService;
	@Autowired
	private ImageMapper imageMapper;
	
	@GetMapping("/images")
	public ResponseEntity<List<ImageDTO>> listAllImages() {
		List<Image> images = imageService.findAll();
		if(images.isEmpty()){
            return new ResponseEntity<List<ImageDTO>>(HttpStatus.NO_CONTENT);
        }
		List<ImageDTO> imageDTOs = imageMapper.mapListEntityToDto(images);
		return new ResponseEntity<List<ImageDTO>>(imageDTOs, HttpStatus.OK);
	}
	
	@PostMapping("/image")
	ResponseEntity<ImageDTO> createImage(@RequestBody ImageDTO imageDTO) {
		Image image = imageMapper. mapToEntityForSave(imageDTO);
		image = imageService.saveImage(image);
		imageDTO = imageMapper.mapToDto(image);
		return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/image/{id}")
	ResponseEntity<ImageDTO> updateImage(@PathVariable("id") Long id, @RequestBody ImageDTO imageDTO) {
		Image image = imageMapper.mapToEntityForUpdate(imageDTO, id);
		image = imageService.updateImage(image);
		imageDTO = imageMapper.mapToDto(image);
		return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
	}
	
	@GetMapping("/image/{id}")
    public ResponseEntity<ImageDTO> showOneImage(@PathVariable Long id) {
		Image image = imageService.findImageById(id);
		ImageDTO imageDTO = imageMapper.mapToDto(image);
        return new ResponseEntity<ImageDTO>(imageDTO, HttpStatus.OK);
    }
	
	@DeleteMapping("/image/{id}")
	public ResponseEntity<String> completelyDeleteImage(@PathVariable Long id) {
		imageService.deleteImage(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
