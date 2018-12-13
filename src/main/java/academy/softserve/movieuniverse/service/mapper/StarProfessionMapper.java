package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.StarProfessionDTO;
import academy.softserve.movieuniverse.entity.StarProfession;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class StarProfessionMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public StarProfession mapToEntity(StarProfessionDTO starProfessionDTO) {
        return modelMapper.map(starProfessionDTO, StarProfession.class);
    }

    public StarProfessionDTO mapToDto(StarProfession starProfessionEntity) {
        return modelMapper.map(starProfessionEntity, StarProfessionDTO.class);
    }

    public List<StarProfessionDTO> mapListEntityToDTO(List<StarProfession> starProfessions) {
        List<StarProfessionDTO> starProfessionDTOs = new ArrayList<>();
        for (StarProfession starProfession: starProfessions ) {
            starProfessionDTOs.add(mapToDto(starProfession));
        }
        return starProfessionDTOs;
    }


}
