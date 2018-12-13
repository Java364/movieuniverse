package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.repository.ProfessionRepository;
import academy.softserve.movieuniverse.service.mapper.ProfessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionServise {
    @Autowired
    private ProfessionRepository professionRepository;
    private ProfessionMapper professionMapper = new ProfessionMapper();

    public void saveProfession(Profession profession){
        professionRepository.save(profession);
    }

    public List<Profession> findAll(){
        return professionRepository.findAll();
    }

    public void deleteProfession(Long id){
        professionRepository.deleteById(id);
    }


    public ProfessionDTO getProfessionDTO(Long id){
        Optional<Profession> linksOptional = professionRepository.findById(id);
        return professionMapper.mapToDto(linksOptional.get());
    }
}
