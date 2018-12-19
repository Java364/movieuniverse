package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.exception.CountryException;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public Country create(Country country) {
		if (country == null)
			throw CountryException.createSaveException(ExceptionType.SAVE.getMessage() + " country");
		return countryRepository.save(country);
	}

	@Transactional
	public Country update(Country country) {
		Optional<Country> countryOptional = countryRepository.findById(country.getId());
		if (country == null || country.getId() == null || !countryOptional.isPresent()) {
			throw CountryException.createUpdateException(ExceptionType.UPDATE.getMessage() + " country");
		}
		country = countryRepository.save(country);
		if (country == null) {
			throw CountryException.createUpdateException(ExceptionType.UPDATE.getMessage() + " country");
		}
		return country;
	}

	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	public Country findById(Long id) {
		Optional<Country> countryOptional = countryRepository.findById(id);
		if (!countryOptional.isPresent()) {
			throw CountryException
					.createSelectException(ExceptionType.SELECT.getMessage() + "country with " + id.toString() + " ID");
		}
		Country country = countryOptional.get();
		return country;
	}

	@Transactional
	public void delete(Long id) {
		Optional<Country> countryOptional = countryRepository.findById(id);
		if (id == null || !countryOptional.isPresent()) {
			throw CountryException
					.createDeleteException(ExceptionType.DELETE.getMessage() + "country with " + id.toString() + " ID");
		}
		countryRepository.deleteById(id);
	}
}
