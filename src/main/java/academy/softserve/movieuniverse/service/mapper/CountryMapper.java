package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryMapper implements ReversibleDtoMapper<Country, CountryDTO> {

	@Override
	public Country mapToEntity(CountryDTO dto) {
		Country country = new Country();
		country.setId(dto.getId());
		country.setName(dto.getName());
		country.setIsRemoved(false);
		
		return country;
	}

	@Override
	public CountryDTO mapToDto(Country entity) {
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(entity.getId());
		countryDTO.setName(entity.getName());
		
		return countryDTO;
	}
	
	public List<CountryDTO> mapListToDto (List<Country> countries) {
		List<CountryDTO> countryDTOs = new ArrayList<>();
		for(Country c : countries) {
			countryDTOs.add(this.mapToDto(c));
		}
		
		return countryDTOs;
	}
	
}
