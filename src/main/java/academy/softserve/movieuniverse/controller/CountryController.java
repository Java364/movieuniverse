package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.country.CountryDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private CountryMapper countryMapper = new CountryMapper();

	@PostMapping
	public ResponseEntity<CountryDTO> create(@RequestBody CountryDTO countryDTO) {
		Country country = countryMapper.mapToEntityForSave(countryDTO);
		country = countryService.create(country);
		return ResponseEntity.status(HttpStatus.CREATED).body(countryMapper.mapToDto(country));
	}

	@GetMapping
	public ResponseEntity<List<CountryDTO>> showAll() {
		return ResponseEntity.status(HttpStatus.OK).body(countryMapper.mapListToDto(countryService.findAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CountryDTO> showById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(countryMapper.mapToDto(countryService.findById(id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		countryService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
		Country country = countryMapper.mapToEntityForUpdate(countryDTO, id);
		country = countryService.update(country);
		countryDTO = countryMapper.mapToDto(country);
		return ResponseEntity.status(HttpStatus.OK).body(countryMapper.mapToDto(countryService.update(country)));
	}
}
