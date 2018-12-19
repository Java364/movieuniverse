package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.exception.ExceptionType;
import academy.softserve.movieuniverse.exception.LinkException;
import academy.softserve.movieuniverse.repository.LinksRepository;
import academy.softserve.movieuniverse.repository.StarRepository;
import academy.softserve.movieuniverse.service.mapper.LinksMapper;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LinksService {
    @Autowired
    private LinksRepository linksRepository;
    @Autowired
    private StarRepository starRepository;
    
    public void saveLinks(Links links){
    if(links.getLinkName().isEmpty() || links ==null)
            throw LinkException.createSaveException(ExceptionType.SAVE.getMessage()+ "Link");{
       linksRepository.save(links);
    }}

    public List<Links> findAll(){
        return linksRepository.findAll();
    }

    public void deleteLinks(Long id){
        if (!linksRepository.findById(id).isPresent())
            throw LinkException.createDeleteException(ExceptionType.DELETE.getMessage()+"link with ID - "+id.toString());
        linksRepository.deleteById(id);
    }

    public Links getOneLinks(Long id)
    {Optional<Links> linksOptional = linksRepository.findById(id);
        if (!linksOptional.isPresent()) {
            throw LinkException.createSelectException(ExceptionType.SELECT.getMessage()+"link with ID - " + id.toString());
        }
        Links links = linksRepository.getOne(id);
        return links;
    }

    public Links updateLinks(Links links) {
        if (links == null || !linksRepository.findById(links.getId()).isPresent())
            throw LinkException.createUpdateException(ExceptionType.UPDATE.getMessage()+"Link");
        links = linksRepository.save(links);
        return links;
    }
}
