package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.service.StarProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarActivityInMoviesController {

    private StarProfessionService starProfessionService;

    @Autowired
    public StarActivityInMoviesController(StarProfessionService starProfessionService) {
        this.starProfessionService = starProfessionService;
    }


}
