package academy.softserve.movieuniverse.service.mapper;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.entity.Avatar;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarMapper {

    @Autowired
    private StarService starService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private LinksService linkService;
    @Autowired
    private AvatarService avatarService;
    @Autowired
    private StarProfessionService starProfessionService;
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private LinksMapper linksMapper;
    @Autowired
    private GalleryMapper galleryMapper;
    @Autowired
    private StarProfessionMapper starProfessionMapper;

    public Star mapListToEntity(StarDTO dto) {
        Star star = new Star();
        star.setFirstName(dto.getFirstName());
        star.setLastName(dto.getLastName());
        star.setId(dto.getId());
        star.setIsRemoved(new Boolean(false));
        return star;
    }

    public StarDTO mapListToDto(Star entity) {
        StarDTO dto = new StarDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setId(entity.getId());
        return dto;
    }

    public Star mapCreateToEntity(StarDTO dto) {
        Star star = new Star();
        star.setBiography(dto.getBiography());
        star.setBirthday(dto.getBirthday());
        star.setCityOfBirth(dto.getCityOfBirth());
        star.setGrowth(dto.getGrowth());
        star.setId(null);
        star.setLastName(dto.getLastName());
        if (dto.getIsRemoved() == null) {
            star.setIsRemoved(false);
        }
        Long id = (long) 1;
        Avatar avatar = avatarService.save(avatarService.findById(id));
        star.setGallery(galleryService.findById(id));
        star.setAvatar(avatar);
        return star;
    }

    public StarDTO mapCreateToDto(Star entity) {
        StarDTO dto = new StarDTO();
        dto.setBiography(entity.getBiography());
        dto.setBirthday(entity.getBirthday());
        dto.setCityOfBirth(entity.getCityOfBirth());
        dto.setFirstName(entity.getFirstName());
        dto.setGrowth(entity.getGrowth());
        dto.setId(entity.getId());
        dto.setLastName(entity.getLastName());
        dto.setIsRemoved(entity.getIsRemoved());
        return dto;
    }

    public StarDTO mapProfileToDto(Star entity) {
        StarDTO dto = new StarDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setGrowth(entity.getGrowth());
        dto.setBirthday(entity.getBirthday());
        dto.setBiography(entity.getBiography());
        dto.setCityOfBirth(entity.getCityOfBirth());
        dto.setIsRemoved(entity.getIsRemoved());
        dto.setSelf(linkTo(methodOn(StarController.class).showOne(entity.getId())).withSelfRel().getHref());
        dto.setLinksu(
                linkTo(methodOn(StarController.class).showLinksByStarId(entity.getId())).withRel("links").getHref());
        dto.setCountriesu(linkTo(methodOn(StarController.class).showCountriesByStarId(entity.getId()))
                .withRel("countries").getHref());
        dto.setProfessionsu(linkTo(methodOn(StarController.class).showProfessionsByStarId(entity.getId()))
                .withRel("professions").getHref());
        dto.setRoles(
                linkTo(methodOn(StarController.class).showRolesByStarId(entity.getId())).withRel("roles").getHref());
        dto.setGallery(linkTo(methodOn(StarController.class).showStarGallery(entity.getId())).withRel("gallery").getHref());
        dto.setAvatar(linkTo(methodOn(StarController.class).showStarAvatar(entity.getId())).withRel("avatar").getHref());
        return dto;
    }

    public List<StarDTO> mapListsToDto(List<Star> stars) {
        List<StarDTO> starDTOs = new ArrayList<>();
        for (Star t : stars) {
            starDTOs.add(this.mapListToDto(t));
        }
        return starDTOs;
    }

    public List<Star> mapListsToEntity(List<StarDTO> starsDTOs) {
        List<Star> stars = new ArrayList<>();
        for (StarDTO t : starsDTOs) {
            stars.add(this.mapListToEntity(t));
        }
        return stars;
    }
}
