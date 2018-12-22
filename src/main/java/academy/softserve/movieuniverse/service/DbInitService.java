package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Country;
import academy.softserve.movieuniverse.entity.Genre;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.repository.CountryRepository;
import academy.softserve.movieuniverse.repository.GenreRepository;
import academy.softserve.movieuniverse.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class DbInitService {

    private final CountryRepository countryRepository;
    
    private final ProfessionRepository professionRepository;

    @Autowired
    public DbInitService(CountryRepository countryRepository, ProfessionRepository professionRepository) {
        this.countryRepository = countryRepository;
        this.professionRepository = professionRepository;
    }

    @PostConstruct
    public void dbInit() {
        insertCountries();
       
        insertProfessions();

    }

    private void insertProfessions() {
        Profession profession1 = new Profession();
        Profession profession2 = new Profession();
        Profession profession3 = new Profession();
        Profession profession4 = new Profession();
        Profession profession5 = new Profession();
        profession1.setType("Actor");
        profession2.setType("Camera operator");
        profession3.setType("Director");
        profession4.setType("Producer");
        profession5.setType("Scriptwriter");
        professionRepository.save(profession1);
        professionRepository.save(profession2);
        professionRepository.save(profession3);
        professionRepository.save(profession4);
        professionRepository.save(profession5);
    }

    private void insertCountries() {
        Country country1 = new Country();
        Country country2 = new Country();
        Country country3 = new Country();
        Country country4 = new Country();
        Country country5 = new Country();
        country1.setName("India");
        country2.setName("France");
        country3.setName("Ukraine");
        country4.setName("United Kingdom");
        country5.setName("USA");
        countryRepository.save(country1);
        countryRepository.save(country2);
        countryRepository.save(country3);
        countryRepository.save(country4);
        countryRepository.save(country5);

    }

    

    @PreDestroy
    public void removeData() {
        
        countryRepository.deleteAll();
        professionRepository.deleteAll();
    }
}
