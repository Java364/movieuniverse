package academy.softserve.movieuniverse.dto;

public class ProfessionDTO {
    private Long id;
    private String professionType;
    private String starIds;
    private Boolean isRemoved;
    private String self;

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

    public String getStarIds() {
        return starIds;
    }

    public void setStarIds(String starIds) {
        this.starIds = starIds;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
