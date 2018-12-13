package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import academy.softserve.movieuniverse.dto.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;

@RestController
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	private GalleryMapper galleryMapper = new GalleryMapper();
	
	@GetMapping("/api/galleries")
	List<GalleryDTO> viewAll() {
		List<Gallery> galleries = galleryService.findAll();
		return galleryMapper.mapListEntityToDto(galleries);
	}

}
