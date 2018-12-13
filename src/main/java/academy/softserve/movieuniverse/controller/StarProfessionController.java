//package academy.softserve.movieuniverse.controller;
//
//import academy.softserve.movieuniverse.entity.StarProfession;
//import academy.softserve.movieuniverse.service.StarProfessionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class StarProfessionController {
//
//    private StarProfessionService starProfessionService;
//
//    @Autowired
//    public StarProfessionController(StarProfessionService starProfessionService) {
//        this.starProfessionService = starProfessionService;
//    }
//
//    @GetMapping("/api/starProfession")
//    public List<StarProfession> viewAll() {
//        return starProfessionService.findAllStarProfession();
//    }
//
//    @GetMapping("/api/starProfession/{id}")
//    public StarProfession getStarProfessions(@PathVariable Long id) {
//        return starProfessionService.getStarProfession(id);
//    }
//
//    @DeleteMapping("/api/starProfession")
//    public ResponseEntity completelyDeleteStarProfession(@PathVariable Long id) {
//        starProfessionService.completelyDeleteStarProfession(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//}
