package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.service.CountryService;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.LinksService;
import academy.softserve.movieuniverse.service.StarProfessionService;
import academy.softserve.movieuniverse.service.StarService;

@Component
public class StarMapper {
	
	@Autowired
	private StarService starService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private LinksService linkService;
	@Autowired
	private StarProfessionService starProfessionService;
	@Autowired
	private CountryMapper countryMapper;
	@Autowired 
	private LinksMapper linksMapper;
	@Autowired
	private GalleryMapper galleryMapper;
	@Autowired
	private StarProfessionMapper starProfessionMapper;
	
	public Star mapListToEntity(StarDTO dto) {
		Star star = new Star();
		star.setFirstName(dto.getFirstName());
		star.setLastName(dto.getLastName());
		star.setId(dto.getId());
		star.setIsRemoved(false);
		return star;
	}

	public StarDTO mapListToDto(Star entity) {
		StarDTO dto = new StarDTO();
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setIsRemoved(false);
		dto.setId(entity.getId());
		return dto;
	}
	
	public Star mapCreateToEntity(StarDTO dto) {
		Star star = new Star();
		star.setBiography(dto.getBiography());
		star.setBirthday(dto.getBirthday());
		star.setCityOfBirth(dto.getCityOfBirth());
		star.setCountries(dto.getCountriesIds().stream().map(p -> countryService.findCountryById(p)).collect(Collectors.toList()));
		star.setFirstName(dto.getFirstName());
		if (dto.getGallery() == null || dto.getGallery() == 0) {
			Long id = (long) 1;
			dto.setGallery(id); 
		}
		star.setGallery(galleryService.getGallery(dto.getGallery()));
		star.setGrowth(dto.getGrowth());
		star.setId(dto.getId());
		star.setLastName(dto.getLastName());
		star.setLinks(dto.getLinksIds().stream().map(p -> linkService.getOneLinks(p)).collect(Collectors.toList()));
		return star;
	}

	public StarDTO mapCreateToDto(Star entity) {
		StarDTO dto = new StarDTO();
		dto.setBiography(entity.getBiography());
		dto.setBirthday(entity.getBirthday());
		dto.setCityOfBirth(entity.getCityOfBirth());
		dto.setCountriesIds(entity.getCountries().stream().map(p -> p.getId()).collect(Collectors.toList()));
		dto.setFirstName(entity.getFirstName());
		dto.setGallery(entity.getGallery().getId());
		dto.setGrowth(entity.getGrowth());
		dto.setId(entity.getId());
		dto.setLastName(entity.getLastName());
		dto.setLinksIds(entity.getLinks().stream().map(p -> p.getId()).collect(Collectors.toList()));
		//dto.setProfessions(entity.getProfessions()); //TODO How to add professions
		return dto;
	}
	
//	public Star mapProfileToEntity(StarDTO dto) {
//		Star star = new Star();
//		star.setBiography(dto.getBiography());
//		star.setBirthday(dto.getBirthday());
//		star.setCityOfBirth(dto.getCityOfBirth());
//		star.setFirstName(dto.getFirstName());
//		star.setGallery(galleryMapper.mapToEntity(dto.getGalleryDto()));
//		star.setGrowth(dto.getGrowth());
//		star.setId(dto.getId());
//		star.setLastName(dto.getLastName());
//		star.setCountries(countryMapper.mapCountriesListToEntity(dto.getCountries()));
//		star.setLinks(linksMapper.mapLinksListToEntity(dto.getLinks()));
//		star.setLinks(dto.getLinksIds().stream().map(p -> linkService.getOneLinks(p)).collect(Collectors.toList()));
//		return star;
//	}
	
	public StarDTO mapProfileToDto(Star entity) {
		StarDTO dto = new StarDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setGrowth(entity.getGrowth());
		dto.setBirthday(entity.getBirthday());
		dto.setBiography(entity.getBiography());
		dto.setCityOfBirth(entity.getCityOfBirth());
		dto.setLinks(linksMapper.mapListToDto(entity.getLinks()));
		dto.setLinksIds(entity.getLinks().stream().map(p -> p.getId()).collect(Collectors.toList()));
		dto.setGalleryDto(galleryMapper.mapToDto(entity.getGallery()));
		dto.setGallery(entity.getGallery().getId());
		dto.setCountries(countryMapper.mapListToDto(entity.getCountries()));
		dto.setCountriesIds(entity.getCountries().stream().map(p -> p.getId()).collect(Collectors.toList()));
		dto.setProfessions(starProfessionMapper.mapListEntityToDTO(entity.getProfessions()));
		dto.setProfessionsIds(entity.getProfessions().stream().map(p -> p.getProfession().getId()).collect(Collectors.toList()));
		dto.setActivities(this.mapActivityListsToDto(entity.getRoles())); //TODO edit when StarActivityDTO will be created
		dto.setMoviesIds(entity.getRoles().stream().map(p -> p.getMovie().getId()).collect(Collectors.toList()));

		return dto;
	}
	
	public List<StarDTO> mapListsToDto(List<Star> stars) {
		List<StarDTO> starDTOs = new ArrayList<>();
		for(Star t: stars) {
			starDTOs.add(this.mapListToDto(t));
		}
		return starDTOs;
	}
	
	public List<Star> mapListsToEntity(List<StarDTO> starsDTOs) {
		List<Star> stars = new ArrayList<>();
		for(StarDTO t: starsDTOs) {
			stars.add(this.mapListToEntity(t));
		}
		return stars;
	}
	
	
	//ACTIVITIES
	public List<StarActivityInMoviesDTO> mapActivityListsToDto(List<StarActivityInMovies> stars) {
		List<StarActivityInMoviesDTO> starDTOs = new ArrayList<>();
		for(StarActivityInMovies t: stars) {
			starDTOs.add(this.mapActivityToDto(t));
		}
		return starDTOs;
	}
	
	public StarActivityInMoviesDTO mapActivityToDto(StarActivityInMovies entity) {
		StarActivityInMoviesDTO dto = new StarActivityInMoviesDTO();
		dto.setId(entity.getId());;
		dto.setMovieId(entity.getMovie().getId());
		dto.setStarId(entity.getStar().getId());
		dto.setProfessionIds(entity.getProfessions().stream().map(p -> p.getId()).collect(Collectors.toList()));
		return dto;
	}
	//THE END OF ACTIVITIES
}
