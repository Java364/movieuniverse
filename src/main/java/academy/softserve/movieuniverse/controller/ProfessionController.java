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

@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionServise professionServise;
    @Autowired
    private ProfessionMapper professionMapper = new ProfessionMapper();

    @PostMapping("/api/createProfession")
    ResponseEntity<ProfessionDTO> createProfession(@RequestBody ProfessionDTO professionDTO) {
        Profession profession = professionMapper.mapToEntity(professionDTO);
        professionServise.saveProfession(profession);
        professionDTO = professionMapper.mapToDto(profession);
        return new ResponseEntity<ProfessionDTO>(professionDTO, HttpStatus.CREATED);

    }
    @GetMapping("/api/listAll")
    public List<ProfessionDTO> findAllProfession() {
        List<Profession> professionList = professionServise.findAll();
        return professionMapper.mapListToDto(professionList);
    }


    @GetMapping("/api/profession/{id}")
    public ResponseEntity<ProfessionDTO> getOneProfession(@PathVariable Long id) {
        Profession profession = professionServise.getOneProfession(id);
        return new ResponseEntity<ProfessionDTO>(professionMapper.mapToDto(profession), HttpStatus.OK);
    }
}
