package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.exception.StarException;
import academy.softserve.movieuniverse.repository.StarRepository;

@Service
public class StarService {
	
	@Autowired
	private StarRepository starRepository;

	@Transactional
	public Star create(Star star) {
		star = starRepository.save(star);
		return star;
	}
	
	@Transactional
	public Star update(Star star, Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if(!starOptional.isPresent()){
			throw StarException.createUpdateException("No such star to update", null);
		}
		star.setId(id);
		star = starRepository.save(star);
		return star;
	}

	public List<Star> showAllStars() {
		return starRepository.findAll();
	}

	public Star findStarById(Long id) { //TODO rename method name
		Optional<Star> starOptional = starRepository.findById(id);
		if(!starOptional.isPresent()){
			throw StarException.createSelectException("No such star", new Exception());
		}
		Star star = starOptional.get();
		return star;
	}
	
	@Transactional
	public void deleteById(Long id){
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw StarException.createDeleteException("No such user to delete", null);
		}
		starRepository.deleteById(id);
	}

}
