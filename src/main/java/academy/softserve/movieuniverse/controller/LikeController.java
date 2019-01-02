package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.like.LikeDTO;
import academy.softserve.movieuniverse.dto.like.LikeFullInfo;
import academy.softserve.movieuniverse.entity.Like;
import academy.softserve.movieuniverse.service.LikeService;
import academy.softserve.movieuniverse.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;
    @Autowired
    private LikeMapper likeMapper;

    @GetMapping("/all")
    public ResponseEntity<Resources<LikeDTO>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new Resources<>(likeMapper.mapListToDto(likeService.findAll()),
                linkTo(methodOn(LikeController.class).showAll()).withSelfRel()));
    }

    @PostMapping
    ResponseEntity<LikeFullInfo> create(@RequestBody LikeDTO likeDTO) {
        Like like = likeMapper.mapToEntityForSave(likeDTO);
        like = likeService.save(like);
        likeDTO = likeMapper.mapToDto(like);
        return new ResponseEntity<LikeFullInfo>(likeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<LikeDTO> update(@PathVariable("id") Long id, @RequestBody LikeDTO likeDTO) {
        Like like = likeMapper.mapToEntityForUpdate(likeDTO, id);
        like = likeService.update(like);
        likeDTO = likeMapper.mapToDto(like);
        return new ResponseEntity<LikeDTO>(likeDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDTO> showById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(likeMapper.mapToDto(likeService.findById(id)));
    }

    @DeleteMapping("/like/{id}")
    public ResponseEntity<String> completelyDelete(@PathVariable Long id) {
        likeService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}