package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;

public class TrailerMapper implements ReversableDtoMapper<Trailer, TrailerDTO>{

	@Override
	public Trailer mapToEntity(TrailerDTO dto) {
		Trailer trailer = new Trailer();
		trailer.setTrailerUrl(dto.getTrailerUrl());
		return null;
	}

	@Override
	public TrailerDTO mapToDto(Trailer entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
