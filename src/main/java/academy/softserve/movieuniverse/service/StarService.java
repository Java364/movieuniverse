package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.star.StarDTO;
import academy.softserve.movieuniverse.dto.star.StarSearchRequest;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.StarRepository;
import academy.softserve.movieuniverse.service.specific.StarSpecific;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StarService {

	private final StarRepository starRepository;
	private final GalleryService galleryService;
	private final StarSpecific starSpecific;

	@Autowired
	public StarService(StarRepository starRepository,
			GalleryService galleryService, StarSpecific starSpecific) {
		this.starRepository = starRepository;
		this.galleryService = galleryService;
		this.starSpecific = starSpecific;
	}

	public Star create(Star star) {
		if (star == null) {
			throw new NotFoundException(ExceptionType.SAVE.getMessage()
					+ " star");
		}
		star = starRepository.save(star);
		return star;
	}

	public Star update(Star star, Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw new NotFoundException(ExceptionType.UPDATE.getMessage()
					+ " star");
		}
		star.setId(id);
		star = starRepository.save(star);
		return star;
	}

	public List<Star> showAll(StarSearchRequest starSearchRequest) {
		return starRepository.findAll(starSpecific.filter(starSearchRequest));
	}

	public List<Star> showAll() {
		return starRepository.findAll();
	}

	public Star findById(Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw new NotFoundException(ExceptionType.SELECT.getMessage()
					+ "star with " + id.toString() + " ID");
		}
		Star star = starOptional.get();
		return star;
	}

	public void deleteById(Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw new NotFoundException(ExceptionType.DELETE.getMessage()
					+ "star with " + id.toString() + " ID");
		}
		starRepository.deleteById(id);
	}

	public Star remove(Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw new NotFoundException(ExceptionType.DELETE.getMessage()
					+ "star with " + id.toString() + " ID");
		}
		Star star = starOptional.get();
		star.setId(id);
		star.setIsRemoved(true);
		star = starRepository.save(star);
		return star;
	}

	public Star makeActive(Long id) {
		Optional<Star> starOptional = starRepository.findById(id);
		if (!starOptional.isPresent()) {
			throw new NotFoundException(ExceptionType.SELECT.getMessage()
					+ "star with " + id.toString() + " ID");
		}
		Star star = starOptional.get();
		star.setId(id);
		star.setIsRemoved(false);
		star = starRepository.save(star);
		return star;
	}

	public Star findAllByLinks(Links links) {
		return starRepository.findByLinks(links);
	}

	public Gallery addNewGallery(Long starId) {
		Star star = findById(starId);
		Gallery gallery = galleryService.save();
		star.setGallery(gallery);
		update(star, starId);
		return gallery;
	}

	public List<Star> findAllByName(String name) {
		return starRepository
				.findAllByFirstNameContainingOrLastNameContainingAllIgnoreCase(
						name, name);
	}

	public boolean validatorCreationAndEditStar(StarDTO dto) {
		if ((dto.getFirstName() == null) 
				|| (dto.getLastName() == null)
				|| (dto.getBiography() == null)
				|| (dto.getCityOfBirth() == null)
				|| (dto.getBirthday() == null)
				|| (dto.getGrowth() == null)
				|| (dto.getFirstName().isEmpty()) 
				|| (dto.getLastName().isEmpty())
				|| (dto.getBiography().isEmpty())
				|| (dto.getCityOfBirth().isEmpty()))
			return true;
		else
			return false;
	}
}
