package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.service.TrailerService;
import academy.softserve.movieuniverse.service.mapper.TrailerMapper;

@RestController
public class TrailerController {
	
	@Autowired
	private TrailerService trailerService;
	
	private TrailerMapper trailerMapper = new TrailerMapper();
	
	@PostMapping("/api/trailer")
	ResponseEntity<TrailerDTO> createTrailer(@RequestBody TrailerDTO trailerDTO) {
		Trailer trailer = trailerMapper.mapToEntity(trailerDTO);
		trailer = trailerService.createTrailer(trailer);
		trailerDTO = trailerMapper.mapToDto(trailer);
		return new ResponseEntity<TrailerDTO>(trailerDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/trailers")
	List<TrailerDTO> viewAll() {
		return trailerMapper.mapListToDto(trailerService.findAll());
	}

}
