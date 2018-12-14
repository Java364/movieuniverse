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

    @Autowired
    private ModelMapper modelMapper;

    public StarProfession mapToEntity(StarProfessionDTO starProfessionDTO) {
        return modelMapper.map(starProfessionDTO, StarProfession.class);
    }

    public StarProfessionDTO mapToDto(StarProfession starProfessionEntity) {
        StarProfessionDTO starProfessionDTO = new StarProfessionDTO();
        starProfessionDTO.setId(starProfessionEntity.getId());
        starProfessionDTO.setStarId(starProfessionEntity.getStar().getId());
        starProfessionDTO.setStarProfessionId(starProfessionEntity.getProfession().getId());
        return starProfessionDTO;
    }

    public List<StarProfessionDTO> mapListEntityToDTO(List<StarProfession> starProfessions) {
        List<StarProfessionDTO> starProfessionDTOs = new ArrayList<>();
        for (StarProfession starProfession: starProfessions ) {
            starProfessionDTOs.add(mapToDto(starProfession));
        }
        return starProfessionDTOs;
    }


}
