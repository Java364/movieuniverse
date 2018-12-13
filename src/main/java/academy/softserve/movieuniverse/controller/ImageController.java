package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import academy.softserve.movieuniverse.dto.ImageDTO;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.service.ImageService;
import academy.softserve.movieuniverse.service.mapper.ImageMapper;

@RestController
public class ImageController {
	@Autowired
	private ImageService imageService;
	private ImageMapper imageMapper = new ImageMapper();
	
	@GetMapping("/api/galleries")
	List<ImageDTO> viewAll() {
		List<Image> images = imageService.findAll();
		return imageMapper.mapListEntityToDto(images);
	}

}
