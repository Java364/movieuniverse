package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.service.StarProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarProfessionController {
    @Autowired
    private StarProfessionService starProfessionService;

    @GetMapping("/api/starProfession")
    List<StarProfession> viewAll() {
        return starProfessionService.findAllStarProfession();
    }

}
