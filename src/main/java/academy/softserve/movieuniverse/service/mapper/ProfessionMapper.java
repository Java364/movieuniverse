package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.service.ProfessionServise;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ProfessionMapper implements ReversableDtoMapper<Profession,ProfessionDTO>{
    @Autowired
    private ProfessionServise professionServise;
    @Override

    public Profession mapToEntity(ProfessionDTO dto) {
        Profession profession = new Profession();
        profession.setId(dto.getId());
        profession.setType(dto.getProfessionType());

        return profession;
    }

    @Override
    public ProfessionDTO mapToDto(Profession entity) {
        ProfessionDTO professionDTO = new ProfessionDTO();
        professionDTO.setId(entity.getId());
        professionDTO.setProfessionType(entity.getType());

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