package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.softserve.movieuniverse.entity.MovieMark;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.MovieMarkException;
import academy.softserve.movieuniverse.repository.MovieMarkRepository;

@Service
public class MovieMarkService {

	@Autowired
	private MovieMarkRepository movieMarkRepository;

	@Transactional
	public MovieMark create(MovieMark movieMark) {
		if (movieMark == null) {
			throw MovieMarkException.createSaveException(ExceptionType.SAVE.getMessage() + " movieMark");
		}
		return movieMarkRepository.save(movieMark);
	}

	@Transactional
	public void delete(Long id) {
		if (id == null || !movieMarkRepository.findById(id).isPresent()) {
			throw MovieMarkException.createDeleteException(
					ExceptionType.DELETE.getMessage() + " movieMark with " + id.toString() + " ID");
		}
		movieMarkRepository.deleteById(id);
	}

	@Transactional
	public MovieMark update(MovieMark movieMark) {
		MovieMark existMovieMark = movieMarkRepository.getOne(movieMark.getId());
		if (movieMark == null || movieMark.getId() == null || existMovieMark == null) {
			throw MovieMarkException.createUpdateException(ExceptionType.UPDATE.getMessage() + " movieMark");
		}
		existMovieMark.setMark(movieMark.getMark());
		existMovieMark.setUser(movieMark.getUser());
		existMovieMark.setMovie(movieMark.getMovie());
		movieMark = movieMarkRepository.save(existMovieMark);
		if (movieMark == null) {
			throw MovieMarkException.createUpdateException(ExceptionType.UPDATE.getMessage() + " movieMark");
		}
		return movieMark;
	}

	public MovieMark findById(Long id) {
		Optional<MovieMark> movieMarkOptional = movieMarkRepository.findById(id);
		if (id == null || !movieMarkOptional.isPresent()) {
			throw MovieMarkException.createSelectException(
					ExceptionType.SELECT.getMessage() + " movieMark with " + id.toString() + " ID");
		}
		MovieMark movieMark = movieMarkOptional.get();
		return movieMark;
	}

	public List<MovieMark> findAll() {
		return movieMarkRepository.findAll();
	}
}
