package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.StarProfessionDTO;
import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.service.StarProfessionService;
import academy.softserve.movieuniverse.mapper.StarProfessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StarProfessionController {

    private StarProfessionService starProfessionService;
    private StarProfessionMapper starProfessionMapper;

    @Autowired
    public StarProfessionController(StarProfessionService starProfessionService,
            StarProfessionMapper starProfessionMapper) {
        this.starProfessionService = starProfessionService;
        this.starProfessionMapper = starProfessionMapper;
    }

    @GetMapping("/starProfession")
    public List<StarProfessionDTO> viewAll() {
        List<StarProfession> allStarProfession = starProfessionService.findAllStarProfession();
        List<StarProfessionDTO> allStarProfessionDTOs = new ArrayList<>();
        for (StarProfession starProfession : allStarProfession) {
            StarProfessionDTO starProfessionDTO = starProfessionMapper.mapToDto(starProfession);
            allStarProfessionDTOs.add(starProfessionDTO);
        }

        return allStarProfessionDTOs;
    }

    @GetMapping("/starProfession/{id}")
    public StarProfessionDTO getStarProfessions(@PathVariable Long id) {
        StarProfession starProfession = starProfessionService.getStarProfession(id);
        StarProfessionDTO starProfessionDTO = starProfessionMapper.mapToDto(starProfession);
        return starProfessionDTO;
    }

    @DeleteMapping("/starProfession")
    public ResponseEntity deleteStarProfession(@RequestParam Long id) {
        starProfessionService.deleteStarProfession(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
