package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.mapper.ProfessionMapper;
import academy.softserve.movieuniverse.mapper.StarProfessionMapper;
import academy.softserve.movieuniverse.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;
    @Autowired
    private ProfessionMapper professionMapper = new ProfessionMapper();
    @Autowired
    private StarProfessionMapper starProfessionMapper;

    @PostMapping
    public ResponseEntity<ProfessionDTO> create(@RequestBody ProfessionDTO professionDTO) {
        Profession profession = professionMapper.mapToEntity(professionDTO);
        professionService.create(profession);
        return ResponseEntity.status(HttpStatus.OK).body(professionMapper.mapToDto(profession));

    }

    @GetMapping
    public ResponseEntity<List<ProfessionDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professionMapper.mapListToDto(professionService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionDTO> showById(@PathVariable Long id) {
        Profession profession = professionService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(professionMapper.mapToDto(profession));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professionService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionDTO> update(@PathVariable("id") Long id, @RequestBody ProfessionDTO professionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(professionMapper
                .mapToDto(professionService.update(professionMapper.mapToEntityForUpdate(professionDTO, id))));
    }

}
