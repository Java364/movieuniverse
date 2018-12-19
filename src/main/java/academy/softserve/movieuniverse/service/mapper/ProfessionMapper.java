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
    @Autowired
    private StarProfessionMapper starProfessionMapper;

    public Profession mapProfessionToEntity(ProfessionDTO dto) {
        Profession profession = new Profession();
        profession.setId(dto.getId());
        profession.setType(dto.getProfessionType());
       /* profession.setStars(dto.getProfessionsIds().stream().map(p -> starProfessionService.getStarProfession(p)).collect(Collectors.toList()));
        *//*profession.setStars(starProfessionMapper.mapListToEntity(dto.getStarsProfessionDTO()));*/
        profession.setIsRemoved(false);
        return profession;
    }

    public ProfessionDTO mapToDto(Profession profession) {
        ProfessionDTO professionDTO = new ProfessionDTO();
        professionDTO.setId(profession.getId());
        professionDTO.setProfessionType(profession.getType());
       /* professionDTO.setStarsIDs(entity.getStars().stream().map(p ->p.getId()).collect(Collectors.toList()));*/
        /*professionDTO.setStarsProfessionDTO(starProfessionMapper.mapListEntityToDTO(profession.getStars()));*/
        professionDTO.setStarIds(profession.getStars().stream().map(p -> p.getStar().getId()).collect(Collectors.toList()));
        professionDTO.setRemoved(profession.getIsRemoved());
        return professionDTO;
    }

    public List<ProfessionDTO> mapListProfessionToDto(List<Profession> professionList) {
        List<ProfessionDTO> professionDTOS = new ArrayList<>();
        for(Profession p: professionList) {
            professionDTOS.add(this.mapToDto(p));
        }
        return professionDTOS;
    }
    public Profession mapToEntityForUpdateProfession(ProfessionDTO dto, Long id) {
        Profession profession = new Profession();
        profession.setId(id);
        profession.setType(dto.getProfessionType());
        /*profession.setStars(starProfessionMapper.mapListToEntity(dto.getStarsProfessionDTO()));*/
        profession.setIsRemoved(false);
        return profession;
    }
}