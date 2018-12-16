package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.exception.LinkException;
import academy.softserve.movieuniverse.repository.LinksRepository;
import academy.softserve.movieuniverse.service.mapper.LinksMapper;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinksService {
    @Autowired
    private LinksRepository linksRepository;
    
    public void saveLinks(Links links){
       linksRepository.save(links);
    }

    public List<Links> findAll(){
        return linksRepository.findAll();
    }

    public void deleteLinks(Long id){
        if (!linksRepository.findById(id).isPresent()) throw LinkException.createDeleteException("!!!!", null);

        linksRepository.deleteById(id);
    }

    public Links getOneLinks(Long id)
    {
        Links links = linksRepository.getOne(id);
        return links;
    }

    public Links updateLinks(Links links) {
        links = linksRepository.save(links);
        return links;
    }
}
