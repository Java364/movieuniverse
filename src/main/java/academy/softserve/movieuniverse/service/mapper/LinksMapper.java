package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.LinksController;
import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.controller.UserController;
import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class LinksMapper {
    @Autowired
    private StarService starService;


    public Links mapToEntityAndSaveLinks(LinksDTO dto) {
        Links links = new Links();

        links.setLinkName(dto.getLinkName());
        links.setSocialNetworkingSite(dto.getSocialNetworkingSite());
        links.setStar(starService.findStarById(dto.getStarID()));
        links.setIsRemoved(false);

        return links;
    }

    public LinksDTO mapEntityToDto(Links links) {
        LinksDTO linksDTO = new LinksDTO();

        linksDTO.setLinkName(links.getLinkName());
        linksDTO.setSocialNetworkingSite(links.getSocialNetworkingSite());
        linksDTO.setStarID(links.getStar().getId());
        linksDTO.setRemoved(links.getIsRemoved());
        linksDTO.add(linkTo(methodOn(LinksController.class).getOneLink(links.getId())).withSelfRel());
        linksDTO.add(linkTo(methodOn(StarController.class).showAllByLinksId(links.getId())).withRel("star"));


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
