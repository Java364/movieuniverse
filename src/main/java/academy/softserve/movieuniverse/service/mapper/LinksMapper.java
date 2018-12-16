package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.service.StarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinksMapper {
    @Autowired
    private StarService starService;


    public Links mapToEntityAndSaveLinks(LinksDTO dto) {
        Links links = new Links();
        links.setId(dto.getId());
        links.setLinkName(dto.getLinkName());
        links.setSocialNetworkingSite(dto.getSocialNetworkingSite());
        links.setStar(starService.findStarById(dto.getStarID()));
        links.setIsRemoved(false);
        return links;
    }

    public LinksDTO mapEntityToDto(Links links) {
        LinksDTO linksDTO = new LinksDTO();
        linksDTO.setId(links.getId());
        linksDTO.setLinkName(links.getLinkName());
        linksDTO.setSocialNetworkingSite(links.getSocialNetworkingSite());
        linksDTO.setStarID(links.getStar().getId());
        linksDTO.setRemoved(links.getIsRemoved());
        return linksDTO;
    }

    public List<LinksDTO> mapListToDto(List<Links> links) {
        List<LinksDTO> linksDTOlist = new ArrayList<>();
        for (Links l : links) {
            linksDTOlist.add(this.mapEntityToDto(l));
        }
        return linksDTOlist;
    }
    
    public List<Links> mapLinksListToEntity(List<LinksDTO> linkDTOs) {
		List<Links> links = new ArrayList<>();
		for (LinksDTO l : linkDTOs) {
			links.add(this.mapToEntityAndSaveLinks(l));
		}
		return links;
	}
    public Links mapToEntityForUpdateLinks(LinksDTO dto, Long id) {
        Links links = new Links();
        links.setId(id);
        links.setLinkName(dto.getLinkName());
        links.setSocialNetworkingSite(dto.getSocialNetworkingSite());
        links.setStar(starService.findStarById(dto.getStarID()));
        links.setIsRemoved(dto.getRemoved());
        return links;
    }

}
