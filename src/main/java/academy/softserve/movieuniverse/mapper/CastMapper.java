package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.dto.castcrew.CastDTO;
import academy.softserve.movieuniverse.dto.castcrew.CastRequest;
import academy.softserve.movieuniverse.dto.star.CreditDTO;
import academy.softserve.movieuniverse.entity.Cast;
import academy.softserve.movieuniverse.entity.Star;
import org.springframework.stereotype.Component;

@Component
public class CastMapper implements DTOMapper<CastDTO, CastRequest, Cast> {

    @Override
    public Cast mapToEntity(CastRequest dto) {
        Star star = new Star();
        Cast cast = new Cast();
        star.setId(dto.getStarId());
        cast.setStar(star);
        cast.setCharacter(dto.getCharacter());
        return cast;
    }

    @Override
    public CastDTO mapToDTO(Cast entity) {
        CastDTO castDTO = new CastDTO();
        CreditDTO creditDTO = StarMapper.mapToCreditDTO(entity.getStar());
        castDTO.setCreditDTO(creditDTO);
        castDTO.setCharacter(entity.getCharacter());
        return castDTO;
    }
}
