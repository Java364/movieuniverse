package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Like;
import academy.softserve.movieuniverse.exception.ExceptionType;

import academy.softserve.movieuniverse.exception.NotFoundException;
import academy.softserve.movieuniverse.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like save(Like like) {
        like = likeRepository.save(like);
        if (like == null)
            throw new  NotFoundException(ExceptionType.SAVE.getMessage() + " like");
        return like;
    }

    public Like update(Like like) {
        like = likeRepository.save(like);
        if (like == null)
            throw new  NotFoundException(ExceptionType.UPDATE.getMessage() + " like");
        return like;
    }

    public Like findById(Long id) {
        Optional<Like> likeOptional = likeRepository.findById(id);
        if (!likeOptional.isPresent()) {
            throw new  NotFoundException(ExceptionType.SELECT.getMessage() + "like with " + id.toString() + " ID");
        }
        Like like = likeOptional.get();
        return like;
    }

    public List<Like> findAll() {
        List<Like> like = new ArrayList<>();
        like = likeRepository.findAll();
        return like;
    }

    public void deleteById(Long id) {
        if (id == null || findById(id) == null)
            throw new  NotFoundException(ExceptionType.DELETE.getMessage() + "like with " + id.toString() + " ID");
        likeRepository.deleteById(id);
    }
}
