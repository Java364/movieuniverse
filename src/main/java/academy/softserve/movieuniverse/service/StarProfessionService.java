package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.repository.StarProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarProfessionService {

    @Autowired
    private StarProfessionRepository starProfessionRepository;

    public void createStarProfession(StarProfession starProfession) {
        starProfessionRepository.save(starProfession);
    }

    public StarProfession getStarProfession(Long id) {
        return starProfessionRepository.getOne(id);
    }

    public void deleteStarProfession(Long id) {
        starProfessionRepository.deleteById(id);
    }

    public List<StarProfession> findAllStarProfession() {
        return starProfessionRepository.findAll();
    }

}
