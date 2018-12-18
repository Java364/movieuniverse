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
import academy.softserve.movieuniverse.dto.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;

@RestController
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private GalleryMapper galleryMapper;
	
	@GetMapping("/galleries")
	public ResponseEntity<List<GalleryDTO>> listAllGalleries() {
		List<Gallery> galleries = galleryService.findAll();
		if(galleries.isEmpty()){
            return new ResponseEntity<List<GalleryDTO>>(HttpStatus.NO_CONTENT);
        }
		List<GalleryDTO> galleryDTOs = galleryMapper.mapListEntityToDto(galleries);
		return new ResponseEntity<List<GalleryDTO>>(galleryDTOs, HttpStatus.OK);
	}
	
	@PostMapping("/gallery")
	ResponseEntity<GalleryDTO> createGallery(@RequestBody GalleryDTO galleryDTO) {
		Gallery gallery = galleryMapper. mapToEntityForSave(galleryDTO);
		gallery = galleryService.saveGallery(gallery);
		galleryDTO = galleryMapper.mapToDto(gallery);
		return new ResponseEntity<GalleryDTO>(galleryDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/gallery/{id}")
	ResponseEntity<GalleryDTO> updateGallery(@PathVariable("id") Long id, @RequestBody GalleryDTO galleryDTO) {
		Gallery gallery = galleryMapper.mapToEntityForUpdate(galleryDTO, id);
		gallery = galleryService.updateGallery(gallery);
		galleryDTO = galleryMapper.mapToDto(gallery);
		return new ResponseEntity<GalleryDTO>(galleryDTO, HttpStatus.OK);
	}
	
	@GetMapping("/gallery/{id}")
    public ResponseEntity<GalleryDTO> showOneGallery(@PathVariable Long id) {
		Gallery gallery = galleryService.findGalleryById(id);
		GalleryDTO galleryDTO = galleryMapper.mapToDto(gallery);
        return new ResponseEntity<GalleryDTO>(galleryDTO, HttpStatus.OK);
    }
	
	@DeleteMapping("/gallery/{id}")
	public ResponseEntity<String> completelyDeleteGallery(@PathVariable Long id) {
		galleryService.deleteGallery(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
