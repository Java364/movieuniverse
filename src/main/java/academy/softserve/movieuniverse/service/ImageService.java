package academy.softserve.movieuniverse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;
	
	public Image createImage(Image image) {
		image = imageRepository.save(image);
		return image;
	}
	
	public Image getImage(Long id) {
		return imageRepository.getOne(id);
	}
	
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
	
	public List<Image> findAll() {
		List<Image> images = new ArrayList<>();
		images = imageRepository.findAll();
		return images;
	}


}
