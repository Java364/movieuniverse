package academy.softserve.movieuniverse.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.controller.hateoas.StarResourceAssembler;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.dto.StarProfessionDTO;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.service.StarProfessionService;
import academy.softserve.movieuniverse.service.StarService;
import academy.softserve.movieuniverse.service.mapper.StarMapper;
import academy.softserve.movieuniverse.service.mapper.StarProfessionMapper;

@RestController
@RequestMapping("/star")
public class StarController {
	
	@Autowired
	private StarService service;
	@Autowired
	private StarProfessionService starProfessionService;
	@Autowired
	private StarMapper mapper;
	@Autowired
	private StarProfessionMapper starProfessionMapper;
	@Autowired
	private StarResourceAssembler essembler;
	
	@GetMapping("/list")
	public ResponseEntity<Resources<Resource<StarDTO>>> showAll() {
		List<Resource<StarDTO>> resources = mapper.mapListsToDto(service.showAllStars()).stream().map(essembler::toResource).collect(Collectors.toList());
		return new ResponseEntity<>(new Resources<>(resources), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Resource<StarDTO>> showOne(@PathVariable Long id) {
		Star star = service.findStarById(id);
		Resource<StarDTO> resource = essembler.toResource(mapper.mapProfileToDto(star));
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
	
	@PostMapping("/create")
	public ResponseEntity<StarDTO> create(@RequestBody StarDTO starDTO) {
		Star star = mapper.mapCreateToEntity(starDTO);
		service.create(star);
		starDTO = mapper.mapCreateToDto(star);
		return new ResponseEntity<StarDTO>(starDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<StarDTO> update(@RequestBody StarDTO starDTO, @PathVariable Long id) {
		Star star = mapper.mapCreateToEntity(starDTO);
		service.update(star, id);
		starDTO = mapper.mapCreateToDto(star);
		return new ResponseEntity<StarDTO>(starDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}/create-profession")
	public ResponseEntity<StarProfessionDTO> createProfession(@RequestBody StarProfessionDTO starProfessionDTO, @PathVariable("id") Long starId) {
		StarProfession starProfession = starProfessionMapper.mapToEntity(starProfessionDTO);
		starProfessionService.createStarProfession(starProfession, starId);
		starProfessionDTO = starProfessionMapper.mapToDto(starProfession);
		return new ResponseEntity<StarProfessionDTO>(starProfessionDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> completelyDelete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PatchMapping("/remove/{id}")
	public ResponseEntity<StarDTO> remove(@PathVariable Long id) {
		service.remove(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PatchMapping("/make-active/{id}")
	public ResponseEntity<StarDTO> makeActive(@PathVariable Long id) {
		service.makeActive(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
