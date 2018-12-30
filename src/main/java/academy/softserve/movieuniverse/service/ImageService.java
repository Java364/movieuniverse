package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Image;
import academy.softserve.movieuniverse.exception.ExceptionType;

import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.GalleryRepository;
import academy.softserve.movieuniverse.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;

import java.util.List;

@Service
@Transactional
public class ImageService {
    private final ImageRepository imageRepository;
    private final GalleryRepository galleryRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository, GalleryRepository galleryRepository) {
        this.imageRepository = imageRepository;
        this.galleryRepository = galleryRepository;
    }

    public Image save(Image image) {
        if (image == null || image.getId() != null)
            throw NotFoundException.createNotFoundException(ExceptionType.SAVE.getMessage() + " image");
        image = imageRepository.save(image);
        if (image == null)
            throw NotFoundException.createNotFoundException(ExceptionType.SAVE.getMessage() + " image");
        return image;
    }

    public Image update(Image newImage, Long id) {
        if (newImage == null) {
            throw NotFoundException.createNotFoundException(ExceptionType.UPDATE.getMessage() + " image");
        }

        return imageRepository.findById(id).map(image -> {
            image.setName(newImage.getName());
            image.setImageUrl(newImage.getImageUrl());
            image.setEntryLastUpdate(new Date());
            return imageRepository.saveAndFlush(image);
        }).orElseThrow(() -> NotFoundException.createNotFoundException(ExceptionType.UPDATE.getMessage() + " image"));


    }

    public Image findById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> NotFoundException.createNotFoundException(ExceptionType.SELECT.getMessage() + "image with " + id.toString() + " ID"));
    }

    public void delete(Long id) {
        if (id == null || !imageRepository.findById(id).isPresent()) {
            throw NotFoundException.createNotFoundException(ExceptionType.DELETE.getMessage() + "image with " + id.toString() + " ID");
        } else {
            imageRepository.deleteById(id);
        }
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
