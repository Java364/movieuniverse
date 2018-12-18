package academy.softserve.movieuniverse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@Autowired
	private TrailerMapper trailerMapper;
	
	@PostMapping("/trailer")
	ResponseEntity<TrailerDTO> createTrailer(@RequestBody TrailerDTO trailerDTO) {
		Trailer trailer = trailerMapper. mapToEntityForSave(trailerDTO);
		trailer = trailerService.saveTrailer(trailer);
		trailerDTO = trailerMapper.mapToDto(trailer);
		return new ResponseEntity<TrailerDTO>(trailerDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/trailer/{id}")
	ResponseEntity<TrailerDTO> updateTrailer(@PathVariable("id") Long id, @RequestBody TrailerDTO trailerDTO) {
		Trailer trailer = trailerMapper.mapToEntityForUpdate(trailerDTO, id);
		trailer = trailerService.updateTrailer(trailer);
		trailerDTO = trailerMapper.mapToDto(trailer);
		return new ResponseEntity<TrailerDTO>(trailerDTO, HttpStatus.OK);
	}
	
	@GetMapping("/trailers")
	public ResponseEntity<List<TrailerDTO>> listAllTrailers() {
        List<Trailer> trailers = trailerService.findAll();
        if(trailers.isEmpty()){
            return new ResponseEntity<List<TrailerDTO>>(HttpStatus.NO_CONTENT);
        }
        List<TrailerDTO> trailerDTOs = trailerMapper.mapListToDto(trailers);
        return new ResponseEntity<List<TrailerDTO>>(trailerDTOs, HttpStatus.OK);
    }
	
	@GetMapping("/trailer/{id}")
    public ResponseEntity<TrailerDTO> showOneTrailer(@PathVariable Long id) {
		Trailer trailer = trailerService.findTrailerById(id);
		TrailerDTO trailerDTO = trailerMapper.mapToDto(trailer);
        return new ResponseEntity<TrailerDTO>(trailerDTO, HttpStatus.OK);
    }
	
	@DeleteMapping("/trailer/{id}")
	public ResponseEntity<String> completelyDeleteTrailer(@PathVariable Long id) {
		trailerService.deleteTrailer(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
