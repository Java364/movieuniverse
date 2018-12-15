package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.entity.Country;

@Component
public class CountryMapper {

	public Country mapToEntity(CountryDTO dto) {
		Country country = new Country();
		country.setId(dto.getId());
		country.setName(dto.getName());

		return country;
	}

	public CountryDTO mapToDto(Country entity) {
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(entity.getId());
		countryDTO.setName(entity.getName());

		return countryDTO;
	}

	public List<CountryDTO> mapListToDto(List<Country> countries) {
		List<CountryDTO> countryDTOs = new ArrayList<>();
		for (Country c : countries) {
			countryDTOs.add(this.mapToDto(c));
		}

		return countryDTOs;
	}
	
	public List<Country> mapCountriesListToEntity(List<CountryDTO> countryDTOs) {
		List<Country> countries = new ArrayList<>();
		for (CountryDTO c : countryDTOs) {
			countries.add(this.mapToEntity(c));
		}
		return countries;
	}
}
