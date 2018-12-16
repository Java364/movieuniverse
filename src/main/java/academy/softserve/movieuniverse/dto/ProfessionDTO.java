package academy.softserve.movieuniverse.dto;


import academy.softserve.movieuniverse.entity.StarProfession;

import java.util.ArrayList;
import java.util.List;

public class ProfessionDTO {
    private Long id;
    private String professionType;
    private List<StarProfessionDTO> starsProfessionDTO = new ArrayList<StarProfessionDTO>();
    private Boolean isRemoved;

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

    public List<StarProfessionDTO> getStarsProfessionDTO() {
        return starsProfessionDTO;
    }

    public void setStarsProfessionDTO(List<StarProfessionDTO> starsProfessionDTO) {
        this.starsProfessionDTO = starsProfessionDTO;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
