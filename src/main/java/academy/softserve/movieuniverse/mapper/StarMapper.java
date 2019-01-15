package academy.softserve.movieuniverse.mapper;

import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.dto.star.CreditDTO;
import academy.softserve.movieuniverse.dto.star.StarDTO;
import academy.softserve.movieuniverse.dto.star.StarSearchInfo;
import academy.softserve.movieuniverse.dto.star.StarSearchShortInfo;
import academy.softserve.movieuniverse.entity.Avatar;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.AvatarService;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class StarMapper {

    private final StarService starService;
    private final GalleryService galleryService;
    private final AvatarService avatarService;

    @Autowired
    public StarMapper(StarService starService, GalleryService galleryService, AvatarService avatarService) {
        this.starService = starService;
        this.galleryService = galleryService;
        this.avatarService = avatarService;
    }

    public Star mapListToEntity(StarDTO dto) {
        Star star = new Star();
        star.setFirstName(dto.getFirstName());
        star.setLastName(dto.getLastName());
        star.setId(dto.getId());
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
        star.setFirstName(dto.getFirstName());
        star.setLastName(dto.getLastName());
        if (dto.getRemoved() == null) {
            star.setIsRemoved(false);
        }
        this.mapCreateGalleryAndAvatar(star);
        return star;
    }

    public Star mapUpdateToEntity(StarDTO dto, Long id) {
        Star star = starService.findById(id);
        star.setBiography(dto.getBiography());
        star.setBirthday(dto.getBirthday());
        star.setCityOfBirth(dto.getCityOfBirth());
        star.setGrowth(dto.getGrowth());
        star.setLastName(dto.getLastName());
        star.setFirstName(dto.getFirstName());
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
        dto.setRemoved(entity.getIsRemoved());
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
        dto.setRemoved(entity.getIsRemoved());
        dto.setSelf(linkTo(methodOn(StarController.class).showOne(entity.getId())).withSelfRel().getHref());
        dto.setLinks(
                linkTo(methodOn(StarController.class).showLinksByStarId(entity.getId())).withRel("links").getHref());
        dto.setCountries(linkTo(methodOn(StarController.class).showCountriesByStarId(entity.getId()))
                .withRel("countries").getHref());
        dto.setProfessions(linkTo(methodOn(StarController.class).showProfessionsByStarId(entity.getId()))
                .withRel("professions").getHref());
        dto.setRoles(
                linkTo(methodOn(StarController.class).showRolesByStarId(entity.getId())).withRel("roles").getHref());
        dto.setGallery(
                linkTo(methodOn(StarController.class).showStarGallery(entity.getId())).withRel("gallery").getHref());
        dto.setAvatar(
                linkTo(methodOn(StarController.class).showStarAvatar(entity.getId())).withRel("avatar").getHref());
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

    private void mapCreateGalleryAndAvatar(Star star) {
        Avatar avatar = avatarService.save(new Avatar());
        Gallery gallery = galleryService.save();
        star.setGallery(gallery);
        star.setAvatar(avatar);
    }

    public StarSearchInfo mapEntityToStarSearchInfo(Star starEntity) {
        StarSearchInfo starDTO = new StarDTO();
        starDTO.setFirstName(starEntity.getFirstName());
        starDTO.setLastName(starEntity.getLastName());
        starDTO.setId(starEntity.getId());
        starDTO.setBiography(starEntity.getBiography());
        starDTO.setBirthday(starEntity.getBirthday());
        starDTO.setSelf(linkTo(methodOn(StarController.class).showOne(starEntity.getId())).withSelfRel().getHref());
        starDTO.setProfessions(linkTo(methodOn(StarController.class).showProfessionsByStarId(starEntity.getId()))
                .withRel("professions").getHref());
        starDTO.setAvatar(
                linkTo(methodOn(StarController.class).showStarAvatar(starEntity.getId())).withRel("avatar").getHref());
        return starDTO;
    }

    public StarSearchShortInfo mapEntityToStarShortSearchInfo(Star starEntity) {
        StarSearchShortInfo starDTO = new StarDTO();
        starDTO.setFirstName(starEntity.getFirstName());
        starDTO.setLastName(starEntity.getLastName());
        starDTO.setId(starEntity.getId());
        starDTO.setBirthday(starEntity.getBirthday());
        starDTO.setSelf(linkTo(methodOn(StarController.class).showOne(starEntity.getId())).withSelfRel().getHref());
        return starDTO;
    }

    public List<StarSearchInfo> mapListEntityToStarSearchInfoList(List<Star> starEntities) {
        return starEntities.stream().map(this::mapEntityToStarSearchInfo).collect(Collectors.toList());
    }

    public List<StarSearchShortInfo> mapListEntityToStarSearchShortInfoList(List<Star> starEntities) {
        return starEntities.stream().map(this::mapEntityToStarShortSearchInfo).collect(Collectors.toList());
    }

    public static CreditDTO mapToCreditDTO(Star star) {
        CreditDTO creditDTO = new StarDTO();
        creditDTO.setId(star.getId());
        creditDTO.setFirstName(star.getFirstName());
        creditDTO.setLastName(star.getLastName());
        return creditDTO;
    }
}
