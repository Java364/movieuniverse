package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.AvatarDTO;
import academy.softserve.movieuniverse.entity.Avatar;
import academy.softserve.movieuniverse.service.AvatarService;
import academy.softserve.movieuniverse.service.mapper.AvatarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/avatar", produces = "application/hal+json")
public class AvatarController {

    private AvatarService service;
    private AvatarMapper mapper;

    @Autowired
    public AvatarController(AvatarService service, AvatarMapper mapper) {
        super();
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<AvatarDTO>> showAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTOList(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvatarDTO> showById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(service.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity completelyDelete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvatarDTO> update(@PathVariable("id") Long id, @RequestBody AvatarDTO avatarDTO) {
        Avatar avatar = mapper.mapToEntity(avatarDTO);
        service.update(avatar, id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(avatar));
    }

}
