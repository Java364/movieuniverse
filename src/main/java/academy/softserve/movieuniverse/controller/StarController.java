package academy.softserve.movieuniverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.StarService;

@RestController
@RequestMapping("/star")
public class StarController {
	
	@Autowired
	private StarService service;
	
	@GetMapping("/list")
	List<Star> showAllStars() {
		List<Star> stars = service.showAllStars();
		return stars;
	}
	
	@GetMapping("/{id}")
	Optional<Star> showOneStar(@PathVariable("id") Long id) {
		return service.findStarById(id);
	}
}
