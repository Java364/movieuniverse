package academy.softserve.movieuniverse.service;

import academy.softserve.movieuniverse.entity.Country;

import javax.annotation.PostConstruct;

public class DbInitService {

    @PostConstruct
    public void dbInit() {
        Country country1 = new Country();
        country1.setName("USA");
        Country country2 = new Country();
        country2.setName("Ukraine");
        Country country3 = new Country();
        country3.setName("France");
    }
}
