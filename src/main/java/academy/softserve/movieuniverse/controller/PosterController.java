package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;
import academy.softserve.movieuniverse.service.PosterService;
import academy.softserve.movieuniverse.service.mapper.PosterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/poster")
public class PosterController {

    @Autowired
    private PosterService posterService;
    @Autowired
    private PosterMapper posterMapper;

    @PostMapping
    ResponseEntity<PosterDTO> create(@RequestBody PosterDTO posterDTO) {
        Poster poster = posterMapper.mapToEntityForSave(posterDTO);
        poster = posterService.save(poster);
        posterDTO = posterMapper.mapToDto(poster);
        return new ResponseEntity<PosterDTO>(posterDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<PosterDTO> update(@PathVariable("id") Long id, @RequestBody PosterDTO posterDTO) {
        Poster poster = posterMapper.mapToEntityForUpdate(posterDTO, id);
        poster = posterService.update(poster);
        posterDTO = posterMapper.mapToDto(poster);
        return new ResponseEntity<PosterDTO>(posterDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosterDTO> show(@PathVariable Long id) {
        Poster poster = posterService.findById(id);
        return new ResponseEntity<>(posterMapper.mapToDto(poster), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> completelyDelete(@PathVariable Long id) {
        posterService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
