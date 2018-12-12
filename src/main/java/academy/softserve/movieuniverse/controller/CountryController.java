package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.repository.CountryRepository;
import academy.softserve.movieuniverse.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@PostMapping("/api/country")
	ResponseEntity<Country> createCountry(@RequestBody Country country){
		country = countryService.createCountry(country);
		
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/country")
	List<Country> findAllCountry() {
		List<Country> countryList = countryService.findAllCountry();
		
		return countryList;
	}
	
	@GetMapping("/api/country/{id}")
	ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Country country = countryService.findCountryById(id);
		
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
}
