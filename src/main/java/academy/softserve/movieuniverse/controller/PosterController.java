package academy.softserve.movieuniverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.service.PosterService;
import academy.softserve.movieuniverse.service.mapper.PosterMapper;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/posters")
public class PosterController {

	@Autowired
	private PosterService posterService;
	@Autowired
	private PosterMapper posterMapper;

	@PutMapping("/{id}")
	public ResponseEntity<PosterDTO> update(@PathVariable("id") Long id, @RequestBody PosterDTO posterDTO) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(posterMapper.mapToDto(posterService.update(posterMapper.mapToEntityForUpdate(posterDTO, id))));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PosterDTO> showById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(posterMapper.mapToDto(posterService.findById(id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> completelyDelete(@PathVariable Long id) {
		posterService.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
