package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.service.ProfessionServise;
import academy.softserve.movieuniverse.mapper.ProfessionMapper;
import academy.softserve.movieuniverse.mapper.StarProfessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profession")
public class ProfessionController {

	@Autowired
	private ProfessionServise professionServise;
	@Autowired
	private ProfessionMapper professionMapper = new ProfessionMapper();
	@Autowired
	private StarProfessionMapper starProfessionMapper;

	@PostMapping
	public ResponseEntity<ProfessionDTO> create(@RequestBody ProfessionDTO professionDTO) {
		Profession profession = professionMapper.mapToEntity(professionDTO);
		professionServise.create(profession);
		return ResponseEntity.status(HttpStatus.OK).body(professionMapper.mapToDto(profession));

	}

	@GetMapping
	public ResponseEntity<List<ProfessionDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(professionMapper.mapListToDto(professionServise.findAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProfessionDTO> showById(@PathVariable Long id) {
		Profession profession = professionServise.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(professionMapper.mapToDto(profession));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		professionServise.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProfessionDTO> update(@PathVariable("id") Long id, @RequestBody ProfessionDTO professionDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(professionMapper
				.mapToDto(professionServise.update(professionMapper.mapToEntityForUpdate(professionDTO, id))));
	}

}
