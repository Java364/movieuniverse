package academy.softserve.movieuniverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.StarCreateDTO;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.dto.StarListDTO;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.StarService;
import academy.softserve.movieuniverse.service.mapper.StarListMapper;
import academy.softserve.movieuniverse.service.mapper.StarProfileMapper;

@RestController
@RequestMapping("/star")
public class StarController {
	
	@Autowired
	private StarService service;
	@Autowired
	private StarListMapper listMapper = new StarListMapper();
	private StarProfileMapper createMapper = new StarProfileMapper();
	
	@GetMapping("/list")
	public List<StarListDTO> showAllStars() {
		List<Star> stars = service.showAllStars();
		return listMapper.mapListToDto(stars);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<StarListDTO> showOneStar(@PathVariable Long id) {
		Star star = service.findStarById(id);
        return new ResponseEntity<>(listMapper.mapToDto(star), HttpStatus.OK);
    }
	
	@PostMapping("/create")
	public ResponseEntity<StarCreateDTO> createStar(@RequestBody StarCreateDTO starDTO) {
		Star star = createMapper.mapToEntity(starDTO);
		service.saveStar(star);
		starDTO = createMapper.mapToDto(star);
		return new ResponseEntity<StarCreateDTO>(starDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<StarCreateDTO> updateStar(@RequestBody StarCreateDTO starDTO, @PathVariable Long id) {
		Star star = createMapper.mapToEntity(starDTO);
		service.saveStar(star);
		starDTO = createMapper.mapToDto(star);
		return new ResponseEntity<StarCreateDTO>(starDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity fullyDeleteStar(@PathVariable Long id) {
		service.fullyDelete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
