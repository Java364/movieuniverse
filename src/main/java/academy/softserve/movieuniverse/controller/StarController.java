package academy.softserve.movieuniverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.StarListDTO;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.StarService;
import academy.softserve.movieuniverse.service.mapper.StarListMapper;

@RestController
@RequestMapping("/star")
public class StarController {
	
	@Autowired
	private StarService service;
	private StarListMapper listMapper = new StarListMapper();
	
	@GetMapping("/list")
	List<StarListDTO> showAllStars() {
		List<Star> stars = service.showAllStars();
		return listMapper.mapListToDto(stars);
	}
	
	@GetMapping("/{id}")
	Optional<Star> showOneStar(@PathVariable("id") Long id) {
		return service.findStarById(id);
	}
	
	@PostMapping("/create")
	ResponseEntity<Star> createStar(@RequestBody Star star) {
		star = service.saveStar(star);
		return new ResponseEntity<Star>(star, HttpStatus.CREATED);
	}
	
//	@PostMapping("/api/trailer")
//	ResponseEntity<TrailerDTO> createTrailer(@RequestBody TrailerDTO trailerDTO) {
//		Trailer trailer = trailerMapper.mapToEntity(trailerDTO);
//		trailer = trailerService.createTrailer(trailer);
//		trailerDTO = trailerMapper.mapToDto(trailer);
//		return new ResponseEntity<TrailerDTO>(trailerDTO, HttpStatus.CREATED);
//	}
}
