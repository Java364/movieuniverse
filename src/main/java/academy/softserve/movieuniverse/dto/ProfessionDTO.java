package academy.softserve.movieuniverse.dto;


import java.util.ArrayList;
import java.util.List;

public class ProfessionDTO {
    private Long id;
    private String professionType;

    private List<Long> starIds = new ArrayList<Long>();

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

    /*public Long getStarsID() {
        return starsID;
    }

    public void setStarsID(Long starsID) {
        this.starsID = starsID;
    }*/

    public List<Long> getStarIds() {
        return starIds;
    }

    public void setStarIds(List<Long> starIds) {
        this.starIds = starIds;
    }

    /*public List<StarProfessionDTO> getStarsProfessionDTO() {
                    return starsProfessionDTO;
                }

                public void setStarsProfessionDTO(List<StarProfessionDTO> starsProfessionDTO) {
                    this.starsProfessionDTO = starsProfessionDTO;
                }*/
    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
