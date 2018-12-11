package academy.softserve.movieuniverse.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RestController
public class MainController {
	
	private static Logger logger = LogManager.getLogger();
	
	@GetMapping("/hi")
	public String mainPage(){
		logger.error("I am error!!!");
		return "HelloWorld";
	}

}
