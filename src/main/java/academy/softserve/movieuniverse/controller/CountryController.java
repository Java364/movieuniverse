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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.mapper.CountryMapper;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private CountryMapper countryMapper = new CountryMapper();

	@PostMapping("/create")
	ResponseEntity<CountryDTO> create(@RequestBody CountryDTO countryDTO) {
		Country country = countryMapper.mapToEntityForSave(countryDTO);
		country = countryService.create(country);
		countryDTO = countryMapper.mapToDto(country);
		return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	List<CountryDTO> showAll() {
		return countryMapper.mapListToDto(countryService.findAll());
	}

	@GetMapping("/show/{id}")
	ResponseEntity<CountryDTO> showOne(@PathVariable Long id) {
		Country country = countryService.findById(id);
		CountryDTO countryDTO = countryMapper.mapToDto(country);
		return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Country> delete(@PathVariable Long id) {
		countryService.delete(id);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
		Country country = countryMapper.mapToEntityForUpdate(countryDTO, id);
		country = countryService.update(country);
		countryDTO = countryMapper.mapToDto(country);
		return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.OK);
	}
}
