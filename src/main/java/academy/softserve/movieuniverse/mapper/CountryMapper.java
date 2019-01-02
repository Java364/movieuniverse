package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.CountryController;
import academy.softserve.movieuniverse.dto.country.CountryDTO;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryMapper {

    @Autowired
    MovieService movieService;
    @Autowired
    StarService starService;
    @Autowired
    CountryService countryService;

    public Country mapToEntityForSave(CountryDTO dto) {
        Country country = new Country();
        country.setId(dto.getId());
        country.setName(dto.getName());
        return country;
    }

    public Country mapToEntityForUpdate(CountryDTO dto, Long id) {
        Country country = new Country();
        country.setId(id);
        country.setName(dto.getName());
        return country;
    }

    public CountryDTO mapToDto(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setSelf(linkTo(methodOn(CountryController.class).showById(country.getId())).withSelfRel().getHref());
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
            countries.add(this.mapToEntityForSave(c));
        }
        return countries;
    }
}
