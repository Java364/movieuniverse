package academy.softserve.movieuniverse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.service.PosterService;
import academy.softserve.movieuniverse.service.mapper.PosterMapper;

@RestController
public class PosterController {
	@Autowired
	private PosterService posterService;
	private PosterMapper posterMapper = new PosterMapper();
	
	@PostMapping("/api/poster")
	ResponseEntity<PosterDTO> createPoster(@RequestBody PosterDTO posterDTO) {
		Poster poster = posterMapper.mapToEntity(posterDTO);
		poster = posterService.createPoster(poster);
		posterDTO = posterMapper.mapToDto(poster);
		return new ResponseEntity<PosterDTO>(posterDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("api/poster/{id}")
	Optional<Poster> showPoster(@PathVariable("id") Long id) {
		return posterService.findPosterById(id);
	}

}
