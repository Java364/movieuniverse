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
@RequestMapping("/poster")
public class PosterController {
	@Autowired
	private PosterService posterService;
	@Autowired
	private PosterMapper posterMapper;

	@PostMapping("/create")
	ResponseEntity<PosterDTO> createPoster(@RequestBody PosterDTO posterDTO) {
		Poster poster = posterMapper.mapToEntity(posterDTO);
		poster = posterService.savePoster(poster);
		posterDTO = posterMapper.mapToDto(poster);
		return new ResponseEntity<PosterDTO>(posterDTO, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	ResponseEntity<PosterDTO> updatePoster(@PathVariable("id") Long id, @RequestBody PosterDTO posterDTO) {
		Poster poster = posterMapper.mapToEntityForUpdate(posterDTO, id);
		poster = posterService.updatePoster(poster);
		posterDTO = posterMapper.mapToDto(poster);
		return new ResponseEntity<PosterDTO>(posterDTO, HttpStatus.OK);
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<PosterDTO> showPoster(@PathVariable Long id) {
		Poster poster = posterService.findPosterById(id);
		return new ResponseEntity<>(posterMapper.mapToDto(poster), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> fullyDeletePoster(@PathVariable Long id) {
		posterService.deletePoster(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
