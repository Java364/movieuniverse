package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.NotFoundException;

import academy.softserve.movieuniverse.repository.StarProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StarProfessionService {

    private final StarProfessionRepository starProfessionRepository;
    @Autowired
    private StarService starService;

    @Autowired
    public StarProfessionService(StarProfessionRepository starProfessionRepository) {
        this.starProfessionRepository = starProfessionRepository;
    }

    @Transactional
    public void createStarProfession(StarProfession starProfession, Long starId) {
        if (starProfession == null) {
            throw NotFoundException.createNotFoundException(ExceptionType.SAVE.getMessage() + " StarProfession");
        }
        if (starService.findById(starId) == null) {
            throw NotFoundException.createNotFoundException(ExceptionType.SELECT.getMessage() + "StarProfession");
        }
        starProfession.setStar(starService.findById(starId));
        starProfessionRepository.save(starProfession);
    }

    public StarProfession getStarProfession(Long id) {
        Optional<StarProfession> starProfession = starProfessionRepository.findById(id);
        if (!starProfession.isPresent()) {
            throw NotFoundException.createNotFoundException(ExceptionType.SELECT.getMessage() + "StarProfession with " + id.toString() + " ID");
        }
        return starProfession.get();
    }

    public void deleteStarProfession(Long id) {
        Optional<StarProfession> starProfession = starProfessionRepository.findById(id);
        if (!starProfession.isPresent()) {
            throw NotFoundException
                    .createNotFoundException(ExceptionType.DELETE.getMessage() + "StarProfession with " + id.toString() + " ID");
        }
        starProfessionRepository.deleteById(id);
    }

    public List<StarProfession> findAllStarProfession() {
        return starProfessionRepository.findAll();
    }

}
