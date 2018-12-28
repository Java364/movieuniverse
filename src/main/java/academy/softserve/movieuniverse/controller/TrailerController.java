package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.trailer.CreateTrailerInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;
import academy.softserve.movieuniverse.service.TrailerService;
import academy.softserve.movieuniverse.service.mapper.TrailerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trailers")
public class TrailerController {

    private final TrailerService trailerService;
    private final TrailerMapper trailerMapper;

    @Autowired
    public TrailerController(TrailerService trailerService, TrailerMapper trailerMapper) {
        this.trailerService = trailerService;
        this.trailerMapper = trailerMapper;
    }

    @PutMapping("/{id}")
    ResponseEntity<TrailerDTO> update(@PathVariable("id") Long id, @RequestBody CreateTrailerInfo trailerDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(trailerMapper.mapToDTO(trailerService.update(trailerMapper.mapToEntity(trailerDTO), id)));
    }

    @GetMapping
    public ResponseEntity<List<TrailerDTO>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(trailerMapper.maptoDTOList(trailerService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrailerDTO> showById(@PathVariable Long id) {
        Trailer trailer = trailerService.findById(id);
        TrailerDTO trailerDTO = trailerMapper.mapToDTO(trailer);
        return ResponseEntity.status(HttpStatus.OK).body(trailerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity completelyDelete(@PathVariable Long id) {
        trailerService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
