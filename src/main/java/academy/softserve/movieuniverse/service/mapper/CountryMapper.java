package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.MovieService;
import academy.softserve.movieuniverse.service.StarService;

import org.springframework.stereotype.Service;

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
			countries.add(this.mapToEntityForSave(c));
		}
		return countries;
	}

	public List<Movie> mapListIdsToMovies(List<Long> movieIds) {
		List<Movie> movies = new ArrayList<>();
		for (Long l : movieIds) {
			movies.add(movieService.findMovieById(l));
		}
		return movies;
	}

	public List<Long> mapMovieToIds(List<Movie> movies) {
		List<Long> movieIds = new ArrayList<>();
		for (Movie movie : movies) {
			movieIds.add(movie.getId());
		}
		return movieIds;
	}

	public List<Long> mapStarsToIds(List<Star> stars) {
		List<Long> starIds = new ArrayList<>();
		for (Star star : stars) {
			starIds.add(star.getId());
		}
		return starIds;
	}

	public List<Star> mapListIdsToStar(List<Long> starIds) {
		List<Star> stars = new ArrayList<>();
		for (Long l : starIds) {
			System.out.println(l);
			Star star = starService.findStarById(l);
			System.out.println(star.getId());
			stars.add(starService.findStarById(l));
		}
		return stars;
	}
}
