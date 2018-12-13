package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class LinksMapper implements ReversableDtoMapper<Links, LinksDTO> {
    @Autowired
    private StarService starService;
    @Override

    public Links mapToEntity(LinksDTO dto) {
        Links links = new Links();
        links.setId(dto.getId());
        links.setLinkName(dto.getLinkName());
        links.setSiteName(dto.getSiteName());
        links.setStar(starService.findStarById(dto.getStarid()).get());
        return links;

    }

    @Override
    public LinksDTO mapToDto(Links entity) {
        LinksDTO linksDTO = new LinksDTO();
        linksDTO.setId(entity.getId());
        linksDTO.setLinkName(entity.getLinkName());
        /*linksDTO.setStarid(entity.getStar().getId());*/
        return linksDTO;
    }

    public List<LinksDTO> mapListToDto(List<Links> links) {
        List<LinksDTO> linksDTOlist = new ArrayList<>();
        for(Links t: links) {
            linksDTOlist.add(this.mapToDto(t));
        }
        return linksDTOlist;
    }
}
