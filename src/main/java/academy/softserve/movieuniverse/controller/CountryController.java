package academy.softserve.movieuniverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/api/country")
	ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO){
		Country country = countryMapper.mapToEntity(countryDTO);
		country = countryService.createCountry(country);
		countryDTO = countryMapper.mapToDto(country);
		
		return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/api/country")
	List<CountryDTO> findAllCountry() {
		
		return countryMapper.mapListToDto(countryService.findAllCountry());
	}
}
