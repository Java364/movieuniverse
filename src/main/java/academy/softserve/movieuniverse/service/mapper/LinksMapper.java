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
    /*private ModelMapper modelMapper = new ModelMapper();*/

    public Links mapToEntity(LinksDTO dto) {
        Links links = new Links();
        links.setId(dto.getId());
        links.setLinkName(dto.getLinkName());
        links.setSocialNetworkingSite(dto.getSocialNetworkingSite());
        links.setStar(starService.findStarById(dto.getStarid()));
        return links;
    }

    public LinksDTO mapToDto(Links entity) {
        LinksDTO linksDTO = new LinksDTO();
        linksDTO.setId(entity.getId());
        linksDTO.setLinkName(entity.getLinkName());
        linksDTO.setSocialNetworkingSite(entity.getSocialNetworkingSite());
        linksDTO.setStarid(entity.getStar().getId());

        return linksDTO;
    }

    public List<LinksDTO> mapListToDto(List<Links> links) {
        List<LinksDTO> linksDTOlist = new ArrayList<>();

        for (Links l : links) {
            linksDTOlist.add(this.mapToDto(l));
        }
        return linksDTOlist;
    }
    
    public List<Links> mapLinksListToEntity(List<LinksDTO> linkDTOs) {
		List<Links> links = new ArrayList<>();
		for (LinksDTO l : linkDTOs) {
			links.add(this.mapToEntity(l));
		}
		return links;
	}
   /*public Links mapToEntity(LinksDTO linksDTO) {
       return modelMapper.map(linksDTO, Links.class);
   }

    public LinksDTO mapToDto(Links linksEntity) {
        return modelMapper.map(linksEntity, LinksDTO.class);
    }

    public List<LinksDTO> mapListToDto(List<Links> links) {
        List<LinksDTO> linksDTOS = new ArrayList<>();
        for (Links links1: links ) {
            linksDTOS.add(mapToDto(links1));
        }
        return linksDTOS;
    }*/
}
