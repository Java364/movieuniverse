package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.service.ProfessionServise;
import academy.softserve.movieuniverse.service.mapper.ProfessionMapper;
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
    private ProfessionServise professionServise;
    @Autowired
    private ProfessionMapper professionMapper = new ProfessionMapper();

    @PostMapping("/createProfession")
    ResponseEntity<ProfessionDTO> createProfession(@RequestBody ProfessionDTO professionDTO) {
        Profession profession = professionMapper.mapProfessionToEntity(professionDTO);
        professionServise.saveProfession(profession);
        professionDTO = professionMapper.mapToDto(profession);
        return new ResponseEntity<ProfessionDTO>(professionDTO, HttpStatus.CREATED);

    }

    @GetMapping("/listAll")
    public List<ProfessionDTO> findAllProfession() {
        List<Profession> professionList = professionServise.findAll();
        return professionMapper.mapListProfessionToDto(professionList);
    }


    @GetMapping("/profession/{id}")
    public ResponseEntity<ProfessionDTO> getOneProfession(@PathVariable Long id) {
        Profession profession = professionServise.getOneProfession(id);
        return new ResponseEntity<ProfessionDTO>(professionMapper.mapToDto(profession), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProfession(@PathVariable Long id) {
        professionServise.deleteProfession(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/profession/{id}")
    ResponseEntity<ProfessionDTO> updateProfession(@PathVariable("id") Long id, @RequestBody ProfessionDTO professionDTO) {
        Profession professions = professionMapper.mapToEntityForUpdateProfession(professionDTO, id);
        professions = professionServise.updateProfession(professions);
        professionDTO = professionMapper.mapToDto(professions);
        return new ResponseEntity<ProfessionDTO>(professionDTO, HttpStatus.OK);
    }
}
