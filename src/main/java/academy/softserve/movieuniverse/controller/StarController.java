package academy.softserve.movieuniverse.controller;

import academy.softserve.movieuniverse.dto.StarDTO;
import academy.softserve.movieuniverse.dto.StarProfessionDTO;
import academy.softserve.movieuniverse.dto.gallery.GalleryDTO;
import academy.softserve.movieuniverse.entity.Gallery;
import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.entity.Star;
import academy.softserve.movieuniverse.entity.StarProfession;
import academy.softserve.movieuniverse.service.GalleryService;
import academy.softserve.movieuniverse.service.LinksService;
import academy.softserve.movieuniverse.service.StarProfessionService;
import academy.softserve.movieuniverse.service.StarService;
import academy.softserve.movieuniverse.service.mapper.GalleryMapper;
import academy.softserve.movieuniverse.service.mapper.StarMapper;
import academy.softserve.movieuniverse.service.mapper.StarProfessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "/stars", produces = "application/hal+json")
public class StarController {

    private final StarService starService;
    private final StarProfessionService starProfessionService;
    private final StarMapper mapper;
    private final StarProfessionMapper starProfessionMapper;
    //    @Autowired
//    private StarResourceAssembler essembler;
    private final LinksService linksService;
    private final GalleryService galleryService;
    private final GalleryMapper galleryMapper;

    @Autowired
    public StarController(StarService starService, StarProfessionService starProfessionService, StarMapper mapper, StarProfessionMapper starProfessionMapper, LinksService linksService, GalleryService galleryService, GalleryMapper galleryMapper) {
        this.starService = starService;
        this.starProfessionService = starProfessionService;
        this.mapper = mapper;
        this.starProfessionMapper = starProfessionMapper;
        this.linksService = linksService;
        this.galleryService = galleryService;
        this.galleryMapper = galleryMapper;
    }


    @GetMapping("/list")
    public ResponseEntity<Resources<Resource<StarDTO>>> showAll() {
//        List<Resource<StarDTO>> resources = mapper.mapListsToDto(service.showAll()).stream().map().collect(Collectors.toList());
        return new ResponseEntity<>(new Resources<>(null), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Resource<StarDTO>> showOne(@PathVariable Long id) {
        Star star = starService.findById(id);
//        Resource<StarDTO> resource = essembler.toResource(mapper.mapProfileToDto(star));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<StarDTO> create(@RequestBody StarDTO starDTO) {
        Star star = mapper.mapCreateToEntity(starDTO);
        starService.create(star);
        starDTO = mapper.mapCreateToDto(star);
        return new ResponseEntity<StarDTO>(starDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StarDTO> update(@RequestBody StarDTO starDTO, @PathVariable Long id) {
        Star star = mapper.mapCreateToEntity(starDTO);
        starService.update(star, id);
        starDTO = mapper.mapCreateToDto(star);
        return new ResponseEntity<StarDTO>(starDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/create-profession")
    public ResponseEntity<StarProfessionDTO> createProfession(@RequestBody StarProfessionDTO starProfessionDTO, @PathVariable("id") Long starId) {
        StarProfession starProfession = starProfessionMapper.mapToEntity(starProfessionDTO);
        starProfessionService.createStarProfession(starProfession, starId);
        starProfessionDTO = starProfessionMapper.mapToDto(starProfession);
        return new ResponseEntity<StarProfessionDTO>(starProfessionDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> completelyDelete(@PathVariable Long id) {
        starService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/remove/{id}")
    public ResponseEntity<StarDTO> remove(@PathVariable Long id) {
        starService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/make-active/{id}")
    public ResponseEntity<StarDTO> makeActive(@PathVariable Long id) {
        starService.makeActive(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/links/{id}")
    public StarDTO showAllByLinksId(@PathVariable Long id) {
        Links links = linksService.getOneLinks(id);
        return mapper.mapProfileToDto(starService.findAllByLinks(links));
    }

    @GetMapping("/{id}/gallery")
    public ResponseEntity<GalleryDTO> showStarGallery(@PathVariable Long id) {
        Star star = starService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(galleryMapper.mapToDTO(star.getGallery()));
    }

    @PostMapping("/{id}/gallery")
    public ResponseEntity<GalleryDTO> createStarGallery(@PathVariable Long id) {
        Gallery gallery = starService.addNewGallery(id);
        System.out.println(gallery);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(galleryMapper.mapToDTO(starService.findById(id).getGallery()));
    }

}
