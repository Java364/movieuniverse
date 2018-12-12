package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import academy.softserve.movieuniverse.dto.StarListDTO;
import academy.softserve.movieuniverse.entity.Star;

public class StarListMapper implements ReversableDtoMapper<Star, StarListDTO>{

	@Override
	public Star mapToEntity(StarListDTO dto) {
		Star star = new Star();
		star.setFirstName(dto.getFirstName());
		star.setLastName(dto.getLastName());
		star.setId(dto.getId());
		star.setIsRemoved(false);
		return star;
	}

	@Override
	public StarListDTO mapToDto(Star entity) {
		StarListDTO dto = new StarListDTO();
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setIsRemoved(false);
		dto.setId(entity.getId());
		return dto;
	}
	
	public List<StarListDTO> mapListToDto(List<Star> stars) {
		List<StarListDTO> starDTOs = new ArrayList<>();
		for(Star t: stars) {
			starDTOs.add(this.mapToDto(t));
		}
		return starDTOs;
	}

}
