package academy.softserve.movieuniverse.controller;

import java.util.List;

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

import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.service.MovieMarkService;
import academy.softserve.movieuniverse.service.mapper.MovieMarkMapper;

@RestController
@CrossOrigin
@RequestMapping("/movieMark")
public class MovieMarkController {

	@Autowired
	private MovieMarkService movieMarkService;
	@Autowired
	private MovieMarkMapper movieMarkMapper;

	@PostMapping("/create")
	ResponseEntity<MovieMarkDTO> create(@RequestBody MovieMarkDTO movieMarkDTO) {
		MovieMark movieMark = movieMarkMapper.mapToEntityForSave(movieMarkDTO);
		movieMark = movieMarkService.create(movieMark);
		movieMarkDTO = movieMarkMapper.mapToDto(movieMark);
		return new ResponseEntity<MovieMarkDTO>(movieMarkDTO, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	List<MovieMarkDTO> showAll() {
		return movieMarkMapper.mapListToDto(movieMarkService.findAll());
	}

	@GetMapping("/show/{id}")
	ResponseEntity<MovieMarkDTO> findById(@PathVariable Long id) {
		MovieMark movieMark = movieMarkService.findById(id);
		MovieMarkDTO movieMarkDTO = movieMarkMapper.mapToDto(movieMark);
		return new ResponseEntity<MovieMarkDTO>(movieMarkDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	ResponseEntity<MovieMarkDTO> update(@RequestBody MovieMarkDTO movieMarkDto, @PathVariable Long id) {
		MovieMark movieMark = movieMarkMapper.mapToEntityForUpdate(movieMarkDto, id);
		movieMark = movieMarkService.update(movieMark);
		movieMarkDto = movieMarkMapper.mapToDto(movieMark);
		return new ResponseEntity<MovieMarkDTO>(movieMarkDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id) {
		movieMarkService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
