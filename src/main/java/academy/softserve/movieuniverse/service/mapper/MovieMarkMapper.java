package academy.softserve.movieuniverse.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import academy.softserve.movieuniverse.dto.MovieMarkDTO;
import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.repository.UserRepository;
import academy.softserve.movieuniverse.service.MovieMarkService;

public class MovieMarkMapper {

	@Autowired
	MovieMarkService movieService;
	@Autowired
	UserRepository userRepository;
	
	public MovieMark mapToEntity(MovieMarkDTO dto) {
		MovieMark movieMark = new MovieMark();
		movieMark.setId(dto.getId());
		movieMark.setIsRemoved(false);
		movieMark.setMark(dto.getMark());
//		movieMark.setMovie(dto.getMovieId(movieService.getId()));
		movieMark.setUser(userRepository.getOne(dto.getUserId()));
		
		return movieMark;
	}

	public MovieMarkDTO mapToDto(MovieMark entity) {
		MovieMarkDTO movieMarkDTO = new MovieMarkDTO();
		movieMarkDTO.setId(entity.getId());
		movieMarkDTO.setMark(entity.getMark());
		movieMarkDTO.setMovieId(entity.getMovie().getId());
		movieMarkDTO.setUserId(entity.getUser().getId());
		
		return movieMarkDTO;
	}

}
