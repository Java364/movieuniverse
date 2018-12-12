package academy.softserve.movieuniverse.service.mapper;

import java.util.ArrayList;
import java.util.List;

import academy.softserve.movieuniverse.dto.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;

public class TrailerMapper implements ReversableDtoMapper<Trailer, TrailerDTO>{

	@Override
	public Trailer mapToEntity(TrailerDTO dto) {
		Trailer trailer = new Trailer();
		trailer.setTrailerUrl(dto.getTrailerUrl());
		trailer.setId(dto.getId());
		trailer.setIsRemoved(false);
		return trailer;
	}

	@Override
	public TrailerDTO mapToDto(Trailer entity) {
		TrailerDTO trailerDTO = new TrailerDTO();
		trailerDTO.setId(entity.getId());
		trailerDTO.setTrailerUrl(entity.getTrailerUrl());
		return trailerDTO;
	}
	
	public List<TrailerDTO> mapListToDto(List<Trailer> trailers) {
		List<TrailerDTO> trailerDTOs = new ArrayList<>();
		for(Trailer t: trailers) {
			trailerDTOs.add(this.mapToDto(t));
		}
		return trailerDTOs;
	}

}
