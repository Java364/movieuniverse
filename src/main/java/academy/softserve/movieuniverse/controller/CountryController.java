package academy.softserve.movieuniverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.repository.CountryRepository;

@RestController
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@PostMapping("/api/country")
	ResponseEntity<Country> createCountry(@RequestBody Country country){
		country = countryRepository.save(country);
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/country/{id}")
	ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Country country = countryRepository.getOne(id);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
}
