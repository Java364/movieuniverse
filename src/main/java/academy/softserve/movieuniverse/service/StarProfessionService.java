package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.exception.StarException;
import academy.softserve.movieuniverse.exception.StarProfessionException;
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
            throw StarProfessionException.createSaveException("New star's profession couldn't be saved", null);
        }
        if (starService.findStarById(starId) == null) {
            throw StarException.createSelectException("No such user", null);
        }
        starProfession.setStar(starService.findStarById(starId));
        starProfessionRepository.save(starProfession);
    }

    public StarProfession getStarProfession(Long id) {
        Optional<StarProfession> starProfession = starProfessionRepository.findById(id);
        if (!starProfession.isPresent()) {
            throw StarProfessionException.createSelectException("Can't find Starprofession with ID:" + id, null);
        }
        return starProfession.get();
    }

    public void deleteStarProfession(Long id) {
        Optional<StarProfession> starProfession = starProfessionRepository.findById(id);
        if (!starProfession.isPresent()) {
            throw StarProfessionException.createDeleteException("Can't delete StarProfession with ID:" + id
                    + "ID doesn't exist", null);
        }
        starProfessionRepository.deleteById(id);
    }

    public List<StarProfession> findAllStarProfession() {
        return starProfessionRepository.findAll();
    }

}
