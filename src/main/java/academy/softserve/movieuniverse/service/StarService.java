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
	public Star saveStar(Star star) {
		star = starRepository.save(star);
		return star;
	}
	
	@Transactional
	public Star updateStar(Star star, Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if(!starOptional.isPresent()){
			throw StarException.createUpdateException("No such user to update", null);
		}
		star.setId(id);
		star = starRepository.save(star);
		return star;
	}

	public List<Star> showAllStars() {
		return starRepository.findAll();
	}

	public Star findStarById(Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if(!starOptional.isPresent()){
			throw StarException.createSelectException("no such star", new Exception());
		}
		Star star = starOptional.get();
		return star;
	}
	
	@Transactional
	public void fullyDelete(Long id){
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw StarException.createDeleteException("no such user to delete", null);
		}
		starRepository.deleteById(id);
	}

}
