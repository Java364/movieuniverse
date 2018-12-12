package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.StarCreateDTO;
import academy.softserve.movieuniverse.entity.Star;

public class StarProfileMapper implements ReversibleDtoMapper<Star, StarCreateDTO> {

	@Override
	public Star mapToEntity(StarCreateDTO dto) {
		Star star = new Star();
		star.setBiography(dto.getBiography());
		star.setBirthday(dto.getBirthday());
		star.setCityOfBirth(dto.getCityOfBirth());
		star.setCountries(dto.getCountries());
		star.setFirstName(dto.getFirstName());
		star.setGallery(dto.getGallery());
		star.setGrowth(dto.getGrowth());
		star.setId(dto.getId());
		star.setLastName(dto.getLastName());
		star.setLinks(dto.getLinks());
		star.setProfessions(dto.getProfessions());
		return star;
	}

	@Override
	public StarCreateDTO mapToDto(Star entity) {
		StarCreateDTO dto = new StarCreateDTO();
		dto.setBiography(entity.getBiography());
		dto.setBirthday(entity.getBirthday());
		dto.setCityOfBirth(entity.getCityOfBirth());
		dto.setCountries(entity.getCountries());
		dto.setFirstName(entity.getFirstName());
		dto.setGallery(entity.getGallery());
		dto.setGrowth(entity.getGrowth());
		dto.setId(entity.getId());
		dto.setLastName(entity.getLastName());
		dto.setLinks(entity.getLinks());
		dto.setProfessions(entity.getProfessions());
		return dto;
	}

}
