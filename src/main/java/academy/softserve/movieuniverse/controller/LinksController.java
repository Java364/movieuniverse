package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.LinksDTO;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.service.LinksService;
import academy.softserve.movieuniverse.service.mapper.LinksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinksController {

    @Autowired
    private LinksService linksService;
    @Autowired
    private LinksMapper linksMapper = new LinksMapper();

    @PostMapping("/api/createLinks")
    ResponseEntity<LinksDTO> createLink(@RequestBody LinksDTO linksDTO) {
        Links links = linksMapper.mapToEntity(linksDTO);
        linksService.saveLinks(links);
        linksDTO = linksMapper.mapToDto(links);
        return new ResponseEntity<LinksDTO>(linksDTO, HttpStatus.CREATED);
    }

    @GetMapping("/api/listAll")
    public List<LinksDTO> findAllLinks() {
        List<Links> linksList = linksService.findAll();
        return linksMapper.mapListToDto(linksList);
    }

    @GetMapping("/api/link/{id}")
    public ResponseEntity<LinksDTO> getOneLink(@PathVariable Long id) {
        Links links = linksService.getOneLinks(id);
        return new ResponseEntity<LinksDTO>(linksMapper.mapToDto(links), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteLink(@PathVariable Long id) {
        linksService.deleteLinks(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/link/{id}")
    ResponseEntity<LinksDTO> updateLink(@PathVariable("id") Long id, @RequestBody LinksDTO linksDTO) {
        Links links = linksMapper.mapToEntityForUpdate(linksDTO, id);
        links = linksService.updateLinks(links);
        linksDTO = linksMapper.mapToDto(links);
        return new ResponseEntity<LinksDTO>(linksDTO, HttpStatus.OK);
    }
        /*Links links = linksMapper.mapToEntity(linksDTO);
        linksService.updateLinks(links, id);
        linksDTO = linksMapper.mapToDto(links);
        return new ResponseEntity<LinksDTO>(linksDTO, HttpStatus.CREATED);
    }*/

}

