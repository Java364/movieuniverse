package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.exception.StarException;
import academy.softserve.movieuniverse.repository.StarRepository;
import academy.softserve.movieuniverse.service.mapper.StarListMapper;
import academy.softserve.movieuniverse.service.mapper.StarProfileMapper;

@Service
public class StarService {
	
	@Autowired
	private StarRepository starRepository;
	private StarProfileMapper profileMapper;
	@Autowired
	private StarListMapper listMapper;

	@Transactional
	public Star saveStar(Star star) {
		star = starRepository.save(star);
		return star;
	}
	
	@Transactional
	public Star updateStar(Star star, Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if(!starOptional.isPresent()){
			StarException.createUpdateException("No such user to update", null);
			return null;
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
		System.out.println(starOptional.isPresent());
		Star star = starOptional.get();
		return star;
	}
	
	@Transactional
	public void fullyDelete(Long id){
		Optional<Star> starOptional = starRepository.findById(id);
		if (starOptional.isPresent()) {
			starRepository.deleteById(id);
		}
	}

}
