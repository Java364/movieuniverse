package academy.softserve.movieuniverse.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.softserve.movieuniverse.dto.StarCreateDTO;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.dto.StarListDTO;
import academy.softserve.movieuniverse.entity.Star;
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

	public Star saveStar(Star star) {
		star = starRepository.save(star);
		return star;
	}

	public List<Star> showAllStars() {
		return starRepository.findAll();
	}

	public Star findStarById(Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
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
