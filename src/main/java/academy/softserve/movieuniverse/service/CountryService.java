package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.exception.CountryException;
import academy.softserve.movieuniverse.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public Country createCountry(Country country) {
		if (country == null)
			throw CountryException.createSaveException("Cant save country", new Exception());
		return countryRepository.save(country);
	}

	@Transactional
	public Country updateCountry(Country country) {
		Optional<Country> countryOptional = countryRepository.findById(country.getId());
		if (country == null || country.getId() == null || !countryOptional.isPresent()) {
			throw CountryException.createUpdateException("No such country to update", new Exception());
		}
		country = countryRepository.save(country);
		if (country == null) {
			throw CountryException.createUpdateException("Cant update country", new Exception());
		}
		return country;
	}

	public List<Country> findAllCountry() {
		return countryRepository.findAll();
	}

	public Country findCountryById(Long id) {
		Optional<Country> countryOptional = countryRepository.findById(id);
		if (!countryOptional.isPresent()) {
			throw CountryException.createSelectException("No such country", new Exception());
		}
		Country country = countryOptional.get();
		return country;
	}

	@Transactional
	public void deleteCountry(Long id) {
		Optional<Country> countryOptional = countryRepository.findById(id);
		if (id == null || !countryOptional.isPresent()) {
			throw CountryException.createDeleteException("No such country to delete", new Exception());
		}
		countryRepository.deleteById(id);
	}
}
