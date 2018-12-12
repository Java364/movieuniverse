package academy.softserve.movieuniverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.repository.MovieMarkRepository;

@Service
public class MovieMarkService {
	
	@Autowired
	private MovieMarkRepository movieMarkRepository;
	
	public MovieMark createMovieMark(MovieMark movieMark) {
		
		return movieMarkRepository.save(movieMark);
	}
	
	public void deleteMovieMark(Long id) {
		movieMarkRepository.deleteById(id);
	}
	
	public MovieMark getMovieMark(Long id) {
		
		return movieMarkRepository.getOne(id);
	}
	
	public List<MovieMark> findAllMovieMarks() {
		return movieMarkRepository.findAll();
	}
	
}
