package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.StarProfessionDTO;
import academy.softserve.movieuniverse.entity.StarProfession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarProfessionMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public StarProfessionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StarProfession mapToEntity(StarProfessionDTO starProfessionDTO) {
        return modelMapper.map(starProfessionDTO, StarProfession.class);
    }

    public StarProfessionDTO mapToDto(StarProfession starProfessionEntity) {
        StarProfessionDTO starProfessionDTO = new StarProfessionDTO();
        starProfessionDTO.setId(starProfessionEntity.getId());
        starProfessionDTO.setStarId(starProfessionEntity.getStar().getId());
        starProfessionDTO.setStarProfessionId(starProfessionEntity.getProfession().getId());
        starProfessionDTO.setStarName(starProfessionEntity.getStar().getFirstName() + " "
                + starProfessionEntity.getStar().getLastName());
        starProfessionDTO.setStarProfession(starProfessionEntity.getProfession().getType());
        return starProfessionDTO;
    }

    public List<StarProfessionDTO> mapListEntityToDTO(List<StarProfession> starProfessions) {
        List<StarProfessionDTO> starProfessionDTOs = new ArrayList<>();
        for (StarProfession starProfession: starProfessions ) {
            starProfessionDTOs.add(mapToDto(starProfession));
        }
        return starProfessionDTOs;
    }
    public List<StarProfession> mapListToEntity(List<StarProfessionDTO> starProfessionDTOS) {
        List<StarProfession> starProfessions = new ArrayList<>();
        for (StarProfessionDTO s : starProfessionDTOS) {
            starProfessions.add(this.mapToEntity(s));
        }
        return starProfessions;
    }


}
