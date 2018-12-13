package academy.softserve.movieuniverse.service.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.repository.MovieRepository;
import academy.softserve.movieuniverse.repository.UserRepository;

public class MovieMarkMapper implements ReversableDtoMapper<MovieMark, MovieMarkDTO> {

	@Autowired
	MovieRepository movieRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public MovieMark mapToEntity(MovieMarkDTO dto) {
		MovieMark movieMark = new MovieMark();
		movieMark.setId(dto.getId());
		movieMark.setMark(dto.getMark());
		movieMark.setMovie(movieRepository.getOne(dto.getMovieId()));
		movieMark.setUser(userRepository.getOne(dto.getUserId()));

		return movieMark;
	}

	@Override
	public MovieMarkDTO mapToDto(MovieMark entity) {
		MovieMarkDTO movieMarkDTO = new MovieMarkDTO();
		movieMarkDTO.setId(entity.getId());
		movieMarkDTO.setMark(entity.getMark());
		movieMarkDTO.setMovieId(entity.getMovie().getId());
		movieMarkDTO.setUserId(entity.getUser().getId());

		return movieMarkDTO;
	}
	
//	public List<MovieMarkDTO> listToDto(){
//		
//	}
	
	

}
