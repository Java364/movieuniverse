package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.ProfessionController;
import academy.softserve.movieuniverse.dto.ProfessionDTO;
import academy.softserve.movieuniverse.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class ProfessionMapper {

	public Profession mapToEntity(ProfessionDTO dto) {
        Profession profession = new Profession();
        profession.setId(dto.getId());
        profession.setType(dto.getProfessionType());
        
        /*
         * profession.setStars(dto.getProfessionsIds().stream().map(p ->
         * starProfessionService.getStarProfession(p)).collect(Collectors.toList()));
         *//* profession.setStars(starProfessionMapper.mapListToEntity(dto.getStarsProfessionDTO())); */
        profession.setIsRemoved(false);
        return profession;
    }

    public ProfessionDTO mapToDto(Profession profession) {
        ProfessionDTO professionDTO = new ProfessionDTO();
        professionDTO.setId(profession.getId());
        professionDTO.setProfessionType(profession.getType());
        professionDTO.setSelf(linkTo(methodOn(ProfessionController.class).showById(profession.getId()))
                .withSelfRel().getHref());
//        professionDTO.setStars(linkTo(methodOn(StarController.class).showProfessionsByStarIds(profession.getStars()));
        professionDTO.setRemoved(profession.getIsRemoved());
        return professionDTO;
    }

    public List<ProfessionDTO> mapListToDto(List<Profession> professionList) {
        List<ProfessionDTO> professionDTOS = new ArrayList<>();
        for (Profession p : professionList) {
            professionDTOS.add(this.mapToDto(p));
        }
        return professionDTOS;
    }

    public Profession mapToEntityForUpdate(ProfessionDTO dto, Long id) {
        Profession profession = new Profession();
        profession.setId(id);
        profession.setType(dto.getProfessionType());
        /* profession.setStars(starProfessionMapper.mapListToEntity(dto.getStarsProfessionDTO())); */
        profession.setIsRemoved(false);
        return profession;
    }
}
