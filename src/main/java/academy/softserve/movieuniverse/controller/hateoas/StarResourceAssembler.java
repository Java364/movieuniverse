package academy.softserve.movieuniverse.controller.hateoas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import academy.softserve.movieuniverse.controller.StarController;
import academy.softserve.movieuniverse.dto.StarDTO;

@Component
public class StarResourceAssembler implements ResourceAssembler<StarDTO, Resource<StarDTO>> {
	
	@Override
	public Resource<StarDTO> toResource(StarDTO starDto) {
		Link starProfileLink = linkTo(StarController.class).slash(starDto.getId()).withSelfRel();
		Resource<StarDTO> resource = new Resource<>(starDto, starProfileLink);
		return resource;
	}
}
