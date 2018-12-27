package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.LinksController;
import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        return links;
    }

    public LinksDTO mapEntityToDto(Links links) {
        LinksDTO linksDTO = new LinksDTO();
        linksDTO.setLinkName(links.getLinkName());
        linksDTO.setSocialNetworkingSite(links.getSocialNetworkingSite());
        linksDTO.setCreated(links.getEntryCreationDate().getTime());
        linksDTO.setUpdated(links.getEntryLastUpdate().getTime());
        linksDTO.setSelf(linkTo(methodOn(LinksController.class).getOneLink(links.getId())).withSelfRel().getHref());
        linksDTO.setStar(linkTo(methodOn(StarController.class).showById(links.getStar().getId())).withRel("star").getHref());
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
        return linkDTOs.stream().map(this::mapToEntityAndSaveLinks).collect(Collectors.toList());

            }

    public Links mapToEntityForUpdateLinks(LinksDTO dto, Long id) {
        Links links = new Links();
        links.setId(id);
        links.setLinkName(dto.getLinkName());
        links.setSocialNetworkingSite(dto.getSocialNetworkingSite());

        return links;
    }

}
