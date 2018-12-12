package academy.softserve.movieuniverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Country createCountry (Country country) {
		country = countryRepository.save(country);
		
		return country;
	}
	
	public Country getCountry (Long id) {
		
		return countryRepository.getOne(id);
	}
	
	public void deleteCountry(Long id) {
		countryRepository.deleteById(id);
	}
}
