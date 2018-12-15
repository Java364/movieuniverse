package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.service.ProfessionServise;
import academy.softserve.movieuniverse.service.StarProfessionService;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class ProfessionMapper {
    @Autowired
    private ProfessionServise professionServise;
    @Autowired
    private StarProfessionService starProfessionService;

    public Profession mapToEntity(ProfessionDTO dto) {
        Profession profession = new Profession();
        profession.setId(dto.getId());
        profession.setType(dto.getProfessionType());
        profession.setStars(dto.getStarsIDs().stream().map(p -> starProfessionService.getStarProfession(p)).collect(Collectors.toList()));
        return profession;
    }

    public ProfessionDTO mapToDto(Profession entity) {
        ProfessionDTO professionDTO = new ProfessionDTO();
        professionDTO.setId(entity.getId());
        professionDTO.setProfessionType(entity.getType());
        professionDTO.setStarsIDs(entity.getStars().stream().map(p ->p.getId()).collect(Collectors.toList()));

        return professionDTO;
    }

    public List<ProfessionDTO> mapListToDto(List<Profession> professionList) {
        List<ProfessionDTO> professionDTOS = new ArrayList<>();
        for(Profession p: professionList) {
            professionDTOS.add(this.mapToDto(p));
        }
        return professionDTOS;
    }
}