package academy.softserve.movieuniverse.controller.hateoas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.service.mapper.StarMapper;

@Component
public class StarResourceAssembler implements ResourceAssembler<Star, Resource<StarDTO>> {
	
	private StarMapper starMapper;

	public StarResourceAssembler(academy.softserve.movieuniverse.service.mapper.StarMapper starMapper) {
		this.starMapper = starMapper;
	}

	@Override
	public Resource<StarDTO> toResource(Star star) {
		Link starProfileLink = linkTo(StarController.class).slash(star.getId()).withSelfRel();
		Resource<StarDTO> resource = new Resource<>(starMapper.mapProfileToDto(star), starProfileLink);
		return resource;
	}
	
	public Resource<StarDTO> toStarsListResource(Star star) {
		Link starProfileLink = linkTo(StarController.class).slash(star.getId()).withSelfRel();
		Resource<StarDTO> resource = new Resource<>(starMapper.mapListToDto(star), starProfileLink);
		return resource;
	}

}
