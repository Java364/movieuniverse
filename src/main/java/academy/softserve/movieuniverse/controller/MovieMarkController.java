package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.moviemark.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.service.MovieMarkService;
import academy.softserve.movieuniverse.service.UserService;
import academy.softserve.movieuniverse.service.mapper.MovieMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movieMark")
public class MovieMarkController {

    @Autowired
    private MovieMarkService movieMarkService;
    @Autowired
    private UserService userService;
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
        return movieMarkMapper.mapToDTOList(movieMarkService.findAll());
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

    @GetMapping("/users/{id}")
    public List<MovieMarkDTO> showAllByUserId(@PathVariable Long id) {
        User user = userService.findById(id);
        return movieMarkMapper.mapToDTOList(movieMarkService.findAllByUser(user));
    }
}
