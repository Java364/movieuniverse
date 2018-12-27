package academy.softserve.movieuniverse.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class HerokuController {
	@RequestMapping("/")
	String index() {
    return "hello";
  }
}
