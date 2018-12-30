package academy.softserve.movieuniverse.service.mapper;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import academy.softserve.movieuniverse.controller.GalleryController;
import academy.softserve.movieuniverse.controller.LinksController;
import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.dto.StarActivityInMoviesDTO;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.entity.StarActivityInMovies;
import academy.softserve.movieuniverse.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        star.setCountries(
                dto.getCountriesIds().stream().map(p -> countryService.findById(p)).collect(Collectors.toList()));
        star.setFirstName(dto.getFirstName());
        if (dto.getGalleryId() == null || galleryService.findById(dto.getGalleryId()) == null) {
            Long id = (long) 1;
            dto.setGalleryId(id);
        }
        star.setGallery(galleryService.findById(dto.getGalleryId()));
        star.setGrowth(dto.getGrowth());
        star.setId(null);
        star.setLastName(dto.getLastName());
        if (dto.getIsRemoved() == null) {
            star.setIsRemoved(false);
        }
        return star;
    }

    public StarDTO mapCreateToDto(Star entity) {
        StarDTO dto = new StarDTO();
        dto.setBiography(entity.getBiography());
        dto.setBirthday(entity.getBirthday());
        dto.setCityOfBirth(entity.getCityOfBirth());
        dto.setCountriesIds(entity.getCountries().stream().map(p -> p.getId()).collect(Collectors.toList()));
        dto.setFirstName(entity.getFirstName());
        dto.setGalleryId(entity.getGallery().getId());
        dto.setGrowth(entity.getGrowth());
        dto.setId(entity.getId());
        dto.setLastName(entity.getLastName());
        dto.setIsRemoved(entity.getIsRemoved());
        return dto;
    }

    // public Star mapProfileToEntity(StarDTO dto) {
    // Star star = new Star();
    // star.setBiography(dto.getBiography());
    // star.setBirthday(dto.getBirthday());
    // star.setCityOfBirth(dto.getCityOfBirth());
    // star.setFirstName(dto.getFirstName());
    // star.setGallery(galleryMapper.mapToEntity(dto.getGalleryDto()));
    // star.setGrowth(dto.getGrowth());
    // star.setId(dto.getId());
    // star.setLastName(dto.getLastName());
    // star.setCountries(countryMapper.mapCountriesListToEntity(dto.getCountries()));
    // star.setLinks(linksMapper.mapLinksListToEntity(dto.getLinks()));
    // star.setLinks(dto.getLinksIds().stream().map(p -> linkService.getOneLinks(p)).collect(Collectors.toList()));
    // return star;
    // }

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
        // dto.setLinks(linksMapper.mapListToDto(entity.getLinks()));
        // dto.setGalleryId(entity.getGallery().getId());
        // dto.setCountries(countryMapper.mapListToDto(entity.getCountries()));
        // dto.setCountriesIds(entity.getCountries().stream().map(p -> p.getId()).collect(Collectors.toList()));
        // dto.setProfessions(starProfessionMapper.mapListEntityToDTO(entity.getProfessions()));
        // dto.setActivities(this.mapActivityListsToDto(entity.getRoles())); // TODO edit when StarActivityDTO will be
        // created
        // dto.setMoviesIds(entity.getRoles().stream().map(p -> p.getMovie().getId()).collect(Collectors.toList()));
        // dto.setLinksIds(entity.getLinks().stream().map(p -> p.getId()).collect(Collectors.toList()));
        // dto.setProfessionsIds(
        // entity.getProfessions().stream().map(p -> p.getProfession().getId()).collect(Collectors.toList()));


        dto.setSelf(linkTo(methodOn(StarController.class).showOne(entity.getId())).withSelfRel().getHref());
        dto.setLinksu(
                linkTo(methodOn(StarController.class).showLinksByStarId(entity.getId())).withRel("links").getHref());
        dto.setCountriesu(linkTo(methodOn(StarController.class).showCountriesByStarId(entity.getId()))
                .withRel("countries").getHref());
        dto.setProfessionsu(linkTo(methodOn(StarController.class).showProfessionsByStarId(entity.getId()))
                .withRel("professions").getHref());
        dto.setRoles(
                linkTo(methodOn(StarController.class).showRolesByStarId(entity.getId())).withRel("roles").getHref());
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
