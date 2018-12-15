package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Links;
import academy.softserve.movieuniverse.repository.LinksRepository;
import academy.softserve.movieuniverse.service.mapper.LinksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinksService {
    @Autowired
    private LinksRepository linksRepository;
    
    public void saveLinks(Links links){
       linksRepository.save(links);
    }

    public List<Links> findAll(){
        return linksRepository.findAll();
    }
    @Transactional
    public void deleteLinks(Long id){
        linksRepository.deleteById(id);
    }

    public Links getOneLinks(Long id){
        return linksRepository.getOne(id);
    }

    public Links updateLinks(Links links) {
        links = linksRepository.save(links);
        return links;
    }
}
