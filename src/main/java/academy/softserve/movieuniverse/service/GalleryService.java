package academy.softserve.movieuniverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.repository.GalleryRepository;

@Service
public class GalleryService {
	@Autowired
	private GalleryRepository galleryRepository;
	
	public Gallery createGallery(Gallery gallery) {
		gallery = galleryRepository.save(gallery);
		return gallery;
	}
	
	public Gallery getGallery(Long id) {
		return galleryRepository.getOne(id);
	}
	
	public void deleteGallery(Long id) {
		galleryRepository.deleteById(id);
	}
	
	public List<Gallery> findAll() {
		return galleryRepository.findAll();
	}

}
