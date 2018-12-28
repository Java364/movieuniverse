package academy.softserve.movieuniverse.service.mapper;

import academy.softserve.movieuniverse.controller.MovieController;
import academy.softserve.movieuniverse.controller.TrailerController;
import academy.softserve.movieuniverse.dto.trailer.CreateTrailerInfo;
import academy.softserve.movieuniverse.dto.trailer.TrailerDTO;
import academy.softserve.movieuniverse.entity.Trailer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class TrailerMapper {

    public Trailer mapToEntity(CreateTrailerInfo trailerDTO) {
        Trailer trailer = new Trailer();
        trailer.setTrailerUrl(trailerDTO.getTrailerUrl());
        return trailer;
    }

    public TrailerDTO mapToDTO(Trailer trailer) {
        TrailerDTO trailerDTO = new TrailerDTO();
        trailerDTO.setId(trailer.getId());
        trailerDTO.setTrailerUrl(trailer.getTrailerUrl());
        trailerDTO.setCreated(trailer.getEntryCreationDate().getTime());
        trailerDTO.setUpdated(trailer.getEntryLastUpdate().getTime());
        trailerDTO.setSelf(linkTo(methodOn(TrailerController.class).showById(trailer.getId())).withSelfRel().getHref());
        trailerDTO.setMovie(linkTo(methodOn(MovieController.class).showById(trailer.getMovie().getId()))
                .withRel("movie").getHref());
        return trailerDTO;
    }

    public List<TrailerDTO> maptoDTOList(List<Trailer> trailers) {
        return trailers.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
