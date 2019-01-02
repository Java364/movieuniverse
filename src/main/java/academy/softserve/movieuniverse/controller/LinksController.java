package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.service.LinksService;
import academy.softserve.movieuniverse.mapper.LinksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin
@RestController
@RequestMapping("/links")
public class LinksController {

    @Autowired
    private LinksService linksService;
    @Autowired
    private LinksMapper linksMapper = new LinksMapper();

    @PostMapping("/create")
    public ResponseEntity<LinksDTO> create(@RequestBody LinksDTO linksDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                linksMapper.mapEntityToDto(linksService.saveLinks(linksMapper.mapToEntityAndSaveLinks(linksDTO))));

    }

    /*
     * @GetMapping public List<LinksDTO> findAllLinks() { List<Links> linksList = linksService.findAll(); return
     * linksMapper.mapListToDto(linksList); }
     */
    @GetMapping
    public ResponseEntity<Resources<LinksDTO>> showAllLinks() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Resources<>(linksMapper.mapListToDto(linksService.findAll()),
                        linkTo(methodOn(LinksController.class).showAllLinks()).withSelfRel()));

    }

    @GetMapping("/link/{id}")
    public ResponseEntity<LinksDTO> getOneLink(@PathVariable Long id) {
        Links links = linksService.getOneLinks(id);
        return new ResponseEntity<LinksDTO>(linksMapper.mapEntityToDto(links), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLink(@PathVariable Long id) {
        linksService.deleteLinks(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/link/{id}")
    ResponseEntity<LinksDTO> updateLink(@PathVariable("id") Long id, @RequestBody LinksDTO linksDTO) {

        Links links = linksMapper.mapToEntityForUpdateLinks(linksDTO, id);
        links = linksService.updateLinks(links);
        linksDTO = linksMapper.mapEntityToDto(links);
        return new ResponseEntity<LinksDTO>(linksDTO, HttpStatus.OK);
    }

}
