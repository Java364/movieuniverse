package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.PosterDTO;
import academy.softserve.movieuniverse.entity.Poster;


public class PosterMapper implements ReversibleDtoMapper<Poster, PosterDTO> {

	@Override
	public Poster mapToEntity(PosterDTO posterDTO) {
		
		Poster poster = new Poster();
		poster.setId(posterDTO.getId());
		poster.setName(posterDTO.getName());
		poster.setImageUrl(posterDTO.getImageUrl());
		return poster;
	}

	@Override
	public PosterDTO mapToDto(Poster entity) {
		PosterDTO posterDTO=new PosterDTO();
		posterDTO.setId(entity.getId());
		posterDTO.setName(entity.getName());
		posterDTO.setImageUrl(entity.getImageUrl());
		return posterDTO;
	}

}
