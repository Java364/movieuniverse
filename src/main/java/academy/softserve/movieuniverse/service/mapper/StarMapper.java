package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.dto.CountryDTO;
import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Star;
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
	//@Autowired 
	private LinksMapper linksMapper;
	//@Autowired
	private GalleryMapper galleryMapper;
	
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
		star.setGallery(galleryService.getGallery(dto.getGallery()));
		star.setGrowth(dto.getGrowth());
		star.setId(dto.getId());
		star.setLastName(dto.getLastName());
//		Long id = (long) 1;
//		Links link = linkService.getOneLinks(id);
//		List<Links> links = new ArrayList<Links>();
//		links.add(link);
//		star.setLinks(links);
		star.setLinks(dto.getLinksIds().stream().map(p -> linkService.getOneLinks(p)).collect(Collectors.toList()));
		//star.setProfessions(
		//dto.getProfessions().stream.map(p -> starProfessionService.);
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
		//dto.setProfessions(entity.getProfessions());
		return dto;
	}
	
	public Star mapProfileToEntity(StarDTO dto) {
		Star star = new Star();
		star.setBiography(dto.getBiography());
		star.setBirthday(dto.getBirthday());
		star.setCityOfBirth(dto.getCityOfBirth());
		star.setFirstName(dto.getFirstName());
		star.setGallery(galleryMapper.mapToEntity(dto.getGalleryDto()));
		star.setGrowth(dto.getGrowth());
		star.setId(dto.getId());
		star.setLastName(dto.getLastName());
		star.setCountries(this.mapCountriesListToEntity(dto.getCountries()));
		star.setLinks(this.mapLinksListToEntity(dto.getLinks()));
		
		return star;
	}
	
	public StarDTO mapProfileToDto(Star entity) {
		StarDTO dto = new StarDTO();
		dto.setBiography(entity.getBiography());
		dto.setBirthday(entity.getBirthday());
		dto.setCityOfBirth(entity.getCityOfBirth());
		dto.setFirstName(entity.getFirstName());
		dto.setGalleryDto(galleryMapper.mapToDto(entity.getGallery()));
		dto.setGrowth(entity.getGrowth());
		dto.setId(entity.getId());
		dto.setLastName(entity.getLastName());
		dto.setCountries(countryMapper.mapListToDto(entity.getCountries()));
		dto.setLinks(linksMapper.mapListToDto(entity.getLinks()));
		//dto.setActivities(activities); //TODO activities
		return dto;
	}
	
	public List<StarDTO> mapListsToDto(List<Star> stars) {
		List<StarDTO> starDTOs = new ArrayList<>();
		for(Star t: stars) {
			starDTOs.add(this.mapListToDto(t));
		}
		return starDTOs;
	}
	
	 public List<Links> mapLinksListToEntity(List<LinksDTO> linkDTOs) {
	        List<Links> links = new ArrayList<>();
	        for (LinksDTO l : linkDTOs) {
	        	links.add(linksMapper.mapToEntity(l));
	        }
	        return links;
	    }
	 
	public List<Country> mapCountriesListToEntity(List<CountryDTO> countryDTOs) {
		List<Country> countries = new ArrayList<>();
		for (CountryDTO c : countryDTOs) {
			countries.add(countryMapper.mapToEntity(c));
		}
		return countries;
	}
	
}
