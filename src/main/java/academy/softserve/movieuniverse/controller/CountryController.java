package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.mapper.CountryMapper;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	private CountryMapper countryMapper = new CountryMapper();

	@PostMapping("/country")
	ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
		Country country = countryMapper.mapToEntity(countryDTO);
		country = countryService.createCountry(country);
		countryDTO = countryMapper.mapToDto(country);
		return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);
	}

	@GetMapping("/countries")
	List<CountryDTO> findAllCountry() {
		return countryMapper.mapListToDto(countryService.findAllCountry());
	}

	@DeleteMapping("/country/{id}")
	ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
		countryService.deleteCountry(id);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}
	
	@PutMapping("/country/{id}")
	ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO countryDTO) {
		Country country = countryMapper.mapToEntity(countryDTO);
		country = countryService.updateCountry(country);
		countryDTO = countryMapper.mapToDto(country);
		return new ResponseEntity<CountryDTO>(countryDTO,HttpStatus.OK);
	}
}
