package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.exception.MovieMarkException;
import academy.softserve.movieuniverse.repository.MovieMarkRepository;

@Service
public class MovieMarkService {

	@Autowired
	private MovieMarkRepository movieMarkRepository;

	@Transactional
	public MovieMark create(MovieMark movieMark) {
		if (movieMark == null) {
			throw MovieMarkException.createSaveException("Cant save movie mark", new Exception());
		}
		return movieMarkRepository.save(movieMark);
	}

	@Transactional
	public void delete(Long id) {
		if (id == null || !movieMarkRepository.findById(id).isPresent()) {
			throw MovieMarkException.createDeleteException("No such movie mark to delete", new Exception());
		}
		movieMarkRepository.deleteById(id);
	}

	@Transactional
	public MovieMark update(MovieMark movieMark) {
		MovieMark existMovieMark = movieMarkRepository.getOne(movieMark.getId());
		if (movieMark == null || movieMark.getId() == null || existMovieMark == null) {
			throw MovieMarkException.createUpdateException("Cant update movie mark", new Exception());
		}
		existMovieMark.setMark(movieMark.getMark());
		existMovieMark.setUser(movieMark.getUser());
		existMovieMark.setMovie(movieMark.getMovie());
		movieMark = movieMarkRepository.save(existMovieMark);
		if (movieMark == null) {
			throw MovieMarkException.createUpdateException("Cant update movie mark", new Exception());
		}
		return movieMark;
	}

	public MovieMark findById(Long id) {
		Optional<MovieMark> movieMarkOptional = movieMarkRepository.findById(id);
		if (id == null || !movieMarkOptional.isPresent()) {
			throw MovieMarkException.createSelectException("No such movie mark ", new Exception());
		}
		MovieMark movieMark = movieMarkOptional.get();
		return movieMark;
	}

	public List<MovieMark> findAll() {
		return movieMarkRepository.findAll();
	}
}
