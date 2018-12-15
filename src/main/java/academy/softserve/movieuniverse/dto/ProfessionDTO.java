package academy.softserve.movieuniverse.dto;


import academy.softserve.movieuniverse.entity.StarProfession;

import java.util.ArrayList;
import java.util.List;

public class ProfessionDTO {
    private Long id;
    private String professionType;
    private List<Long> starsIDs = new ArrayList<Long>();

    public ProfessionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessionType() {
        return professionType;
    }

    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }

    public List<Long> getStarsIDs() {
        return starsIDs;
    }

    public void setStarsIDs(List<Long> starsIDs) {
        this.starsIDs = starsIDs;
    }
}
